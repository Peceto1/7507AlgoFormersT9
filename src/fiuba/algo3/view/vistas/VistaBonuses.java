package fiuba.algo3.view.vistas;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.Bonus;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.view.Dibujable;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class VistaBonuses implements Dibujable {

    Canvas canvasBonuses;
    Arena arena;
    Map<Punto, Bonus> bonusesEnMapa;
    private final String flashResource = "file:src/fiuba/algo3/view/resources/images/textures/flash.png";
    private final String canonResource = "file:src/fiuba/algo3/view/resources/images/textures/canon.png";
    private final String burburjaResource = "file:src/fiuba/algo3/view/resources/images/textures/burbuja.png";
    private final String errorResource = "file:src/fiuba/algo3/view/resources/images/textures/error.jpg";
    private Image imageFlash;
    private Image imageCanon;
    private Image imageBurbuja;
    private Image imageError;
    private int imageHeightSize = 20;
    private int imageWidthSize = 20;


    public VistaBonuses(Canvas canvasBonuses) {
        this.canvasBonuses = canvasBonuses;
        this.arena = Arena.getInstance();
        this.imageFlash = new Image(flashResource);
        this.imageCanon = new Image(canonResource);
        this.imageBurbuja = new Image(burburjaResource);
        this.imageError = new Image(errorResource);
        this.bonusesEnMapa = new HashMap<>();
    }


    @Override
    public void dibujar() {

        ConvertidorPuntoAPixels convertidor = new ConvertidorPuntoAPixels();
        int ancho = arena.getAncho();
        int alto = arena.getAlto();

        for (int y = 1; y <= alto; y++) {

            for (int x = 1; x <= ancho; x++) {

                PuntoTierra puntoTierra = new PuntoTierra(x, y);
                PuntoAire puntoAire = new PuntoAire(x, y);

                Bonus bonusTierra = arena.devolverBonusEn(puntoTierra);
                Bonus bonusAire = arena.devolverBonusEn(puntoAire);

                if (!bonusTierra.getNombreBonus().equals("NullBonus"))
                    bonusesEnMapa.put(puntoTierra, bonusTierra);

                if (!bonusAire.getNombreBonus().equals("NullBonus"))
                    bonusesEnMapa.put(puntoAire, bonusAire);

                int pixelXTierra = convertidor.convertirX(puntoTierra);
                int pixelYTierra = convertidor.convertirY(puntoTierra);
                int pixelXAire = convertidor.convertirX(puntoAire);
                int pixelYAire = convertidor.convertirY(puntoAire);

                dibujarBonus(bonusTierra, pixelXTierra, pixelYTierra);
                dibujarBonus(bonusAire, pixelXAire, pixelYAire);
            }
        }
    }


    private void dibujarBonus(Bonus bonusADibujar, int x, int y) {

        GraphicsContext gc = canvasBonuses.getGraphicsContext2D();

        x = x - imageWidthSize/2;
        y = y - imageHeightSize/2;

        switch (bonusADibujar.getNombreBonus()) {

            case "Flash" :
                gc.drawImage(imageFlash, x, y);
                return;

            case "Burbuja Inmaculada" :
                gc.drawImage(imageBurbuja, x, y);
                return;

            case "Doble Cañon" :
                gc.drawImage(imageCanon, x, y);
                return;

            case "NullBonus" :
                return;
        }

        // No deberia llegar
        gc.drawImage(imageError, x, y);
    }


    @Override
    public void actualizar() {

    }


    @Override
    public void limpiar() {

    }


}
