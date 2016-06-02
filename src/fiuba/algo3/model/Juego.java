package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.AlgoformerPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {

    private List<Jugador> jugadores;
    private Arena arena;
    private AlgoformerPool pool;
    private Jugador ganador;
    private int turno;


    public Juego() {

        this.jugadores = new ArrayList<>();
        this.pool = AlgoformerPool.getInstance();
        this.arena = Arena.getInstance();
        this.arena.inicializar();
        this.pool.inicializar();
        this.ubicarAlgoformers();
        this.arena.colocarChispa(new Punto(26, 26, 0));
        this.ganador = null;
        this.turno = 1;
    }


    private void ubicarAlgoformers() {
        arena.ubicarAlgoformer(pool.obtenerBumblebee(), new Punto(1, 25, 0));
        arena.ubicarAlgoformer(pool.obtenerOptimus(), new Punto(1, 26, 0));
        arena.ubicarAlgoformer(pool.obtenerRatchet(), new Punto(1, 27, 0));
        arena.ubicarAlgoformer(pool.obtenerFrenzy(), new Punto(51, 27, 0));
        arena.ubicarAlgoformer(pool.obtenerMegatron(), new Punto(51, 26, 0));
        arena.ubicarAlgoformer(pool.obtenerBonecrusher(), new Punto(51, 25, 0));
    }


    public void crearJugador(String nombre, String equipo) {
        jugadores.add(new Jugador(nombre, pool.obtenerEquipo(equipo)));
    }


    public Jugador getJugadorEnTurno() {
        int cantJugadores = this.jugadores.size();
        return this.jugadores.get(turno % cantJugadores);
    }


    public void comenzarPartida() {
        mezclarJugadores();
        Jugador actual = getJugadorEnTurno();
        actual.iniciarTurno();
    }


    public void finalizarTurno() {
        actualizarMapa();
        ganador = obtenerGanador();
        this.turno++;
        Jugador siguiente = getJugadorEnTurno();
        siguiente.iniciarTurno();
    }


    public Jugador obtenerGanador() {

        for (Jugador actual : jugadores)
            if (actual.tieneChispa())
                return actual;

        for (Jugador actual : jugadores)
            if (!actual.tieneVivos())
                jugadores.remove(actual);

        if (jugadores.size() == 1)
            return jugadores.get(0);

        return null;
    }


    public Boolean hayGanador() {
        return ganador != null;
    }


    private void actualizarMapa() {

        for (Jugador jugador : jugadores)
            jugador.removerMuertos(arena);
    }


    private void mezclarJugadores() {
        Collections.shuffle(this.jugadores);
    }

}
