package fiuba.algo3.model;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTests {

    @Test
    public void crearJuegoNuevoYPreguntarPorJugadorEnTurnoActualDebeSerElPrimerJugador() {

        String jugador1 = "Jorge";
        String jugador2 = "Ana";
        Juego juego = new Juego(jugador1, jugador2);
        Jugador jugadorEnTurno = juego.getJugadorEnTurno();

        Assert.assertTrue(jugadorEnTurno.getNombre().equals(jugador1));
    }

    @Test
    public void crearJuegoNuevoAvanzar1TurnoYPreguntarPorJugadorEnTurnoActualDebeSerElSegundoJugador() {

        String jugador1 = "Jorge";
        String jugador2 = "Ana";
        Juego juego = new Juego(jugador1, jugador2);
        juego.avanzarTurno();
        Jugador jugadorEnTurno = juego.getJugadorEnTurno();

        Assert.assertTrue(jugadorEnTurno.getNombre().equals(jugador2));
    }

    @Test
    public void crearJuegoNuevoAvanzar2TurnosYPreguntarPorJugadorEnTurnoActualDebeSerElPrimerJugador() {

        String jugador1 = "Jorge";
        String jugador2 = "Ana";
        Juego juego = new Juego(jugador1, jugador2);
        juego.avanzarTurno();
        juego.avanzarTurno();
        Jugador jugadorEnTurno = juego.getJugadorEnTurno();

        Assert.assertTrue(jugadorEnTurno.getNombre().equals(jugador1));

    }

}
