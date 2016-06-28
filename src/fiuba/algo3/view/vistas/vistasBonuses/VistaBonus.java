package fiuba.algo3.view.vistas.vistasBonuses;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.view.Dibujable;
import fiuba.algo3.view.vistas.VistaMapaChispa;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class VistaBonus implements Dibujable{

    Canvas canvasBonuses;
    Arena arena;
    String bonusResource;
    Image imageBonus;
    private int imageHeightSize;
    private int imageWidthSize;


    VistaBonus(Canvas canvasBonuses) {
        this.canvasBonuses = canvasBonuses;
        this.arena = Arena.getInstance();
        imageHeightSize = 20;
        imageWidthSize = 20;
    }

    @Override
    public void dibujar(double pixelX, double pixelY) {

        int ajusteX = imageWidthSize/2;
        int ajusteY = imageHeightSize/2;

        GraphicsContext gc = canvasBonuses.getGraphicsContext2D();
        gc.drawImage(imageBonus, pixelX-ajusteX, pixelY-ajusteY);

    }

    public void limpiar(double x, double y){

        x = x - imageWidthSize/2;
        y = y - imageHeightSize/2;

        GraphicsContext gc = canvasBonuses.getGraphicsContext2D();
        gc.clearRect(x, y, 40, 20);

    }
    public void actualizar(double x, double y){
        limpiar(x,y);
    }

}
