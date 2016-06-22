package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaBonecrusher extends VistaAlgoformer {
	
	public VistaBonecrusher(Canvas canvasAlgoformers, Algoformer bonecrusher) {
        super(canvasAlgoformers, bonecrusher);
        this.algoformerHResource = "file:src/fiuba/algo3/view/resources/images/textures/bonecrusherH.png";
        this.algoformerAResource = "file:src/fiuba/algo3/view/resources/images/textures/bonecrusherA.png";
        this.imagenesAlgoformer.add(new Image(algoformerHResource));
        this.imagenesAlgoformer.add(new Image(algoformerAResource));
    }
}
