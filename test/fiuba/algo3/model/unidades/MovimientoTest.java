package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovimientoTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();


    @Before
    public void before() {
        pool.inicializar();
        arena.inicializar();
    }


    @Test
    public void ubicarAlgoformerEnUnPuntoDeLaArenaYPedirleDeMoverseALaDerechaCasilleroASuDerechaLoContiene() {
        Punto partida = new Punto(2, 2, 0);
        Punto llegada = new Punto(3, 2, 0);
        Direccion derecha = new DireccionDerecha();

        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, partida);
        optimus.reiniciarMovimiento();

        optimus.moverseHacia(derecha);
        Assert.assertEquals(optimus.getUbicacion(), llegada);
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void ubicarAlgoformerEnElBordeDelTableroYPedirleQueSeMuevaHaciaArribaLanzaExcepcion() {
        Punto partida = new Punto(1, 51, 0);
        Direccion arriba = new DireccionIzquierda();

        Algoformer megatron = pool.obtenerMegatron();
        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.moverseHacia(arriba);
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void moverAlgoformerHumanoideUnaCantidadDeVecesMayorASuVelocidadLanzaExcepcion() {
        Punto partida = new Punto(1, 1, 0);
        Direccion derecha = new DireccionDerecha();
        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, partida);
        optimus.reiniciarMovimiento();

        int cantMovimientos = 2;    // Optimus tiene 2 de velocidad en Humanoide

        for (int i=0; i<cantMovimientos; i++)
            optimus.moverseHacia(derecha);

        optimus.moverseHacia(derecha);
    }

    @Test
    public void moverAlgoformerHumanoideUnaCantidadDeVecesMayorASuVelocidadAlgoformerQuedaEnPosicionValida() {
        Punto partida = new Punto(1, 1, 0);
        Punto llegada = new Punto(3, 1, 0);
        Direccion derecha = new DireccionDerecha();
        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, partida);
        optimus.reiniciarMovimiento();

        int cantMovimientos = 2;    // Optimus tiene 2 de velocidad en Humanoide

        for (int i=0; i<cantMovimientos; i++)
            optimus.moverseHacia(derecha);

        try {
            optimus.moverseHacia(derecha);
        } catch (MovimientoNoValidoException e) {
            Assert.assertEquals(llegada, optimus.getUbicacion());
        }
    }

    @Test
    public void moverAlgoformerAlternoUnaCantidadDeVecesMayorASuVelocidadArenaQuedaValida() {
        Punto partida = new Punto(1, 1, 0);
        Punto llegada = new Punto(9, 1, 0);
        Direccion derecha = new DireccionDerecha();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        arena.ubicarAlgoformer(bonecrusher, partida);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();

        int cantMovimientos = 8;    // BoneCrusher tiene 8 de velocidad en Alterno

        for (int i=0; i<cantMovimientos; i++)
            bonecrusher.moverseHacia(derecha);

        try {
            bonecrusher.moverseHacia(derecha);
        } catch (MovimientoNoValidoException e) {
            Assert.assertTrue(arena.estaOcupado(llegada));
            Assert.assertFalse(arena.estaOcupado(new Punto(10, 1, 0)));     // Punto siguiente
            Assert.assertFalse(arena.estaOcupado(new Punto(8, 1, 0)));
        }
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void moverAlgoformerHumanoideYQueSeTopeConOtroHumanoideLanzaExcepcion() {
        Punto partida = new Punto(1, 1, 0);
        Direccion diagonalArriba = new DireccionDerechaArriba();
        Punto ocupado = new Punto(2, 2, 0);
        Algoformer bumbleblee = pool.obtenerBumblebee();
        Algoformer frenzy = pool.obtenerFrenzy();

        arena.ubicarAlgoformer(bumbleblee, partida);
        bumbleblee.reiniciarMovimiento();
        arena.ubicarAlgoformer(frenzy, ocupado);
        frenzy.reiniciarMovimiento();

        bumbleblee.moverseHacia(diagonalArriba);
    }
    
    @Test
    public void moverAlgoformerHumanoideYQueSeTopeConOtroHumanoideNoVaciaCasillero() {
        Punto partida = new Punto(1, 1, 0);
        Direccion diagonalArriba = new DireccionDerechaArriba();
        Punto ocupado = new Punto(2, 2, 0);
        Algoformer bumbleblee = pool.obtenerBumblebee();
        Algoformer frenzy = pool.obtenerFrenzy();

        arena.ubicarAlgoformer(bumbleblee, partida);
        bumbleblee.reiniciarMovimiento();
        arena.ubicarAlgoformer(frenzy, ocupado);
        frenzy.reiniciarMovimiento();

        try{
        	bumbleblee.moverseHacia(diagonalArriba);
        }catch(MovimientoNoValidoException e){
        	Assert.assertTrue(arena.estaOcupado(partida));
        }
    }
    
    @Test
    public void moverAlgoformerVoladorSobreTerrestreNoChocan() {
        Punto partida = new Punto(1, 1, 0);
        Direccion diagonalDerechaArriba = new DireccionDerechaArriba();
        Punto ocupado = new Punto(2, 2, 0);
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer frenzy = pool.obtenerFrenzy();

        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();

        arena.ubicarAlgoformer(frenzy, ocupado);
        frenzy.reiniciarMovimiento();

        megatron.moverseHacia(diagonalDerechaArriba);
    }

    @Test
    public void moverAlgoformerAlternoHastaAgotarSusMovimientosLuegoResetearMovimientoPuedeSeguirMoviendose() {
    	
        Punto partida = new Punto(25, 25, 0);
        Punto llegada = new Punto(31, 19, 0);
        Direccion diagonalDerechaAbajo = new DireccionDerechaAbajo();
        Algoformer bumblebee = pool.obtenerBumblebee();
        arena.ubicarAlgoformer(bumblebee, partida);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.reiniciarMovimiento();
        
        int movimientos = 5;
        
        for (int i = 0; i< movimientos ; i++){
        	bumblebee.moverseHacia(diagonalDerechaAbajo);
        }
        bumblebee.reiniciarMovimiento();
    	bumblebee.moverseHacia(diagonalDerechaAbajo);
        Assert.assertEquals(bumblebee.getUbicacion(),llegada);

    }
    
    @Test
    public void AlgoformerHumanoideSeMueveCorrectamente(){
    	Punto partida = new Punto(15,4,0);
    	Punto llegada = new Punto(15,3,0);
    	Direccion abajo = new DireccionAbajo();
    	Algoformer optimus = pool.obtenerOptimus();

    	arena.ubicarAlgoformer(optimus, partida);
        optimus.reiniciarMovimiento();

    	optimus.moverseHacia(abajo);
    	Assert.assertEquals(llegada, optimus.getUbicacion());
    	  	   	
    }
    
    @Test (expected = MovimientoNoValidoException.class)
    public void AlgoformerHumanoideNoPuedeSuperarSuLimiteDeMovimientos(){
    	Punto partida = new Punto(15, 4, 0);
    	Direccion abajo = new DireccionAbajo();
    	Algoformer megatron = pool.obtenerMegatron();

    	arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();

    	megatron.moverseHacia(abajo);   // Solamente se puede mover 1 espacio en Humanoide
    	megatron.moverseHacia(abajo);
    }
    
    @Test (expected = MovimientoNoValidoException.class)
    public void AlgoformerHumanoideChocaConAlternoEnTierra(){
    	Punto partida = new Punto(40,10,0);
    	Punto llegada = new Punto(39,11,0);
    	Direccion diagonalIzquierdaArriba = new DireccionIzquierdaArriba();
    	Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer bonecrusher = pool.obtenerBonecrusher();

        arena.ubicarAlgoformer(bumblebee, partida);
        bumblebee.reiniciarMovimiento();
        arena.ubicarAlgoformer(bonecrusher, llegada);
    	bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();

    	bumblebee.moverseHacia(diagonalIzquierdaArriba);
    }
    
	@Test
	public void AlgoformerMuertoNoPuedeTransformarse(){
		Algoformer optimusprime = pool.obtenerOptimus();
		Algoformer megatron = pool.obtenerMegatron();
		
        Punto p1 = new Punto(25, 25, 0);
        Punto p2 = new Punto(24, 24, 0);
        Direccion Arriba = new DireccionArriba();

        arena.ubicarAlgoformer(optimusprime, p2);
        optimusprime.reiniciarMovimiento();
        arena.ubicarAlgoformer(megatron, p1);
        megatron.reiniciarMovimiento();
        
        for (int i=0;i<10;i++){
            optimusprime.atacar(megatron);
        }

        // megatron sigue vivo (le quedan 50 de vida)
        optimusprime.atacar(megatron);
        // megatron esta muerto con exactamente 0 de vida
        
        megatron.moverseHacia(Arriba);
    }
}


    

