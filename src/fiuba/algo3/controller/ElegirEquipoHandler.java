package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public abstract class ElegirEquipoHandler implements EventHandler<ActionEvent> {

    Juego juego;
    TextField input;
    Label msjError;
    Text nroJugador;


    Boolean ingresoValido() {
        if (input.getText().trim().equals("")) {
            msjError.setText("Debe ingresar un nombre");
            this.input.requestFocus();
            return false;
        }
        return true;
    }

    void limpiarPanel() {
        input.clear();
        msjError.setText("");

        if (juego.getCantJugadores() < 2) {
            nroJugador.setText("Jugador 2");
            return;
        }

        nroJugador.setText("Fin de Elección");
        nroJugador.setFill(Color.LIGHTGREEN);
        input.setDisable(true);
    }


}
