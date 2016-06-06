package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovimientoTest {

    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arenaDeJuego = Arena.getInstance();


    @Before
    public void before() {
        instanciadorDeAlgoformers.inicializar();
        arenaDeJuego.inicializar();
    }


    @Test
    public void ubicarAlgoformerEnUnPuntoDeLaArenaYPedirleDeMoverseALaDerechaCasilleroASuDerechaLoContiene() {
    	PuntoTierra pundoDePartida = new PuntoTierra(2, 2);
        PuntoTierra puntoDeLlegada = new PuntoTierra(3, 2);
        Direccion direccionDerecha = new DireccionDerecha();

        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        arenaDeJuego.ubicarAlgoformer(optimus, pundoDePartida);
        optimus.reiniciarMovimiento();

        optimus.moverseHacia(direccionDerecha);
        Assert.assertEquals(optimus.getUbicacion(), puntoDeLlegada);
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void ubicarAlgoformerEnElBordeDelTableroYPedirleQueSeMuevaHaciaArribaLanzaExcepcion() {
        PuntoTierra puntoDePartida = new PuntoTierra(1, 51);
        Direccion direccionArriba = new DireccionIzquierda();

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        arenaDeJuego.ubicarAlgoformer(megatron, puntoDePartida);
        megatron.reiniciarMovimiento();
        megatron.moverseHacia(direccionArriba);
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void moverAlgoformerHumanoideUnaCantidadDeVecesMayorASuVelocidadLanzaExcepcion() {
        PuntoTierra puntoDePartida = new PuntoTierra(1, 1);
        Direccion direccionDerecha = new DireccionDerecha();
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        arenaDeJuego.ubicarAlgoformer(optimus, puntoDePartida);
        optimus.reiniciarMovimiento();

        int cantidadMovimientosDeOptimusHumanoide = 2;

        for (int i=0; i<cantidadMovimientosDeOptimusHumanoide; i++)
            optimus.moverseHacia(direccionDerecha);

        optimus.moverseHacia(direccionDerecha);
    }

    @Test
    public void moverAlgoformerHumanoideUnaCantidadDeVecesMayorASuVelocidadAlgoformerQuedaEnPosicionValida() {
        PuntoTierra puntoDePartida = new PuntoTierra(1, 1);
        PuntoTierra puntoDeLlegada = new PuntoTierra(3, 1);
        Direccion direccionDerecha = new DireccionDerecha();
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        arenaDeJuego.ubicarAlgoformer(optimus, puntoDePartida);
        optimus.reiniciarMovimiento();

        int cantidadMovimientosDeOptimusHumanoide = 2;
        
        for (int i=0; i<cantidadMovimientosDeOptimusHumanoide; i++)
            optimus.moverseHacia(direccionDerecha);

        try {
            optimus.moverseHacia(direccionDerecha);
        } catch (MovimientoNoValidoException e) {
            Assert.assertEquals(puntoDeLlegada, optimus.getUbicacion());
        }
    }

    @Test
    public void moverAlgoformerAlternoUnaCantidadDeVecesMayorASuVelocidadArenaQuedaValida() {
        PuntoTierra puntoDePartida = new PuntoTierra(1, 1);
        PuntoTierra puntoDeLlegada = new PuntoTierra(9, 1);
        Direccion direccionDerecha = new DireccionDerecha();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        arenaDeJuego.ubicarAlgoformer(bonecrusher, puntoDePartida);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();

        int cantidadMovimientosBoneCrusherAlterno = 8;

        for (int i=0; i<cantidadMovimientosBoneCrusherAlterno; i++)
            bonecrusher.moverseHacia(direccionDerecha);

        try {
            bonecrusher.moverseHacia(direccionDerecha);
        } catch (MovimientoNoValidoException e) {
            Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDeLlegada));
            Assert.assertFalse(arenaDeJuego.estaOcupado(new PuntoTierra(10, 1)));     // Punto siguiente
            Assert.assertFalse(arenaDeJuego.estaOcupado(new PuntoTierra(8, 1)));
        }
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void moverAlgoformerHumanoideYQueSeTopeConOtroHumanoideLanzaExcepcion() {
        PuntoTierra puntoDePartida = new PuntoTierra(1, 1);
        Direccion direccionDiagonalDerechaArriba = new DireccionDerechaArriba();
        PuntoTierra posicionOcupada = new PuntoTierra(2, 2);
        Algoformer bumbleblee = instanciadorDeAlgoformers.obtenerBumblebee();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();

        arenaDeJuego.ubicarAlgoformer(bumbleblee, puntoDePartida);
        bumbleblee.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(frenzy, posicionOcupada);
        frenzy.reiniciarMovimiento();

        bumbleblee.moverseHacia(direccionDiagonalDerechaArriba);
    }
    
    @Test
    public void moverAlgoformerHumanoideYQueSeTopeConOtroHumanoideNoVaciaCasillero() {
        PuntoTierra puntoDePartida = new PuntoTierra(1, 1);
        Direccion direccionDiagonalDerechaArriba = new DireccionDerechaArriba();
        PuntoTierra posicionOcupada = new PuntoTierra(2, 2);
        Algoformer bumbleblee = instanciadorDeAlgoformers.obtenerBumblebee();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();

        arenaDeJuego.ubicarAlgoformer(bumbleblee, puntoDePartida);
        bumbleblee.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(frenzy, posicionOcupada);
        frenzy.reiniciarMovimiento();

        try{
        	bumbleblee.moverseHacia(direccionDiagonalDerechaArriba);
        }catch(MovimientoNoValidoException e){
        	Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDePartida));
        }
    }
    
    @Test
    public void moverAlgoformerVoladorSobreTerrestreNoChocan() {
        PuntoTierra puntoDePartida = new PuntoTierra(1, 1);
        Direccion direccionDiagonalDerechaArriba = new DireccionDerechaArriba();
        PuntoTierra posicionOcupada = new PuntoTierra(2, 2);
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();

        arenaDeJuego.ubicarAlgoformer(megatron, puntoDePartida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();

        arenaDeJuego.ubicarAlgoformer(frenzy, posicionOcupada);
        frenzy.reiniciarMovimiento();

        megatron.moverseHacia(direccionDiagonalDerechaArriba);
    }

    @Test
    public void moverAlgoformerAlternoHastaAgotarSusMovimientosLuegoResetearMovimientoPuedeSeguirMoviendose() {
    	
        PuntoTierra puntoPartida = new PuntoTierra(25, 25);
        PuntoTierra puntoDeLlegada = new PuntoTierra(31, 19);
        Direccion direccionDiagonalDerechaAbajo = new DireccionDerechaAbajo();
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        arenaDeJuego.ubicarAlgoformer(bumblebee, puntoPartida);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.reiniciarMovimiento();
        
        int cantidadMovimientosBumblebeeAlterno = 5;
        
        for (int i = 0; i< cantidadMovimientosBumblebeeAlterno ; i++){
        	bumblebee.moverseHacia(direccionDiagonalDerechaAbajo);
        }
        bumblebee.reiniciarMovimiento();
    	bumblebee.moverseHacia(direccionDiagonalDerechaAbajo);
        Assert.assertEquals(bumblebee.getUbicacion(),puntoDeLlegada);

    }
    
    @Test
    public void AlgoformerHumanoideSeMueveCorrectamente(){
    	PuntoTierra puntoDePartida = new PuntoTierra(15,4);
    	PuntoTierra puntoDeLlegada = new PuntoTierra(15,3);
    	Direccion direccionAbajo = new DireccionAbajo();
    	Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();

    	arenaDeJuego.ubicarAlgoformer(optimus, puntoDePartida);
        optimus.reiniciarMovimiento();

    	optimus.moverseHacia(direccionAbajo);
    	Assert.assertEquals(puntoDeLlegada, optimus.getUbicacion());
    	  	   	
    }
    
    @Test (expected = MovimientoNoValidoException.class)
    public void AlgoformerHumanoideNoPuedeSuperarSuLimiteDeMovimientos(){
    	PuntoTierra puntoDePartida = new PuntoTierra(15, 4);
    	Direccion direccionAbajo = new DireccionAbajo();
    	Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();

    	arenaDeJuego.ubicarAlgoformer(megatron, puntoDePartida);
        megatron.reiniciarMovimiento();

    	megatron.moverseHacia(direccionAbajo);
    	megatron.moverseHacia(direccionAbajo);
    }
    
    @Test (expected = MovimientoNoValidoException.class)
    public void AlgoformerHumanoideChocaConAlternoEnTierra(){
    	PuntoTierra puntoDePartida = new PuntoTierra(40,10);
    	PuntoTierra puntoDeLlegada = new PuntoTierra(39,11);
    	Direccion direccionDiagonalIzquierdaArriba = new DireccionIzquierdaArriba();
    	Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();

        arenaDeJuego.ubicarAlgoformer(bumblebee, puntoDePartida);
        bumblebee.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(bonecrusher, puntoDeLlegada);
    	bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();

    	bumblebee.moverseHacia(direccionDiagonalIzquierdaArriba);
    }
    
	@Test
	public void AlgoformerMuertoNoPuedeTransformarse(){
		Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		
        PuntoTierra posicionInicialMegatron = new PuntoTierra(25, 25);
        PuntoTierra posicionInicialOptimus = new PuntoTierra(24, 24);
        Direccion direccionArriba = new DireccionArriba();

        arenaDeJuego.ubicarAlgoformer(optimusprime, posicionInicialOptimus);
        optimusprime.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(megatron, posicionInicialMegatron);
        megatron.reiniciarMovimiento();
        
        for (int i=0;i<10;i++){
            optimusprime.atacar(megatron);
        }

        // megatron sigue vivo (le quedan 50 de vida)
        optimusprime.atacar(megatron);
        // megatron esta muerto con exactamente 0 de vida
        
        megatron.moverseHacia(direccionArriba);
    }
}


    

