package fiuba.algo3.controller;


import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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
        HBox contenedorDirecciones = (HBox) contenedorJuego.getPanelAbajo().lookup("#contenedorDirecciones");
        contenedorDirecciones.setVisible(true);
    }



    private void inicializarMovimientosRestantes(Algoformer algoformerAccionado) {
        Label movRestantes = (Label) contenedorJuego.getPanelAbajo().lookup("#movRestantesLabel");
        movRestantes.setText(Integer.toString(algoformerAccionado.getMovimientosRestantes()));
    }
}
