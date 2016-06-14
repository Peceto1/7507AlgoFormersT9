package fiuba.algo3.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class BarraDeMenu extends MenuBar {

    Menu menuArchivo;
    Menu menuVer;
    Menu menuAyuda;

    public BarraDeMenu(Stage stage) {

        this.menuArchivo = new Menu("Archivo");
        this.menuVer = new Menu("Ver");
        this.menuAyuda = new Menu("Ayuda");
        agregarOpcionesAMenus();
    }


    private void agregarOpcionesAMenus() {

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionPantallaCompleta = new MenuItem("Pantalla Completa");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        // Si quiero usar fullscreen necesito usar el stage que me pasé por parámetro
        // Por ahora no me interesa eso...

        this.menuArchivo.getItems().add(opcionSalir);
        this.menuVer.getItems().add(opcionPantallaCompleta);
        this.menuAyuda.getItems().add(opcionAcercaDe);

        opcionSalir.setOnAction(new OpcionSalirEventHandler());
        opcionPantallaCompleta.setDisable(true);        // Pantalla completa desabilitada
        opcionAcercaDe.setOnAction(new OpcionAcercaDeEventHandler());


        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }


    private class OpcionSalirEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            System.exit(0);
        }
    }


    private class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Acerca De...");
            alert.setHeaderText("Algoformers");
            alert.setContentText("Grupo T9 - Algoritmos III\n" +
                                "Primer Cuatrimestre 2016");
            alert.show();
        }
    }

}
