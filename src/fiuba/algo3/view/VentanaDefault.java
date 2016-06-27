package fiuba.algo3.view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaDefault extends BorderPane {

    Stage stage;
    BarraDeMenu menuBar;


    public VentanaDefault(Stage stage) {
        this.stage = stage;
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }


    public BarraDeMenu getMenuBar() {
        return this.menuBar;
    }


    public void ocultarBarraDeMenu() {
        this.setTop(null);
    }


    public void mostrarBarraDeMenu() {
        this.setTop(menuBar);
    }
}
