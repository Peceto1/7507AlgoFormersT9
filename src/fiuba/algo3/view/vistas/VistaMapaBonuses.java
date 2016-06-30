package fiuba.algo3.view.vistas;


import fiuba.algo3.model.arena.*;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.vistasBonuses.*;
import javafx.scene.canvas.Canvas;

import java.util.HashMap;
import java.util.Map;

public class VistaMapaBonuses {

    Map<Punto, Bonus> bonusesEnMapa;
    Map<PuntoPixels, Bonus>bonusesEnMapaPixels;
    Map<Bonus, VistaBonus> vistaDeBonuses;
    Arena arenaDeJuegoSingleton;
    VistaBonus vistaCanon;
    VistaBonus vistaFlash;
    VistaBonus vistaBurbuja;
    private VistaMapaChispa mapaChispa;
    private Canvas canvas;

    public VistaMapaBonuses(Canvas canvasBonuses){

        this.bonusesEnMapa = new HashMap<>();
        this.bonusesEnMapaPixels = new HashMap<>();
        this.vistaDeBonuses = new HashMap<>();
        arenaDeJuegoSingleton = Arena.getInstance();
        construirVistasBonuses(canvasBonuses);
        this.canvas = canvasBonuses;
        this.mapaChispa = new VistaMapaChispa(arenaDeJuegoSingleton.getChispa(), arenaDeJuegoSingleton.getUbicacionChispa());
    }


    public void mostrar() {
        obtenerPuntosConBonus();

        for (Map.Entry<PuntoPixels, Bonus> par : this.bonusesEnMapaPixels.entrySet()) {

            VistaBonus vistaActual = getVista(par.getValue());
            PuntoPixels ubicacion = par.getKey();

            vistaActual.dibujar(ubicacion.getX(), ubicacion.getY());
        }
        mapaChispa.dibujar(canvas);
    }


    private VistaBonus getVista(Bonus bonus) {
        return vistaDeBonuses.get(bonus);
    }


    public void actualizar(Punto puntoAActualizar){

        if (!bonusesEnMapa.containsKey(puntoAActualizar))
            return;

        ConvertidorPuntoAPixels conversor = new ConvertidorPuntoAPixels();
        PuntoPixels puntoPixeleado = conversor.convertir(puntoAActualizar);

        vistaCanon.actualizar(puntoPixeleado.getX(), puntoPixeleado.getY());


    }


    private void construirVistasBonuses(Canvas canvas){
        vistaCanon = new VistaCanon(canvas);
        vistaFlash = new VistaFlash(canvas);
        vistaBurbuja = new VistaBurbuja(canvas);
        vistaDeBonuses.put(new BonusDobleCanon(), vistaCanon);
        vistaDeBonuses.put(new BonusFlash(), vistaFlash);
        vistaDeBonuses.put(new BonusBurbujaInmaculada(), vistaBurbuja);
    }


    private void obtenerPuntosConBonus() {

        ConvertidorPuntoAPixels convertidor = new ConvertidorPuntoAPixels();
        int ancho = arenaDeJuegoSingleton.getAncho();
        int alto = arenaDeJuegoSingleton.getAlto();

        for (int y = 1; y <= alto; y++) {

            for (int x = 1; x <= ancho; x++) {

                PuntoTierra puntoTierra = new PuntoTierra(x, y);
                PuntoAire puntoAire = new PuntoAire(x, y);

                Bonus bonusTierra = arenaDeJuegoSingleton.devolverBonusEn(puntoTierra);
                Bonus bonusAire = arenaDeJuegoSingleton.devolverBonusEn(puntoAire);

                PuntoPixels tierra = convertidor.convertir(puntoTierra);
                PuntoPixels aire = convertidor.convertir(puntoAire);

                if (!bonusTierra.getNombreBonus().equals("Sin Bonus")){
                    bonusesEnMapa.put(puntoTierra, bonusTierra);
                    bonusesEnMapaPixels.put(tierra, bonusTierra);
                }

                if (!bonusAire.getNombreBonus().equals("Sin Bonus")){
                    bonusesEnMapa.put(puntoAire, bonusAire);
                    bonusesEnMapaPixels.put(aire, bonusAire);
                }
            }
        }
    }

}
