package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Test;

public class AlgoformerAtaqueHumanoideTest {

    @Test
    public void DecepticonAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer megatron = new Megatron("Megatron", 200, MegatronHumanoide.getInstance());
        megatron.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 200);
    }

    @Test
    public void AutobotAtacarseASiMismoNoSeInflijeDanio() {
        Algoformer bumblebee = new Bumblebee("Bumblebee", 500, BumblebeeHumanoide.getInstance());
        bumblebee.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 500);
    }

    @Test
    public void AutobotAtacaADecepticonEnEstadoHumanoideDecepticonPierdeVidaAdecuada() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, OptimusPrimeHumanoide.getInstance());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherHumanoide.getInstance());

        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 150);
    }

    @Test
    public void DecepticonAtacaAAutobotEnEstadoHumanoideAutobotPierdeVidaAdecuada() {
        Algoformer bumblebee = new Bumblebee("Bumblebee", 350, BumblebeeHumanoide.getInstance());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherHumanoide.getInstance());

        bonecrusher.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 320);
    }

    @Test
    public void AutobotAtacaAotroAutobotVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer ratchet = new Ratchet("Ratchet", 150, RatchetHumanoide.getInstance());
        Algoformer bumblebee = new Bumblebee("Bumblebee", 350, BumblebeeHumanoide.getInstance());

        ratchet.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }

    @Test
    public void DecepticonAtacaAOtroDecepticonVidaDelReceptorDelAtaqueNoCambia() {
        Algoformer frenzy = new Frenzy("Frenzy", 150, FrenzyHumanoide.getInstance());
        Algoformer megatron = new Megatron("Megatron", 550, MegatronHumanoide.getInstance());

        frenzy.atacar(megatron);
        Assert.assertEquals(megatron.getVida(), 550);
    }

    @Test
    public void DecepticonAtacaAAutobotHastaMatarloLuegoAutobotNoEstaVivo() {
        Algoformer optimusprime = new OptimusPrime("Optimus Prime", 500, OptimusPrimeHumanoide.getInstance());
        Algoformer megatron = new Megatron("Megatron", 550, MegatronHumanoide.getInstance());

        for (int i=0;i<49;i++){
            megatron.atacar(optimusprime);
        }

        // optimusprime sigue vivo (le quedan 10 de vida)
        megatron.atacar(optimusprime);
        Assert.assertFalse(optimusprime.estaVivo());
    }

    @Test
    public void AutobotAtacaADecepticonHastaMatarloLuegoDecepticonNoEstaVivo() {
        Algoformer optimusprime = new OptimusPrime("Optimus Prime", 500, OptimusPrimeHumanoide.getInstance());
        Algoformer megatron = new Megatron("Megatron", 550, MegatronHumanoide.getInstance());

        for (int i=0; i<10; i++) {
            optimusprime.atacar(megatron);
        }

        // megatron sigue vivo (le quedan 50 de vida)
        optimusprime.atacar(megatron);
        Assert.assertFalse(megatron.estaVivo());
    }

}
