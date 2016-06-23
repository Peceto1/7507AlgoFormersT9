package fiuba.algo3.controller;

import fiuba.algo3.view.ContenedorJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickEnMapaHandler implements EventHandler<MouseEvent> {

    private ContenedorJuego contenedorJuego;


    public ClickEnMapaHandler(ContenedorJuego contenedorJuego) {
        this.contenedorJuego = contenedorJuego;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        contenedorJuego.seleccionarCasillero(mouseEvent.getX(), mouseEvent.getY());
    }

}
