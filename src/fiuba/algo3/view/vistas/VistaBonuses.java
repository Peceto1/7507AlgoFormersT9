package fiuba.algo3.view.vistas;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.Bonus;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class VistaBonuses {

    Canvas canvasBonuses;
    Arena arena;
    Map<Punto, Bonus> bonusesEnMapa;
    Map<PuntoPixels, Bonus>bonusesEnMapaPixels;
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
        this.bonusesEnMapaPixels = new HashMap<>();
    }
    
    private void obtenerPuntosConBonus(){
    	ConvertidorPuntoAPixels convertidor = new ConvertidorPuntoAPixels();
        int ancho = arena.getAncho();
        int alto = arena.getAlto();

        for (int y = 1; y <= alto; y++) {

            for (int x = 1; x <= ancho; x++) {

                PuntoTierra puntoTierra = new PuntoTierra(x, y);
                PuntoAire puntoAire = new PuntoAire(x, y);

                Bonus bonusTierra = arena.devolverBonusEn(puntoTierra);
                Bonus bonusAire = arena.devolverBonusEn(puntoAire);

                int pixelXTierra = convertidor.convertirX(puntoTierra);
                int pixelYTierra = convertidor.convertirY(puntoTierra);
                PuntoPixels tierra = new PuntoPixels(pixelXTierra,pixelYTierra);
                
                
                int pixelXAire = convertidor.convertirX(puntoAire);
                int pixelYAire = convertidor.convertirY(puntoAire);
                PuntoPixels aire = new PuntoPixels(pixelXAire,pixelYAire);
                
                if (!bonusTierra.getNombreBonus().equals("NullBonus")){
                    bonusesEnMapa.put(puntoTierra, bonusTierra);
                	bonusesEnMapaPixels.put(tierra, bonusTierra);
                }	

                if (!bonusAire.getNombreBonus().equals("NullBonus")){
                    bonusesEnMapa.put(puntoAire, bonusAire);
                    bonusesEnMapaPixels.put(aire, bonusAire);
                }
            }
        }
    }


    public void mostrar() {
    	obtenerPuntosConBonus();
    	for (PuntoPixels actual: bonusesEnMapaPixels.keySet())
    		dibujar(actual);
    }


    private void dibujar(PuntoPixels punto) {

        GraphicsContext gc = canvasBonuses.getGraphicsContext2D();

        Bonus bonusADibujar = bonusesEnMapaPixels.get(punto);

        switch (bonusADibujar.getNombreBonus()) {

            case "Flash" :
                gc.drawImage(imageFlash, punto.getX(), punto.getY());
                return;

            case "Burbuja Inmaculada" :
                gc.drawImage(imageBurbuja, punto.getX(), punto.getY());
                return;

            case "Doble Cañon" :
                gc.drawImage(imageCanon, punto.getX(), punto.getY());
                return;

            case "NullBonus" :
                return;
        }

        // No deberia llegar
        gc.drawImage(imageError, punto.getX(), punto.getY());
    }


}
