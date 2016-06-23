package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.juego.JugadorNoPuedeObtenerAlgoformerContrarioException;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BotonMoverHandler extends BotonAccionHandler  implements EventHandler<ActionEvent> {
	

    public BotonMoverHandler(ContenedorJuego contenedorJuego) {
    	super(contenedorJuego);
    }


    @Override
    public void handle(ActionEvent actionEvent) {
    	contenedorJuego.setAccionado();
        Algoformer algoformerAccionado = contenedorJuego.getAlgoformerAccionado();
    	if (!puedeRealizarAccion(algoformerAccionado))
    		return;
        inicializarMovimientosRestantes(algoformerAccionado);
        deshabilitarAcciones();
    }


    private void deshabilitarAcciones() {
        HBox contenedorDirecciones = (HBox) contenedorJuego.getPanelAbajo().lookup("#contenedorDirecciones");
        HBox contenedorAcciones = (HBox) contenedorJuego.getPanelAbajo().lookup("#contenedorAcciones");
        VBox contenedorCombinarse = (VBox) contenedorJuego.getPanelAbajo().lookup("#contenedorCombinarseVBox");
        contenedorDirecciones.setVisible(true);
        contenedorAcciones.setDisable(true);
        contenedorCombinarse.setDisable(true);
    }


    private void inicializarMovimientosRestantes(Algoformer algoformerAccionado) {
        Label movRestantes = (Label) contenedorJuego.getPanelAbajo().lookup("#movRestantesLabel");
        movRestantes.setText(Integer.toString(algoformerAccionado.getMovimientosRestantes()));
    }
}
