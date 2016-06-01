package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerChispaTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();


    @Before
    public void before() {
        pool.inicializar();
        arena.inicializar();
    }


    @Test
    public void AlObtenerUnAlgoformerNoTieneLaChispa() {
    	Punto punto = new Punto(26,26,0);
        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, punto);
        Assert.assertFalse(optimus.tieneChispa());
    }

    @Test
    public void AlgoformerEnEstadoHumanoideAlCapturarChispaTieneLaChispa() {
        Algoformer frenzy = pool.obtenerFrenzy();
        Punto punto = new Punto(26,26,0);
        arena.ubicarAlgoformer(frenzy, punto);
        frenzy.capturarChispa();

        Assert.assertTrue(frenzy.tieneChispa());
    }

    @Test(expected = ImposibleCapturarChispaException.class)
    public void AlgoformerEnEstadoAlternoNoPuedeCapturarLaChispa() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        Punto punto = new Punto(26,26,0);
        arena.ubicarAlgoformer(bumblebee, punto);
        bumblebee.transformarse();
        bumblebee.capturarChispa();

    }
    
    @Test (expected = ImposibleCapturarChispaException.class)
    public void AlgoformerNoPuedeAgarrarLaChispaSiNoSeEncuentraEnElMismoCasillero(){
    	Punto punto = new Punto(15,4,0);
        Algoformer bumblebee = pool.obtenerBumblebee();
        arena.ubicarAlgoformer(bumblebee, punto);
        bumblebee.capturarChispa();
    }

}
