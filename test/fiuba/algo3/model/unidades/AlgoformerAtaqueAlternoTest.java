package fiuba.algo3.model.unidades;


import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class AlgoformerAtaqueAlternoTest {
	
	@Before
	public void before(){
		AlgoformerPool pool = AlgoformerPool.getInstance();
		pool.inicializar();
	}
		
	
    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        bonecrusher.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        optimusprime.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 500);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoAlternoDecepticonPierdeVidaAdecuada() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();

        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 185);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoAlternoAutobotPierdeVidaAdecuada() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();

        bonecrusher.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 470);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bumblebee = pool.obtenerBumblebee();

        optimusprime.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer frenzy = pool.obtenerFrenzy();

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }
    
    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
        for (int i=0;i<11;i++){
        	bonecrusher.atacar(bumblebee);
        }

        // bumblebee sigue vivo (le quedan 20 de vida)
        bonecrusher.atacar(bumblebee);
        Assert.assertFalse(bumblebee.estaVivo());
    }

    @Test
    public void AutobotAtacaADecepticonHastaMatarloLuegoDecepticonNoEstaVivo() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer ratchet = pool.obtenerRatchet();
        Algoformer frenzy = pool.obtenerFrenzy();

        for (int i=0; i<11; i++) {
            ratchet.atacar(frenzy);
        }

        // frenzy sigue vivo (le quedan 15 de vida)
        ratchet.atacar(frenzy);
        Assert.assertFalse(frenzy.estaVivo());
    }
    

}
