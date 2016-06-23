package fiuba.algo3.controller;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.layouts.PanelAbajo;
import fiuba.algo3.view.layouts.PanelLateral;
import fiuba.algo3.view.utilities.ReproductorFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Optional;

public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {

    private Label infoJugador;
    private Label infoEquipo;
    private Label infoTurno;
    private Juego juego;
    private Text msjError;
    private HBox botoneraDeDirecciones;
    private HBox botoneraDeAcciones;
    private VBox botoneraDeCombinacion;
    private ContenedorJuego contenedorJuego;


    public BotonTerminarTurnoHandler(PanelLateral panelLateral, PanelAbajo panelAbajo, ContenedorJuego contenedorJuego) {

        this.infoJugador = (Label) panelLateral.lookup("#infoJugador");
        this.infoEquipo = (Label) panelLateral.lookup("#infoEquipo");
        this.infoTurno = (Label) panelLateral.lookup("#infoTurno");
        this.msjError = (Text) panelLateral.lookup("#msjErrorText");
        this.botoneraDeDirecciones = (HBox) panelAbajo.lookup("#contenedorDirecciones");
        this.botoneraDeAcciones = (HBox) panelAbajo.lookup("#contenedorAcciones");
        this.botoneraDeCombinacion = (VBox) panelAbajo.lookup("#contenedorCombinarseVBox");
        this.contenedorJuego = contenedorJuego;
        this.juego = contenedorJuego.getJuego();
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        ReproductorFX.reproducirFX(ReproductorFX.ENDTURN);
    	juego.finalizarTurno();

    	if (juego.hayGanador()) {
            // ToDo refactor en un metodo
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("¡GANADOR!");
    		alert.setHeaderText(null);
    		alert.setContentText("¡EL JUGADOR: " + juego.obtenerGanador().getNombre().toUpperCase() + " HA GANADO LA PARTIDA!");
    		ButtonType boton = new ButtonType("Terminar", ButtonData.FINISH);
    		alert.getButtonTypes().setAll(boton);
    		Optional<ButtonType> result = alert.showAndWait();
    		System.exit(0);
    		alert.show();
    	}

        this.contenedorJuego.panearCamara();

    	String nombreJug = juego.getJugadorEnTurno().getNombre();
        String equipoJug = juego.getJugadorEnTurno().getEquipo();
        String numeroTurno = Integer.toString(juego.getTurno());
        
        botoneraDeDirecciones.setVisible(false);
        botoneraDeAcciones.setDisable(false);
        botoneraDeCombinacion.setDisable(false);
        infoJugador.setText("Jugador: " + nombreJug);
        infoTurno.setText("Turno: " + numeroTurno);
        infoEquipo.setText("Equipo: " + equipoJug);

        //
        Algoformer ultimoUsado = juego.getJugadorEnTurno().getUltimoAlgoformerUtilizado();
        contenedorJuego.setAccionado(ultimoUsado);
        Punto ubicacionA = ultimoUsado.getUbicacion();
        contenedorJuego.getPanelLateral().actualizarStats(ultimoUsado, Arena.getInstance().devolverBonusEn(ubicacionA),Arena.getInstance().devolverTerrenoEn(ubicacionA));

        //
        msjError.setText("");
    }


}
