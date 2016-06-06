package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerAtaqueHumanoideTest {

    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arenaDeJuego = Arena.getInstance();

	
	@Before
	public void before(){
		arenaDeJuego.inicializar();
		instanciadorDeAlgoformers.inicializar();
	}

    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        PuntoTierra ubicacionMegatron = new PuntoTierra(2, 2);
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        megatron.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        
        PuntoTierra ubicacionBumblebee = new PuntoTierra(12,3);
        arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionBumblebee);
        bumblebee.reiniciarMovimiento();
        
        bumblebee.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoHumanoideDecepticonPierdeVidaAdecuada() {
        Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        
        PuntoTierra ubicacionOptimus = new PuntoTierra(10,10);
        PuntoTierra ubicacionBoneCrusher = new PuntoTierra(11,11);
        arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBoneCrusher);
        bonecrusher.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(optimusprime, ubicacionOptimus);
        optimusprime.reiniciarMovimiento();
        
        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 150);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoHumanoideAutobotPierdeVidaAdecuada() {
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        PuntoTierra ubicacionBumblebee = new PuntoTierra(40,40);
        PuntoTierra ubicacionBoneCrusher = new PuntoTierra(41,40);
        
        arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBoneCrusher);
        bonecrusher.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionBumblebee);
        bumblebee.reiniciarMovimiento();
        
        bonecrusher.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 320);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        PuntoTierra ubicacionRatchet = new PuntoTierra(24, 24);
        PuntoTierra ubicacionBumblebee = new PuntoTierra(25, 25);
        arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionRatchet);
        ratchet.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionBumblebee);
        bumblebee.reiniciarMovimiento();
        
        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        PuntoTierra ubicacionFrenzy = new PuntoTierra(20,20);
        PuntoTierra ubicacionMegatron = new PuntoTierra(17,17);

        arenaDeJuego.ubicarAlgoformer(frenzy, ubicacionFrenzy);
        frenzy.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
        Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        PuntoTierra ubicacionMegatron = new PuntoTierra(25, 25);
        PuntoTierra ubicacionOptimus = new PuntoTierra(24, 24);

        arenaDeJuego.ubicarAlgoformer(optimusprime, ubicacionOptimus);
        optimusprime.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        
        for (int i=0;i<49;i++){
            megatron.atacar(optimusprime);
        }

        // optimusprime sigue vivo (le quedan 10 de vida)
        megatron.atacar(optimusprime);
        Assert.assertFalse(optimusprime.estaVivo());
    }

    @Test
    public void AutobotAtacaADecepticonHastaMatarloLuegoDecepticonNoEstaVivo() {
        Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();

        PuntoTierra ubicacionMegatron = new PuntoTierra(25, 25);
        PuntoTierra ubicacionOptimus = new PuntoTierra(24, 24);

        arenaDeJuego.ubicarAlgoformer(optimusprime, ubicacionOptimus);
        optimusprime.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();

        for (int i=0; i<10; i++) {
            optimusprime.atacar(megatron);
        }

        // megatron sigue vivo (le quedan 50 de vida)
        optimusprime.atacar(megatron);
        Assert.assertFalse(megatron.estaVivo());
    }
    
	@Test
	public void AlgoformerMuertoNoPuedeTransformarse(){
		Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		
        PuntoTierra ubicacionMegatron = new PuntoTierra(25, 25);
        PuntoTierra ubicacionOptimus = new PuntoTierra(24, 24);

        arenaDeJuego.ubicarAlgoformer(optimusprime, ubicacionOptimus);
        optimusprime.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        
        for (int i=0;i<49;i++){
            megatron.atacar(optimusprime);
        }

        // optimusprime sigue vivo (le quedan 10 de vida)
        megatron.atacar(optimusprime);
        Assert.assertFalse(optimusprime.estaVivo());
    }

}
