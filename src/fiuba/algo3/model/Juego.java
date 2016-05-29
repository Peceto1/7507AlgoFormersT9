package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {

    private List<Jugador> jugadores;
    private Arena arena;
    private int turno;


    public Juego(String player1, String player2) {

        this.jugadores = new ArrayList<>();
        this.jugadores.add(new Jugador(player1));
        this.jugadores.add(new Jugador(player2));
        Collections.shuffle(this.jugadores);
        this.arena = Arena.getInstance();
        this.turno = 0;
    }


    public Jugador getJugadorEnTurno() {
        int cantJugadores = this.jugadores.size();
        return this.jugadores.get(turno % cantJugadores);
    }


    public void avanzarTurno() {
        this.turno++;
    }

}
