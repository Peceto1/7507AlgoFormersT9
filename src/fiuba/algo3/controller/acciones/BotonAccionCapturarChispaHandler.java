package fiuba.algo3.controller.acciones;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.EstadoProtoNoPuedeRealizarAcciones;
import fiuba.algo3.model.unidades.ImposibleCapturarChispaException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.ReproductorFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class BotonAccionCapturarChispaHandler extends BotonAccionHandler implements EventHandler<ActionEvent> {

	private Text msjError;


    public BotonAccionCapturarChispaHandler(ContenedorJuego contenedor) {
    	super(contenedor);
    	this.msjError = contenedor.getMsjError();
    }

    
	@Override
	public void handle(ActionEvent actionEvent) {
		contenedorJuego.setAccionado(null);
	     Algoformer algoformerACapturar = contenedorJuego.getAlgoformerAccionado();

	     if (!puedeRealizarAccion(algoformerACapturar))
	    	 return;
	     
		try {
			algoformerACapturar.capturarChispa();
		} catch (ImposibleCapturarChispaException e) {
			ReproductorFX.reproducirFX(ReproductorFX.ERROR1);
			this.msjError.setText("No se esta localizado sobre la chispa");
			return;
		} catch(EstadoProtoNoPuedeRealizarAcciones e){
			ReproductorFX.reproducirFX(ReproductorFX.ERROR1);
			this.msjError.setText(e.getMessage());
			return;
		}

		deshabilitarAcciones();
		this.msjError.setText("Chispa Capturada!");
	}
	
}
