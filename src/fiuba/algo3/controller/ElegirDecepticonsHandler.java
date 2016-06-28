package fiuba.algo3.controller;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.VentanaDefault;
import fiuba.algo3.view.utilities.ReproductorFX;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ElegirDecepticonsHandler extends ElegirEquipoHandler {

    private Button decepticons;


    public ElegirDecepticonsHandler(Juego juego, TextField input, Button decepticons, Label msjError, Text nroJugador, VBox panelAbajo, VentanaDefault ventanaDefault) {
        this.juego = juego;
        this.input = input;
        this.decepticons = decepticons;
        this.msjError = msjError;
        this.nroJugador = nroJugador;
        this.panelAbajo = panelAbajo;
        this.equipo = "DECEPTICONS";
        this.ventanaDefault = ventanaDefault;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!ingresoValido())
            return;

        if (!crearJugador())
            return;

        decepticons.setDisable(true);
        mostrarEleccion();
        limpiarPanel();
        ReproductorFX.reproducirFX(ReproductorFX.HITFX);
    }


}
