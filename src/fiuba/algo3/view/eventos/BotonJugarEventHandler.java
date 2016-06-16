package fiuba.algo3.view.eventos;

import fiuba.algo3.model.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {


    Stage stage;
    Scene escenaJuego;

    public BotonJugarEventHandler(Stage stage, Scene escenaJuego) {
        this.stage = stage;
        this.escenaJuego = escenaJuego;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.setScene(escenaJuego);
        this.stage.setFullScreen(true);
    }

}
