package fiuba.algo3.controller.HandlersMovimiento;


import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

abstract class HandlerMovimiento implements EventHandler<ActionEvent> {

    private VistaMapaAlgoformers vistaMapaAlgoformers;
    private VistaMapaBonuses vistaMapaBonuses;
    private ContenedorJuego contenedorJuego;
    private Text msjError;

    public HandlerMovimiento(ContenedorJuego contenedorJuego){
        this.vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
        this.vistaMapaBonuses = contenedorJuego.getVistaMapaBonuses();
        this.contenedorJuego = contenedorJuego;
        this.msjError = contenedorJuego.getMsjError();
    }

    public void handle(ActionEvent actionEvent) {

        Algoformer algoformerAMoverse = this.contenedorJuego.algoformerAccionado;
        PuntoPixels ubicacionPixelVieja = this.vistaMapaAlgoformers.getVista(algoformerAMoverse).getUbicacion();

        try {
            algoformerAMoverse.moverseHacia(obtenerDireccion());
        } catch (MovimientoNoValidoException e) {
            // ToDo this.msjError.setText(e.getMessage());
            this.msjError.setText("No se puede mover");
            return;
        }

        actualizarMovimientosRestantes(algoformerAMoverse);

        Punto ubicacionNueva = algoformerAMoverse.getUbicacion();
        VistaAlgoformer vistaAlgoformerAMover = this.vistaMapaAlgoformers.getVista(algoformerAMoverse);
        vistaAlgoformerAMover.actualizar(ubicacionPixelVieja.getX(), ubicacionPixelVieja.getY());

        
        limpiarMsjError();
        vistaMapaBonuses.actualizar(ubicacionNueva);
        contenedorJuego.actualizarStatsLateral(algoformerAMoverse.getUbicacion());
    }


    private void actualizarMovimientosRestantes(Algoformer algoformerAMoverse) {
        Label movRestantes = (Label) contenedorJuego.getPanelAbajo().lookup("#movRestantesLabel");
        movRestantes.setText(Integer.toString(algoformerAMoverse.getMovimientosRestantes()));
    }


    private void limpiarMsjError() {
        this.msjError.setText("");
    }


    abstract Direccion obtenerDireccion();
}
