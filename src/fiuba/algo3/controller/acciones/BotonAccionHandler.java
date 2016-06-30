package fiuba.algo3.controller.acciones;
import fiuba.algo3.controller.VidaPropertyListener;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.juego.JugadorNoPuedeObtenerAlgoformerContrarioException;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.BotonProfile;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.eventos.ProfileOnClickHandler;
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


    protected void habilitarBotonProfileCombinacion(Algoformer combinacion, String equipo, Boolean deshabilitado) {

        GridPane grillaAlgoformers = (GridPane) contenedorJuego.getPanelLateral().lookup("#grillaAlgoformersGridPane");
        BotonProfile botonProfileCombinacion;

        if (equipo.equals("AUTOBOTS")) {
            botonProfileCombinacion = (BotonProfile) contenedorJuego.getPanelAbajo().lookup("#profileCombinacionesHBox").lookup("#superionBotonProfile");
            botonProfileCombinacion.setDisable(deshabilitado);
            botonProfileCombinacion.setOnAction(new ProfileOnClickHandler(combinacion, contenedorJuego));
            combinacion.vidaProperty().addListener(new VidaPropertyListener(botonProfileCombinacion));
            grillaAlgoformers.lookup("#optimusBotonProfile").setDisable(!deshabilitado);
            grillaAlgoformers.lookup("#bumblebleeBotonProfile").setDisable(!deshabilitado);
            grillaAlgoformers.lookup("#ratchetBotonProfile").setDisable(!deshabilitado);
            return;
        }

        botonProfileCombinacion = (BotonProfile) contenedorJuego.getPanelAbajo().lookup("#profileCombinacionesHBox").lookup("#menasorBotonProfile");
        botonProfileCombinacion.setDisable(deshabilitado);
        botonProfileCombinacion.setOnAction(new ProfileOnClickHandler(combinacion, contenedorJuego));
        combinacion.vidaProperty().addListener(new VidaPropertyListener(botonProfileCombinacion));
        grillaAlgoformers.lookup("#megatronBotonProfile").setDisable(!deshabilitado);
        grillaAlgoformers.lookup("#bonecrusherBotonProfile").setDisable(!deshabilitado);
        grillaAlgoformers.lookup("#frenzyBotonProfile").setDisable(!deshabilitado);
    }
    
    
}
