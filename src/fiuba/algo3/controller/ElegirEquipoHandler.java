package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.juego.YaExisteJugadorConEseNombreException;
import fiuba.algo3.view.utilities.ReproductorFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class ElegirEquipoHandler implements EventHandler<ActionEvent> {

    Juego juego;
    TextField input;
    Label msjError;
    Text nroJugador;
    VBox panelAbajo;
    String equipo;


    Boolean ingresoValido() {
        if (input.getText().trim().equals("")) {
            ReproductorFX.reproducirFX(ReproductorFX.ERROR1);
            msjError.setText("Debe ingresar un nombre");
            this.input.requestFocus();
            return false;
        }
        return true;
    }


    Boolean crearJugador() {

        try {
            juego.crearJugador(input.getText().trim(), equipo);
        } catch (YaExisteJugadorConEseNombreException e) {
            ReproductorFX.reproducirFX(ReproductorFX.ERROR1);
            msjError.setText("Nombre en uso");
            return false;
        }
        return true;
    }


    void mostrarEleccion() {
        Label eleccion = new Label();
        eleccion.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        if (equipo.equals("AUTOBOTS"))
            eleccion.setTextFill(Color.LIMEGREEN);

        else
            eleccion.setTextFill(Color.INDIANRED);

        eleccion.setText(input.getText().trim() + " eligió " + equipo);
        VBox elecciones = (VBox) panelAbajo.lookup("#eleccionesVBox");
        elecciones.getChildren().add(eleccion);
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
        panelAbajo.lookup("#botonComenzarBatalla").setVisible(true);
    }


}
