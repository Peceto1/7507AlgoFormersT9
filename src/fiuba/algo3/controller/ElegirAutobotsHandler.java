package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.juego.YaExisteJugadorConEseNombreException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ElegirAutobotsHandler extends ElegirEquipoHandler {

    Button autobots;


    public ElegirAutobotsHandler(Juego juego, TextField input, Button autobots, Label msjError, Text nroJugador) {
        this.juego = juego;
        this.input = input;
        this.autobots = autobots;
        this.msjError = msjError;
        this.nroJugador = nroJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!ingresoValido())
            return;

        try {
            juego.crearJugador(input.getText().trim(), "AUTOBOTS");
        } catch (YaExisteJugadorConEseNombreException e) {
            msjError.setText("Nombre en uso");
            return;
        }

        autobots.setDisable(true);
        limpiarPanel();
    }

}