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
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500,OptimusPrimeAlterno.getInstance());
        optimusprime.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 500);
    }

    @Test
    public void AutobotAtacaADecepticonImprimeAutobotAtacaADecepticon() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500,OptimusPrimeAlterno.getInstance());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());

        optimusprime.atacar(bonecrusher);
        Assert.assertEquals(bonecrusher.getVida(), 185);
    }

    @Test
    public void DecepticonAtacaAAutobotImprimeDecepticonAtacaAAutobot() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500,OptimusPrimeAlterno.getInstance());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());

        bonecrusher.atacar(optimusprime);
        Assert.assertEquals(optimusprime.getVida(), 470);
    }

    @Test
    public void AutobotAtacaAotroAutobotImprimeFriendlyFire() {
        Algoformer optimusprime = new OptimusPrime("OptimusPrime", 500,OptimusPrimeAlterno.getInstance());
        Algoformer bumblebee = new Bumblebee("Bumblebee", 350,BumblebeeAlterno.getInstance());

        optimusprime.atacar(bumblebee);
        Assert.assertEquals(bumblebee.getVida(), 350);
    }
    
    @Test
    public void DecepticonAtacaAAutobotHastaMatarlo() {
    	Algoformer bumblebee = new Bumblebee("Bumblebee", 350,BumblebeeAlterno.getInstance());
        Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
        
        for (int i=0;i<11;i++){
        	bonecrusher.atacar(bumblebee);
        }

        // bumblebee sigue vivo (le quedan 20 de vida)
        bonecrusher.atacar(bumblebee);
        Assert.assertFalse(bumblebee.estaVivo());
        
    }
    
    //Transformaciones de los Autobots
    @Test
    public void OptimusPrimeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	Algoformer optimusPrime = new OptimusPrime("Optimus Prime", 500, OptimusPrimeAlterno.getInstance());
    	optimusPrime.transformarse();
    	Assert.assertEquals(optimusPrime.getEstado(),OptimusPrimeHumanoide.getInstance());
    }
    
    @Test
    public void OptimusPrimeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	Algoformer optimusPrime = new OptimusPrime("Optimus Prime", 500, OptimusPrimeAlterno.getInstance());
    	optimusPrime.transformarse();
    	optimusPrime.transformarse();
    	Assert.assertEquals(optimusPrime.getEstado(),OptimusPrimeAlterno.getInstance());
    }
 
    @Test
    public void BumblebeeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	Algoformer bumblebee = new Bumblebee("Bumblebee", 350, BumblebeeAlterno.getInstance());
    	bumblebee.transformarse();
    	Assert.assertEquals(bumblebee.getEstado(),BumblebeeHumanoide.getInstance());
    }
    
    @Test
    public void BumblebeeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	Algoformer bumblebee = new Bumblebee("Bumblebee", 350, BumblebeeAlterno.getInstance());
    	bumblebee.transformarse();
    	bumblebee.transformarse();
    	Assert.assertEquals(bumblebee.getEstado(),BumblebeeAlterno.getInstance());
    }
    
    @Test
    public void RatchetEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	Algoformer ratchet = new Ratchet("Ratchet", 150, RatchetAlterno.getInstance());
    	ratchet.transformarse();
    	Assert.assertEquals(ratchet.getEstado(),RatchetHumanoide.getInstance());
    }
    
    @Test
    public void RatchetEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	Algoformer ratchet = new Ratchet("Ratchet", 150, RatchetAlterno.getInstance());
    	ratchet.transformarse();
    	ratchet.transformarse();
    	Assert.assertEquals(ratchet.getEstado(),RatchetAlterno.getInstance());
    }
    
    
    //Transformaciones de los Decepticons
    @Test
    public void MegatronEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	Algoformer megatron = new BoneCrusher("Megatron", 550, MegatronAlterno.getInstance());
    	megatron.transformarse();
    	Assert.assertEquals(megatron.getEstado(),MegatronHumanoide.getInstance());
    }
   
    @Test
    public void MegatronEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	Algoformer megatron = new Megatron("Megatron", 550, MegatronAlterno.getInstance());
    	megatron.transformarse();
    	megatron.transformarse();
    	Assert.assertEquals(megatron.getEstado(),MegatronAlterno.getInstance());
    }
    
    @Test
    public void BoneCrusherEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
    	bonecrusher.transformarse();
    	Assert.assertEquals(bonecrusher.getEstado(),BoneCrusherHumanoide.getInstance());
    }
   
    @Test
    public void BoneCrusherEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	Algoformer bonecrusher = new BoneCrusher("BoneCrusher", 200, BoneCrusherAlterno.getInstance());
    	bonecrusher.transformarse();
    	bonecrusher.transformarse();
    	Assert.assertEquals(bonecrusher.getEstado(),BoneCrusherAlterno.getInstance());
    }
 
    @Test
    public void FrenzyEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
    	Algoformer frenzy = new Frenzy("Frenzy", 400, FrenzyAlterno.getInstance());
    	frenzy.transformarse();
    	Assert.assertEquals(frenzy.getEstado(),FrenzyHumanoide.getInstance());
    }
   
    @Test
    public void FrenzyEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
    	Algoformer frenzy = new Frenzy("Frenzy", 400, FrenzyAlterno.getInstance());
    	frenzy.transformarse();
    	frenzy.transformarse();
    	Assert.assertEquals(frenzy.getEstado(),FrenzyAlterno.getInstance());
    }
    

}
