package fiuba.algo3.view.eventos;

import fiuba.algo3.view.ContenedorEleccionEquipos;
import fiuba.algo3.view.VentanaDefault;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {


    VentanaDefault ventanaDefault;
    ContenedorEleccionEquipos escenaProxima;

    public BotonJugarEventHandler(VentanaDefault ventanaDefault, ContenedorEleccionEquipos escenaProxima) {
        this.ventanaDefault = ventanaDefault;
        this.escenaProxima = escenaProxima;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.ventanaDefault.setCenter(escenaProxima);
    }

}
