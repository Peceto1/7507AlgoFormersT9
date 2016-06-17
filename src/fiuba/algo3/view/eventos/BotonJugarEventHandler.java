package fiuba.algo3.view.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {


    Stage stage;
    Scene escenaProxima;

    public BotonJugarEventHandler(Stage stage, Scene escenaProxima) {
        this.stage = stage;
        this.escenaProxima = escenaProxima;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.setScene(escenaProxima);
        this.stage.setFullScreen(true);
    }

}
