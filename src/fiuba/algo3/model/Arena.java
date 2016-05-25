package fiuba.algo3.model;

import java.util.HashMap;

public class Arena {

    private HashMap<Punto, Casillero> arena;
    private int ancho;
    private int alto;
    private int niveles;


    public Arena(int ancho, int alto, int niveles) {
        this.ancho = ancho;
        this.alto = alto;
        this.niveles = niveles;

        this.arena = new HashMap<>();
        inicializarArena();
    }


    private void inicializarArena() {

        for (int i=1; i<=ancho; i++) {
            for (int j=1; j<=alto; j++) {
                for (int k=0; k<niveles; k++) {

                    Punto punto = new Punto(i, j, k);
                    Casillero casillero = new Casillero();  // Hay que ver de pasarle el terreno adecuado (Aire o Tierra)
                }
            }
        }
    }



}
