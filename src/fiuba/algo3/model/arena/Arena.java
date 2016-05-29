package fiuba.algo3.model.arena;

import java.util.HashMap;
import java.util.Map;

public class Arena {

	private static Arena instancia = new Arena();
    private Map<Punto, Casillero> arena;
    private final int ANCHO = 51;
    private final int ALTO = 51;
    private final int NIVELES = 2;


    private Arena() {
        this.arena = new HashMap<>();
        inicializarArena();
    }


    private void inicializarArena() {

        for (int i=1; i<=ANCHO; i++) {
            for (int j=1; j<=ALTO; j++) {
                for (int k=0; k<NIVELES; k++) {

                    Punto punto = new Punto(i, j, k);
                    Casillero casillero = new Casillero();  // Hay que ver de pasarle el terreno adecuado (Aire o Tierra)
                    arena.put(punto, casillero);
                }
            }
        }
    }

    public static Arena getInstance(){
    	return instancia;
    }

    public Boolean estaEnArena(Punto punto_nuevo){
    	return arena.containsKey(punto_nuevo);
    }
        
    public Boolean estaOcupado(Punto punto_nuevo){
    	Casillero casillero_a_revisar = arena.get(punto_nuevo);
    	return casillero_a_revisar.estaOcupado();  	
    }
    

}
