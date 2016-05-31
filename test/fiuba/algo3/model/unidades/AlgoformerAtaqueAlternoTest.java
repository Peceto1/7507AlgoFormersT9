package fiuba.algo3.model.unidades;


import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;

import org.junit.Assert;
import org.junit.Before;

public class AlgoformerAtaqueAlternoTest {
	
    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();
	
	@Before
	public void before(){
		pool.inicializar();
		arena.inicializar();
	}
		
	
    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        Punto bonePos = new Punto (26,1,0);
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        bonecrusher.reiniciarMovimiento();
        
        bonecrusher.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Punto optimusPos = new Punto (26,1,0);
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        optimusprime.reiniciarMovimiento();
        
        optimusprime.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 500);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoAlternoDecepticonPierdeVidaAdecuada() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();

        Punto optimusPos = new Punto(13,5,0);
        Punto bonePos = new Punto(15,9,0);
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        optimusprime.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();  
        
        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 185);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoAlternoAutobotPierdeVidaAdecuada() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
        Punto optimusPos = new Punto(13,5,0);
        Punto bonePos = new Punto(16,5,0);
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        optimusprime.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();      
                
        bonecrusher.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 470);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bumblebee = pool.obtenerBumblebee();
        
        Punto optimusPos = new Punto(13,5,0);
        Punto bumbPos = new Punto(16,5,0);
        arena.ubicarAlgoformer(bumblebee, bumbPos);
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        optimusprime.reiniciarMovimiento();
        bumblebee.reiniciarMovimiento();     

        optimusprime.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer frenzy = pool.obtenerFrenzy();
        
        Punto megaPos = new Punto (35,10,1);
        Punto frenPos = new Punto (37,12,0);
        arena.ubicarAlgoformer(megatron, megaPos);
        arena.ubicarAlgoformer(frenzy, frenPos);
        megatron.reiniciarMovimiento();
        frenzy.reiniciarMovimiento();

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }
    
    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
    	AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
        Punto bonePos = new Punto (27,47,0);
        Punto bumblePos = new Punto(29,50,0);
        arena.ubicarAlgoformer(bumblebee, bonePos);
        arena.ubicarAlgoformer(bonecrusher, bumblePos);
        bumblebee.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();
        
        for (int i=0;i<11;i++){
        	bonecrusher.atacar(bumblebee);
        }

        // bumblebee sigue vivo (le quedan 20 de vida)
        bonecrusher.atacar(bumblebee);
        Assert.assertFalse(bumblebee.estaVivo());
    }

    @Test
    public void AutobotAtacaADecepticonHastaMatarloLuegoDecepticonNoEstaVivo() {
        Algoformer ratchet = pool.obtenerRatchet();
        Algoformer frenzy = pool.obtenerFrenzy();
        Punto aire = new Punto (27,47,1);
        Punto tierra = new Punto(27,47,0);
        
        arena.ubicarAlgoformer(frenzy, tierra);
        arena.ubicarAlgoformer(ratchet, aire);
        frenzy.reiniciarMovimiento();
        ratchet.reiniciarMovimiento();
        
        for (int i=0; i<11; i++) {
            ratchet.atacar(frenzy);
        }

        // frenzy sigue vivo (le quedan 15 de vida)
        ratchet.atacar(frenzy);
        Assert.assertFalse(frenzy.estaVivo());
    }
    
    @Test
    public void AutobotTerrestreAtacaADecepticonAereoEnRangoYLePega(){
    	Algoformer bumblebee = pool.obtenerBumblebee();
    	Algoformer megatron = pool.obtenerMegatron();
    	Punto tierra = new Punto (31,5,0);
    	Punto aire = new Punto (32,5,1);
    	
    	arena.ubicarAlgoformer(megatron, aire);
    	arena.ubicarAlgoformer(bumblebee, tierra);
    	bumblebee.reiniciarMovimiento();
    	megatron.reiniciarMovimiento();
    	
    	bumblebee.atacar(megatron);
    	Assert.assertEquals(megatron.getVida(), 530);
    	
    }
    
    @Test
    public void AutobotAereoAtacaADecepticonTerrestreEnRangoYLePega(){
    	Algoformer ratchet  = pool.obtenerRatchet();
    	Algoformer frenzy = pool.obtenerFrenzy();
    	Punto tierra = new Punto (31,5,0);
    	Punto aire = new Punto (32,5,1);
    	
    	arena.ubicarAlgoformer(ratchet, aire);
    	arena.ubicarAlgoformer(frenzy, tierra);
    	ratchet.reiniciarMovimiento();
    	frenzy.reiniciarMovimiento();
    	
    	ratchet.atacar(frenzy);
    	Assert.assertEquals(frenzy.getVida(), 365);	
    }
    
    @Test
    public void DecepticonAereoCombateConAutobotAereo(){
    	Algoformer megatron = pool.obtenerMegatron();
    	Algoformer ratchet = pool.obtenerRatchet();
    	Punto aire = new Punto(50,50,1);
    	Punto aire2 = new Punto(49,49,1);
    	
    	arena.ubicarAlgoformer(ratchet, aire2);
    	arena.ubicarAlgoformer(megatron, aire);
    	megatron.reiniciarMovimiento();
    	ratchet.reiniciarMovimiento();
    	
    	megatron.atacar(ratchet);
    	Assert.assertEquals(ratchet.getVida(), 95);
    	
    }

}
