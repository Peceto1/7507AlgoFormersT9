package fiuba.algo3.view;

import fiuba.algo3.model.juego.Juego;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class ContenedorJuego extends BorderPane {

    Stage stage;
    BarraDeMenu barraMenu;
    Juego juego;


    ContenedorJuego(Stage stage, Juego juego, BarraDeMenu menuBar) {
        this.stage = stage;
        this.barraMenu = menuBar;
        this.juego = juego;
        this.setTop(menuBar);
    }


}
