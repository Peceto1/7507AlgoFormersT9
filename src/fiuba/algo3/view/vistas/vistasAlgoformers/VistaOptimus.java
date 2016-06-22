package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaOptimus extends VistaAlgoformer {


    public VistaOptimus(Canvas canvasAlgoformers, Algoformer optimus) {
        super(canvasAlgoformers, optimus);
        this.algoformerHResource = "file:src/fiuba/algo3/view/resources/images/textures/optimusH.png";
        this.algoformerAResource = "file:src/fiuba/algo3/view/resources/images/textures/optimusA.png";
        this.imagenesAlgoformer.add(new Image(algoformerHResource));
        this.imagenesAlgoformer.add(new Image(algoformerAResource));
    }

}
