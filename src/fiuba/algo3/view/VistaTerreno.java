package fiuba.algo3.view;

import fiuba.algo3.model.arena.Terreno;
import fiuba.algo3.model.espacio.Punto;
import javafx.scene.canvas.Canvas;

public abstract class VistaTerreno implements Dibujable {

    private Terreno terreno;
    private Punto posicion; // ---> no se si es necesario
    Canvas canvas;


}
