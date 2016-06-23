package fiuba.algo3.controller.acciones;

import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionCombinarseHandler extends BotonAccionHandler implements EventHandler<ActionEvent> {
	
	public BotonAccionCombinarseHandler(ContenedorJuego contenedor){
		super(contenedor);
	}

	@Override
	public void handle(ActionEvent arg0) {
		contenedorJuego.getMsjError().setText("NOT IMPLEMENTED YET");
	}

}
