package fiuba.algo3.controller.acciones;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.EstadoProtoNoPuedeRealizarAcciones;
import fiuba.algo3.model.unidades.NoPuedeSepararseException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.HashMap;
import java.util.Map;

public class BotonAccionSepararseHandler extends BotonAccionHandler implements EventHandler<ActionEvent> {
	private VistaMapaBonuses vistaMapaBonuses;
	
	public BotonAccionSepararseHandler(ContenedorJuego contenedor){
		super(contenedor);
		this.vistaMapaBonuses = contenedor.getVistaMapaBonuses();
	}

	@Override
	public void handle(ActionEvent arg0) {

		Jugador enTurno = contenedorJuego.getJuego().getJugadorEnTurno();
		ConvertidorPuntoAPixels convertidor = new ConvertidorPuntoAPixels();

		Algoformer combinacion = enTurno.getAlgoformers().get(0);
		VistaAlgoformer vistaDeCombinacion = contenedorJuego.getVistaMapaAlgoformers().getVista(combinacion);
		PuntoPixels ubicacionDePixelesDeCombinacion = convertidor.convertir(combinacion.getUbicacion());

		try{
			enTurno.separarAlgoformers();
		}catch(NoPuedeSepararseException | EstadoProtoNoPuedeRealizarAcciones e){
			contenedorJuego.getMsjError().setText(e.getMessage());
			return;
		}

		vistaDeCombinacion.limpiar(ubicacionDePixelesDeCombinacion.getX(), ubicacionDePixelesDeCombinacion.getY());
		dibujarEquipoAlgoformers(enTurno, convertidor);

		deshabilitarAcciones();
		habilitarBotonProfileCombinacion(combinacion, contenedorJuego.getJuego().getJugadorEnTurno().getEquipo(), true);
	}

	private void dibujarEquipoAlgoformers(Jugador jugador, ConvertidorPuntoAPixels convertidor){
		for(Algoformer algoformerADibujar: jugador.getAlgoformers()){
			VistaAlgoformer vista = contenedorJuego.getVistaMapaAlgoformers().getVista(algoformerADibujar);
			vista.cambiarImagenAHumanoide();
			PuntoPixels posicionPixeles = convertidor.convertir(algoformerADibujar.getUbicacion());
			vista.dibujar(posicionPixeles.getX(),posicionPixeles.getY());
			vistaMapaBonuses.actualizar(algoformerADibujar.getUbicacion());
			contenedorJuego.seleccionarCasillero(posicionPixeles.getX(),posicionPixeles.getY());
		}
	}

}
