package fiuba.algo3.model.juego;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.unidades.AlgoformerPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {

    private List<Jugador> jugadores;
    private Arena arenaSingleton;
    private AlgoformerPool poolSingleton;
    private List<String> equiposDisponibles;
    private Jugador ganador;
    private int turno;


    public Juego() {

        this.jugadores = new ArrayList<>();
        this.poolSingleton = AlgoformerPool.getInstance();
        this.arenaSingleton = Arena.getInstance();
        this.arenaSingleton.inicializar();
        this.poolSingleton.inicializar();
        this.ubicarAlgoformers();
        this.inicializarEquipos();
        this.arenaSingleton.colocarChispa(new PuntoTierra(26, 26));
        this.ganador = null;
        this.turno = 1;
    }


    private void ubicarAlgoformers() {
        arenaSingleton.ubicarAlgoformer(poolSingleton.obtenerBumblebee(), new PuntoTierra(1, 25));
        arenaSingleton.ubicarAlgoformer(poolSingleton.obtenerOptimus(), new PuntoTierra(1, 26));
        arenaSingleton.ubicarAlgoformer(poolSingleton.obtenerRatchet(), new PuntoTierra(1, 27));
        arenaSingleton.ubicarAlgoformer(poolSingleton.obtenerFrenzy(), new PuntoTierra(51, 27));
        arenaSingleton.ubicarAlgoformer(poolSingleton.obtenerMegatron(), new PuntoTierra(51, 26));
        arenaSingleton.ubicarAlgoformer(poolSingleton.obtenerBonecrusher(), new PuntoTierra(51, 25));
    }
    
    public void setTrampas(){
    	arenaSingleton.setTerrenoAleatorio();
    	arenaSingleton.setBonusAleatorio();
    }


    private void inicializarEquipos() {
        this.equiposDisponibles = new ArrayList<>();
        this.equiposDisponibles.add("AUTOBOTS");
        this.equiposDisponibles.add("DECEPTICONS");
    }


    public void crearJugador(String nombre, String equipo) {
        int indiceEquipo = this.equiposDisponibles.indexOf(equipo);

        try {
            equipo = this.equiposDisponibles.remove(indiceEquipo);
        } catch (IndexOutOfBoundsException e) {
            throw new EquipoNoDisponibleException();
        }

        jugadores.add(new Jugador(nombre, poolSingleton.obtenerEquipo(equipo)));
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

        for (Jugador jugador : jugadores){
        	jugador.resetStatsAlgoformers();
            jugador.removerMuertos();
        }
    }


    private void mezclarJugadores() {
        Collections.shuffle(this.jugadores);
    }

}
