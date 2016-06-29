package fiuba.algo3.view.vistas;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.Dibujable;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VistaPosicionChispa{

	private Canvas canvasApuntadorChispa;
	private String pathApuntadorChispa;
	private Image imagenApuntadorChispa;
	private int imageHeightSize;
    private int imageWidthSize;
    private PuntoPixels posicionChispa;
    
    
    public VistaPosicionChispa(Canvas canvasPosicionChispa, Punto posicionChispa){
    	ConvertidorPuntoAPixels convertidor = new ConvertidorPuntoAPixels();
    	this.canvasApuntadorChispa = canvasPosicionChispa;
    	this.posicionChispa = convertidor.convertir(posicionChispa);
    	this.imageHeightSize = 200;
    	this.imageWidthSize = 200;
    	this.pathApuntadorChispa = "file:src/fiuba/algo3/view/resources/images/flecha.png";
    	this.imagenApuntadorChispa = new Image(pathApuntadorChispa);
    }
    
    
    public void dibujar() {

        int x = (int) posicionChispa.getX() - imageWidthSize-10;
        int y = (int) posicionChispa.getY() - imageHeightSize/2;

        GraphicsContext gc = canvasApuntadorChispa.getGraphicsContext2D();
        gc.drawImage(imagenApuntadorChispa, x, y);
    }
    
    
    public void limpiar() {

    	int x = (int) posicionChispa.getX() - imageWidthSize-10;
        int y = (int) posicionChispa.getY() - imageHeightSize/2;

        GraphicsContext gc = canvasApuntadorChispa.getGraphicsContext2D();
        gc.clearRect(x, y, 204, 204); // 40 y 20 son el ancho y alto del casillero. Tengo que cambiarlo para borrar la flecha ENTERA
    }

	
}
