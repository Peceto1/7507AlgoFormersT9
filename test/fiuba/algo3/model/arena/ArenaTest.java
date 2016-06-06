package fiuba.algo3.model.arena;

import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArenaTest {

    private Arena arenaDeJuego = Arena.getInstance();
    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();


    @Before
    public void before() {
        arenaDeJuego.inicializar();
    }

    @Test
    public void preguntarSiUnCasilleroContieneLaChispaSiNoLaContieneDaFalse(){
    	PuntoTierra puntoDePrueba = new PuntoTierra(1,1);
    	Assert.assertFalse(arenaDeJuego.contieneChispa(puntoDePrueba));
    }
    
    @Test
    public void preguntarSiUnCasilleroContieneLaChispaSiLaContieneDaTrue(){
    	PuntoTierra puntoPosicionDeLaChispa = new PuntoTierra(26,26);
        arenaDeJuego.colocarChispa(puntoPosicionDeLaChispa);
    	Assert.assertTrue(arenaDeJuego.contieneChispa(puntoPosicionDeLaChispa));
    }

    @Test
    public void obtenerArenaDosVecesSonLaMismaInstancia() {
        Arena otraArenaDeJuego = Arena.getInstance();
        Assert.assertTrue(arenaDeJuego == otraArenaDeJuego);
    }

    @Test
    public void preguntarSiUnCasilleroEstaOcupadoDondeNoHayAlgoformerDaFalse() {
        PuntoTierra puntoDePrueba = new PuntoTierra(1, 1);
        Assert.assertFalse(arenaDeJuego.estaOcupado(puntoDePrueba));
    }

    @Test
    public void preguntarSiUnCasilleroEstaOcupadoDondeHayAlgoformerDaTrue() {
        PuntoTierra puntoPosicionDeOptimus = new PuntoTierra(1, 3);
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        arenaDeJuego.ubicarAlgoformer(optimus, puntoPosicionDeOptimus);
        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoPosicionDeOptimus));
    }

    @Test
    public void removerChispaDeArenaDevuelveChispaYNoSeEncuentraMasEnLaArena() {
        PuntoTierra puntoDeChispa = new PuntoTierra(26, 26);
        arenaDeJuego.obtenerChispa(puntoDeChispa);
        Assert.assertFalse(arenaDeJuego.contieneChispa(puntoDeChispa));
    }



}
