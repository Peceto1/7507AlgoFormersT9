package fiuba.algo3.controller;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.juego.JugadorNoPuedeObtenerAlgoformerContrarioException;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class BotonAccionHandler{
	public ContenedorJuego contenedorJuego;
	
	public BotonAccionHandler(ContenedorJuego contenedor){
		this.contenedorJuego = contenedor;
	}
	
	
	public boolean puedeRealizarAccion(Algoformer algoformerAccionado){
		if (algoformerAccionado == null)
            return false;

        Jugador jugadorEnTurno = contenedorJuego.getJuego().getJugadorEnTurno();

        try {
            jugadorEnTurno.obtenerAlgoformerEn(algoformerAccionado.getUbicacion());
        } catch (JugadorNoPuedeObtenerAlgoformerContrarioException e) {
            contenedorJuego.getMsjError().setText(e.devolverMensajeError());
            return false;
        }
        return true;
	}
}
