package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.Espinas;
import fiuba.algo3.model.arena.NebulosaDeAndromeda;
import fiuba.algo3.model.arena.Pantano;
import fiuba.algo3.model.arena.TormentaPsionica;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionAbajo;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.DireccionDerechaAbajo;
import fiuba.algo3.model.espacio.DireccionIzquierda;
import fiuba.algo3.model.espacio.DireccionIzquierdaArriba;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.juego.JugadorNoPuedeObtenerAlgoformerContrarioException;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.EstadoProtoNoPuedeRealizarAcciones;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.model.unidades.NoHaySuficientesAlgoformersAdyacentesException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega02Test {

    private Arena arena = Arena.getInstance();
    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();


    @Before
    public void before() {
        instanciadorDeAlgoformers.inicializar();
        arena.inicializar();
    }


    @Test
    public void test01PruebasDeTerrenoEnJuego() {
    	Punto posicionInicialOptimus = new PuntoTierra(1,26);
    	Punto posicionInicialBumblebee = new PuntoTierra(1,25);
    	Punto posicionInicialMegatron = new PuntoTierra(51,26);
    	
    	Punto ubicacionPantano = new PuntoTierra(6,25);
    	Punto ubicacionEspinas = new PuntoTierra(20,25);
    	Punto ubicacionTormenta = new PuntoAire(22,26);
    	Punto ubicacionNebulosa = new PuntoAire(45,28);
    	
    	arena.setTerrenoEnPunto(ubicacionPantano, new Pantano());
    	arena.setTerrenoEnPunto(ubicacionEspinas, new Espinas());
    	arena.setTerrenoEnPunto(ubicacionTormenta, new TormentaPsionica());
    	arena.setTerrenoEnPunto(ubicacionNebulosa, new NebulosaDeAndromeda());
    	
        String nombreJugador1 = "Diego";
        String nombreJugador2 = "Guille";

        Juego juego = new Juego();
        arena.setTerrenoEnPunto(ubicacionPantano, new Pantano());
    	arena.setTerrenoEnPunto(ubicacionEspinas, new Espinas());
    	arena.setTerrenoEnPunto(ubicacionTormenta, new TormentaPsionica());
    	arena.setTerrenoEnPunto(ubicacionNebulosa, new NebulosaDeAndromeda());
        juego.crearJugador(nombreJugador1, "DECEPTICONS");
        juego.crearJugador(nombreJugador2, "AUTOBOTS");
        juego.comenzarPartida();
        
        Jugador jugadorActual = juego.getJugadorEnTurno();

        if (!jugadorActual.getNombre().equals(nombreJugador2)) {
            juego.finalizarTurno();
            jugadorActual = juego.getJugadorEnTurno();
        }
        
        Algoformer optimus = jugadorActual.obtenerAlgoformerEn(posicionInicialOptimus);
        optimus.transformarse();
        
        Assert.assertFalse(arena.estaOcupado(new PuntoAire(1,26)));
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();

        Algoformer algoformerSeleccionado = null;

        try {
            algoformerSeleccionado = jugadorActual.obtenerAlgoformerEn(posicionInicialBumblebee);
        } catch (JugadorNoPuedeObtenerAlgoformerContrarioException e) {
            Assert.assertNull(algoformerSeleccionado);
        }
        
        Algoformer megatron = jugadorActual.obtenerAlgoformerEn(posicionInicialMegatron);
        megatron.transformarse();
        
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(51,26)));
        
        juego.finalizarTurno();
        
        Direccion direccionDiagonalDerechaAbajo = new DireccionDerechaAbajo();
        Direccion direccionDerecha = new DireccionDerecha();
        
        int movimientosOptimusAlterno = 5;
        optimus.moverseHacia(direccionDiagonalDerechaAbajo);
        
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(2,25)));
        
        for (int i=0; i<(movimientosOptimusAlterno-2);i++)
        	optimus.moverseHacia(direccionDerecha);
        
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(5,25)));
        
        juego.finalizarTurno();
        
        Direccion direccionDiagonalIzquierdaArriba = new DireccionIzquierdaArriba();
        Direccion direccionIzquierda = new DireccionIzquierda();
        
        int movimientosMegatronAlterno = 8;
        
        megatron.moverseHacia(direccionDiagonalIzquierdaArriba);
        megatron.moverseHacia(direccionDiagonalIzquierdaArriba);
        
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(49,28)));
        
        megatron.moverseHacia(direccionIzquierda);
        megatron.moverseHacia(direccionIzquierda);
        megatron.moverseHacia(direccionIzquierda);
        megatron.moverseHacia(direccionIzquierda);
        
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(45,28)));

        try{
        	megatron.moverseHacia(direccionIzquierda);
        }catch(MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(new PuntoAire(45,28)));
        }
        
        juego.finalizarTurno();
        
        optimus.transformarse();
        
        juego.finalizarTurno();
        
        try{
        	megatron.moverseHacia(direccionIzquierda);
        }catch(MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(new PuntoAire(45,28)));
        }
        
        juego.finalizarTurno();
        
        try{
        	optimus.moverseHacia(direccionDerecha);
        }catch (MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(new PuntoTierra(5,25)));
        }
        
        optimus.transformarse();
        
        juego.finalizarTurno();
        
        try{
        	megatron.moverseHacia(direccionIzquierda);
        }catch(MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(new PuntoAire(45,28)));
        }
        
        juego.finalizarTurno();
        
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(5,25)));
        optimus.moverseHacia(direccionDerecha);
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(6,25)));
        for (int i=0; i<(movimientosOptimusAlterno-2);i++)
        	optimus.moverseHacia(direccionDerecha);
        
        try{
        	optimus.moverseHacia(direccionDerecha);
        }catch(MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(new PuntoTierra(9,25)));
        }
        
        juego.finalizarTurno();
        
        megatron.moverseHacia(direccionIzquierda);
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(44,28)));
        
        for (int i=0;i<(movimientosMegatronAlterno-1);i++)
        	megatron.moverseHacia(direccionIzquierda);
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(37,28)));
        
        juego.finalizarTurno();
        
        for (int i=0;i<movimientosOptimusAlterno;i++)
        	optimus.moverseHacia(direccionDerecha);
        
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(14,25)));
        
        juego.finalizarTurno();
        
        for (int i=0;i<movimientosMegatronAlterno;i++)
        	megatron.moverseHacia(direccionIzquierda);
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(29,28)));
        
        juego.finalizarTurno();
        
        for (int i=0;i<movimientosOptimusAlterno;i++)
        	optimus.moverseHacia(direccionDerecha);
        
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(19,25)));
        
        juego.finalizarTurno();
        
        for (int i=0;i<movimientosMegatronAlterno;i++)
        	megatron.moverseHacia(direccionIzquierda);
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(21,28)));
        
        juego.finalizarTurno();
        
        Assert.assertEquals( optimus.getVidaMax(),optimus.getVida());
        
        optimus.moverseHacia(direccionDerecha);
        
        Assert.assertEquals(optimus.getVidaMax()-(optimus.getVidaMax()/20), optimus.getVida());	
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(20,25)));
        
        optimus.moverseHacia(direccionDerecha);
        optimus.moverseHacia(direccionIzquierda);
        Assert.assertEquals(450, optimus.getVida());
        
        optimus.moverseHacia(direccionDerecha);
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(21,25)));
        
        juego.finalizarTurno();
        
        Direccion direccionAbajo = new DireccionAbajo();
        megatron.moverseHacia(direccionAbajo);
        megatron.moverseHacia(direccionAbajo);
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(21,26)));
        
        juego.finalizarTurno();
        juego.finalizarTurno();
        
        megatron.atacar(optimus);
        Assert.assertEquals(395,optimus.getVida());
        
        juego.finalizarTurno();
        juego.finalizarTurno();
        
        megatron.moverseHacia(direccionDerecha);
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(22,26)));
        megatron.moverseHacia(direccionIzquierda);
        
        juego.finalizarTurno();
        juego.finalizarTurno();
        
        megatron.atacar(optimus);
        Assert.assertEquals(362, optimus.getVida());
        
        juego.finalizarTurno();
        juego.finalizarTurno();
        
        megatron.transformarse();
        
        juego.finalizarTurno();
        juego.finalizarTurno();
        
        megatron.atacar(optimus);
        
        Assert.assertEquals(352, optimus.getVida());
        
        juego.finalizarTurno();
        juego.finalizarTurno();
        
        megatron.transformarse();
        
        juego.finalizarTurno();
        juego.finalizarTurno();
        
        megatron.moverseHacia(direccionDerecha);
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(22,26)));
        megatron.moverseHacia(direccionIzquierda);
        
        juego.finalizarTurno();
        juego.finalizarTurno();
        
        megatron.atacar(optimus);
        Assert.assertEquals(319, optimus.getVida());
        }

    @Test
    public void test02PruebasSuperionYMenasorEnJuego(){
    	Punto posicionInicialRatchet = new PuntoTierra(1,27);
    	Punto posicionInicialOptimus = new PuntoTierra(1,26);
    	Punto posicionInicialBumblebee = new PuntoTierra(1,25);
    	Punto posicionInicialFrenzy = new PuntoTierra(51,27);
    	Punto posicionInicialMegatron = new PuntoTierra(51,26);
    	Punto posicionInicialBoneCrusher = new PuntoTierra(51,25);
    	
        String nombreJugador1 = "Fran";
        String nombreJugador2 = "Santi";
        
        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, "DECEPTICONS");
        juego.crearJugador(nombreJugador2, "AUTOBOTS");
        juego.comenzarPartida();
        
        Jugador jugadorActual = juego.getJugadorEnTurno();

        if (!jugadorActual.getNombre().equals(nombreJugador1)) {
            juego.finalizarTurno();
            jugadorActual = juego.getJugadorEnTurno();
        }
        
        jugadorActual.combinarAlgoformers();
        Assert.assertFalse(arena.estaOcupado(posicionInicialFrenzy));
        Assert.assertFalse(arena.estaOcupado(posicionInicialBoneCrusher));
        Assert.assertTrue(arena.estaOcupado(posicionInicialMegatron));
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        Algoformer optimus = jugadorActual.obtenerAlgoformerEn(posicionInicialOptimus);
        
        Direccion direccionDerecha = new DireccionDerecha();
        optimus.moverseHacia(direccionDerecha);
        optimus.moverseHacia(direccionDerecha);
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        
        Algoformer menasor = jugadorActual.obtenerAlgoformerEn(posicionInicialMegatron);
        Assert.assertNotNull(menasor);
        
        Direccion direccionIzquierda = new DireccionIzquierda();
        
        try{
        	menasor.moverseHacia(direccionIzquierda);
        }catch(EstadoProtoNoPuedeRealizarAcciones e){
        	
        	Assert.assertTrue(arena.estaOcupado(posicionInicialMegatron));
        }
        
        try{
        	menasor.atacar(optimus);
        }catch(EstadoProtoNoPuedeRealizarAcciones e){
        	Assert.assertTrue(arena.estaOcupado(posicionInicialMegatron));
        }
        try{
        	menasor.transformarse();
        }catch(EstadoProtoNoPuedeRealizarAcciones e){
        	Assert.assertTrue(arena.estaOcupado(posicionInicialMegatron));
        }
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        
        try{
        	jugadorActual.combinarAlgoformers();
        }catch(NoHaySuficientesAlgoformersAdyacentesException e){
        	Assert.assertTrue(arena.estaOcupado(posicionInicialBumblebee));
        	Assert.assertTrue(arena.estaOcupado(posicionInicialRatchet));
        	Assert.assertFalse(arena.estaOcupado(posicionInicialOptimus));
        	Assert.assertTrue(arena.estaOcupado(new PuntoTierra(3,26)));
        }
        
        //Algoformer ratchet = jugadorActual.combinarAlgoformers();
    }


}
