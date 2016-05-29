package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Test;

public class AlgoformerPoolTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();


    @Test
    public void obtenerOptimusPrimeDosVecesSonLaMismaInstancia() {
        Algoformer optimus1 = pool.obtenerOptimus();
        Algoformer optimus2 = pool.obtenerOptimus();

        Assert.assertTrue(optimus1 == optimus2);
    }

    @Test
    public void obtenerBumblebeeDosVecesSonLaMismaInstancia() {
        Algoformer bumblebee1 = pool.obtenerBumblebee();
        Algoformer bumblebee2 = pool.obtenerBumblebee();

        Assert.assertTrue(bumblebee1 == bumblebee2);
    }

    @Test
    public void obtenerRatchetDosVecesSonLaMismaInstancia() {
        Algoformer ratchet1 = pool.obtenerRatchet();
        Algoformer ratchet2 = pool.obtenerRatchet();

        Assert.assertTrue(ratchet1 == ratchet2);
    }

    @Test
    public void obtenerMegatronDosVecesSonLaMismaInstancia() {
        Algoformer megatron1 = pool.obtenerMegatron();
        Algoformer megatron2 = pool.obtenerMegatron();

        Assert.assertTrue(megatron1 == megatron2);
    }

    @Test
    public void obtenerBonecrusherDosVecesSonLaMismaInstancia() {
        Algoformer bonecrusher1 = pool.obtenerBonecrusher();
        Algoformer bonecrusher2 = pool.obtenerBonecrusher();

        Assert.assertTrue(bonecrusher1 == bonecrusher2);
    }

    @Test
    public void obtenerFrenzyDosVecesSonLaMismaInstancia() {
        Algoformer frenzy1 = pool.obtenerFrenzy();
        Algoformer frenzy2 = pool.obtenerFrenzy();

        Assert.assertTrue(frenzy1 == frenzy2);
    }

    @Test
    public void obtenerOptimusPrimeYLuegoObtenerMegatronSonInstanciasDistintas() {
        Algoformer optimus = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();

        Assert.assertFalse(optimus == megatron);
    }


}
