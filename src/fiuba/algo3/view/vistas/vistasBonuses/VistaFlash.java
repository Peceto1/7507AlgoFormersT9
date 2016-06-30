package fiuba.algo3.view.vistas.vistasBonuses;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaFlash extends VistaBonus {

    public VistaFlash(Canvas canvasBonuses) {
        super(canvasBonuses);
        this.bonusResource = "file:src/fiuba/algo3/view/resources/images/textures/flash.png";
        this.imageBonus = new Image(this.bonusResource);
    }
}


