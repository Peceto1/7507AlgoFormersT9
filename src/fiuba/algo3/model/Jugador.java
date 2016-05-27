package fiuba.algo3.model;

import fiuba.algo3.model.unidades.Algoformer;

import java.util.HashMap;


public class Jugador {

    private String nombre;
    private HashMap<String, Algoformer> algoformers;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.algoformers = new HashMap<>();
    }


    public String getNombre() {
        return nombre;
    }


    public void agregarAlgoformer(String nombre, Algoformer algoformer){
    	algoformers.put(nombre, algoformer);
    }
}
