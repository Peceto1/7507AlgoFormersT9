package fiuba.algo3.model.arena;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;

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
        inicializar();
    }


    public void inicializar() {

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


    public Boolean estaEnArena(Punto punto){
    	return arena.containsKey(punto);
    }


    public Boolean estaOcupado(Punto punto){
    	Casillero aRevisar = arena.get(punto);
    	return aRevisar.estaOcupado();
    }


    public void ubicarAlgoformer(Algoformer algoformer, Punto punto) {

        if (estaOcupado(punto))
            return;

        arena.get(punto).colocar(algoformer);
        algoformer.setUbicacion(punto);
    }


    public Algoformer removerAlgoformerEn(Punto punto) {
        return arena.get(punto).removerAlgoformer();
    }
}
