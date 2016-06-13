package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.Pantano;
import fiuba.algo3.model.espacio.*;
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
    public void MenasorPuedeSepararseYSusMiembrosQuedanColocadosEnLosAlrededores() {
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

    @Test
    public void MenasorAlHaberseFormadoConDosCompanierosEnAlternoSeSeparanCorrectamente() {
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

        List<Algoformer> miembros = menasor.separarse();
        
        List<Algoformer> algoformers = arena.obtenerAlgoformersEn(puntoInicioCentro.obtenerAdyacentes());
        algoformers.add(arena.obtenerAlgoformerEn(puntoInicioCentro));

        Assert.assertTrue(algoformers.containsAll(miembros));
        Assert.assertEquals(algoformers.size(), miembros.size());
    }

    @Test (expected = MovimientoNoValidoException.class)
    public void MenasorAlHaberseFormadoCon2CompanierosEnAlternoAlSepararseEstosPasanAHumanoide() {
        Punto puntoArribaDeInicio = new PuntoTierra(51, 27);
        Punto puntoInicioCentro = new PuntoTierra(51, 26);
        Punto puntoAbajoDeInicio = new PuntoTierra(51, 25);
        Direccion izquierda = new DireccionIzquierda();
        Punto puntoArribaConPantanoALaIzquierda = puntoArribaDeInicio.obtenerPuntoEn(izquierda);
        Punto puntoAbajoConPantanoALaIzquierda = puntoAbajoDeInicio.obtenerPuntoEn(izquierda);
        arena.setTerrenoEnPunto(puntoAbajoConPantanoALaIzquierda, new Pantano());
        arena.setTerrenoEnPunto(puntoArribaConPantanoALaIzquierda, new Pantano());

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();

        arena.ubicarAlgoformer(megatron, puntoArribaDeInicio);
        arena.ubicarAlgoformer(bonecrusher, puntoInicioCentro);
        arena.ubicarAlgoformer(frenzy, puntoAbajoDeInicio);
        megatron.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();
        frenzy.reiniciarMovimiento();

        megatron.transformarse();
        megatron.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();

        Algoformer menasor = bonecrusher.combinarse();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();

        menasor.separarse();
        megatron.reiniciarMovimiento();
        megatron.moverseHacia(izquierda);
    }

    @Test
    public void MenasorRecibeDanioYAlSepararseElDanioEsRepartidoEntreSusMiembros() {
        Punto puntoArribaDeInicio = new PuntoTierra(51, 27);
        Punto puntoInicioCentro = new PuntoTierra(51, 26);
        Punto puntoAbajoDeInicio = new PuntoTierra(51, 25);
        Punto ubicacionOptimus = new PuntoTierra(49, 26);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();

        arena.ubicarAlgoformer(megatron, puntoArribaDeInicio);
        arena.ubicarAlgoformer(bonecrusher, puntoInicioCentro);
        arena.ubicarAlgoformer(frenzy, puntoAbajoDeInicio);
        arena.ubicarAlgoformer(optimus, ubicacionOptimus);
        megatron.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();
        frenzy.reiniciarMovimiento();

        megatron.transformarse();
        megatron.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();

        Algoformer menasor = bonecrusher.combinarse();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();

        optimus.atacar(menasor);        // Ataque Optimus Humanoide : 50

        List<Algoformer> miembros = menasor.separarse();
        Assert.assertEquals(50/3, miembros.get(0).getVidaMax() - miembros.get(0).getVida());
    }

    @Test
    public void UnMiembroDeMenasorMuereAlSepararseSoloSeDevuelven2Miembros() {
        Punto puntoArribaDeInicio = new PuntoTierra(51, 27);
        Punto puntoInicioCentro = new PuntoTierra(51, 26);
        Punto puntoAbajoDeInicio = new PuntoTierra(51, 25);
        Punto ubicacionOptimus = new PuntoTierra(49, 26);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();

        arena.ubicarAlgoformer(megatron, puntoArribaDeInicio);
        arena.ubicarAlgoformer(bonecrusher, puntoInicioCentro);
        arena.ubicarAlgoformer(frenzy, puntoAbajoDeInicio);
        arena.ubicarAlgoformer(optimus, ubicacionOptimus);
        megatron.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();
        frenzy.reiniciarMovimiento();

        megatron.transformarse();
        megatron.reiniciarMovimiento();
        frenzy.transformarse();
        frenzy.reiniciarMovimiento();

        optimus.atacar(bonecrusher);
        optimus.atacar(bonecrusher);
        optimus.atacar(bonecrusher);

        Algoformer menasor = bonecrusher.combinarse();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();

        optimus.atacar(menasor);
        optimus.atacar(menasor);
        optimus.atacar(menasor);
        optimus.atacar(menasor);

        List<Algoformer> miembros = menasor.separarse();
        List<Algoformer> algoformersAlrededor = arena.obtenerAlgoformersEn(puntoInicioCentro.obtenerAdyacentes());

        if (arena.obtenerAlgoformerEn(puntoInicioCentro) != null)
            algoformersAlrededor.add(arena.obtenerAlgoformerEn(puntoInicioCentro));

        Assert.assertEquals(miembros.size(), algoformersAlrededor.size());
    }

    @Test
    public void SuperionYMenasorEnSimultaneoPuedenSepararseCorrectamente() {
        Punto puntoArribaInicioDECEPTICONS = new PuntoTierra(51, 27);
        Punto puntoInicioCentroDECEPTICONS = new PuntoTierra(51, 26);
        Punto puntoAbajoDeInicioDECEPTICONS = new PuntoTierra(51, 25);
        Punto puntoArribaInicioAUTOBOTS = new PuntoTierra(1, 27);
        Punto puntoInicioCentroAUTOBOTS = new PuntoTierra(1, 26);
        Punto puntoAbajoDeInicioAUTOBOTS = new PuntoTierra(1, 25);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
        Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
        Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();

        arena.ubicarAlgoformer(megatron, puntoArribaInicioDECEPTICONS);
        arena.ubicarAlgoformer(bonecrusher, puntoInicioCentroDECEPTICONS);
        arena.ubicarAlgoformer(frenzy, puntoAbajoDeInicioDECEPTICONS);
        arena.ubicarAlgoformer(ratchet, puntoArribaInicioAUTOBOTS);
        arena.ubicarAlgoformer(optimus, puntoInicioCentroAUTOBOTS);
        arena.ubicarAlgoformer(bumblebee, puntoAbajoDeInicioAUTOBOTS);

        megatron.reiniciarMovimiento();
        bonecrusher.reiniciarMovimiento();
        frenzy.reiniciarMovimiento();
        ratchet.reiniciarMovimiento();
        optimus.reiniciarMovimiento();
        bumblebee.reiniciarMovimiento();

        megatron.transformarse();
        megatron.reiniciarMovimiento();
        ratchet.transformarse();
        ratchet.reiniciarMovimiento();

        Algoformer menasor = bonecrusher.combinarse();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        menasor.reiniciarMovimiento();
        Algoformer superion = optimus.combinarse();
        superion.reiniciarMovimiento();
        superion.reiniciarMovimiento();
        superion.reiniciarMovimiento();

        Punto puntoCercanoAMenasor = new PuntoTierra(49, 26);

        while (!superion.getUbicacion().equals(puntoCercanoAMenasor)) {
            superion.moverseHacia(new DireccionDerecha());
            superion.reiniciarMovimiento();
        }

        superion.atacar(menasor);


        List<Algoformer> miembrosMenasor = menasor.separarse();
        List<Algoformer> miembrosSuperion = superion.separarse();

        Assert.assertEquals(miembrosMenasor.size(), miembrosSuperion.size());
    }

}
