package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.*;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.unidades.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega01Test {

    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arenaDeJuego = Arena.getInstance();

    @Before
    public void before() {
        instanciadorDeAlgoformers.inicializar();
        arenaDeJuego.inicializar();
    }


    @Test
    public void test01_a_SeUbicaAlgoformerHumanoideEnUnCasilleroAlMoverseSeMueveAcorde() {
        PuntoTierra puntoDePartida = new PuntoTierra(10, 10);
        PuntoTierra puntoIntermedioDeCamino = new PuntoTierra(11, 10);
        PuntoTierra puntoDeLlegada = new PuntoTierra(12, 10);
        Direccion direccionDerecha = new DireccionDerecha();

        Assert.assertFalse(arenaDeJuego.estaOcupado(puntoDePartida));

        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        arenaDeJuego.ubicarAlgoformer(optimus, puntoDePartida);

        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDePartida));

        optimus.reiniciarMovimiento();  // Inicializo su turno para moverse
        optimus.moverseHacia(direccionDerecha);

        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoIntermedioDeCamino));
        Assert.assertFalse(arenaDeJuego.estaOcupado(puntoDePartida));

        optimus.moverseHacia(direccionDerecha);

        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDeLlegada));
        Assert.assertFalse(arenaDeJuego.estaOcupado(puntoIntermedioDeCamino));

        try {
            optimus.moverseHacia(direccionDerecha);
        }
        catch (MovimientoNoValidoException e) {
            Assert.assertFalse(arenaDeJuego.estaOcupado(puntoDePartida));
            Assert.assertFalse(arenaDeJuego.estaOcupado(puntoIntermedioDeCamino));
            Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDeLlegada));
        }
    }


    @Test
    public void test02_a_SeUbicaUnAlgoformerHumanoideSeLoTransformaYSeVerificaQueSePuedaTransformarEnAmbasDirecciones() {
        PuntoTierra puntoDePartidaTerrestre = new PuntoTierra(1, 1);
        PuntoAire puntoDePartidaEnAire = new PuntoAire(1, 1);

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        arenaDeJuego.ubicarAlgoformer(megatron, puntoDePartidaTerrestre);
        megatron.reiniciarMovimiento();
        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDePartidaTerrestre));
        Assert.assertFalse(arenaDeJuego.estaOcupado(puntoDePartidaEnAire));

        megatron.transformarse();
        megatron.reiniciarMovimiento();

        Assert.assertFalse(arenaDeJuego.estaOcupado(puntoDePartidaTerrestre));
        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDePartidaEnAire));

        megatron.transformarse();
        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDePartidaTerrestre));
        Assert.assertFalse(arenaDeJuego.estaOcupado(puntoDePartidaEnAire));
    }

    @Test
    public void test03_a_SeUbicaUnAlgoformerEnEstadoAlternoSeMueveYSeVerificaQueSeHayaDesplazadoCorrectamente() {
        PuntoTierra puntoDePartida = new PuntoTierra(16, 16);
        PuntoAire puntoAereoSobrePartida = new PuntoAire(16,16);
        PuntoAire puntoDeLlegada = new PuntoAire(8, 8);
        Direccion direccionDiagonalAbajoIzquierda = new DireccionIzquierdaAbajo();

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        arenaDeJuego.ubicarAlgoformer(megatron, puntoDePartida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();

        int cantidadDeMovimientosTotalesDeMegatron = 8;

        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoAereoSobrePartida));

        for (int i=0; i<cantidadDeMovimientosTotalesDeMegatron; i++)
            megatron.moverseHacia(direccionDiagonalAbajoIzquierda);

        Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDeLlegada));
        Assert.assertFalse(arenaDeJuego.estaOcupado(puntoDePartida));
        Assert.assertFalse(arenaDeJuego.estaOcupado(new PuntoTierra(24, 24)));

        try {
            megatron.moverseHacia(direccionDiagonalAbajoIzquierda);
        } catch (MovimientoNoValidoException e) {
            Assert.assertTrue(arenaDeJuego.estaOcupado(puntoDeLlegada));
            Assert.assertFalse(arenaDeJuego.estaOcupado(new PuntoAire(7, 7)));
        }
    }

    @Test
    public void test04_a_IntegracionJuegoJugadoresArenaAlgoformersChispa() {
    	//Las siguientes posicions iniciales son las posiciones predeterminadas
    	//En las que el Juego coloca a los Algoformers
    	Punto posicionInicialRatchet = new PuntoTierra(1,27);
    	Punto posicionInicialOptimus = new PuntoTierra(1,26);
    	Punto posicionInicialBumblebee = new PuntoTierra(1,25);
    	Punto posicionInicialFrenzy = new PuntoTierra(51,27);
    	Punto posicionInicialMegatron = new PuntoTierra(51,26);
    	Punto posicionInicialBoneCrusher = new PuntoTierra(51,25);
    	
        String nombreJugador1 = "Fran";
        String nombreJugador2 = "Santi";
        
        Punto posicionDeLaChispa = new PuntoTierra(26, 26);
        Punto posicionSobreLaChispa = new PuntoAire(26,26);

        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, "AUTOBOTS");
        juego.crearJugador(nombreJugador2, "DECEPTICONS");
        juego.comenzarPartida();
        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionInicialRatchet));
        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionInicialOptimus));
        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionInicialBumblebee));
        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionInicialFrenzy));
        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionInicialMegatron));
        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionInicialBoneCrusher));

        Jugador actual = juego.getJugadorEnTurno();

        if (!actual.getNombre().equals(nombreJugador1)) {
            juego.finalizarTurno();
            actual = juego.getJugadorEnTurno();
        }

        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Direccion izquierda = new DireccionIzquierda();
        int cantidadDeMovimientosTotalesDeMegatron = 8;

        megatron.transformarse();
        Assert.assertTrue(arenaDeJuego.estaOcupado(new PuntoAire(51, 26)));
        juego.finalizarTurno();
        juego.finalizarTurno(); //Salteamos el turno del Jugador 2

        for (int j=0; j<3; j++) {

            for (int i = 0; i < cantidadDeMovimientosTotalesDeMegatron; i++)
                megatron.moverseHacia(izquierda);

            juego.finalizarTurno();
            juego.finalizarTurno();
        }

        Assert.assertTrue(arenaDeJuego.estaOcupado(new PuntoAire(27, 26)));
        juego.finalizarTurno();
        juego.finalizarTurno();

        megatron.moverseHacia(izquierda);

        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionSobreLaChispa));
        Assert.assertTrue(arenaDeJuego.contieneChispa(posicionDeLaChispa));

        juego.finalizarTurno();
        juego.finalizarTurno();

        try {
            megatron.capturarChispa();
        } catch (ImposibleCapturarChispaException e) {
            Assert.assertFalse(megatron.tieneChispa());
        }

        megatron.transformarse();
        juego.finalizarTurno();
        juego.finalizarTurno();

        megatron.capturarChispa();
        Assert.assertTrue(megatron.tieneChispa());
        Assert.assertFalse(arenaDeJuego.contieneChispa(posicionDeLaChispa));

        juego.finalizarTurno();
        Assert.assertTrue(juego.hayGanador());
        Assert.assertEquals(juego.obtenerGanador(), actual);
    }

    @Test
    public void test05_a_AutobotHumanoideVsDecepticonHumanoide() {
        Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
        Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
        Punto puntoInicioOptimus = new PuntoTierra(41, 41);
        Punto puntoInicioMegatron = new PuntoTierra(51, 51);
        Direccion direccionDiagonalDerechaArriba = new DireccionDerechaArriba();
        Direccion direccionDiagonalIzquierdaAbajo = new DireccionIzquierdaAbajo();
        int cantidadTotalDeMovimientosOptimusAlterno = 5;
        int cantidadTotalMovimientosMegatronAlterno = 8;

        arenaDeJuego.ubicarAlgoformer(optimus, puntoInicioOptimus);
        optimus.reiniciarMovimiento();
        optimus.transformarse();
        optimus.reiniciarMovimiento();

        arenaDeJuego.ubicarAlgoformer(megatron, puntoInicioMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();


        for (int i = 0; i < cantidadTotalDeMovimientosOptimusAlterno; i++)
            optimus.moverseHacia(direccionDiagonalDerechaArriba);
        
        Punto posicionActualDeOptimus = new PuntoTierra(46,46);
        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionActualDeOptimus));

        optimus.reiniciarMovimiento();

        for (int i = 0; i < cantidadTotalMovimientosMegatronAlterno; i++)
            megatron.moverseHacia(direccionDiagonalIzquierdaAbajo);

        megatron.reiniciarMovimiento();

        Punto posicionActualDeMegatron = new PuntoAire(43,43);
        Assert.assertTrue(arenaDeJuego.estaOcupado(posicionActualDeMegatron));

        optimus.atacar(megatron);
        optimus.reiniciarMovimiento();

        Assert.assertEquals(megatron.getVida(), 550 - 15);

        try {
            megatron.atacar(optimus);
            megatron.reiniciarMovimiento();
        } catch (FueraDeRangoException e) {
            Assert.assertEquals(optimus.getVida(), 500);
        }

        optimus.atacar(megatron);
        optimus.reiniciarMovimiento();

        Assert.assertEquals(megatron.getVida(), 550 - 15 * 2);

        megatron.moverseHacia(direccionDiagonalDerechaArriba);
        megatron.reiniciarMovimiento();

        megatron.atacar(optimus);

        Assert.assertEquals(optimus.getVida(), 500 - 55);
    }
}

