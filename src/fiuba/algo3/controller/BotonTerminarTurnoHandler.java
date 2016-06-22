package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.layouts.PanelAbajo;
import fiuba.algo3.view.layouts.PanelLateral;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {

    private Label infoJugador;
    private Label infoEquipo;
    private Label infoTurno;
    private Juego modelJuego;
    private Text msjError;
    private HBox botoneraDeDirecciones;
    private HBox botoneraDeAcciones;
    private VBox botoneraDeCombinacion;

    public BotonTerminarTurnoHandler(PanelLateral panelLateral, PanelAbajo panelAbajo, Juego juego) {
        this.infoJugador = (Label) panelLateral.lookup("#infoJugador");
        this.infoEquipo = (Label) panelLateral.lookup("#infoEquipo");
        this.infoTurno = (Label) panelLateral.lookup("#infoTurno");
        this.msjError = (Text) panelLateral.lookup("#msjErrorText");
        this.modelJuego = juego;
        this.botoneraDeDirecciones = (HBox) panelAbajo.lookup("#contenedorDirecciones");
        this.botoneraDeAcciones = (HBox) panelAbajo.lookup("#contenedorAcciones");
        this.botoneraDeCombinacion = (VBox) panelAbajo.lookup("#contenedorCombinarseVBox");
    }


    @Override
    public void handle(ActionEvent actionEvent) {
    	modelJuego.finalizarTurno();
    	String nombreJug = modelJuego.getJugadorEnTurno().getNombre();
        String equipoJug = modelJuego.getJugadorEnTurno().getEquipo();
        String numeroTurno = Integer.toString(modelJuego.getTurno());
        
        botoneraDeDirecciones.setVisible(false);
        botoneraDeAcciones.setDisable(false);
        botoneraDeCombinacion.setDisable(false);
        infoJugador.setText("Jugador: " + nombreJug);
        infoTurno.setText("Turno: " + numeroTurno);
        infoEquipo.setText("Equipo: " + equipoJug);
        msjError.setText("");

    }


}
