package fiuba.algo3.view.vistas;

import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.view.Dibujable;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.vistas.vistasAlgoformers.*;
import javafx.scene.canvas.Canvas;

import java.util.HashMap;
import java.util.Map;


public class VistaMapaAlgoformers implements Dibujable {

    private Map<Algoformer, VistaAlgoformer> algoformersEnMapa;
    private Juego juego;


    public VistaMapaAlgoformers(Canvas canvasAlgoformers, Juego juego) {
        this.juego = juego;
        this.algoformersEnMapa = new HashMap<>();
        construirVistas(canvasAlgoformers);
    }


    private void construirVistas(Canvas canvasAlgoformers) {
        AlgoformerPool poolSingleton = AlgoformerPool.getInstance();
        //this.algoformersEnMapa.put(poolSingleton.obtenerOptimus(), new VistaOptimus(canvasAlgoformers, poolSingleton.obtenerOptimus()));
        this.algoformersEnMapa.put(poolSingleton.obtenerBumblebee(), new VistaBumbleblee(canvasAlgoformers, poolSingleton.obtenerBumblebee()));
        //this.algoformersEnMapa.put(poolSingleton.obtenerRatchet(), new VistaRatchet(canvasAlgoformers, poolSingleton.obtenerRatchet()));
        //this.algoformersEnMapa.put(poolSingleton.obtenerMegatron(), new VistaMegatron(canvasAlgoformers, poolSingleton.obtenerMegatron()));
        //this.algoformersEnMapa.put(poolSingleton.obtenerBonecrusher(), new VistaBonecrusher(canvasAlgoformers, poolSingleton.obtenerBonecrusher()));
        //this.algoformersEnMapa.put(poolSingleton.obtenerFrenzy(), new VistaFrenzy(canvasAlgoformers, poolSingleton.obtenerFrenzy()));
    }


    @Override
    public void mostrar() {

        ConvertidorPuntoAPixels convertidor = new ConvertidorPuntoAPixels();

        for (Map.Entry<Algoformer, VistaAlgoformer> par : this.algoformersEnMapa.entrySet()) {

            VistaAlgoformer vistaActual = par.getValue();
            PuntoTierra ubicacion = (PuntoTierra) par.getKey().getUbicacion();
            int pixelX = convertidor.convertirX(ubicacion);
            int pixelY = convertidor.convertirY(ubicacion);

            vistaActual.dibujar(pixelX, pixelY);
        }
    }


    @Override
    public void actualizar() {

    }


    @Override
    public void limpiar() {

    }


    @Override
    public void dibujar(int x, int y) {

    }



}