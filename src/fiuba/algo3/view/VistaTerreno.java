package fiuba.algo3.view;

import fiuba.algo3.model.arena.TerrenoAplicable;
import fiuba.algo3.model.espacio.Punto;
import javafx.scene.canvas.Canvas;

public abstract class VistaTerreno implements Dibujable {

    private TerrenoAplicable terreno;
    private Punto posicion; // ---> no se si es necesario
    Canvas canvas;


}
