package fiuba.algo3.view.eventos;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ProfileOnClickHandler implements EventHandler<ActionEvent> {
	private Algoformer algoformer;
	private ContenedorJuego contenedor;
	
	public ProfileOnClickHandler(Algoformer algoformer,ContenedorJuego contenedor){
		this.algoformer = algoformer;
		this.contenedor = contenedor;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		ConvertidorPuntoAPixels conversor = new ConvertidorPuntoAPixels();
		PuntoPixels ubicacionPixels = conversor.convertir(algoformer.getUbicacion());
		contenedor.seleccionarCasillero(ubicacionPixels.getX(), ubicacionPixels.getY());
		contenedor.panearCamara(algoformer.getUbicacion());
	}

}
