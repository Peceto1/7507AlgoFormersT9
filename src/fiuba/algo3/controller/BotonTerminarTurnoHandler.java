package fiuba.algo3.controller;

import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.layouts.PanelAbajo;
import fiuba.algo3.view.layouts.PanelLateral;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.utilities.ReproductorFX;
import fiuba.algo3.view.utilities.ReproductorMusica;
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
    private String victoryThemeResource = "src/fiuba/algo3/view/resources/sounds/victoryTheme.mp3";


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
    		alertarGanador();
    	}

        this.contenedorJuego.panearCamara();

        resetearBotonesDeAcciones();
        actualizarInfoTurno();
        actualizarAlgoformerSeleccionado();
        //
        
        //
        msjError.setText("");
    }
    
    public void alertarGanador(){
    	ReproductorMusica.stop();
        ReproductorMusica.playBackGroundTheme(victoryThemeResource, false);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("¡GANADOR!");
		alert.setHeaderText(null);
		alert.setContentText("¡EL JUGADOR: " + juego.obtenerGanador().getNombre() + " HA GANADO LA PARTIDA!");
		ButtonType boton = new ButtonType("Terminar", ButtonData.FINISH);
		alert.getButtonTypes().setAll(boton);
		Optional<ButtonType> result = alert.showAndWait();
		System.exit(0);
		alert.show();
    }
    
    private void actualizarInfoTurno(){
    	
    	String nombreJug = juego.getJugadorEnTurno().getNombre();
        String equipoJug = juego.getJugadorEnTurno().getEquipo();
        String numeroTurno = Integer.toString(juego.getTurno());
        
        
    	infoJugador.setText("Jugador: " + nombreJug);
        infoTurno.setText("Turno: " + numeroTurno);
        infoEquipo.setText("Equipo: " + equipoJug);
    }
    
    private void resetearBotonesDeAcciones(){
    	botoneraDeDirecciones.setVisible(false);
        botoneraDeAcciones.setDisable(false);
        botoneraDeCombinacion.setDisable(false);
    }
    
    private void actualizarAlgoformerSeleccionado(){
    	Algoformer ultimoUsado = juego.getJugadorEnTurno().getUltimoAlgoformerUtilizado();
        contenedorJuego.setAccionado(ultimoUsado);
        Punto ubicacionA = ultimoUsado.getUbicacion();
        ConvertidorPuntoAPixels conversor = new ConvertidorPuntoAPixels();
        PuntoPixels ubicacionUltimoPixels = conversor.convertir(ubicacionA);
        
        contenedorJuego.seleccionarCasillero(ubicacionUltimoPixels.getX(), ubicacionUltimoPixels.getY());
    }


}
