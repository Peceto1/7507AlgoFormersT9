package fiuba.algo3.view.vistas.vistasAlgoformers;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.Dibujable;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
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
    ConvertidorPuntoAPixels convertidor;


    public VistaAlgoformer(Canvas canvasAlgoformers, Algoformer algoformer) {
        this.canvasAlgoformers = canvasAlgoformers;
        this.algoformer = algoformer;
        this.imageHeightSize = 20;
        this.imageWidthSize = 20;
        this.imagenesAlgoformer = new ArrayList<>();
        this.indiceImagenActual = 0;
        this.convertidor = new ConvertidorPuntoAPixels();
    }


    Image obtenerImagenActual() {
        return this.imagenesAlgoformer.get(indiceImagenActual % 2);
    }


    public PuntoPixels getUbicacion() {
        return this.convertidor.convertir( this.algoformer.getUbicacion() );
    }


    public void cambiarImagen() {
        this.indiceImagenActual++;
    }


    @Override
    public void dibujar(double x, double y) {

        x = x - imageWidthSize/2;
        y = y - imageHeightSize/2;

        GraphicsContext gc = canvasAlgoformers.getGraphicsContext2D();
        gc.drawImage(obtenerImagenActual(), x, y);
    }


    @Override
    public void actualizar(double x, double y) {
        limpiar(x, y);
        PuntoPixels nuevoPunto = convertidor.convertir(this.algoformer.getUbicacion());
        dibujar(nuevoPunto.getX(), nuevoPunto.getY());
    }


    @Override
    public void limpiar(double x, double y) {

        x = x - imageWidthSize/2;
        y = y - imageHeightSize/2;

        GraphicsContext gc = canvasAlgoformers.getGraphicsContext2D();
        gc.clearRect(x, y, 40, 20);
    }



}
