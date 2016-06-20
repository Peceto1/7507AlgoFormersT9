package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.Dibujable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public abstract class VistaAlgoformer implements Dibujable {

    String algoformerHResource;
    String algoformerAResource;
    Image imageAlgoformerH;
    Image imageAlgoformerA;
    int imageHeightSize;
    int imageWidthSize;
    Canvas canvasAlgoformers;
    Algoformer algoformer;


    public VistaAlgoformer(Canvas canvasAlgoformers, Algoformer algoformer) {
        this.canvasAlgoformers = canvasAlgoformers;
        this.algoformer = algoformer;
        this.imageHeightSize = 20;
        this.imageWidthSize = 20;

    }


    @Override
    public void dibujar(int x, int y) {

    }


    @Override
    public void actualizar() {

    }


    @Override
    public void limpiar() {

    }


    @Override
    public void mostrar() {

    }



}
