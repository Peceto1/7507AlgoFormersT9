package fiuba.algo3.controller.acciones;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.juego.JugadorNoPuedeObtenerAlgoformerContrarioException;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.ReproductorFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class BotonAccionHandler implements EventHandler<ActionEvent> {

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
            ReproductorFX.reproducirFX(ReproductorFX.ERROR1);
            contenedorJuego.getMsjError().setText(e.devolverMensajeError());
            return false;
        }

        contenedorJuego.getJuego().getJugadorEnTurno().setUltimoAlgoformerUtilizado(algoformerAccionado);
        return true;
	}
	
    
    protected void deshabilitarAcciones() {
        HBox contenedorAcciones = (HBox) contenedorJuego.getPanelAbajo().lookup("#contenedorAcciones");
        VBox contenedorCombinarse = (VBox) contenedorJuego.getPanelAbajo().lookup("#contenedorCombinarseVBox");
        ReproductorFX.reproducirFX(ReproductorFX.HITFX);
        contenedorAcciones.setDisable(true);
        contenedorCombinarse.setDisable(true);
    }


    protected void habilitarBotonProfileCombinacion(String equipo, Boolean deshabilitado) {

        GridPane grillaAlgoformers = (GridPane) contenedorJuego.getPanelLateral().lookup("#grillaAlgoformersGridPane");

        if (equipo.equals("AUTOBOTS")) {
            contenedorJuego.getPanelAbajo().lookup("#profileCombinacionesHBox").lookup("#superionBotonProfile").setDisable(deshabilitado);
            grillaAlgoformers.lookup("#optimusBotonProfile").setDisable(!deshabilitado);
            grillaAlgoformers.lookup("#bumblebleeBotonProfile").setDisable(!deshabilitado);
            grillaAlgoformers.lookup("#ratchetBotonProfile").setDisable(!deshabilitado);
            return;
        }

        contenedorJuego.getPanelAbajo().lookup("#profileCombinacionesHBox").lookup("#menasorBotonProfile").setDisable(deshabilitado);
        grillaAlgoformers.lookup("#megatronBotonProfile").setDisable(!deshabilitado);
        grillaAlgoformers.lookup("#bonecrusherBotonProfile").setDisable(!deshabilitado);
        grillaAlgoformers.lookup("#frenzyBotonProfile").setDisable(!deshabilitado);
    }
    
    
}
