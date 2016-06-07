package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerLealtadTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();

    @Before
    public void before() {
        pool.inicializar();
    }

    @Test
    public void preguntarSiUnAutobotEsLealAOtroAutobotDaTrue() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer optimus = pool.obtenerOptimus();

        Assert.assertTrue(bumblebee.esLealA(optimus));
    }

    @Test
    public void preguntarSiUnDecepticonEsLealAOtroDecepticonDaTrue() {
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer frenzy = pool.obtenerFrenzy();

        Assert.assertTrue(megatron.esLealA(frenzy));
    }

    @Test
    public void pregutarSiUnAutobotEsLealAUnDecepticonDaFalse() {
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        Algoformer ratchet = pool.obtenerRatchet();

        Assert.assertFalse(bonecrusher.esLealA(ratchet));
    }

    @Test
    public void preguntarSiUnDecepticonEsLealAUnAutobotDaFalse() {
        Algoformer optimus = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();

        Assert.assertFalse(megatron.esLealA(optimus));
    }


}
