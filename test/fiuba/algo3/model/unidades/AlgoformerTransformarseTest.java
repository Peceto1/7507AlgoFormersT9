package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;

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
        PuntoTierra punto = new PuntoTierra(10, 10);
        arena.ubicarAlgoformer(ratchet, punto);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetAlterno.getInstance());
    }

    @Test
    public void RatchetEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer ratchet = pool.obtenerRatchet();
        PuntoTierra punto = new PuntoTierra(10, 10);
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
        PuntoTierra punto = new PuntoTierra(10, 10);
        arena.ubicarAlgoformer(megatron, punto);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronAlterno.getInstance());
    }

    @Test
    public void MegatronEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer megatron = pool.obtenerMegatron();
        PuntoTierra punto = new PuntoTierra(10, 11);
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
        PuntoTierra partida = new PuntoTierra(10, 10);
        PuntoAire llegada = new PuntoAire(10, 10);

        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getUbicacion(), llegada);
    }

    @Test
    public void AlgoformerAereoEnEstadoAlternoAlTransformarseBajaATierraCorrectamente() {
        Algoformer megatron = pool.obtenerMegatron();
        PuntoTierra partida = new PuntoTierra(10, 10);

        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();   // Pasa a Estado Alterno (sube)
        megatron.reiniciarMovimiento();
        megatron.transformarse();   // Pasa a Estado Humanoide (baja)
        Assert.assertEquals(megatron.getUbicacion(), partida);
    }

}
