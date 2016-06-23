package fiuba.algo3.controller;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.ImposibleCapturarChispaException;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class BotonCapturarChispaHandler extends BotonAccionHandler implements EventHandler<ActionEvent> {
	private Text msjError;
    
    public BotonCapturarChispaHandler(ContenedorJuego contenedor){
    	super(contenedor);
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
	     deshabilitarAcciones();
	     this.msjError.setText("Chispa Capturada!");
	}
	
}
