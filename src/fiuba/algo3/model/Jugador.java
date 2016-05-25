package fiuba.algo3.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private List<Algoformer> algoformers;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.algoformers = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }
}
