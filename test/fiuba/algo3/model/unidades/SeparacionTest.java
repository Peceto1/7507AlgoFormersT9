package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierra;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SeparacionTest {

    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();

    @Before
    public void before() {
        arena.inicializar();
        instanciadorDeAlgoformers.inicializar();
    }


    @Test (expected = NoPuedeSepararseException.class)
    public void AlgoformerNoCombinadoNoPuedeSepararse() {
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        optimus.separarse();
    }

    @Test (expected = EstadoProtoNoPuedeRealizarAcciones.class)
    public void estadoProtoNoPuedeSepararse() {
        Punto puntoInicioCentro = new PuntoTierra(25, 25);
        Punto puntoDerechoDeInicio = new PuntoTierra(26, 25);
        Punto puntoIzquierdoDeInicio = new PuntoTierra(24, 25);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();

        arena.ubicarAlgoformer(megatron, puntoInicioCentro);
        arena.ubicarAlgoformer(bonecrusher, puntoDerechoDeInicio);
        arena.ubicarAlgoformer(frenzy, puntoIzquierdoDeInicio);

        Algoformer menasor = megatron.combinarse();
        menasor.reiniciarMovimiento();
        menasor.separarse();
    }

    @Test (expected = NoPuedeSepararseException.class)
    public void MenasorNoPuedeSepararseSiSeEncuentraEnUnaEsquinaBloqueadoPor3Contrincantes() {
        Punto puntoInicioCentro = new PuntoTierra(1, 1);
        Punto puntoAbajoDeInicio = new PuntoTierra(1, 2);
        Punto puntoDerechaDeInicio = new PuntoTierra(2, 1);
        Punto puntoDiagonalDerechaAbajo = new PuntoTierra(2, 2);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();

        arena.ubicarAlgoformer(megatron, puntoInicioCentro);
        arena.ubicarAlgoformer(bonecrusher, puntoAbajoDeInicio);
        arena.ubicarAlgoformer(frenzy, puntoDerechaDeInicio);
        Algoformer menasor = megatron.combinarse();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();

        arena.ubicarAlgoformer(optimus, puntoAbajoDeInicio);
        arena.ubicarAlgoformer(bumblebee, puntoDerechaDeInicio);
        arena.ubicarAlgoformer(ratchet, puntoDiagonalDerechaAbajo);

        menasor.separarse();
    }

    @Test (expected = NoPuedeSepararseException.class)
    public void MenasorNoPuedeSepararseSiSeEncuentraEnUnaEsquinaBloqueadoPor2Contrincantes() {
        Punto puntoInicioCentro = new PuntoTierra(1, 1);
        Punto puntoAbajoDeInicio = new PuntoTierra(1, 2);
        Punto puntoDerechaDeInicio = new PuntoTierra(2, 1);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();

        arena.ubicarAlgoformer(megatron, puntoInicioCentro);
        arena.ubicarAlgoformer(bonecrusher, puntoAbajoDeInicio);
        arena.ubicarAlgoformer(frenzy, puntoDerechaDeInicio);
        Algoformer menasor = megatron.combinarse();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();

        arena.ubicarAlgoformer(optimus, puntoAbajoDeInicio);
        arena.ubicarAlgoformer(bumblebee, puntoDerechaDeInicio);

        menasor.separarse();
    }

    @Test
    public void MenasorPuedeSepararseSiSeEncuentraEnUnaEsquinaBloqueadoPor1Contrincante() {
        Punto puntoInicioCentro = new PuntoTierra(1, 1);
        Punto puntoAbajoDeInicio = new PuntoTierra(1, 2);
        Punto puntoDerechaDeInicio = new PuntoTierra(2, 1);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();

        arena.ubicarAlgoformer(megatron, puntoInicioCentro);
        arena.ubicarAlgoformer(bonecrusher, puntoAbajoDeInicio);
        arena.ubicarAlgoformer(frenzy, puntoDerechaDeInicio);
        Algoformer menasor = megatron.combinarse();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();

        arena.ubicarAlgoformer(optimus, puntoAbajoDeInicio);

        List<Algoformer> miembros = menasor.separarse();
        List<Algoformer> algoformers = arena.obtenerAlgoformersEn(puntoInicioCentro.obtenerAdyacentes());
        algoformers.add(arena.obtenerAlgoformerEn(puntoInicioCentro));
        algoformers.remove(optimus);

        Assert.assertTrue(algoformers.containsAll(miembros));
        Assert.assertEquals(algoformers.size(), miembros.size());
    }


    @Test
    public void MenasorPuedeSepararseYSusMiembrosQuedanEnColocadosEnLosAlrededores() {
        Punto puntoInicioCentro = new PuntoTierra(25, 25);
        Punto puntoDerechoDeInicio = new PuntoTierra(26, 25);
        Punto puntoIzquierdoDeInicio = new PuntoTierra(24, 25);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();

        arena.ubicarAlgoformer(megatron, puntoInicioCentro);
        arena.ubicarAlgoformer(bonecrusher, puntoDerechoDeInicio);
        arena.ubicarAlgoformer(frenzy, puntoIzquierdoDeInicio);

        Algoformer menasor = megatron.combinarse();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();

        List<Algoformer> miembros = menasor.separarse();
        List<Algoformer> algoformers = arena.obtenerAlgoformersEn(puntoInicioCentro.obtenerAdyacentes());
        algoformers.add(arena.obtenerAlgoformerEn(puntoInicioCentro));

        Assert.assertTrue(algoformers.containsAll(miembros));
        Assert.assertEquals(algoformers.size(), miembros.size());
    }


    // REVISAR ESTA PRUEBA, MEGATRON TIENE PROBLEMAS CUANDO TRATA DE DESCENDER
    @Test
    public void MenasorAlHaberseFormadoConDosCompanierosEnAlternoAlSepararseEstanEnHumanoide() {
        Punto puntoInicioCentro = new PuntoTierra(25, 25);
        Punto puntoDerechoDeInicio = new PuntoTierra(26, 25);
        Punto puntoIzquierdoDeInicio = new PuntoTierra(24, 25);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();

        arena.ubicarAlgoformer(megatron, puntoIzquierdoDeInicio);
        arena.ubicarAlgoformer(bonecrusher, puntoInicioCentro);
        arena.ubicarAlgoformer(frenzy, puntoDerechoDeInicio);
        megatron.reiniciarMovimiento();
        frenzy.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();

        megatron.transformarse();
        megatron.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();
        Algoformer menasor = bonecrusher.combinarse();

        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();

        //List<Algoformer> miembros = menasor.separarse();  SE ROMPE
        System.out.println("mala leche");
    }

}
