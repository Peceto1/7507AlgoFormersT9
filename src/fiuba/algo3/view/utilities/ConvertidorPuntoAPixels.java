package fiuba.algo3.view.utilities;

import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;

public class ConvertidorPuntoAPixels {

    private int altoPxCasillero;
    private int anchoPxCasillero;


    public ConvertidorPuntoAPixels() {
        this.altoPxCasillero = 20;
        this.anchoPxCasillero = 40;
    }


    public PuntoPixels convertir(PuntoAire punto) {
        int x = punto.getX();
        int y = punto.getY();

        int xPixel = anchoPxCasillero * x - anchoPxCasillero/2;
        int yPixel = 2 * altoPxCasillero * y - (altoPxCasillero + altoPxCasillero/2);
        return new PuntoPixels(xPixel, yPixel);
    }


    public PuntoPixels convertir(PuntoTierra punto) {
        int x = punto.getX();
        int y = punto.getY();

        int xPixel = anchoPxCasillero * x - anchoPxCasillero/2;
        int yPixel = 2 * altoPxCasillero * y - (altoPxCasillero - altoPxCasillero/2);
        return new PuntoPixels(xPixel, yPixel);
    }


}
