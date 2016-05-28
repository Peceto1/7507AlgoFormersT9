package fiuba.algo3.model.unidades;


import org.junit.Test;
import org.junit.Assert;

public class AlgoformerAtaqueAlternoTest {

    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
        bonecrusher.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500,OptimusPrimeAlterno.getInstance());
        optimusprime.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 500);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoAlternoDecepticonPierdeVidaAdecuada() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500,OptimusPrimeAlterno.getInstance());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());

        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 185);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoAlternoAutobotPierdeVidaAdecuada() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500,OptimusPrimeAlterno.getInstance());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());

        bonecrusher.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 470);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500,OptimusPrimeAlterno.getInstance());
        Algoformer bumblebee = new Bumblebee("Bumblebee", 350,BumblebeeAlterno.getInstance());

        optimusprime.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer frenzy = new Frenzy("Frenzy", 150, FrenzyAlterno.getInstance());
        Algoformer megatron = new Megatron("Megatron", 550, MegatronAlterno.getInstance());

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }
    
    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
    	Algoformer bumblebee = new Bumblebee("Bumblebee", 350,BumblebeeAlterno.getInstance());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
        
        for (int i=0;i<11;i++){
        	bonecrusher.atacar(bumblebee);
        }

        // bumblebee sigue vivo (le quedan 20 de vida)
        bonecrusher.atacar(bumblebee);
        Assert.assertFalse(bumblebee.estaVivo());
    }

    @Test
    public void AutobotAtacaADecepticonHastaMatarloLuegoDecepticonNoEstaVivo() {
        Algoformer ratchet = new Ratchet("Ratchet", 150, RatchetAlterno.getInstance());
        Algoformer frenzy = new Frenzy("Frenzy", 400, FrenzyAlterno.getInstance());

        for (int i=0; i<11; i++) {
            ratchet.atacar(frenzy);
        }

        // frenzy sigue vivo (le quedan 15 de vida)
        ratchet.atacar(frenzy);
        Assert.assertFalse(frenzy.estaVivo());
    }
    

}
