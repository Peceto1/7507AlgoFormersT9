package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaRatchet extends VistaAlgoformer {


    public VistaRatchet(Canvas canvasAlgoformers, Algoformer ratchet) {
        super(canvasAlgoformers, ratchet);
        this.algoformerHResource = "file:src/fiuba/algo3/view/resources/images/textures/ratchetH.png";
        this.algoformerAResource = "file:src/fiuba/algo3/view/resources/images/textures/ratchetA.png";
        this.imagenesAlgoformer.add(new Image(algoformerHResource));
        this.imagenesAlgoformer.add(new Image(algoformerAResource));
    }

}
