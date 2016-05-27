package fiuba.algo3.model.unidades;

import org.junit.Test;

public class AlgoformerTest {

    @Test
    public void DecepticonAtacarseASiMismoImprimeFriendlyFire() {
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, new BoneCrusherAlterno());
        bonecrusher.atacar(bonecrusher);
    }

    @Test
    public void AutobotAtacarseASiMismoImprimeFriendlyFire() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, new OptimusPrimeAlterno());
        optimusprime.atacar(optimusprime);
    }

    @Test
    public void AutobotAtacaADecepticonImprimeAutobotAtacaADecepticon() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, new OptimusPrimeAlterno());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, new BoneCrusherAlterno());

        optimusprime.atacar(bonecrusher);
    }

    @Test
    public void DecepticonAtacaAAutobotImprimeDecepticonAtacaAAutobot() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, new OptimusPrimeAlterno());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, new BoneCrusherAlterno());

        bonecrusher.atacar(optimusprime);
    }

    @Test
    public void AutobotAtacaAotroAutobotImprimeFriendlyFire() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500, new OptimusPrimeAlterno());
        Algoformer bumblebee = new Bumblebee("OptimusPrime", 350, new OptimusPrimeAlterno());

        optimusprime.atacar(bumblebee);
    }

}
