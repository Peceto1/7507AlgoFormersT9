package fiuba.algo3.model.unidades;


import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;

import org.junit.Assert;
import org.junit.Before;

public class AlgoformerAtaqueAlternoTest {
	
    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arenaDeJuego = Arena.getInstance();
	
	@Before
	public void before(){
		instanciadorDeAlgoformers.inicializar();
		arenaDeJuego.inicializar();
	}
		
	
    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        PuntoTierra ubicacionBoneCrusher = new PuntoTierra(26,1);
        arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBoneCrusher);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();
        
        bonecrusher.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
        PuntoTierra ubicacionOptimus = new PuntoTierra(26,1);
        arenaDeJuego.ubicarAlgoformer(optimusprime, ubicacionOptimus);
        optimusprime.reiniciarMovimiento();
        optimusprime.transformarse();
        optimusprime.reiniciarMovimiento();
        
        optimusprime.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 500);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoAlternoDecepticonPierdeVidaAdecuada() {
        Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();

        PuntoTierra ubicacionOptimus = new PuntoTierra(13,5);
        PuntoTierra ubicacionBoneCrusher = new PuntoTierra(15,9);
        arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBoneCrusher);
        optimusprime.reiniciarMovimiento();
        optimusprime.transformarse();
        optimusprime.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(optimusprime, ubicacionOptimus);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();
        
        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 185);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoAlternoAutobotPierdeVidaAdecuada() {
        Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        
        PuntoTierra ubicacionOptimus = new PuntoTierra(13,5);
        PuntoTierra ubicacionBoneCrusher = new PuntoTierra(16,5);
        arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBoneCrusher);
        bonecrusher.reiniciarMovimiento();
        bonecrusher.transformarse();
        bonecrusher.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(optimusprime, ubicacionOptimus);
        optimusprime.reiniciarMovimiento();
        optimusprime.transformarse();
        optimusprime.reiniciarMovimiento();
                
        bonecrusher.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 470);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer optimusprime = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        
        PuntoTierra ubicacionOptimus = new PuntoTierra(13,5);
        PuntoTierra ubicacionBumblebee = new PuntoTierra(16,5);
        arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionBumblebee);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(optimusprime, ubicacionOptimus);
        optimusprime.reiniciarMovimiento();
        optimusprime.transformarse();
        optimusprime.reiniciarMovimiento();

        optimusprime.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        
        PuntoTierra ubicacionMegatron = new PuntoTierra (35,10);
        PuntoTierra ubicacionFrenzy = new PuntoTierra (37,12);
        arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(frenzy, ubicacionFrenzy);
        frenzy.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }
    
    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        
        PuntoTierra ubicacionBoneCrusher = new PuntoTierra(27,47);
        PuntoTierra ubicacionBumblebee = new PuntoTierra(29,50);
        arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionBoneCrusher);
        bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBumblebee);
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
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        PuntoTierra ubicacionRatchet = new PuntoTierra(27,47);
        PuntoTierra ubicacionFrenzy = new PuntoTierra(27,46);
        
        arenaDeJuego.ubicarAlgoformer(frenzy, ubicacionFrenzy);
        frenzy.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();
        arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionRatchet);
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
    	Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
    	Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
    	PuntoTierra ubicacionMegatron = new PuntoTierra(31, 5);
    	PuntoTierra ubicacionBumblebee = new PuntoTierra(32, 5);
    	
    	arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
    	arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionBumblebee);
    	bumblebee.reiniciarMovimiento();
        bumblebee.transformarse();
        bumblebee.reiniciarMovimiento();
    	megatron.reiniciarMovimiento();
    	
    	bumblebee.atacar(megatron);
    	Assert.assertEquals(megatron.getVida(), 530);
    	
    }
    
    @Test
    public void AutobotAereoAtacaADecepticonTerrestreEnRangoYLePega(){
    	Algoformer ratchet  = instanciadorDeAlgoformers.obtenerRatchet();
    	Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
    	PuntoTierra ubicacionFrenzy = new PuntoTierra(31,5);
    	PuntoTierra ubicacionRatchet = new PuntoTierra(32,5);
    	
    	arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionRatchet);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();
    	arenaDeJuego.ubicarAlgoformer(frenzy, ubicacionFrenzy);
    	frenzy.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();
    	
    	ratchet.atacar(frenzy);
    	Assert.assertEquals(frenzy.getVida(), 365);	
    }
    
    @Test
    public void DecepticonAereoCombateConAutobotAereo(){
    	Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
    	Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
    	PuntoTierra ubicacionMegatron = new PuntoTierra(50,50);
    	PuntoTierra ubicacionRatchet = new PuntoTierra(49,49);
    	
    	arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionRatchet);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();
    	arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
    	megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
    	
    	megatron.atacar(ratchet);
    	Assert.assertEquals(ratchet.getVida(), 95);
    	
    }

}
