package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.utilities.ReproductorMusica;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BotonComenzarBatallaHandler implements EventHandler<ActionEvent> {


    Stage stage;
    Scene escenaProxima;
    Juego juego;
    Button botonComenzarBatalla;

    public BotonComenzarBatallaHandler(Stage stage, Scene escenaProxima, Juego juego, Button botonComenzarBatalla) {
        this.stage = stage;
        this.escenaProxima = escenaProxima;
        this.botonComenzarBatalla = botonComenzarBatalla;
        this.juego = juego;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        juego.comenzarPartida();
        botonComenzarBatalla.setDisable(true);
        ReproductorMusica.fadeOut(Duration.seconds(2));

        Timeline accionDeFade = ReproductorMusica.getTimeline();
        accionDeFade.setOnFinished( (ae) -> {
            // ToDo cambiar de escena
        } );
    }
}
