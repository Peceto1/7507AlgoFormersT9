package fiuba.algo3.model;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {

    private String nombreJugador1 = "Jorge";
    private String nombreJugador2 = "Ana";

/*
    @Test
    public void crearJuegoNuevoYPreguntarPorJugadorEnTurnoActualDebeAlgunoDeLos2Jugadores() {

        Juego juego = new Juego(nombreJugador1, nombreJugador2);
        Jugador jugadorEnTurno = juego.getJugadorEnTurno();
        String nombreJugadorEnturno = jugadorEnTurno.getNombre();

        Assert.assertTrue(nombreJugadorEnturno.equals(nombreJugador1) || nombreJugadorEnturno.equals(nombreJugador2));
    }

    @Test
    public void crearJuegoNuevoAvanzar1TurnoYPreguntarPorJugadorEnTurnoActualDebeSerElOtroJugador() {

        Juego juego = new Juego(nombreJugador1, nombreJugador2);
        Jugador jugadorEnTurno1 = juego.getJugadorEnTurno();
        juego.avanzarTurno();
        Jugador jugadorEnTurno2 = juego.getJugadorEnTurno();

        Assert.assertNotEquals(jugadorEnTurno1, jugadorEnTurno2);
    }

    @Test
    public void crearJuegoNuevoAvanzar2TurnosYPreguntarPorJugadorEnTurnoActualDebeSerElJugadorDelPrimerTurno() {

        Juego juego = new Juego(nombreJugador1, nombreJugador2);
        Jugador jugadorEnTurno1 = juego.getJugadorEnTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        Jugador jugadorEnTurno3 = juego.getJugadorEnTurno();

        Assert.assertEquals(jugadorEnTurno1, jugadorEnTurno3);
    }

    @Test
    public void crearJuegoNuevoAvanzar1TurnosYPreguntarPorJugadorActualDebeSerIgualAlJugadorEnElTurno4() {

        Juego juego = new Juego(nombreJugador1, nombreJugador2);
        juego.avanzarTurno();
        Jugador jugadorEnTurno2 = juego.getJugadorEnTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        Jugador jugadorEnTurno4 = juego.getJugadorEnTurno();

        Assert.assertEquals(jugadorEnTurno2, jugadorEnTurno4);
    }*/

}
