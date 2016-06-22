package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaFrenzy extends VistaAlgoformer {


    public VistaFrenzy(Canvas canvasAlgoformers, Algoformer frenzy) {
        super(canvasAlgoformers, frenzy);
        this.algoformerHResource = "file:src/fiuba/algo3/view/resources/images/textures/frenzyH.png";
        this.algoformerAResource = "file:src/fiuba/algo3/view/resources/images/textures/frenzyA.png";
        this.imagenesAlgoformer.add(new Image(algoformerHResource));
        this.imagenesAlgoformer.add(new Image(algoformerAResource));
    }

}
