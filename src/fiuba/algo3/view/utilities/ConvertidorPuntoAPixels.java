package fiuba.algo3.view.utilities;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;

public class ConvertidorPuntoAPixels {

    private int altoPxCasillero;
    private int anchoPxCasillero;


    public ConvertidorPuntoAPixels() {
        this.altoPxCasillero = 20;
        this.anchoPxCasillero = 40;
    }


    public PuntoPixels convertir(Punto punto) {
        int x = punto.getX();
        int y = punto.getY();
        int nivel = punto.getNivel();

        int xPixel = anchoPxCasillero * x - anchoPxCasillero/2;
        int yPixel = (nivel == 0) ? 2 * altoPxCasillero * y - (altoPxCasillero - altoPxCasillero/2) : 2 * altoPxCasillero * y - (altoPxCasillero + altoPxCasillero/2);
        return new PuntoPixels(xPixel, yPixel);
    }

    public Punto reconvertir(PuntoPixels par){
    	double pixX = par.getX();
    	double pixY = par.getY();

    	double puntoX = (pixX/40)+1;
    	double puntoY = (pixY/40)+1;
    	double nivel = (pixY/20)+1;

        if (((int)nivel)%2 == 0){
            return new PuntoTierra((int) puntoX, (int) puntoY);
        }
        return new PuntoAire((int) puntoX, (int) puntoY);

    }

}
