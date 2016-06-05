package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;

public class AlgoformerAtaqueMixtoTest {
	private AlgoformerPool pool = AlgoformerPool.getInstance();
	private Arena arena = Arena.getInstance();
	
	@Before
	public void before(){
		arena.inicializar();
		pool.inicializar();
	}

    @Test
    public void AutobotAlternoAtacaAAutobotHumanoideNoLeSacaVida(){
        Algoformer ratchet = pool.obtenerRatchet();
        Algoformer bumblebee = pool.obtenerBumblebee();
        PuntoTierra p1 = new PuntoTierra(25,25);
        PuntoTierra p2 = new PuntoTierra(24,24);
        
        arena.ubicarAlgoformer(ratchet,p1);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();

        arena.ubicarAlgoformer(bumblebee, p2);
        bumblebee.reiniciarMovimiento();

        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }
    
    @Test
    public void AutobotHumanoideAtacaAAutobotAlternoNoLeSacaVida(){
        Algoformer ratchet = pool.obtenerRatchet();
        Algoformer bumblebee = pool.obtenerBumblebee();
        PuntoTierra p1 = new PuntoTierra(25,25);
        PuntoTierra p2 = new PuntoTierra(24,24);
        
        arena.ubicarAlgoformer(ratchet, p1);
        ratchet.reiniciarMovimiento();
        arena.ubicarAlgoformer(bumblebee, p2);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();

        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }
    
    @Test
    public void DecepticonAlternoAtacaADecepticonHumanoideNoLeSacaVida(){
        Algoformer frenzy = pool.obtenerFrenzy();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        PuntoTierra p1 = new PuntoTierra(25,25);
        PuntoTierra p2 = new PuntoTierra(24,24);
        
        arena.ubicarAlgoformer(frenzy, p1);
        frenzy.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();
        arena.ubicarAlgoformer(bonecrusher, p2);
        frenzy.reiniciarMovimiento();

        frenzy.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }
    
    @Test
    public void DecepticonHumanoideAtacaADecepticonAlternoNoLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        PuntoTierra p1 = new PuntoTierra(25, 25);
        PuntoTierra p2 = new PuntoTierra(24, 24);
        
        arena.ubicarAlgoformer(megatron, p1);
        megatron.reiniciarMovimiento();
        arena.ubicarAlgoformer(bonecrusher, p2);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();

        megatron.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void DecepticonAlternoAtacaAAutobotHumanoideYLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer optimusPrime = pool.obtenerOptimus();
        PuntoTierra p1 = new PuntoTierra(25, 25);
        PuntoTierra p2 = new PuntoTierra(24, 24);
        
        arena.ubicarAlgoformer(megatron, p1);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        arena.ubicarAlgoformer(optimusPrime, p2);
        optimusPrime.reiniciarMovimiento();

        megatron.atacar(optimusPrime);
        Assert.assertEquals(optimusPrime.getVida(), 445);
    }
    
    @Test
    public void DecepticonHumanoideAtacaAAutobotAlternoYLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer optimusPrime = pool.obtenerOptimus();
        PuntoTierra p1 = new PuntoTierra(25, 25);
        PuntoTierra p2 = new PuntoTierra(24, 24);
        
        arena.ubicarAlgoformer(megatron,p1);
        megatron.reiniciarMovimiento();
        arena.ubicarAlgoformer(optimusPrime, p2);
        optimusPrime.reiniciarMovimiento();
        optimusPrime.transformarse();
        optimusPrime.reiniciarMovimiento();

        megatron.atacar(optimusPrime);
        Assert.assertEquals(optimusPrime.getVida(), 490);
    }

    @Test
    public void AutobotAlternoAtacaADecepticonHumanoideYLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer ratchet = pool.obtenerRatchet();
        PuntoTierra p1 = new PuntoTierra(25, 25);
        PuntoTierra p2 = new PuntoTierra(24, 24);
        
        arena.ubicarAlgoformer(megatron, p1);
        megatron.reiniciarMovimiento();
        arena.ubicarAlgoformer(ratchet, p2);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();

        ratchet.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 515);
    }
    
    @Test
    public void AutobotHumanoideAtacaADecepticonAlternoYLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer ratchet = pool.obtenerRatchet();
        PuntoTierra p1 = new PuntoTierra(25, 25);
        PuntoTierra p2 = new PuntoTierra(24, 24);
        
        arena.ubicarAlgoformer(megatron, p1);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        arena.ubicarAlgoformer(ratchet, p2);
        ratchet.reiniciarMovimiento();

        ratchet.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 545);
    }
    
}
