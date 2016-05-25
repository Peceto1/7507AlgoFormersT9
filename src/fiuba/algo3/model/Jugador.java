package fiuba.algo3.model;

import java.util.Dictionary;

public class Jugador {

    private String nombre;
    private Dictionary<String,Algoformer> algoformers;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void agregarAlgoformer(String nombre,Algoformer algoformer){
    	algoformers.put(nombre, algoformer);
    }
}
