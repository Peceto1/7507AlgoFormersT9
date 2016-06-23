package fiuba.algo3.controller.acciones;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class BotonAccionTransformarHandler extends BotonAccionHandler implements EventHandler<ActionEvent> {
	
	private VistaMapaAlgoformers vistaMapaAlgoformers;
    private VistaMapaBonuses vistaMapaBonuses;
    private Text msjError;
    

    public BotonAccionTransformarHandler(ContenedorJuego contenedorJuego){
    	super(contenedorJuego);
    	this.vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
        this.vistaMapaBonuses = contenedorJuego.getVistaMapaBonuses();
        this.msjError = contenedorJuego.getMsjError();
    }


	@Override
	public void handle(ActionEvent actionEvent) {

	     contenedorJuego.setAccionado();
	     Algoformer algoformerATransformarse = contenedorJuego.getAlgoformerAccionado();
	     
	     if (!puedeRealizarAccion(algoformerATransformarse))
	    		 return;
		
		PuntoPixels ubicacionPixelVieja = this.vistaMapaAlgoformers.getVista(algoformerATransformarse).getUbicacion();

        try {
        	algoformerATransformarse.transformarse();
        } catch (MovimientoNoValidoException e) {
            this.msjError.setText("No se puede transformar");// Solo ocurre en caso de un aereo intentando descender a pantano
            return;
        }

        Punto ubicacionNueva = algoformerATransformarse.getUbicacion();
        VistaAlgoformer a = this.vistaMapaAlgoformers.getVista(algoformerATransformarse);
        
        a.cambiarImagen();
        a.actualizar(ubicacionPixelVieja.getX(), ubicacionPixelVieja.getY());
        
        if (!algoformerATransformarse.estaVivo()){//muerte por espinas
        	limpiarAlgoformerDePantalla(ubicacionNueva,algoformerATransformarse);
        }

        contenedorJuego.actualizarStatsLateral(algoformerATransformarse.getUbicacion());
        deshabilitarAcciones();
        this.msjError.setText("");
        vistaMapaBonuses.actualizar(ubicacionNueva);
	}

	private void limpiarAlgoformerDePantalla(Punto ubicacion, Algoformer algoformer) {
		ConvertidorPuntoAPixels conversor = new ConvertidorPuntoAPixels();
        PuntoPixels ubicacionPixelsNueva = conversor.convertir(ubicacion);
    	VistaMapaAlgoformers vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
        VistaAlgoformer vistaAlgoformer = vistaMapaAlgoformers.getVista(algoformer);
    	vistaAlgoformer.limpiar(ubicacionPixelsNueva.getX(),ubicacionPixelsNueva.getY());		
	}


}
