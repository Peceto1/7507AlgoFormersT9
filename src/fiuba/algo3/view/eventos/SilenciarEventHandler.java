package fiuba.algo3.view.eventos;

import fiuba.algo3.view.utilities.ReproductorFX;
import fiuba.algo3.view.utilities.ReproductorMusica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SilenciarEventHandler implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {
        ReproductorMusica.setMute(!ReproductorMusica.isMute());
        ReproductorFX.setMute(!ReproductorFX.isMute());
    }

}
