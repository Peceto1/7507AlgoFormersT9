package fiuba.algo3.controller;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BotonTransformarHandler implements EventHandler<ActionEvent> {
	
	private VistaMapaAlgoformers vistaMapaAlgoformers;
    private VistaMapaBonuses vistaMapaBonuses;
    private Text msjError;
    private HBox botoneraDeAcciones;
    private VBox botoneraDeCombinacion;
    private ContenedorJuego contenedorJuego;
    
    
    public BotonTransformarHandler(ContenedorJuego contenedorJuego, HBox contenedorAcciones, VBox contenedorCombinarseSepararse){
        this.vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
        this.vistaMapaBonuses = contenedorJuego.getVistaMapaBonuses();
        this.msjError = contenedorJuego.getMsjError();
        this.botoneraDeAcciones = contenedorAcciones;
        this.botoneraDeCombinacion = contenedorCombinarseSepararse;
        this.contenedorJuego = contenedorJuego;
        
        
    }

	@Override
	public void handle(ActionEvent actionEvent) {

	     contenedorJuego.setAccionado();
	     Algoformer algoformerATransformarse = contenedorJuego.getAlgoformerAccionado();
	     
	     if (algoformerATransformarse == null){
	            return;
	        }
		
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

        //
        botoneraDeAcciones.setDisable(true);
        botoneraDeCombinacion.setDisable(true);
        this.msjError.setText("");
        vistaMapaBonuses.actualizar(ubicacionNueva);
	}
	
	

}
