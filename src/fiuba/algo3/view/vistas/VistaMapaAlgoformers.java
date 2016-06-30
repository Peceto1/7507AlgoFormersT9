package fiuba.algo3.view.vistas;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.*;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.vistasAlgoformers.*;
import javafx.scene.canvas.Canvas;

import java.util.HashMap;
import java.util.Map;


public class VistaMapaAlgoformers {

    private Map<Algoformer, VistaAlgoformer> algoformersEnMapa;
    private Canvas canvasDeLasVistas;


    public VistaMapaAlgoformers(Canvas canvasAlgoformers) {
        this.algoformersEnMapa = new HashMap<>();
        this.canvasDeLasVistas = canvasAlgoformers;
        construirVistas(canvasAlgoformers);
    }


    private void construirVistas(Canvas canvasAlgoformers) {
        AlgoformerPool poolSingleton = AlgoformerPool.getInstance();

        this.algoformersEnMapa.put(poolSingleton.obtenerOptimus(), new VistaOptimus(canvasAlgoformers, poolSingleton.obtenerOptimus()));
        this.algoformersEnMapa.put(poolSingleton.obtenerBumblebee(), new VistaBumbleblee(canvasAlgoformers, poolSingleton.obtenerBumblebee()));
        this.algoformersEnMapa.put(poolSingleton.obtenerRatchet(), new VistaRatchet(canvasAlgoformers, poolSingleton.obtenerRatchet()));
        this.algoformersEnMapa.put(poolSingleton.obtenerMegatron(), new VistaMegatron(canvasAlgoformers, poolSingleton.obtenerMegatron()));
        this.algoformersEnMapa.put(poolSingleton.obtenerBonecrusher(), new VistaBonecrusher(canvasAlgoformers, poolSingleton.obtenerBonecrusher()));
        this.algoformersEnMapa.put(poolSingleton.obtenerFrenzy(), new VistaFrenzy(canvasAlgoformers, poolSingleton.obtenerFrenzy()));
    }


    public VistaAlgoformer getVista(Algoformer algoformer) {
        return this.algoformersEnMapa.get(algoformer);
    }


    public void agregarEntradaCombinacion(Algoformer algoformer, String equipo){
        this.algoformersEnMapa.remove(algoformer);
        if (equipo.equals("AUTOBOTS"))
            this.algoformersEnMapa.put(algoformer, new VistaSuperion(this.canvasDeLasVistas, algoformer));
        if (equipo.equals("DECEPTICONS"))
            this.algoformersEnMapa.put(algoformer, new VistaMenasor(this.canvasDeLasVistas, algoformer));
    }

    public void eliminarEntrada(Algoformer algoformer){
        this.algoformersEnMapa.remove(algoformer);
    }

    public void mostrar() {

        ConvertidorPuntoAPixels convertidor = new ConvertidorPuntoAPixels();

        for (Map.Entry<Algoformer, VistaAlgoformer> par : this.algoformersEnMapa.entrySet()) {

            VistaAlgoformer vistaActual = par.getValue();
            Punto ubicacion = par.getKey().getUbicacion();
            if (ubicacion != null) {
                PuntoPixels punto = convertidor.convertir(ubicacion);
                vistaActual.dibujar(punto.getX(), punto.getY());
            }
        }
    }




}
