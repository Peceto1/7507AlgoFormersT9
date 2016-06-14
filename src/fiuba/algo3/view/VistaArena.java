package fiuba.algo3.view;

import fiuba.algo3.model.arena.Arena;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaArena implements Dibujable {

    private Arena arenaSingleton = Arena.getInstance();
    private Canvas canvasArena;


    public VistaArena(Canvas canvasArena) {
        this.canvasArena = canvasArena;
    }


    @Override
    public void dibujar() {
        // Voy a tener que dibujar los terrenos
        canvasArena.getGraphicsContext2D().setFill(Color.DARKBLUE);
        canvasArena.getGraphicsContext2D().fillOval(0, 0, 50, 50);
    }


    @Override
    public void limpiar() {

    }


    @Override
    public void actualizar() {

    }

}
