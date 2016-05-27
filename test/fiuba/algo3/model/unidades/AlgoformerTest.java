package fiuba.algo3.model.unidades;


import org.junit.Test;
import org.junit.Assert;

public class AlgoformerTest {

    @Test
    public void DecepticonAtacarseASiMismoImprimeFriendlyFire() {
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
        bonecrusher.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 200);
    }

    @Test
    public void AutobotAtacarseASiMismoImprimeFriendlyFire() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, new OptimusPrimeAlterno());
        optimusprime.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 500);
    }

    @Test
    public void AutobotAtacaADecepticonImprimeAutobotAtacaADecepticon() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, new OptimusPrimeAlterno());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());

        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 185);
    }

    @Test
    public void DecepticonAtacaAAutobotImprimeDecepticonAtacaAAutobot() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, new OptimusPrimeAlterno());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());

        bonecrusher.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 470);
    }

    @Test
    public void AutobotAtacaAotroAutobotImprimeFriendlyFire() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, new OptimusPrimeAlterno());
        Algoformer bumblebee = new Bumblebee("Bumblebee", 350, new OptimusPrimeAlterno());

        optimusprime.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }
    
    @Test
    public void DecepticonAtacaAAutobotHastaMatarlo() {
    	Algoformer bumblebee = new Bumblebee("Bumblebee", 350, new OptimusPrimeAlterno());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
        
        for (int i=0;i<11;i++){
        	bonecrusher.atacar(bumblebee);
        }

        // bumblebee sigue vivo (le quedan 20 de vida)
        bonecrusher.atacar(bumblebee);
        Assert.assertFalse(bumblebee.estaVivo());
        
    }

}
