package fiuba.algo3.controller;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.ImposibleCapturarChispaException;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BotonCapturarChispaHandler implements EventHandler<ActionEvent> {
	private Text msjError;
	private HBox botoneraDeAcciones;
    private VBox botoneraDeCombinacion;
    private ContenedorJuego contenedorJuego;
    
    public BotonCapturarChispaHandler(ContenedorJuego contenedor, HBox contenedorAcciones, VBox contenedorCombinacion){
    	this.botoneraDeAcciones = contenedorAcciones;
    	this.botoneraDeCombinacion = contenedorCombinacion;
    	this.msjError = contenedor.getMsjError();
    	this.contenedorJuego = contenedor;
    }
    
	@Override
	public void handle(ActionEvent actionEvent) {
		contenedorJuego.setAccionado();
	     Algoformer algoformerATransformarse = contenedorJuego.getAlgoformerAccionado();
	     
	     if (algoformerATransformarse == null){
	            return;
	     }
	     
	     try {
	        	algoformerATransformarse.capturarChispa();
	        } catch (ImposibleCapturarChispaException e) {
	            this.msjError.setText("No se esta localizado sobre la chispa");
	            return;
	        }
	     botoneraDeAcciones.setDisable(true);
	     botoneraDeCombinacion.setDisable(true);
	     this.msjError.setText("Chispa Capturada!");
	}

}
