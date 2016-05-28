package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Test;

public class AlgoformerTransformarseTest {


    @Test
    public void OptimusPrimeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer optimusPrime = new OptimusPrime("Optimus Prime", 500, OptimusPrimeAlterno.getInstance());
        optimusPrime.transformarse();
        Assert.assertEquals(optimusPrime.getEstado(), OptimusPrimeHumanoide.getInstance());
    }

    @Test
    public void OptimusPrimeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer optimusPrime = new OptimusPrime("Optimus Prime", 500, OptimusPrimeAlterno.getInstance());
        optimusPrime.transformarse();
        optimusPrime.transformarse();
        Assert.assertEquals(optimusPrime.getEstado(), OptimusPrimeAlterno.getInstance());
    }

    @Test
    public void BumblebeeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer bumblebee = new Bumblebee("Bumblebee", 350, BumblebeeAlterno.getInstance());
        bumblebee.transformarse();
        Assert.assertEquals(bumblebee.getEstado(), BumblebeeHumanoide.getInstance());
    }

    @Test
    public void BumblebeeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer bumblebee = new Bumblebee("Bumblebee", 350, BumblebeeAlterno.getInstance());
        bumblebee.transformarse();
        bumblebee.transformarse();
        Assert.assertEquals(bumblebee.getEstado(), BumblebeeAlterno.getInstance());
    }

    @Test
    public void RatchetEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer ratchet = new Ratchet("Ratchet", 150, RatchetAlterno.getInstance());
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetHumanoide.getInstance());
    }

    @Test
    public void RatchetEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer ratchet = new Ratchet("Ratchet", 150, RatchetAlterno.getInstance());
        ratchet.transformarse();
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetAlterno.getInstance());
    }

    @Test
    public void MegatronEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer megatron = new BoneCrusher("Megatron", 550, MegatronAlterno.getInstance());
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronHumanoide.getInstance());
    }

    @Test
    public void MegatronEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer megatron = new Megatron("Megatron", 550, MegatronAlterno.getInstance());
        megatron.transformarse();
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronAlterno.getInstance());
    }

    @Test
    public void BoneCrusherEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
        bonecrusher.transformarse();
        Assert.assertEquals(bonecrusher.getEstado(), BoneCrusherHumanoide.getInstance());
    }

    @Test
    public void BoneCrusherEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
        bonecrusher.transformarse();
        bonecrusher.transformarse();
        Assert.assertEquals(bonecrusher.getEstado(), BoneCrusherAlterno.getInstance());
    }

    @Test
    public void FrenzyEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer frenzy = new Frenzy("Frenzy", 400, FrenzyAlterno.getInstance());
        frenzy.transformarse();
        Assert.assertEquals(frenzy.getEstado(), FrenzyHumanoide.getInstance());
    }

    @Test
    public void FrenzyEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer frenzy = new Frenzy("Frenzy", 400, FrenzyAlterno.getInstance());
        frenzy.transformarse();
        frenzy.transformarse();
        Assert.assertEquals(frenzy.getEstado(), FrenzyAlterno.getInstance());
    }


}
