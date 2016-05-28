package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerAtaqueHumanoideTest {
	
	@Before
	public void before(){
		AlgoformerPool pool = AlgoformerPool.getInstance();
		pool.inicializar();
	}

    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer megatron = pool.obtenerMegatron();
        megatron.transformarse();
        megatron.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();
        bumblebee.transformarse();
        bumblebee.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoHumanoideDecepticonPierdeVidaAdecuada() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
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
        
        bonecrusher.transformarse();
        bumblebee.transformarse();
        
        bonecrusher.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 320);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer ratchet = pool.obtenerRatchet();
        
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

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();
        
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
