package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;

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
        Punto aire = new Punto(25,25,1);
        Punto tierra = new Punto(24,24,0);
        
        arena.ubicarAlgoformer(ratchet,aire);
        arena.ubicarAlgoformer(bumblebee, tierra);
        ratchet.reiniciarMovimiento();
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();

        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }
    
    @Test
    public void AutobotHumanoideAtacaAAutobotAlternoNoLeSacaVida(){
        Algoformer ratchet = pool.obtenerRatchet();
        Algoformer bumblebee = pool.obtenerBumblebee();
        Punto aire = new Punto(25,25,1);
        Punto tierra = new Punto(24,24,0);
        
        arena.ubicarAlgoformer(ratchet,aire);
        arena.ubicarAlgoformer(bumblebee, tierra);
        ratchet.reiniciarMovimiento();
        bumblebee.reiniciarMovimiento();
        ratchet.transformarse();

        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }
    
    @Test
    public void DecepticonAlternoAtacaADecepticonHumanoideNoLeSacaVida(){
        Algoformer frenzy = pool.obtenerFrenzy();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        Punto tierra1 = new Punto(25,25,0);
        Punto tierra2 = new Punto(24,24,0);
        
        arena.ubicarAlgoformer(frenzy,tierra1);
        arena.ubicarAlgoformer(bonecrusher, tierra2);
        frenzy.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();

        frenzy.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }
    
    @Test
    public void DecepticonHumanoideAtacaADecepticonAlternoNoLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        Punto aire = new Punto(25,25,1);
        Punto tierra = new Punto(24,24,0);
        
        arena.ubicarAlgoformer(megatron,aire);
        arena.ubicarAlgoformer(bonecrusher, tierra);
        megatron.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();
        megatron.transformarse();

        megatron.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void DecepticonAlternoAtacaAAutobotHumanoideYLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer optimusPrime = pool.obtenerOptimus();
        Punto aire = new Punto(25,25,1);
        Punto tierra = new Punto(24,24,0);
        
        arena.ubicarAlgoformer(megatron,aire);
        arena.ubicarAlgoformer(optimusPrime, tierra);
        megatron.reiniciarMovimiento();
        optimusPrime.reiniciarMovimiento();
        optimusPrime.transformarse();

        megatron.atacar(optimusPrime);
        Assert.assertEquals(optimusPrime.getVida(), 445);
    }
    
    @Test
    public void DecepticonHumanoideAtacaAAutobotAlternoYLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer optimusPrime = pool.obtenerOptimus();
        Punto aire = new Punto(25,25,1);
        Punto tierra = new Punto(24,24,0);
        
        arena.ubicarAlgoformer(megatron,aire);
        arena.ubicarAlgoformer(optimusPrime, tierra);
        megatron.reiniciarMovimiento();
        optimusPrime.reiniciarMovimiento();
        megatron.transformarse();

        megatron.atacar(optimusPrime);
        Assert.assertEquals(optimusPrime.getVida(), 490);
    }

    @Test
    public void AutobotAlternoAtacaADecepticonHumanoideYLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer ratchet = pool.obtenerRatchet();
        Punto aire1 = new Punto(25,25,1);
        Punto aire2 = new Punto(24,24,1);
        
        arena.ubicarAlgoformer(megatron,aire1);
        arena.ubicarAlgoformer(ratchet, aire2);
        megatron.reiniciarMovimiento();
        ratchet.reiniciarMovimiento();
        megatron.transformarse();

        ratchet.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 515);
    }
    
    @Test
    public void AutobotHumanoideAtacaADecepticonAlternoYLeSacaVida(){
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer ratchet = pool.obtenerRatchet();
        Punto aire1 = new Punto(25,25,1);
        Punto aire2 = new Punto(24,24,1);
        
        arena.ubicarAlgoformer(megatron,aire1);
        arena.ubicarAlgoformer(ratchet, aire2);
        megatron.reiniciarMovimiento();
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();

        ratchet.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 545);
    }
    
}
