package fiuba.algo3.model.arena;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArenaTest {

    private Arena arenaDeJuego = Arena.getInstance();
    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();


    @Before
    public void before() {
        arenaDeJuego.inicializar();
        instanciadorDeAlgoformers.inicializar();
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

    @Test
    public void colocarAlgoformersAdyacentesAUnPuntoAlObtenerlosEstanTodos() {
        Punto puntoEnTierra = new PuntoTierra(5, 5);
        List<Punto> puntosAdyacentes = puntoEnTierra.obtenerAdyacentes();

        Algoformer algoformers[] = {instanciadorDeAlgoformers.obtenerOptimus(),
                                    instanciadorDeAlgoformers.obtenerMegatron(),
                                    instanciadorDeAlgoformers.obtenerBumblebee(),
                                    instanciadorDeAlgoformers.obtenerRatchet(),
                                    instanciadorDeAlgoformers.obtenerFrenzy(),
                                    instanciadorDeAlgoformers.obtenerBonecrusher()
                                    };

        List<Algoformer> listaDeAlgoformers2 = Arrays.asList(algoformers);

        arenaDeJuego.ubicarAlgoformer(algoformers[0], new PuntoTierra(5, 6));
        arenaDeJuego.ubicarAlgoformer(algoformers[1], new PuntoTierra(6, 6));
        arenaDeJuego.ubicarAlgoformer(algoformers[2], new PuntoTierra(4, 6));
        arenaDeJuego.ubicarAlgoformer(algoformers[3], new PuntoTierra(6, 4));
        arenaDeJuego.ubicarAlgoformer(algoformers[4], new PuntoTierra(4, 5));
        arenaDeJuego.ubicarAlgoformer(algoformers[5], new PuntoTierra(5, 4));

        List<Algoformer> listaDeAlgoformers = arenaDeJuego.obtenerAlgoformersEn(puntosAdyacentes);

        Assert.assertEquals(listaDeAlgoformers.size(), 6);
        Assert.assertTrue(listaDeAlgoformers.containsAll(listaDeAlgoformers2));
    }



}
