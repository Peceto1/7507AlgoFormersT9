package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaBumbleblee extends VistaAlgoformer {


    public VistaBumbleblee(Canvas canvasAlgoformers, Algoformer bumblebee) {
        super(canvasAlgoformers, bumblebee);
        this.algoformerHResource = "file:src/fiuba/algo3/view/resources/images/textures/bumblebeeH.png";
        this.algoformerAResource = "file:src/fiuba/algo3/view/resources/images/textures/bumblebeeA.png";
        this.imagenesAlgoformer.add(new Image(algoformerHResource));
        this.imagenesAlgoformer.add(new Image(algoformerAResource));
    }


}
