package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;
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
        Direccion derecha = new Direccion(1, 0);

        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, partida);
        optimus.reiniciarMovimiento();

        optimus.moverseHacia(derecha);
        Assert.assertEquals(optimus.getUbicacion(), llegada);
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void ubicarAlgoformerEnElBordeDelTableroYPedirleQueSeMuevaHaciaArribaLanzaExcepcion() {
        Punto partida = new Punto(1, 51, 1);
        Direccion arriba = new Direccion(0, 1);

        Algoformer megatron = pool.obtenerMegatron();
        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.moverseHacia(arriba);
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void moverAlgoformerUnaCantidadDeVecesMayorASuVelocidadLanzaExcepcion() {
        Punto partida = new Punto(1, 1, 0);
        Direccion derecha = new Direccion(1, 0);
        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, partida);
        optimus.reiniciarMovimiento();

        int cantMovimientos = 5;    // Optimus tiene 5 de velocidad

        for (int i=0; i<cantMovimientos; i++)
            optimus.moverseHacia(derecha);

        optimus.moverseHacia(derecha);
    }

    @Test
    public void moverAlgoformerUnaCantidadDeVecesMayorASuVelocidadAlgoformerQuedaEnPosicionValida() {
        Punto partida = new Punto(1, 1, 0);
        Punto llegada = new Punto(6, 1, 0);
        Direccion derecha = new Direccion(1, 0);
        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, partida);
        optimus.reiniciarMovimiento();

        int cantMovimientos = 5;    // Optimus tiene 5 de velocidad

        for (int i=0; i<cantMovimientos; i++)
            optimus.moverseHacia(derecha);

        try {
            optimus.moverseHacia(derecha);
        } catch (MovimientoNoValidoException e) {
            Assert.assertEquals(llegada, optimus.getUbicacion());
        }
    }

    @Test
    public void moverAlgoformerUnaCantidadDeVecesMayorASuVelocidadTableroQuedaValido() {
        Punto partida = new Punto(1, 1, 0);
        Punto llegada = new Punto(9, 1, 0);
        Direccion derecha = new Direccion(1, 0);
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        arena.ubicarAlgoformer(bonecrusher, partida);
        bonecrusher.reiniciarMovimiento();

        int cantMovimientos = 8;    // BoneCrusher tiene 8 de velocidad

        for (int i=0; i<cantMovimientos; i++)
            bonecrusher.moverseHacia(derecha);

        try {
            bonecrusher.moverseHacia(derecha);
        } catch (MovimientoNoValidoException e) {
            Assert.assertTrue(arena.estaOcupado(llegada));
            Assert.assertTrue(!arena.estaOcupado(new Punto(10, 1, 0)));
        }
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void moverAlgoformerYQueSeTopeConOtroLanzaExcepcion() {
        Punto partida = new Punto(1, 1, 0);
        Direccion diagonalArriba = new Direccion(1, 1);
        Punto ocupado = new Punto(2, 2, 0);
        Algoformer bumbleblee = pool.obtenerBumblebee();
        Algoformer frenzy = pool.obtenerFrenzy();
        arena.ubicarAlgoformer(bumbleblee, partida);
        arena.ubicarAlgoformer(frenzy, ocupado);
        bumbleblee.reiniciarMovimiento();
        frenzy.reiniciarMovimiento();

        bumbleblee.moverseHacia(diagonalArriba);
    }
    
    @Test
    public void moverAlgoformerVoladorSobreTerrestreNoChocan() {
        Punto partida = new Punto(1, 1, 1);
        Direccion diagonalDerechaArriba = new Direccion(1, 1);
        Punto ocupado = new Punto(2, 2, 0);
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer frenzy = pool.obtenerFrenzy();
        arena.ubicarAlgoformer(megatron, partida);
        arena.ubicarAlgoformer(frenzy, ocupado);
        megatron.reiniciarMovimiento();
        frenzy.reiniciarMovimiento();

        megatron.moverseHacia(diagonalDerechaArriba);
    }

    @Test
    public void moverAlgoformerHastaAgotarSusMovimientosLuegoResetearMovimientoPuedeSeguirMoviendose() {
    	
        Punto partida = new Punto(25, 25, 0);
        Punto llegada = new Punto(31,19,0);
        Direccion diagonalDerechaAbajo = new Direccion(1, -1);
        Algoformer bumblebee = pool.obtenerBumblebee();
        arena.ubicarAlgoformer(bumblebee, partida);
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
    	Direccion abajo = new Direccion(0,-1);
    	Algoformer optimus = pool.obtenerOptimus();
    	arena.ubicarAlgoformer(optimus, partida);
    	
    	optimus.transformarse();
    	optimus.reiniciarMovimiento();
    	optimus.moverseHacia(abajo);
    	
    	Assert.assertEquals(llegada, optimus.getUbicacion());
    	  	   	
    }
    
    @Test (expected = MovimientoNoValidoException.class)
    public void AlgoformerHumanoideNoPuedeSuperarSuLimiteDeMovimientos(){
    	Punto partida = new Punto(15,4,0);
    	Punto llegada = new Punto(15,3,0);
    	Direccion abajo = new Direccion(0,-1);
    	Algoformer megatron = pool.obtenerMegatron();
    	megatron.transformarse();
    	arena.ubicarAlgoformer(megatron, partida);
    	
    	megatron.reiniciarMovimiento();
    	megatron.moverseHacia(abajo);
    	megatron.moverseHacia(abajo);
    	
    	Assert.assertEquals(llegada, megatron.getUbicacion());	  	   	
    }
    
    @Test (expected = MovimientoNoValidoException.class)
    public void AlgoformerHumanoideChocaConAlternoEnTierra(){
    	Punto partida = new Punto(40,10,0);
    	Punto llegada = new Punto(39,11,0);
    	Direccion diagonalIzquierdaArriba = new Direccion(-1,1);
    	
    	Algoformer bumblebee = pool.obtenerBumblebee();
    	Algoformer bonecrusher = pool.obtenerBonecrusher();
    	bumblebee.transformarse();
    	
    	arena.ubicarAlgoformer(bonecrusher, llegada);
    	arena.ubicarAlgoformer(bumblebee, partida);
    	bumblebee.reiniciarMovimiento();
    	bumblebee.moverseHacia(diagonalIzquierdaArriba);
    	
    }
}


    

