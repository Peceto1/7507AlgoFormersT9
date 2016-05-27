package fiuba.algo3.model.unidades;

import org.junit.Test;

public class AlgoformerTest {

    @Test
    public void AlgoformerAtacarseASiMismoImprimeFriendlyFire() {
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, new BoneCrusherAlterno());
        bonecrusher.atacar(bonecrusher);
    }

}
