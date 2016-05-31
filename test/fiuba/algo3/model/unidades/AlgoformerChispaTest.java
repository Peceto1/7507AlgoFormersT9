package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Chispa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerChispaTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();


    @Before
    public void before() {
        pool.inicializar();
    }


    @Test
    public void AlObtenerUnAlgoformerNoTieneLaChispa() {
        Algoformer optimus = pool.obtenerOptimus();
        Assert.assertFalse(optimus.tieneChispa());
    }

    @Test
    public void AlgoformerEnEstadoHumanoideAlCapturarChispaTieneLaChispa() {
        Algoformer frenzy = pool.obtenerFrenzy();
        Chispa chispa = new Chispa();
        frenzy.capturarChispa(chispa);

        Assert.assertTrue(frenzy.tieneChispa());
    }

    @Test
    public void AlgoformerEnEstadoAlternoNoPuedeCapturarLaChispa() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        Chispa chispa = new Chispa();
        bumblebee.transformarse();
        bumblebee.capturarChispa(chispa);

        Assert.assertFalse(bumblebee.tieneChispa());
    }

}
