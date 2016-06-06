package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoformerTransformarseTest {

    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arenaDeJuego = Arena.getInstance();

    @Before
	public void before(){
		instanciadorDeAlgoformers.inicializar();
        arenaDeJuego.inicializar();
	}


    @Test
    public void OptimusPrimeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
        optimusPrime.transformarse();
        Assert.assertEquals(optimusPrime.getEstado(), OptimusPrimeAlterno.getInstance());
    }

    @Test
    public void OptimusPrimeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
        optimusPrime.transformarse();
        optimusPrime.transformarse();
        Assert.assertEquals(optimusPrime.getEstado(), OptimusPrimeHumanoide.getInstance());
    }

    @Test
    public void BumblebeeEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        bumblebee.transformarse();
        Assert.assertEquals(bumblebee.getEstado(), BumblebeeAlterno.getInstance());
    }

    @Test
    public void BumblebeeEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        bumblebee.transformarse();
        Assert.assertEquals(bumblebee.getEstado(), BumblebeeAlterno.getInstance());
    }

    @Test
    public void RatchetEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        PuntoTierra posicionInicialRatchet = new PuntoTierra(10, 10);
        arenaDeJuego.ubicarAlgoformer(ratchet, posicionInicialRatchet);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetAlterno.getInstance());
    }

    @Test
    public void RatchetEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        Punto posicionInicialRatchet = new PuntoTierra(10, 10);
        arenaDeJuego.ubicarAlgoformer(ratchet, posicionInicialRatchet);
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();
        ratchet.transformarse();
        Assert.assertEquals(ratchet.getEstado(), RatchetHumanoide.getInstance());
    }

    @Test
    public void MegatronEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Punto posicionInicialMegatron = new PuntoTierra(10, 10);
        arenaDeJuego.ubicarAlgoformer(megatron, posicionInicialMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronAlterno.getInstance());
    }

    @Test
    public void MegatronEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Punto posicionInicialMegatron = new PuntoTierra(10, 11);
        arenaDeJuego.ubicarAlgoformer(megatron, posicionInicialMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getEstado(), MegatronHumanoide.getInstance());
    }

    @Test
    public void BoneCrusherEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        bonecrusher.transformarse();
        Assert.assertEquals(bonecrusher.getEstado(), BoneCrusherAlterno.getInstance());
    }

    @Test
    public void BoneCrusherEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        bonecrusher.transformarse();
        bonecrusher.transformarse();
        Assert.assertEquals(bonecrusher.getEstado(), BoneCrusherHumanoide.getInstance());
    }

    @Test
    public void FrenzyEnEstadoHumanoideSeTransformaAlEstadoAlternoCorrectamente(){
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        frenzy.transformarse();
        Assert.assertEquals(frenzy.getEstado(), FrenzyAlterno.getInstance());
    }

    @Test
    public void FrenzyEnEstadoAlternoSeTransformaAlEstadoHumanoideCorrectamente(){
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        frenzy.transformarse();
        frenzy.transformarse();
        Assert.assertEquals(frenzy.getEstado(), FrenzyHumanoide.getInstance());
    }

    @Test
    public void AlgoformerAereoEnEstadoHumanoideAlTransformarseSubeAAireCorrectamente() {
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Punto puntoDePartida = new PuntoTierra(10, 10);
        Punto puntoDeLlegada = new PuntoAire(10, 10);

        arenaDeJuego.ubicarAlgoformer(megatron, puntoDePartida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getUbicacion(), puntoDeLlegada);
    }

    @Test
    public void AlgoformerAereoEnEstadoAlternoAlTransformarseBajaATierraCorrectamente() {
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Punto puntoDePartida = new PuntoTierra(10, 10);

        arenaDeJuego.ubicarAlgoformer(megatron, puntoDePartida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        Assert.assertEquals(megatron.getUbicacion(), puntoDePartida);
    }

}
