package fiuba.algo3.controller.acciones;

import fiuba.algo3.controller.ClickearEnemigoHandler;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class BotonAccionAtacarHandler extends BotonAccionHandler {


    public BotonAccionAtacarHandler(ContenedorJuego contenedorJuego) {
        super(contenedorJuego);
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        contenedorJuego.setAccionado(null);
        Algoformer algoformerAtacante = contenedorJuego.getAlgoformerAccionado();

        if (!puedeRealizarAccion(algoformerAtacante))
            return;

        StackPane contenedorCanvases = (StackPane) this.contenedorJuego.lookup("#contenedorStackPane");
        contenedorCanvases.setOnMouseClicked(new ClickearEnemigoHandler(algoformerAtacante, contenedorJuego));
        HBox contenedorTerminarTurno = (HBox) this.contenedorJuego.lookup("#ContenedorFinalizarTurno");
        contenedorTerminarTurno.setDisable(true);
        deshabilitarAcciones();
        
    }
    
    


}
