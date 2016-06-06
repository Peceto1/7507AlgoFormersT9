package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerChispaTest {

    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arenaDeJuego = Arena.getInstance();


    @Before
    public void before() {
        instanciadorDeAlgoformers.inicializar();
        arenaDeJuego.inicializar();
    }


    @Test
    public void AlObtenerUnAlgoformerNoTieneLaChispa() {
    	PuntoTierra puntoDeChispa = new PuntoTierra(26,26);
        arenaDeJuego.colocarChispa(puntoDeChispa);
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        arenaDeJuego.ubicarAlgoformer(optimus, puntoDeChispa);
        Assert.assertFalse(optimus.tieneChispa());
    }

    @Test
    public void AlgoformerEnEstadoHumanoideAlCapturarChispaTieneLaChispa() {
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        PuntoTierra puntoDeChispa = new PuntoTierra(26,26);
        arenaDeJuego.colocarChispa(puntoDeChispa);
        arenaDeJuego.ubicarAlgoformer(frenzy, puntoDeChispa);
        frenzy.capturarChispa();

        Assert.assertTrue(frenzy.tieneChispa());
    }

    @Test(expected = ImposibleCapturarChispaException.class)
    public void AlgoformerEnEstadoAlternoNoPuedeCapturarLaChispa() {
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        PuntoTierra puntoDeChispa = new PuntoTierra(26,26);
        arenaDeJuego.colocarChispa(puntoDeChispa);
        arenaDeJuego.ubicarAlgoformer(bumblebee, puntoDeChispa);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.capturarChispa();
    }
    
    @Test (expected = ImposibleCapturarChispaException.class)
    public void AlgoformerNoPuedeAgarrarLaChispaSiNoSeEncuentraEnElMismoCasillero(){
    	PuntoTierra posicionInicialBumblebee = new PuntoTierra(15,4);
        PuntoTierra ubicacionChispa = new PuntoTierra(26, 26);
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        arenaDeJuego.colocarChispa(ubicacionChispa);
        arenaDeJuego.ubicarAlgoformer(bumblebee, posicionInicialBumblebee);
        bumblebee.reiniciarMovimiento();
        bumblebee.capturarChispa();
    }

}
