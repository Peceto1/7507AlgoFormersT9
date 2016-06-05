package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.*;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega01Test {

    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();

    @Before
    public void before() {
        pool.inicializar();
        arena.inicializar();
    }


    @Test
    public void test01_a_SeUbicaAlgoformerHumanoideEnUnCasilleroAlMoverseSeMueveAcorde() {
        PuntoTierra partida = new PuntoTierra(10, 10);
        PuntoTierra intermedio = new PuntoTierra(11, 10);
        PuntoTierra llegada = new PuntoTierra(12, 10);       // Optimus tiene velocidad 2 en Humanoide
        Direccion derecha = new DireccionDerecha();    

        Assert.assertFalse(arena.estaOcupado(partida));    // No hay algoformer aún.

        Algoformer optimus = pool.obtenerOptimus();     // Algoformer por defecto en Estado Humanoide
        arena.ubicarAlgoformer(optimus, partida);       // Lo ubico en el punto de partida

        Assert.assertTrue(arena.estaOcupado(partida));      // Se ubicó correctamente

        optimus.reiniciarMovimiento();  // Inicializo su turno para moverse
        optimus.moverseHacia(derecha);  // Se mueve un casillero a la derecha

        Assert.assertTrue(arena.estaOcupado(intermedio));     // Ahora optimus se encuentra uno a la derecha
        Assert.assertFalse(arena.estaOcupado(partida));     // Ya no se encuentra más en el punto de partida

        optimus.moverseHacia(derecha);  // Se mueve nuevamente a la derecha.

        Assert.assertTrue(arena.estaOcupado(llegada));      // Llegó al punto de destino
        Assert.assertFalse(arena.estaOcupado(intermedio));

        try {
            optimus.moverseHacia(derecha);      // Trato de moverlo aunque se le acabaron sus movimientos
        }
        catch (MovimientoNoValidoException e) {
            Assert.assertFalse(arena.estaOcupado(partida));     // No se encuentra en el punto de partida
            Assert.assertFalse(arena.estaOcupado(intermedio));  // No se encuentra en el punto de paso
            Assert.assertTrue(arena.estaOcupado(llegada));      // Se encuentra en el punto de llegada
        }
    }


    @Test
    public void test02_a_SeUbicaUnAlgoformerHumanoideSeLoTransformaYSeVerificaQueSePuedaTransformarEnAmbasDirecciones() {
        PuntoTierra partida = new PuntoTierra(1, 1);
        PuntoAire partidaEnAire = new PuntoAire(1, 1);

        Algoformer megatron = pool.obtenerMegatron();
        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();     // Inicializo su movimiento

        Assert.assertTrue(arena.estaOcupado(partida));          // Se encuentra donde lo ubique
        Assert.assertFalse(arena.estaOcupado(partidaEnAire));   // No se encuentra en el aire

        megatron.transformarse();   // Lo transformo a su estado Alterno (volador)
        megatron.reiniciarMovimiento(); // Inicializo su movimiento

        Assert.assertFalse(arena.estaOcupado(partida));         // No se encuentra más en la tierra
        Assert.assertTrue(arena.estaOcupado(partidaEnAire));    // Se encuentra en el aire

        megatron.transformarse();   // Lo transformo nuevamente a Humanoide y debe descender
        Assert.assertTrue(arena.estaOcupado(partida));
        Assert.assertFalse(arena.estaOcupado(partidaEnAire));
    }

    @Test
    public void test03_a_SeUbicaUnAlgoformerEnEstadoAlternoSeMueveYSeVerificaQueSeHayaDesplazadoCorrectamente() {
        PuntoTierra partida = new PuntoTierra(16, 16);
        PuntoAire llegada = new PuntoAire(8, 8);
        Direccion diagonalAbajoIzq = new DireccionIzquierdaAbajo();

        Algoformer megatron = pool.obtenerMegatron();
        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();       // Sube al aire, megatron Alterno tiene velocidad 8
        megatron.reiniciarMovimiento();

        // Megatron Alterno tiene velocidad 8
        int cantMovimientos = 8;

        Assert.assertTrue(arena.estaOcupado(new PuntoAire(16, 16)));

        for (int i=0; i<cantMovimientos; i++)
            megatron.moverseHacia(diagonalAbajoIzq);

        Assert.assertTrue(arena.estaOcupado(llegada));
        Assert.assertFalse(arena.estaOcupado(partida));
        Assert.assertFalse(arena.estaOcupado(new PuntoTierra(16, 16)));
        Assert.assertFalse(arena.estaOcupado(new PuntoTierra(24, 24)));

        // Trato de moverlo nuevamente y lanza excepcion
        try {
            megatron.moverseHacia(diagonalAbajoIzq);
        } catch (MovimientoNoValidoException e) {
            Assert.assertTrue(arena.estaOcupado(llegada));      // Permanece en donde habia quedado
            Assert.assertFalse(arena.estaOcupado(new PuntoAire(7, 7)));  // No se movio de donde estaba
        }
    }

    @Test
    public void test04_a_IntegracionJuegoJugadoresArenaAlgoformersChispa() {

        String jugador1 = "Fran";
        String jugador2 = "Santi";

        Juego juego = new Juego();
        juego.crearJugador(jugador1, "DECEPTICONS");
        juego.crearJugador(jugador2, "AUTOBOTS");
        juego.comenzarPartida();
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(1, 27)));
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(1, 26)));
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(1, 25)));
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(51, 27)));
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(51, 26))); // MEGATRON
        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(51, 25)));

        Jugador actual = juego.getJugadorEnTurno();     // Tomo al jugador con el primer turno

        if (!actual.getNombre().equals(jugador1)) {
            juego.finalizarTurno();
            actual = juego.getJugadorEnTurno();
        }

        // EN actual TENGO AL JUGADOR CON LOS DECEPTICONS
        Algoformer megatron = pool.obtenerMegatron();
        Direccion izquierda = new DireccionIzquierda();
        int cantMovimientos = 8;    // Cantidad de movimientos de Megatron en Alterno

        megatron.transformarse();    // SE TRANSFORMA EN ALTERNO
        Assert.assertTrue(arena.estaOcupado(new PuntoAire(51, 26)));     // Se encuentra en el aire
        juego.finalizarTurno();     // termina turno Megatron
        juego.finalizarTurno();     // Saltea el turno del oponente

        for (int j=0; j<3; j++) {

            for (int i = 0; i < cantMovimientos; i++)
                megatron.moverseHacia(izquierda);

            juego.finalizarTurno();     // Termina Turno Megatron
            juego.finalizarTurno();     // Saltea el del Oponente
        }

        Assert.assertTrue(arena.estaOcupado(new PuntoAire(27, 26)));     // MEGATRON ESTA EN (27, 26, 1)
        juego.finalizarTurno(); // Termina turno Megatron
        juego.finalizarTurno(); // Termina turno Oponente

        megatron.moverseHacia(izquierda);   // MEGATRON SE ENCUENTRA ARRIBA DE LA CHISPA (EN EL AIRE)

        Assert.assertTrue(arena.estaOcupado(new PuntoAire(26, 26)));
        Assert.assertTrue(arena.contieneChispa(new PuntoTierra(26, 26)));

        juego.finalizarTurno();     // Termina turno Megatron
        juego.finalizarTurno();     // Termina turno oponente

        try {
            megatron.capturarChispa();      // No se puede capturar chispa en estado ALTERNO
        } catch (ImposibleCapturarChispaException e) {
            Assert.assertFalse(megatron.tieneChispa());
        }

        megatron.transformarse();   // MEGATRON BAJA A TIERRA, AHORA PUEDE CAPTURAR CHISPA
        juego.finalizarTurno();     // Termina turno Megatron
        juego.finalizarTurno();     // Termina turno oponente

        megatron.capturarChispa();          // Megatron captura la chispa
        Assert.assertTrue(megatron.tieneChispa());      // Megatron tiene la chispa
        Assert.assertFalse(arena.contieneChispa(new PuntoTierra(26, 26)));     // No esta mas en el tablero

        juego.finalizarTurno();
        Assert.assertTrue(juego.hayGanador());  // Hay un Ganador
        Assert.assertEquals(juego.obtenerGanador(), actual);
        // Ese ganador es el jugador de Decepticons
    }

    @Test
    public void test05_a_AutobotHumanoideVsDecepticonHumanoide() {
        Algoformer optimus = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();
        Punto inicioOptimus = new PuntoTierra(41, 41);       // Inician en lados opuestos del mapa
        Punto inicioMegatron = new PuntoTierra(51, 51);
        Direccion diagonalArriba = new DireccionDerechaArriba();
        Direccion diagonalAbajo = new DireccionIzquierdaAbajo();
        int movimientosOptimusAlterno = 5;
        int movimientosMegatronAlterno = 8;

        arena.ubicarAlgoformer(optimus, inicioOptimus);
        optimus.reiniciarMovimiento();
        optimus.transformarse();    // Ambos se transforman para alcanzarse mas rápidamente
        optimus.reiniciarMovimiento();

        arena.ubicarAlgoformer(megatron, inicioMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();

        // Optimus se mueve lo más que puede hacia Megatron
        for (int i = 0; i < movimientosOptimusAlterno; i++)
            optimus.moverseHacia(diagonalArriba);       // Queda en (46, 46, 0)

        Assert.assertTrue(arena.estaOcupado(new PuntoTierra(46, 46)));

        optimus.reiniciarMovimiento(); // Reinicio su movimiento para su proximo turno

        // Megatron se mueve lo más que puede hacia Optimus
        for (int i = 0; i < movimientosMegatronAlterno; i++)
            megatron.moverseHacia(diagonalAbajo);       // Queda en (43, 43, 1)

        megatron.reiniciarMovimiento(); // Reinicio su movimiento para su proximo turno

        Assert.assertTrue(arena.estaOcupado(new PuntoAire(43, 43)));

        // OPTIMUS YA ESTA EN RANGO, ATACA A MEGATRON (AMBOS EN ESTADO ALTERNO)
        optimus.atacar(megatron);
        optimus.reiniciarMovimiento();  // Termina su turno

        Assert.assertEquals(megatron.getVida(), 550 - 15); // Megatron es dañado en 15

        // MEGATRON NO PUEDE ESPERAR Y ATACA SIN ESTAR EN RANGO DESDE EL AIRE
        try {
            megatron.atacar(optimus);
            megatron.reiniciarMovimiento(); // Termina su turno
        } catch (FueraDeRangoException e) {
            Assert.assertEquals(optimus.getVida(), 500); // LA VIDA DE OPTIMUS NO CAMBIO
        }

        // OPTIMUS ATACA DE NUEVO
        optimus.atacar(megatron);
        optimus.reiniciarMovimiento();  // Termina su turno

        Assert.assertEquals(megatron.getVida(), 550 - 15 * 2);

        megatron.moverseHacia(diagonalArriba);   // Megatron se acerca y ahora esta en rango de ataque.
        megatron.reiniciarMovimiento();
        // Salteo turno de optimus
        megatron.atacar(optimus);   // Megatron ataca a optimus

        Assert.assertEquals(optimus.getVida(), 500 - 55);   // Megatron le hizo daño a optimus
    }
}

