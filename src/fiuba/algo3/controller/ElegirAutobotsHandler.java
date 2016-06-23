package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.utilities.ReproductorFX;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ElegirAutobotsHandler extends ElegirEquipoHandler {

    Button autobots;


    public ElegirAutobotsHandler(Juego juego, TextField input, Button autobots, Label msjError, Text nroJugador, VBox panelAbajo) {
        this.juego = juego;
        this.input = input;
        this.autobots = autobots;
        this.msjError = msjError;
        this.nroJugador = nroJugador;
        this.panelAbajo = panelAbajo;
        this.equipo = "AUTOBOTS";
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!ingresoValido())
            return;

        if (!crearJugador())
            return;

        autobots.setDisable(true);
        mostrarEleccion();
        limpiarPanel();
        ReproductorFX.reproducirFX(ReproductorFX.HITFX);
    }

}
