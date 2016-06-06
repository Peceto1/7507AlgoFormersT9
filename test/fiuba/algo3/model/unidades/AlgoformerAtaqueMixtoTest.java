package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;

public class AlgoformerAtaqueMixtoTest {
	private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
	private Arena arenaDeJuego = Arena.getInstance();
	
	@Before
	public void before(){
		arenaDeJuego.inicializar();
		instanciadorDeAlgoformers.inicializar();
	}

    @Test
    public void AutobotAlternoAtacaAAutobotHumanoideNoLeSacaVida(){
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        PuntoTierra ubicacionRatchet = new PuntoTierra(25,25);
        PuntoTierra ubicacionBumblebee = new PuntoTierra(24,24);
        
        arenaDeJuego.ubicarAlgoformer(ratchet,ubicacionRatchet);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();

        arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionBumblebee);
        bumblebee.reiniciarMovimiento();

        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }
    
    @Test
    public void AutobotHumanoideAtacaAAutobotAlternoNoLeSacaVida(){
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        PuntoTierra ubicacionRatchet = new PuntoTierra(25,25);
        PuntoTierra ubicacionBumblebee = new PuntoTierra(24,24);
        
        arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionRatchet);
        ratchet.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionBumblebee);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();

        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }
    
    @Test
    public void DecepticonAlternoAtacaADecepticonHumanoideNoLeSacaVida(){
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        PuntoTierra ubicacionFrenzy = new PuntoTierra(25,25);
        PuntoTierra ubicacionBoneCrusher = new PuntoTierra(24,24);
        
        arenaDeJuego.ubicarAlgoformer(frenzy, ubicacionFrenzy);
        frenzy.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBoneCrusher);
        frenzy.reiniciarMovimiento();

        frenzy.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }
    
    @Test
    public void DecepticonHumanoideAtacaADecepticonAlternoNoLeSacaVida(){
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        PuntoTierra ubicacionMegatron = new PuntoTierra(25, 25);
        PuntoTierra ubicacionBoneCrusher = new PuntoTierra(24, 24);
        
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBoneCrusher);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();

        megatron.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void DecepticonAlternoAtacaAAutobotHumanoideYLeSacaVida(){
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
        PuntoTierra ubicacionMegatron = new PuntoTierra(25, 25);
        PuntoTierra ubicacionOptimus = new PuntoTierra(24, 24);
        
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(optimusPrime, ubicacionOptimus);
        optimusPrime.reiniciarMovimiento();

        megatron.atacar(optimusPrime);
        Assert.assertEquals(optimusPrime.getVida(), 445);
    }
    
    @Test
    public void DecepticonHumanoideAtacaAAutobotAlternoYLeSacaVida(){
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
        PuntoTierra ubicacionMegatron = new PuntoTierra(25, 25);
        PuntoTierra ubicacionOptimus = new PuntoTierra(24, 24);
        
        arenaDeJuego.ubicarAlgoformer(megatron,ubicacionMegatron);
        megatron.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(optimusPrime, ubicacionOptimus);
        optimusPrime.reiniciarMovimiento();
        optimusPrime.transformarse();
        optimusPrime.reiniciarMovimiento();

        megatron.atacar(optimusPrime);
        Assert.assertEquals(optimusPrime.getVida(), 490);
    }

    @Test
    public void AutobotAlternoAtacaADecepticonHumanoideYLeSacaVida(){
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        PuntoTierra ubicacionMegatron = new PuntoTierra(25, 25);
        PuntoTierra ubicacionRatchet = new PuntoTierra(24, 24);
        
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionRatchet);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();

        ratchet.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 515);
    }
    
    @Test
    public void AutobotHumanoideAtacaADecepticonAlternoYLeSacaVida(){
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        PuntoTierra ubicacionMegatron = new PuntoTierra(25, 25);
        PuntoTierra ubicacionRatchet = new PuntoTierra(24, 24);
        
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionRatchet);
        ratchet.reiniciarMovimiento();

        ratchet.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 545);
    }
    
}
