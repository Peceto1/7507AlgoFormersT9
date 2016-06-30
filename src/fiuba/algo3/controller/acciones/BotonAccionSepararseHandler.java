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

		Map<VistaAlgoformer, Punto> mapa= new HashMap<>();
		mapa.put(contenedorJuego.getVistaMapaAlgoformers().getVista(enTurno.getAlgoformers().get(0)),enTurno.getAlgoformers().get(0).getUbicacion());

		try{
			enTurno.separarAlgoformers();
		}catch(NoPuedeSepararseException | EstadoProtoNoPuedeRealizarAcciones e){
			contenedorJuego.getMsjError().setText(e.getMessage());
			return;
		}


		for (Map.Entry<VistaAlgoformer, Punto> par : mapa.entrySet()) {
			VistaAlgoformer vistaActual = par.getKey();
			Punto ubicacion = par.getValue();
			if (ubicacion != null) {
				PuntoPixels punto = convertidor.convertir(ubicacion);
				vistaActual.limpiar(punto.getX(), punto.getY());
			}
		}

		for(Algoformer algoformerADibujar: enTurno.getAlgoformers()){
			VistaAlgoformer vista = contenedorJuego.getVistaMapaAlgoformers().getVista(algoformerADibujar);
			PuntoPixels posicionPixeles = convertidor.convertir(algoformerADibujar.getUbicacion());
			vista.dibujar(posicionPixeles.getX(),posicionPixeles.getY());
			vistaMapaBonuses.actualizar(algoformerADibujar.getUbicacion());
			contenedorJuego.seleccionarCasillero(posicionPixeles.getX(),posicionPixeles.getY());
		}


		deshabilitarAcciones();
	}

}
