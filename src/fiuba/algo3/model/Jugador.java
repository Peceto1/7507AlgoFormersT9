package fiuba.algo3.model;

import fiuba.algo3.model.unidades.Algoformer;

import java.util.HashMap;
import java.util.Map;


public class Jugador {

    private String nombre;
    private Map<String, Algoformer> algoformers;


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
