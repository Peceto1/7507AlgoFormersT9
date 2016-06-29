package fiuba.algo3.controller;


import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.vistas.VistaPosicionChispa;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class BotonMostrarChispa implements EventHandler<ActionEvent> {
	private ContenedorJuego contenedor;
	private Juego juego;
	private VistaPosicionChispa vistaFlecha;
	
	public BotonMostrarChispa(ContenedorJuego contenedor){
		this.vistaFlecha = contenedor.getVistaPosicionChispa();
		this.contenedor = contenedor;
		this.juego = contenedor.getJuego();
	}
	
	
	@Override
	public void handle(ActionEvent arg0) {
		Punto posicionChispa = juego.getPosicionChispa();
		contenedor.seleccionarCasillero(posicionChispa.getX(), posicionChispa.getY());
		contenedor.panearCamara(posicionChispa);
		vistaFlecha.dibujar();
		PauseTransition delay = new PauseTransition(Duration.seconds(2));
		delay.setOnFinished( event -> vistaFlecha.limpiar() );
		delay.play();
	}

}
