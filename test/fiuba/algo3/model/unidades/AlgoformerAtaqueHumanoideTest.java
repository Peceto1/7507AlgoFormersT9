package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerAtaqueHumanoideTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();

	
	@Before
	public void before(){
		arena.inicializar();
		pool.inicializar();
	}

    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer megatron = pool.obtenerMegatron();
        Punto aire = new Punto(2, 2, 1);
        arena.ubicarAlgoformer(megatron, aire);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();
        
        Punto lugarBumble = new Punto(12,3,0);
        arena.ubicarAlgoformer(bumblebee, lugarBumble);
            
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        
        bumblebee.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoHumanoideDecepticonPierdeVidaAdecuada() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
        Punto optimusPos = new Punto(10,10,0);
        Punto bonePos = new Punto(11,11,0);
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        
        optimusprime.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        optimusprime.transformarse();
        
        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 150);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoHumanoideAutobotPierdeVidaAdecuada() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
        Punto bumblePos = new Punto(40,40,0);
        Punto bonePos = new Punto(41,40,0);
        
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        arena.ubicarAlgoformer(bumblebee, bumblePos);
        bonecrusher.reiniciarMovimiento();
        bumblebee.reiniciarMovimiento();
        
        bonecrusher.transformarse();
        bumblebee.transformarse();
        
        bonecrusher.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 320);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer ratchet = pool.obtenerRatchet();
        Punto aire = new Punto(24, 24, 1);
        Punto tierra = new Punto(25, 25, 0);
        arena.ubicarAlgoformer(ratchet, aire);
        arena.ubicarAlgoformer(bumblebee, tierra);
        ratchet.reiniciarMovimiento();
        bumblebee.reiniciarMovimiento();
        ratchet.transformarse();
        bumblebee.transformarse();
        
        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
        AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer frenzy = pool.obtenerFrenzy();
        Algoformer megatron = pool.obtenerMegatron();
        
        Punto frenzyPos = new Punto(20,20,0);
        Punto megatronPos = new Punto(17,17,1);
        arena.ubicarAlgoformer(frenzy, frenzyPos);
        arena.ubicarAlgoformer(megatron, megatronPos);
        
        frenzy.reiniciarMovimiento();
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        frenzy.transformarse();

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();
        Punto aire = new Punto(25, 25, 1);
        Punto tierra = new Punto(24, 24, 0);
        arena.ubicarAlgoformer(optimusprime, tierra);
        arena.ubicarAlgoformer(megatron, aire);
        optimusprime.reiniciarMovimiento();
        megatron.reiniciarMovimiento();
        optimusprime.transformarse();
        megatron.transformarse();
        
        for (int i=0;i<49;i++){
            megatron.atacar(optimusprime);
        }

        // optimusprime sigue vivo (le quedan 10 de vida)
        megatron.atacar(optimusprime);
        Assert.assertFalse(optimusprime.estaVivo());
    }

    @Test
    public void AutobotAtacaADecepticonHastaMatarloLuegoDecepticonNoEstaVivo() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();

        Punto aire = new Punto(25, 25, 1);
        Punto tierra = new Punto(24, 24, 0);

        arena.ubicarAlgoformer(optimusprime, tierra);
        arena.ubicarAlgoformer(megatron, aire);
        optimusprime.reiniciarMovimiento();
        megatron.reiniciarMovimiento();
        optimusprime.transformarse();
        megatron.transformarse();
        
        for (int i=0; i<10; i++) {
            optimusprime.atacar(megatron);
        }

        // megatron sigue vivo (le quedan 50 de vida)
        optimusprime.atacar(megatron);
        Assert.assertFalse(megatron.estaVivo());
    }

}
