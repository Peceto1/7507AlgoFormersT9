package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaMenasor extends VistaAlgoformer {


    public VistaMenasor(Canvas canvasAlgoformers, Algoformer menasor) {
        super(canvasAlgoformers, menasor);
        this.algoformerHResource = "file:src/fiuba/algo3/view/resources/images/textures/menasor.png";
        this.algoformerAResource = "file:src/fiuba/algo3/view/resources/images/textures/menasor.png";
        this.imagenesAlgoformer.add(new Image(algoformerHResource));
        this.imagenesAlgoformer.add(new Image(algoformerAResource));
    }


}