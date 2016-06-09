package fiuba.algo3.model.juego;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.unidades.Algoformer;
import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {

    private String nombreJugador1 = "Jorge";
    private String nombreJugador2 = "Ana";
    private String teamAutobots = "AUTOBOTS";
    private String teamDecepticons = "DECEPTICONS";


    @Test
    public void crearJuegoNuevoYPreguntarPorJugadorEnTurnoActualDebeAlgunoDeLos2Jugadores() {

        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, teamAutobots);
        juego.crearJugador(nombreJugador2, teamDecepticons);
        juego.comenzarPartida();
        Jugador jugadorEnTurno = juego.getJugadorEnTurno();
        String nombreJugadorEnturno = jugadorEnTurno.getNombre();

        Assert.assertTrue(nombreJugadorEnturno.equals(nombreJugador1) || nombreJugadorEnturno.equals(nombreJugador2));
    }

    @Test
    public void crearJuegoNuevoAvanzar1TurnoYPreguntarPorJugadorEnTurnoActualDebeSerElOtroJugador() {

        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, teamAutobots);
        juego.crearJugador(nombreJugador2, teamDecepticons);
        juego.comenzarPartida();
        Jugador jugadorEnTurno1 = juego.getJugadorEnTurno();
        juego.finalizarTurno();
        Jugador jugadorEnTurno2 = juego.getJugadorEnTurno();

        Assert.assertNotEquals(jugadorEnTurno1, jugadorEnTurno2);
    }

    @Test
    public void crearJuegoNuevoAvanzar2TurnosYPreguntarPorJugadorEnTurnoActualDebeSerElJugadorDelPrimerTurno() {

        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, teamAutobots);
        juego.crearJugador(nombreJugador2, teamDecepticons);
        juego.comenzarPartida();
        Jugador jugadorEnTurno1 = juego.getJugadorEnTurno();
        juego.finalizarTurno();
        juego.finalizarTurno();
        Jugador jugadorEnTurno3 = juego.getJugadorEnTurno();

        Assert.assertEquals(jugadorEnTurno1, jugadorEnTurno3);
    }

    @Test
    public void crearJuegoNuevoAvanzar1TurnosYPreguntarPorJugadorActualDebeSerIgualAlJugadorEnElTurno4() {

        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, teamAutobots);
        juego.crearJugador(nombreJugador2, teamDecepticons);
        juego.comenzarPartida();
        juego.finalizarTurno();
        Jugador jugadorEnTurno2 = juego.getJugadorEnTurno();
        juego.finalizarTurno();
        juego.finalizarTurno();
        Jugador jugadorEnTurno4 = juego.getJugadorEnTurno();

        Assert.assertEquals(jugadorEnTurno2, jugadorEnTurno4);
    }

    @Test
    public void crearJuegoNuevoAvanzarTurnosYPreguntarSiHayGanadorEsFalse() {

        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, teamAutobots);
        juego.crearJugador(nombreJugador2, teamDecepticons);
        juego.comenzarPartida();
        juego.finalizarTurno();
        juego.finalizarTurno();
        juego.finalizarTurno();

        Assert.assertFalse(juego.hayGanador());
    }

    @Test (expected = EquipoNoDisponibleException.class)
    public void crearJuegoNuevoNoSePuedenCrearDosJugadoresDelMismoEquipo() {

        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, teamAutobots);
        juego.crearJugador(nombreJugador2, teamAutobots);
    }

    @Test
    public void crearJuegoYPedirUnAutobotAUnJugadorQueJuegaEnDecepticonsDevuelveNull() {

        Juego juego = new Juego();
        juego.crearJugador(nombreJugador1, teamAutobots);
        juego.crearJugador(nombreJugador2, teamDecepticons);
        juego.comenzarPartida();

        Jugador jugadorEnTurno = juego.getJugadorEnTurno();

        if (!jugadorEnTurno.getNombre().equals(nombreJugador2)) {
            juego.finalizarTurno();
            jugadorEnTurno = juego.getJugadorEnTurno();
        }

        Punto ubicacionInicialOptimusPrime = new PuntoTierra(1, 26);
        Algoformer optimus = jugadorEnTurno.obtenerAlgoformerEn(ubicacionInicialOptimusPrime);

        Assert.assertNull(optimus);
    }

}
