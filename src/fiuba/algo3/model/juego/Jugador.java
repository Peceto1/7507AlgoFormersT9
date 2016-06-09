package fiuba.algo3.model.juego;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException;
import fiuba.algo3.model.unidades.NoHaySuficientesAlgoformersAdyacentesException;

import java.util.ArrayList;
import java.util.Iterator;
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

        Iterator<Algoformer> iter = this.algoformers.iterator();

        while (iter.hasNext()) {
            Algoformer actual = iter.next();

            if (!actual.estaVivo()) {
                arena.removerAlgoformerEn(actual.getUbicacion());
                iter.remove();
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


    public Algoformer obtenerAlgoformerEn(Punto punto) {
        Algoformer algoformer = Arena.getInstance().obtenerAlgoformerEn(punto);
        return (this.algoformers.contains(algoformer)) ? algoformer : null;
    }


    public void combinarAlgoformers() {

        for (Algoformer algoformer : this.algoformers) {

            Algoformer combinacion = null;

            try {
                combinacion = algoformer.combinarse();
            }

            catch (EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException |
                    NoHaySuficientesAlgoformersAdyacentesException e) {
                continue;
            }

            if (combinacion != null) {
                this.algoformers.clear();
                this.algoformers.add(combinacion);
                return;
            }

        }

    }


    public void separarAlgoformers() {

    }
}
