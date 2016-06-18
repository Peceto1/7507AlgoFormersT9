package fiuba.algo3.view;

import fiuba.algo3.view.eventos.OpcionSalirEventHandler;
import fiuba.algo3.view.eventos.SilenciarEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class BarraDeMenu extends MenuBar {

    Menu menuArchivo;
    Menu menuOpciones;
    Menu menuAyuda;
    MenuItem opcionPantallaCompleta;
    String estiloNegro = "-fx-base: #474747;";


    public BarraDeMenu(Stage stage) {

        this.menuArchivo = new Menu("Archivo");
        this.menuOpciones = new Menu("Opciones");
        this.menuAyuda = new Menu("Ayuda");
        opcionPantallaCompleta = new MenuItem("Pantalla Completa");
        agregarOpcionesAMenus(stage);
        this.setStyle(estiloNegro);
    }


    private void agregarOpcionesAMenus(Stage stage) {

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        MenuItem opcionSilenciar = new MenuItem("Silenciar/Reproducir");

        this.menuArchivo.getItems().add(opcionSalir);
        this.menuOpciones.getItems().addAll(opcionPantallaCompleta, new SeparatorMenuItem(), opcionSilenciar);
        this.menuAyuda.getItems().add(opcionAcercaDe);

        opcionSalir.setOnAction(new OpcionSalirEventHandler());
        opcionAcercaDe.setOnAction(new OpcionAcercaDeEventHandler());
        opcionSilenciar.setOnAction(new SilenciarEventHandler());
        opcionPantallaCompleta.setOnAction(new OpcionPantallaCompletaHandler(stage, opcionPantallaCompleta));
        opcionPantallaCompleta.setDisable(true);


        this.getMenus().addAll(menuArchivo, menuOpciones, menuAyuda);
    }


    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);
    }


    private class OpcionPantallaCompletaHandler implements EventHandler<ActionEvent> {

        Stage stage;
        MenuItem opcionPantallaCompleta;

        OpcionPantallaCompletaHandler(Stage stage, MenuItem opcionPantallaCompleta) {
            this.stage = stage;
            this.opcionPantallaCompleta = opcionPantallaCompleta;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            if (!this.stage.isFullScreen()) {
                this.stage.setFullScreen(true);
                this.opcionPantallaCompleta.setDisable(true);
            }
        }

    }


    private class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Acerca De...");
            alert.setHeaderText("Algoformers");
            alert.setContentText("Grupo T9 - Algoritmos III\n" +
                                "Primer Cuatrimestre 2016\n\n" +
                                "Integrantes:\n" +
                                "\tCzop, Guillermo\n" +
                                "\tDorgan, Santiago\n" +
                                "\tIrrazabal, Diego\n" +
                                "\tPenovi, Francisco");
            alert.show();
        }
    }

}
