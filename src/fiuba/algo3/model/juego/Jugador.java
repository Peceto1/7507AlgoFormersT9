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
    private String equipo;
    private List<Algoformer> algoformers;
    private Algoformer ultimoAlgoformerUtilizado;


    Jugador(String nombre, List<Algoformer> equipo) {
        this.nombre = nombre;
        this.algoformers = new ArrayList<>(equipo);
        this.ultimoAlgoformerUtilizado = this.algoformers.get(0);
    }


    public String getNombre() {
        return nombre;
    }


    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }


    public Algoformer getUltimoAlgoformerUtilizado() {

        if (!ultimoAlgoformerUtilizado.estaVivo() && cantidadAlgoformers() > 0)
            return this.algoformers.get(0);

        return ultimoAlgoformerUtilizado;
    }


    public void setUltimoAlgoformerUtilizado(Algoformer algoformer) {
        this.ultimoAlgoformerUtilizado = algoformer;
    }


    public String getEquipo() {
        return equipo;
    }


    public List<Algoformer> getAlgoformers() {
        return this.algoformers;
    }


    void iniciarTurno() {

        for (Algoformer actual : algoformers){
            actual.reiniciarMovimiento();
            actual.aplicarEfectos();
        }
    }


    void removerMuertos() {

        Iterator<Algoformer> iter = this.algoformers.iterator();

        while (iter.hasNext()) {
            Algoformer actual = iter.next();

            if (!actual.estaVivo()) {
                Arena.getInstance().removerAlgoformerEn(actual.getUbicacion());
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
        Algoformer algoformerSeleccionado = Arena.getInstance().obtenerAlgoformerEn(punto);

        if (!this.algoformers.contains(algoformerSeleccionado))
            throw new JugadorNoPuedeObtenerAlgoformerContrarioException();

        return algoformerSeleccionado;
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
        throw new NoHaySuficientesAlgoformersAdyacentesException();

    }


    public void separarAlgoformers() {
    	List<Algoformer> listaDeAlgoformers = algoformers.get(0).separarse();
    	this.algoformers.remove(0);
    	this.algoformers.addAll(listaDeAlgoformers);
    }


	void resetStatsAlgoformers() {
		for (Algoformer actual: algoformers)
			actual.resetearStats();
	}


	public int cantidadAlgoformers(){
		return algoformers.size();
	}
}
