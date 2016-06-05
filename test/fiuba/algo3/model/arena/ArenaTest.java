package fiuba.algo3.model.arena;

import fiuba.algo3.model.espacio.PuntoTierra;
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
    	PuntoTierra punto = new PuntoTierra(1,1);
    	Assert.assertFalse(arena.contieneChispa(punto));
    }
    
    @Test
    public void preguntarSiUnCasilleroContieneLaChispaSiLaContieneDaTrue(){
    	PuntoTierra punto = new PuntoTierra(26,26);
        arena.colocarChispa(punto);
    	Assert.assertTrue(arena.contieneChispa(punto));
    }

    @Test
    public void obtenerArenaDosVecesSonLaMismaInstancia() {
        Arena arena2 = Arena.getInstance();
        Assert.assertTrue(arena == arena2);
    }

    @Test
    public void preguntarSiUnCasilleroEstaOcupadoDondeNoHayAlgoformerDaFalse() {
        PuntoTierra punto = new PuntoTierra(1, 1);
        Assert.assertFalse(arena.estaOcupado(punto));
    }

    @Test
    public void preguntarSiUnCasilleroEstaOcupadoDondeHayAlgoformerDaTrue() {
        PuntoTierra punto = new PuntoTierra(1, 3);
        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, punto);
        Assert.assertTrue(arena.estaOcupado(punto));
    }

    @Test
    public void removerChispaDeArenaDevuelveChispaYNoSeEncuentraMasEnLaArena() {
        PuntoTierra puntoDeChispa = new PuntoTierra(26, 26);
        arena.obtenerChispa(puntoDeChispa);
        Assert.assertFalse(arena.contieneChispa(puntoDeChispa));
    }



}
