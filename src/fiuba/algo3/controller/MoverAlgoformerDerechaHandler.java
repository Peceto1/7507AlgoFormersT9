package fiuba.algo3.controller;

import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.view.ContenedorJuego;

import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class MoverAlgoformerDerechaHandler implements EventHandler<ActionEvent> {

    private VistaMapaAlgoformers vistaMapaAlgoformers;
    private VistaMapaBonuses vistaMapaBonuses;
    private Text msjError;


    public MoverAlgoformerDerechaHandler(ContenedorJuego contenedorJuego) {
        this.vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
        this.vistaMapaBonuses = contenedorJuego.getVistaMapaBonuses();
        this.msjError = contenedorJuego.getMsjError();
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();

        PuntoPixels ubicacionPixelVieja = this.vistaMapaAlgoformers.getVista(bumblebee).getUbicacion();

        try {
            bumblebee.moverseHacia(new DireccionDerecha());
        } catch (MovimientoNoValidoException e) {
            this.msjError.setText("No se puede mover");
            return;
        }

        Punto ubicacionNueva = bumblebee.getUbicacion();
        VistaAlgoformer a = this.vistaMapaAlgoformers.getVista(bumblebee);

        a.actualizar(ubicacionPixelVieja.getX(), ubicacionPixelVieja.getY());

        //
        vistaMapaBonuses.actualizar(ubicacionNueva);
    }
}