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


    public int convertirX(PuntoAire punto) {
        int x = punto.getX();
        return anchoPxCasillero * x - altoPxCasillero;
    }


    public int convertirX(PuntoTierra punto) {
        int x = punto.getX();
        return anchoPxCasillero * x - altoPxCasillero;
    }


    public int convertirY(PuntoAire punto) {
        int y = punto.getY();
        return 2 * altoPxCasillero * y - (altoPxCasillero + altoPxCasillero/2);
    }


    public int convertirY(PuntoTierra punto) {
        int y = punto.getY();
        return 2 * altoPxCasillero * y - (altoPxCasillero - altoPxCasillero/2);
    }


}
