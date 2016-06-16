package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class ElegirDecepticonsHandler implements EventHandler<ActionEvent> {

    Juego juego;
    TextField input;
    Button autobots;
    Button decepticons;
    Label msjError;

    public ElegirDecepticonsHandler(Juego juego, TextField input, Button autobots, Button decepticons, Label msjError) {
        this.juego = juego;
        this.input = input;
        this.autobots = autobots;
        this.decepticons = decepticons;
        this.msjError = msjError;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (input.getText().trim().equals("")) {
            msjError.setText("Debe ingresar un nombre");
            this.msjError.setTextFill(Color.web("#FF0000"));
            this.input.requestFocus();
            return;
        }

    }


}
