package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;

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
    	PuntoTierra punto = new PuntoTierra(26,26);
        arena.colocarChispa(punto);
        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, punto);
        Assert.assertFalse(optimus.tieneChispa());
    }

    @Test
    public void AlgoformerEnEstadoHumanoideAlCapturarChispaTieneLaChispa() {
        Algoformer frenzy = pool.obtenerFrenzy();
        PuntoTierra punto = new PuntoTierra(26,26);
        arena.colocarChispa(punto);
        arena.ubicarAlgoformer(frenzy, punto);
        frenzy.capturarChispa();

        Assert.assertTrue(frenzy.tieneChispa());
    }

    @Test(expected = ImposibleCapturarChispaException.class)
    public void AlgoformerEnEstadoAlternoNoPuedeCapturarLaChispa() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        PuntoTierra punto = new PuntoTierra(26,26);
        arena.colocarChispa(punto);
        arena.ubicarAlgoformer(bumblebee, punto);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.capturarChispa();

    }
    
    @Test (expected = ImposibleCapturarChispaException.class)
    public void AlgoformerNoPuedeAgarrarLaChispaSiNoSeEncuentraEnElMismoCasillero(){
    	PuntoTierra punto = new PuntoTierra(15,4);
        PuntoTierra ubicacionChispa = new PuntoTierra(26, 26);
        Algoformer bumblebee = pool.obtenerBumblebee();
        arena.colocarChispa(ubicacionChispa);
        arena.ubicarAlgoformer(bumblebee, punto);
        bumblebee.reiniciarMovimiento();
        bumblebee.capturarChispa();
    }

}
