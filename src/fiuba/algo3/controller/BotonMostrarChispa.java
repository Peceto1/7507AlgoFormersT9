package fiuba.algo3.controller;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMostrarChispa implements EventHandler<ActionEvent> {
	private ContenedorJuego contenedor;
	private Juego juego;
	
	public BotonMostrarChispa(ContenedorJuego contenedor){
	this.contenedor = contenedor;
	this.juego = contenedor.getJuego();
	}
	
	
	@Override
	public void handle(ActionEvent arg0) {
		Punto posicionChispa = juego.getPosicionChispa();
		contenedor.seleccionarCasillero(posicionChispa.getX(), posicionChispa.getY());
		contenedor.panearCamara(posicionChispa);
	}

}
