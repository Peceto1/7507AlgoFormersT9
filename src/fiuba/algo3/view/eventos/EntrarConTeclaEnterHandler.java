package fiuba.algo3.view.eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EntrarConTeclaEnterHandler implements EventHandler<KeyEvent> {

    Button botonADisparar;


    public EntrarConTeclaEnterHandler(Button botonADisparar) {
        this.botonADisparar = botonADisparar;
    }


    @Override
    public void handle(KeyEvent keyEvent) {

        if (!keyEvent.getCode().equals(KeyCode.ENTER))
            return;

        botonADisparar.fire();
    }
}
