package fiuba.algo3.view.vistas.vistasAlgoformers;


import fiuba.algo3.model.unidades.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaSuperion extends VistaAlgoformer {


    public VistaSuperion(Canvas canvasAlgoformers, Algoformer superion) {
        super(canvasAlgoformers, superion);
        this.algoformerHResource = "file:src/fiuba/algo3/view/resources/images/textures/Superior.png";
        this.algoformerAResource = "file:src/fiuba/algo3/view/resources/images/textures/Superior.png";
        this.imagenesAlgoformer.add(new Image(algoformerHResource));
        this.imagenesAlgoformer.add(new Image(algoformerAResource));
    }


}