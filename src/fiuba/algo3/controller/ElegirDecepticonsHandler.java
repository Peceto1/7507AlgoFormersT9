package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.juego.YaExisteJugadorConEseNombreException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ElegirDecepticonsHandler extends ElegirEquipoHandler {

    Button decepticons;


    public ElegirDecepticonsHandler(Juego juego, TextField input, Button decepticons, Label msjError, Text nroJugador) {
        this.juego = juego;
        this.input = input;
        this.decepticons = decepticons;
        this.msjError = msjError;
        this.nroJugador = nroJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!ingresoValido())
            return;

        try {
            juego.crearJugador(input.getText().trim(), "DECEPTICONS");
        } catch (YaExisteJugadorConEseNombreException e) {
            msjError.setText("Nombre en uso");
            return;
        }

        decepticons.setDisable(true);
        limpiarPanel();
    }


}
