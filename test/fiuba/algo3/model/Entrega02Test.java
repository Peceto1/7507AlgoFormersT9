package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.Espinas;
import fiuba.algo3.model.arena.NebulosaDeAndromeda;
import fiuba.algo3.model.arena.Pantano;
import fiuba.algo3.model.arena.TormentaPsionica;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.DireccionDerechaAbajo;
import fiuba.algo3.model.espacio.DireccionDerechaArriba;
import fiuba.algo3.model.espacio.DireccionIzquierda;
import fiuba.algo3.model.espacio.DireccionIzquierdaArriba;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;

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
    public void IntegracionTerrenosYJuego() {
    	Punto posicionInicialRatchet = new PuntoTierra(1,27);
    	Punto posicionInicialOptimus = new PuntoTierra(1,26);
    	Punto posicionInicialBumblebee = new PuntoTierra(1,25);
    	Punto posicionInicialFrenzy = new PuntoTierra(51,27);
    	Punto posicionInicialMegatron = new PuntoTierra(51,26);
    	Punto posicionInicialBoneCrusher = new PuntoTierra(51,25);
    	
    	Punto ubicacionPantano = new PuntoTierra(6,25);
    	Punto ubicacionEspinas = new PuntoTierra(40,24);
    	Punto ubicacionTormenta = new PuntoAire(10,30);
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
        
        Assert.assertNull(jugadorActual.obtenerAlgoformerEn(posicionInicialBumblebee));
        
        Algoformer megatron = jugadorActual.obtenerAlgoformerEn(posicionInicialMegatron);
        megatron.transformarse();
        
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(51,26)));
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        
        Direccion direccionDiagonalDerechaAbajo = new DireccionDerechaAbajo();
        Direccion direccionDerecha = new DireccionDerecha();
        
        int movimientosOptimusAlterno = 5;
        optimus.moverseHacia(direccionDiagonalDerechaAbajo);
        
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(2,25)));
        
        for (int i=0; i<(movimientosOptimusAlterno-2);i++)
        	optimus.moverseHacia(direccionDerecha);
        
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(5,25)));
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        
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
        jugadorActual = juego.getJugadorEnTurno();
        
        optimus.transformarse();
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        
        try{
        	megatron.moverseHacia(direccionIzquierda);
        }catch(MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(new PuntoAire(45,28)));
        }
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        
        try{
        	optimus.moverseHacia(direccionDerecha);
        }catch (MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(new PuntoTierra(5,25)));
        }
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(5,25)));
        
        optimus.transformarse();
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        
        try{
        	megatron.moverseHacia(direccionIzquierda);
        }catch(MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(new PuntoAire(45,28)));
        }
        
        juego.finalizarTurno();
        jugadorActual = juego.getJugadorEnTurno();
        
        //Assert.assertTrue(arena.estaOcupado(new PuntoTierra(5,25)));
        optimus.moverseHacia(direccionDerecha);
        //Assert.assertTrue(arena.estaOcupado(new PuntoTierra(6,25)));
        for (int i=0; i<(movimientosOptimusAlterno-2);i++)
        	optimus.moverseHacia(direccionDerecha);
        
        try{
        	optimus.moverseHacia(direccionDerecha);
        }catch(MovimientoNoValidoException e){
        	//Assert.assertTrue(arena.estaOcupado(new PuntoTierra(10,25)));
        }
        	
        	
    }



}
