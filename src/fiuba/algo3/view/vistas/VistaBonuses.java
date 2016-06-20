package fiuba.algo3.view.vistas;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.view.Dibujable;
import javafx.scene.canvas.Canvas;

import java.util.Map;

public class VistaBonuses implements Dibujable {

    Canvas canvasBonuses;
    Arena arena;
    Map<Punto, Dibujable> bonusesEnMapa;


    public VistaBonuses(Canvas canvasBonuses) {
        this.canvasBonuses = canvasBonuses;
        this.arena = Arena.getInstance();
    }


    @Override
    public void dibujar() {

    }


    @Override
    public void actualizar() {

    }


    @Override
    public void limpiar() {

    }


}
