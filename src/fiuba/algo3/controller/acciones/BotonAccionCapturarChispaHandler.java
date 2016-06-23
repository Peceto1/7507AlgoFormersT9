package fiuba.algo3.controller.acciones;

import fiuba.algo3.controller.acciones.BotonAccionHandler;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.ImposibleCapturarChispaException;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BotonAccionCapturarChispaHandler extends BotonAccionHandler implements EventHandler<ActionEvent> {
	private Text msjError;
	private HBox botoneraDeAcciones;
    private VBox botoneraDeCombinacion;
    
    public BotonAccionCapturarChispaHandler(ContenedorJuego contenedor, HBox contenedorAcciones, VBox contenedorCombinacion){
    	super(contenedor);
    	this.botoneraDeAcciones = contenedorAcciones;
    	this.botoneraDeCombinacion = contenedorCombinacion;
    	this.msjError = contenedor.getMsjError();
    }
    
	@Override
	public void handle(ActionEvent actionEvent) {
		contenedorJuego.setAccionado();
	     Algoformer algoformerACapturar = contenedorJuego.getAlgoformerAccionado();
	     if(!puedeRealizarAccion(algoformerACapturar))
	    	 return;
	     
	     try {
	        	algoformerACapturar.capturarChispa();
	        } catch (ImposibleCapturarChispaException e) {
	            this.msjError.setText("No se esta localizado sobre la chispa");
	            return;
	        }
	     botoneraDeAcciones.setDisable(true);
	     botoneraDeCombinacion.setDisable(true);
	     this.msjError.setText("Chispa Capturada!");
	}
	
}
