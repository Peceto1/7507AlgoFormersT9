package fiuba.algo3.controller;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class BotonAccionAtacarHandler extends BotonAccionHandler {


    public BotonAccionAtacarHandler(ContenedorJuego contenedorJuego) {
        super(contenedorJuego);
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        contenedorJuego.setAccionado();
        Algoformer algoformerAtacante = contenedorJuego.getAlgoformerAccionado();

        if (!puedeRealizarAccion(algoformerAtacante))
            return;

        StackPane contenedorCanvases = (StackPane) this.contenedorJuego.lookup("#contenedorStackPane");
        contenedorCanvases.setOnMouseClicked(new ClickearEnemigoHandler(algoformerAtacante, contenedorJuego));
    }


}
