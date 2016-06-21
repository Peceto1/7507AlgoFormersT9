package fiuba.algo3.controller;

import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaBonuses;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoverAlgoformerDerechaHandler implements EventHandler<ActionEvent> {

    VistaMapaAlgoformers vistaAlgoformers;
    VistaBonuses vistaBonuses;


    public MoverAlgoformerDerechaHandler(VistaMapaAlgoformers vistaAlgoformers, VistaBonuses vistaBonuses) {
        this.vistaAlgoformers = vistaAlgoformers;
        this.vistaBonuses = vistaBonuses;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        AlgoformerPool pool = AlgoformerPool.getInstance();
        Algoformer bumblebee = pool.obtenerBumblebee();

        PuntoPixels ubicacionPixelVieja = this.vistaAlgoformers.getVista(bumblebee).getUbicacion();

        try {
            bumblebee.moverseHacia(new DireccionDerecha());
        } catch (MovimientoNoValidoException e) {
            System.out.println("No se puede mover");
            return;
        }

        Punto ubicacionNueva = bumblebee.getUbicacion();
        VistaAlgoformer a = this.vistaAlgoformers.getVista(bumblebee);

        a.actualizar(ubicacionPixelVieja.getX(), ubicacionPixelVieja.getY());
        //this.vistaBonuses.actualizar();

    }

}
