package fiuba.algo3.view.eventos;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.ContenedorEleccionEquipos;
import fiuba.algo3.view.VentanaDefault;
import fiuba.algo3.view.utilities.ReproductorFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonJugarEventHandler implements EventHandler<ActionEvent> {


    VentanaDefault ventanaDefault;
    ContenedorEleccionEquipos escenaProxima;
    Juego juego;

    public BotonJugarEventHandler(VentanaDefault ventanaDefault) {
        this.ventanaDefault = ventanaDefault;
        this.juego = new Juego();
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.escenaProxima = new ContenedorEleccionEquipos(ventanaDefault, juego);
        ReproductorFX.inicializarReproductorFX();
        ReproductorFX.reproducirFX(ReproductorFX.ROBOTIC);
        this.ventanaDefault.setCenter(escenaProxima);
    }

}
