package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerPoolTest {

    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();


    @Before
    public void before() {
        instanciadorDeAlgoformers.inicializar();
    }


    @Test
    public void obtenerOptimusPrimeDosVecesSonLaMismaInstancia() {
        Algoformer optimus1 = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer optimus2 = instanciadorDeAlgoformers.obtenerOptimus();

        Assert.assertTrue(optimus1 == optimus2);
    }

    @Test
    public void obtenerBumblebeeDosVecesSonLaMismaInstancia() {
        Algoformer bumblebee1 = instanciadorDeAlgoformers.obtenerBumblebee();
        Algoformer bumblebee2 = instanciadorDeAlgoformers.obtenerBumblebee();

        Assert.assertTrue(bumblebee1 == bumblebee2);
    }

    @Test
    public void obtenerRatchetDosVecesSonLaMismaInstancia() {
        Algoformer ratchet1 = instanciadorDeAlgoformers.obtenerRatchet();
        Algoformer ratchet2 = instanciadorDeAlgoformers.obtenerRatchet();

        Assert.assertTrue(ratchet1 == ratchet2);
    }

    @Test
    public void obtenerMegatronDosVecesSonLaMismaInstancia() {
        Algoformer megatron1 = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer megatron2 = instanciadorDeAlgoformers.obtenerMegatron();

        Assert.assertTrue(megatron1 == megatron2);
    }

    @Test
    public void obtenerBonecrusherDosVecesSonLaMismaInstancia() {
        Algoformer bonecrusher1 = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer bonecrusher2 = instanciadorDeAlgoformers.obtenerBonecrusher();

        Assert.assertTrue(bonecrusher1 == bonecrusher2);
    }

    @Test
    public void obtenerFrenzyDosVecesSonLaMismaInstancia() {
        Algoformer frenzy1 = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer frenzy2 = instanciadorDeAlgoformers.obtenerFrenzy();

        Assert.assertTrue(frenzy1 == frenzy2);
    }

    @Test
    public void obtenerOptimusPrimeYLuegoObtenerMegatronSonInstanciasDistintas() {
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();

        Assert.assertFalse(optimus == megatron);
    }

    @Test
    public void obtenerOptimusPrimeIndividualEsElMismoQueElDelEquipoAutobots() {
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer optimus2 = null;

        for (Algoformer autobot : instanciadorDeAlgoformers.obtenerEquipo("AUTOBOTS")) {
            if (autobot.getNombre().equals("Optimus Prime"))
                optimus2 = autobot;
        }

        Assert.assertTrue(optimus == optimus2);
    }


}
