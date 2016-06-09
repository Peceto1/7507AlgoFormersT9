package fiuba.algo3.model.juego;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.unidades.Algoformer;

import java.util.ArrayList;
import java.util.List;


public class Jugador {

    private String nombre;
    private List<Algoformer> algoformers;


    Jugador(String nombre, List<Algoformer> equipo) {
        this.nombre = nombre;
        this.algoformers = new ArrayList<>(equipo);
    }


    public String getNombre() {
        return nombre;
    }


    void iniciarTurno() {

        for (Algoformer actual : algoformers){
            actual.reiniciarMovimiento();
            actual.aplicarEfectos();
        }
    }


    void removerMuertos(Arena arena) {

        for (Algoformer actual : algoformers) {

            if (!actual.estaVivo()) {
                arena.removerAlgoformerEn(actual.getUbicacion());
                algoformers.remove(actual);
            }
        }
    }


    Boolean tieneChispa() {

        for (Algoformer actual : algoformers) {

            if (actual.tieneChispa())
                return true;
        }
        return false;
    }


    Boolean tieneVivos() {
        return algoformers.size() > 0;
    }
}
