package fiuba.algo3.view.eventos;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.ContenedorEleccionEquipos;
import fiuba.algo3.view.VentanaDefault;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {


    VentanaDefault ventanaDefault;
    ContenedorEleccionEquipos escenaProxima;
    Juego juego;

    public BotonJugarEventHandler(VentanaDefault ventanaDefault, Juego juego) {
        this.ventanaDefault = ventanaDefault;
        this.juego = juego;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.escenaProxima = new ContenedorEleccionEquipos(ventanaDefault, juego);
        this.ventanaDefault.setCenter(escenaProxima);
    }

}
