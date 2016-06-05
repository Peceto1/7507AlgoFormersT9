package fiuba.algo3.model.unidades;


import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;

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
        PuntoTierra bonePos = new PuntoTierra(26,1);
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();        // Lo paso al Alterno
        bonecrusher.reiniciarMovimiento();
        
        bonecrusher.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer optimusprime = pool.obtenerOptimus();
        PuntoTierra optimusPos = new PuntoTierra(26,1);
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        optimusprime.reiniciarMovimiento();
        optimusprime.transformarse();
        optimusprime.reiniciarMovimiento();
        
        optimusprime.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 500);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoAlternoDecepticonPierdeVidaAdecuada() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();

        PuntoTierra optimusPos = new PuntoTierra(13,5);
        PuntoTierra bonePos = new PuntoTierra(15,9);
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        optimusprime.reiniciarMovimiento();
        optimusprime.transformarse();
        optimusprime.reiniciarMovimiento();
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();
        
        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 185);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoAlternoAutobotPierdeVidaAdecuada() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
        PuntoTierra optimusPos = new PuntoTierra(13,5);
        PuntoTierra bonePos = new PuntoTierra(16,5);
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        optimusprime.reiniciarMovimiento();
        optimusprime.transformarse();
        optimusprime.reiniciarMovimiento();
                
        bonecrusher.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 470);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bumblebee = pool.obtenerBumblebee();
        
        PuntoTierra optimusPos = new PuntoTierra(13,5);
        PuntoTierra bumbPos = new PuntoTierra(16,5);
        arena.ubicarAlgoformer(bumblebee, bumbPos);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.reiniciarMovimiento();
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        optimusprime.reiniciarMovimiento();
        optimusprime.transformarse();
        optimusprime.reiniciarMovimiento();

        optimusprime.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer megatron = pool.obtenerMegatron();
        Algoformer frenzy = pool.obtenerFrenzy();
        
        PuntoTierra megaPos = new PuntoTierra (35,10);
        PuntoTierra frenPos = new PuntoTierra (37,12);
        arena.ubicarAlgoformer(megatron, megaPos);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        arena.ubicarAlgoformer(frenzy, frenPos);
        frenzy.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }
    
    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
        PuntoTierra bonePos = new PuntoTierra(27,47);
        PuntoTierra bumblePos = new PuntoTierra(29,50);
        arena.ubicarAlgoformer(bumblebee, bonePos);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.reiniciarMovimiento();
        arena.ubicarAlgoformer(bonecrusher, bumblePos);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
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
        PuntoTierra p1 = new PuntoTierra(27,47);
        PuntoTierra p2 = new PuntoTierra(27,46);
        
        arena.ubicarAlgoformer(frenzy, p2);
        frenzy.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();
        arena.ubicarAlgoformer(ratchet, p1);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
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
    	PuntoTierra p1 = new PuntoTierra(31, 5);
    	PuntoTierra p2 = new PuntoTierra(32, 5);
    	
    	arena.ubicarAlgoformer(megatron, p1);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
    	arena.ubicarAlgoformer(bumblebee, p2);
    	bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.reiniciarMovimiento();
    	megatron.reiniciarMovimiento();
    	
    	bumblebee.atacar(megatron);
    	Assert.assertEquals(megatron.getVida(), 530);
    	
    }
    
    @Test
    public void AutobotAereoAtacaADecepticonTerrestreEnRangoYLePega(){
    	Algoformer ratchet  = pool.obtenerRatchet();
    	Algoformer frenzy = pool.obtenerFrenzy();
    	PuntoTierra p2 = new PuntoTierra(31,5);
    	PuntoTierra p1 = new PuntoTierra(32,5);
    	
    	arena.ubicarAlgoformer(ratchet, p1);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();
    	arena.ubicarAlgoformer(frenzy, p2);
    	frenzy.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();
    	
    	ratchet.atacar(frenzy);
    	Assert.assertEquals(frenzy.getVida(), 365);	
    }
    
    @Test
    public void DecepticonAereoCombateConAutobotAereo(){
    	Algoformer megatron = pool.obtenerMegatron();
    	Algoformer ratchet = pool.obtenerRatchet();
    	PuntoTierra p1 = new PuntoTierra(50,50);
    	PuntoTierra p2 = new PuntoTierra(49,49);
    	
    	arena.ubicarAlgoformer(ratchet, p2);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();
    	arena.ubicarAlgoformer(megatron, p1);
    	megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
    	
    	megatron.atacar(ratchet);
    	Assert.assertEquals(ratchet.getVida(), 95);
    	
    }

}
