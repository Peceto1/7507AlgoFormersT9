package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaMegatron extends VistaAlgoformer {


    public VistaMegatron(Canvas canvasAlgoformers, Algoformer megatron) {
        super(canvasAlgoformers, megatron);
        this.algoformerHResource = "file:src/fiuba/algo3/view/resources/images/textures/megatronH.png";
        this.algoformerAResource = "file:src/fiuba/algo3/view/resources/images/textures/megatronA.png";
        this.imagenesAlgoformer.add(new Image(algoformerHResource));
        this.imagenesAlgoformer.add(new Image(algoformerAResource));
    }

}
