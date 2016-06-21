package fiuba.algo3.model.espacio;

import fiuba.algo3.model.arena.Arena;

import java.util.ArrayList;
import java.util.List;

public abstract class Punto {

    protected int x;
    protected int y;
    private int nivel;


    public Punto(int x, int y, int nivel) {

        this.x = x;
        this.y = y;
        this.nivel = nivel;
    }


    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }


    public int getNivel() {
        return this.nivel;
    }


    public int distanciaAl(Punto other) {
        return Math.max(Math.abs(this.x - other.x), Math.abs(this.y - other.y));    // Distancia de Chebyshov
    }

    public List<Punto> obtenerAdyacentes() {

        Arena arena = Arena.getInstance();

        Direccion direcciones[] = Direccion.crearDireccionesEnTodoSentido();

        List<Punto> puntosAdyacentes = new ArrayList<>();

        Punto puntoAlternativo;

        try {
            puntoAlternativo = this.ascender();
        } catch (PuntoAireNoPuedeAscenderException e) {
            puntoAlternativo = this.descender();
        }

        puntosAdyacentes.add(puntoAlternativo);

        for (Direccion direccion : direcciones) {

            Punto PuntoEnUnNivel = this.obtenerPuntoEn(direccion);
            Punto PuntoEnOtroNivel = puntoAlternativo.obtenerPuntoEn(direccion);

            if (arena.estaEnArena(PuntoEnUnNivel))
                puntosAdyacentes.add(PuntoEnUnNivel);

            if (arena.estaEnArena(PuntoEnOtroNivel))
                puntosAdyacentes.add(PuntoEnOtroNivel);
        }

        return puntosAdyacentes;
    }


    public List<Punto> obtenerAdyacentesEnTierra() {

        Arena arena = Arena.getInstance();
        Direccion direcciones[] = Direccion.crearDireccionesEnTodoSentido();

        List<Punto> puntosAdyacentes = new ArrayList<>();

        for (Direccion direccion : direcciones) {
            Punto nuevo = this.obtenerPuntoEn(direccion);

            if (arena.estaEnArena(nuevo))
                puntosAdyacentes.add(nuevo);
        }

        return puntosAdyacentes;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punto punto = (Punto) o;

        if (x != punto.x) return false;
        if (y != punto.y) return false;
        return nivel == punto.nivel;

    }


    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + nivel;
        return result;
    }
    
    public int obtenerNivel(){
    	return this.nivel;
    }


    public abstract Punto obtenerPuntoEn(Direccion direccion);
    public abstract Punto ascender();
    public abstract Punto descender();

}
