package fiuba.algo3.model.arena;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArenaTest {

    private Arena arena = Arena.getInstance();
    private AlgoformerPool pool = AlgoformerPool.getInstance();


    @Before
    public void before() {
        arena.inicializar();
    }

    @Test
    public void preguntarSiUnCasilleroContieneLaChispaSiNoLaContieneDaFalse(){
    	Punto punto =new Punto(1,1,0);
    	Assert.assertFalse(arena.contieneChispa(punto));
    }
    
    @Test
    public void preguntarSiUnCasilleroContieneLaChispaSiLaContieneDaTrue(){
    	Punto punto =new Punto(26,26,0);
    	Assert.assertTrue(arena.contieneChispa(punto));
    }

    @Test
    public void obtenerArenaDosVecesSonLaMismaInstancia() {
        Arena arena2 = Arena.getInstance();
        Assert.assertTrue(arena == arena2);
    }

    @Test
    public void preguntarSiUnCasilleroEstaOcupadoDondeNoHayAlgoformerDaFalse() {
        Punto punto = new Punto(1, 1, 0);
        Assert.assertFalse(arena.estaOcupado(punto));
    }

    @Test
    public void preguntarSiUnCasilleroEstaOcupadoDondeHayAlgoformerDaTrue() {
        Punto punto = new Punto(1, 3, 0);
        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, punto);
        Assert.assertTrue(arena.estaOcupado(punto));
    }



}
