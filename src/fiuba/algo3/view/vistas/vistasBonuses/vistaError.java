package fiuba.algo3.view.vistas.vistasBonuses;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class vistaError extends VistaBonus {

    public vistaError(Canvas canvasBonuses){
        super(canvasBonuses);
        this.bonusResource = "file:src/fiuba/algo3/view/resources/images/textures/error.png";
        this.imageBonus = new Image(this.bonusResource);
    }

}