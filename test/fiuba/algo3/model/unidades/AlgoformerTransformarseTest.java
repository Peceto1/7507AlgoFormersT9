package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerTransformarseTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();

    @Before
	public void before(){
		pool.inicializar();
        arena.inicializar();
	}


    @Test
    public void OptimusPrimeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer optimusPrime = pool.obtenerOptimus();
        optimusPrime.transformarse();
        Assert.assertEquals(optimusPrime.getEstado(), OptimusPrimeAlterno.getInstance());
    }

    @Test
    public void OptimusPrimeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer optimusPrime = pool.obtenerOptimus();
        optimusPrime.transformarse();
        optimusPrime.transformarse();
        Assert.assertEquals(optimusPrime.getEstado(), OptimusPrimeHumanoide.getInstance());
    }

    @Test
    public void BumblebeeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer bumblebee = pool.obtenerBumblebee();
        bumblebee.transformarse();
        Assert.assertEquals(bumblebee.getEstado(), BumblebeeAlterno.getInstance());
    }

    @Test
    public void BumblebeeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer bumblebee = pool.obtenerBumblebee();
        bumblebee.transformarse();
        Assert.assertEquals(bumblebee.getEstado(), BumblebeeAlterno.getInstance());
    }

    @Test
    public void RatchetEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer ratchet = pool.obtenerRatchet();
        Punto punto = new Punto(10, 10, 0);
        arena.ubicarAlgoformer(ratchet, punto);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetAlterno.getInstance());
    }

    @Test
    public void RatchetEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer ratchet = pool.obtenerRatchet();
        Punto punto = new Punto(10, 10, 0);
        arena.ubicarAlgoformer(ratchet, punto);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetHumanoide.getInstance());
    }

    @Test
    public void MegatronEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer megatron = pool.obtenerMegatron();
        Punto punto = new Punto(10, 10, 0);
        arena.ubicarAlgoformer(megatron, punto);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronAlterno.getInstance());
    }

    @Test
    public void MegatronEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer megatron = pool.obtenerMegatron();
        Punto punto = new Punto(10, 11, 0);
        arena.ubicarAlgoformer(megatron, punto);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronHumanoide.getInstance());
    }

    @Test
    public void BoneCrusherEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        bonecrusher.transformarse();
        Assert.assertEquals(bonecrusher.getEstado(), BoneCrusherAlterno.getInstance());
    }

    @Test
    public void BoneCrusherEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer bonecrusher = pool.obtenerBonecrusher();
        bonecrusher.transformarse();
        bonecrusher.transformarse();
        Assert.assertEquals(bonecrusher.getEstado(), BoneCrusherHumanoide.getInstance());
    }

    @Test
    public void FrenzyEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer frenzy = pool.obtenerFrenzy();
        frenzy.transformarse();
        Assert.assertEquals(frenzy.getEstado(), FrenzyAlterno.getInstance());
    }

    @Test
    public void FrenzyEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer frenzy = pool.obtenerFrenzy();
        frenzy.transformarse();
        frenzy.transformarse();
        Assert.assertEquals(frenzy.getEstado(), FrenzyHumanoide.getInstance());
    }

    @Test
    public void AlgoformerAereoEnEstadoHumanoideAlTransformarseSubeAAireCorrectamente() {
        Algoformer megatron = pool.obtenerMegatron();
        Punto partida = new Punto(10, 10, 0);
        Punto llegada = new Punto(10, 10, 1);

        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getUbicacion(), llegada);
    }

    @Test
    public void AlgoformerAereoEnEstadoAlternoAlTransformarseBajaATierraCorrectamente() {
        Algoformer megatron = pool.obtenerMegatron();
        Punto partida = new Punto(10, 10, 0);

        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();   // Pasa a Estado Alterno (sube)
        megatron.reiniciarMovimiento();
        megatron.transformarse();   // Pasa a Estado Humanoide (baja)
        Assert.assertEquals(megatron.getUbicacion(), partida);
    }

	@Test (expected = AlgoformerMuertoException.class)
	public void AlgoformerMuertoNoPuedeTransformarse(){
		Algoformer optimusprime = pool.obtenerOptimus();
		Algoformer megatron = pool.obtenerMegatron();
		
        Punto p1 = new Punto(25, 25, 0);
        Punto p2 = new Punto(24, 24, 0);

        arena.ubicarAlgoformer(optimusprime, p2);
        optimusprime.reiniciarMovimiento();
        arena.ubicarAlgoformer(megatron, p1);
        megatron.reiniciarMovimiento();
        
        for (int i=0;i<49;i++){
            megatron.atacar(optimusprime);
        }

        // optimusprime sigue vivo (le quedan 10 de vida)
        megatron.atacar(optimusprime);
        // optimusprime esta muerto
        
        optimusprime.transformarse();
    }

}
