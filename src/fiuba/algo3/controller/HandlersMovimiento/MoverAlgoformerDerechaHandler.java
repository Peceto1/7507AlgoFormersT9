package fiuba.algo3.controller.HandlersMovimiento;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.view.ContenedorJuego;

import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class MoverAlgoformerDerechaHandler extends HandlerMovimiento {

    public MoverAlgoformerDerechaHandler(ContenedorJuego contenedorJuego) {
        super(contenedorJuego);

    }

    @Override
    Direccion obtenerDireccion() {
        return new DireccionDerecha();
    }
}
