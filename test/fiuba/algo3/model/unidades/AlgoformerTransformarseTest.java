package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerTransformarseTest {
	
	@Before
	public void before(){
		AlgoformerPool pool = AlgoformerPool.getInstance();
		pool.inicializar();
	}


    @Test
    public void OptimusPrimeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusPrime = pool.obtenerOptimus();
        optimusPrime.transformarse();
        Assert.assertEquals(optimusPrime.getEstado(), OptimusPrimeHumanoide.getInstance());
    }

    @Test
    public void OptimusPrimeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusPrime = pool.obtenerOptimus();
        optimusPrime.transformarse();
        optimusPrime.transformarse();
        Assert.assertEquals(optimusPrime.getEstado(), OptimusPrimeAlterno.getInstance());
    }

    @Test
    public void BumblebeeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();
        bumblebee.transformarse();
        Assert.assertEquals(bumblebee.getEstado(), BumblebeeHumanoide.getInstance());
    }

    @Test
    public void BumblebeeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();
        bumblebee.transformarse();
        bumblebee.transformarse();
        Assert.assertEquals(bumblebee.getEstado(), BumblebeeAlterno.getInstance());
    }

    @Test
    public void RatchetEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer ratchet = pool.obtenerRatchet();
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetHumanoide.getInstance());
    }

    @Test
    public void RatchetEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer ratchet = pool.obtenerRatchet();
        ratchet.transformarse();
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetAlterno.getInstance());
    }

    @Test
    public void MegatronEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer megatron = pool.obtenerMegatron();
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronHumanoide.getInstance());
    }

    @Test
    public void MegatronEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer megatron = pool.obtenerMegatron();
        megatron.transformarse();
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronAlterno.getInstance());
    }

    @Test
    public void BoneCrusherEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        bonecrusher.transformarse();
        Assert.assertEquals(bonecrusher.getEstado(), BoneCrusherHumanoide.getInstance());
    }

    @Test
    public void BoneCrusherEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        bonecrusher.transformarse();
        bonecrusher.transformarse();
        Assert.assertEquals(bonecrusher.getEstado(), BoneCrusherAlterno.getInstance());
    }

    @Test
    public void FrenzyEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer frenzy = pool.obtenerFrenzy();
        frenzy.transformarse();
        Assert.assertEquals(frenzy.getEstado(), FrenzyHumanoide.getInstance());
    }

    @Test
    public void FrenzyEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer frenzy = pool.obtenerFrenzy();
        frenzy.transformarse();
        frenzy.transformarse();
        Assert.assertEquals(frenzy.getEstado(), FrenzyAlterno.getInstance());
    }


}
