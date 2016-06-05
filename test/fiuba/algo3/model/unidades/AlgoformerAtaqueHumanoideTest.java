package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerAtaqueHumanoideTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();

	
	@Before
	public void before(){
		arena.inicializar();
		pool.inicializar();
	}

    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer megatron = pool.obtenerMegatron();
        PuntoTierra punto = new PuntoTierra(2, 2);
        arena.ubicarAlgoformer(megatron, punto);
        megatron.reiniciarMovimiento();
        megatron.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        
        PuntoTierra lugarBumble = new PuntoTierra(12,3);
        arena.ubicarAlgoformer(bumblebee, lugarBumble);
        bumblebee.reiniciarMovimiento();
        
        bumblebee.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoHumanoideDecepticonPierdeVidaAdecuada() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        
        PuntoTierra optimusPos = new PuntoTierra(10,10);
        PuntoTierra bonePos = new PuntoTierra(11,11);
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        bonecrusher.reiniciarMovimiento();
        arena.ubicarAlgoformer(optimusprime, optimusPos);
        optimusprime.reiniciarMovimiento();
        
        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 150);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoHumanoideAutobotPierdeVidaAdecuada() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        PuntoTierra bumblePos = new PuntoTierra(40,40);
        PuntoTierra bonePos = new PuntoTierra(41,40);
        
        arena.ubicarAlgoformer(bonecrusher, bonePos);
        bonecrusher.reiniciarMovimiento();
        arena.ubicarAlgoformer(bumblebee, bumblePos);
        bumblebee.reiniciarMovimiento();
        
        bonecrusher.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 320);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer bumblebee = pool.obtenerBumblebee();
        Algoformer ratchet = pool.obtenerRatchet();
        PuntoTierra p1 = new PuntoTierra(24, 24);
        PuntoTierra p2 = new PuntoTierra(25, 25);
        arena.ubicarAlgoformer(ratchet, p1);
        ratchet.reiniciarMovimiento();
        arena.ubicarAlgoformer(bumblebee, p2);
        bumblebee.reiniciarMovimiento();
        
        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer frenzy = pool.obtenerFrenzy();
        Algoformer megatron = pool.obtenerMegatron();
        PuntoTierra frenzyPos = new PuntoTierra(20,20);
        PuntoTierra megatronPos = new PuntoTierra(17,17);

        arena.ubicarAlgoformer(frenzy, frenzyPos);
        frenzy.reiniciarMovimiento();
        arena.ubicarAlgoformer(megatron, megatronPos);
        megatron.reiniciarMovimiento();

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();
        PuntoTierra p1 = new PuntoTierra(25, 25);
        PuntoTierra p2 = new PuntoTierra(24, 24);

        arena.ubicarAlgoformer(optimusprime, p2);
        optimusprime.reiniciarMovimiento();
        arena.ubicarAlgoformer(megatron, p1);
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
        Algoformer optimusprime = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();

        PuntoTierra p1 = new PuntoTierra(25, 25);
        PuntoTierra p2 = new PuntoTierra(24, 24);

        arena.ubicarAlgoformer(optimusprime, p2);
        optimusprime.reiniciarMovimiento();
        arena.ubicarAlgoformer(megatron, p1);
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
		Algoformer optimusprime = pool.obtenerOptimus();
		Algoformer megatron = pool.obtenerMegatron();
		
        PuntoTierra p1 = new PuntoTierra(25, 25);
        PuntoTierra p2 = new PuntoTierra(24, 24);

        arena.ubicarAlgoformer(optimusprime, p2);
        optimusprime.reiniciarMovimiento();
        arena.ubicarAlgoformer(megatron, p1);
        megatron.reiniciarMovimiento();
        
        for (int i=0;i<49;i++){
            megatron.atacar(optimusprime);
        }

        // optimusprime sigue vivo (le quedan 10 de vida)
        megatron.atacar(optimusprime);
        Assert.assertFalse(optimusprime.estaVivo());
    }

}
