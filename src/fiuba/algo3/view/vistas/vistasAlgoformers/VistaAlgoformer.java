package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.Dibujable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public abstract class VistaAlgoformer implements Dibujable {

    String algoformerHResource;
    String algoformerAResource;
    List<Image> imagenesAlgoformer;
    int indiceImagenActual;
    int imageHeightSize;
    int imageWidthSize;
    Canvas canvasAlgoformers;
    Algoformer algoformer;


    public VistaAlgoformer(Canvas canvasAlgoformers, Algoformer algoformer) {
        this.canvasAlgoformers = canvasAlgoformers;
        this.algoformer = algoformer;
        this.imageHeightSize = 20;
        this.imageWidthSize = 20;
        this.imagenesAlgoformer = new ArrayList<>();
        this.indiceImagenActual = 0;
    }


    Image obtenerImagenActual() {
        return this.imagenesAlgoformer.get(indiceImagenActual % 2);
    }


    void cambiarImagen() {
        this.indiceImagenActual++;
    }


    @Override
    public void dibujar(int x, int y) {

        x = x - imageWidthSize/2;
        y = y - imageHeightSize/2;

        GraphicsContext gc = canvasAlgoformers.getGraphicsContext2D();
        gc.drawImage(obtenerImagenActual(), x, y);
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
