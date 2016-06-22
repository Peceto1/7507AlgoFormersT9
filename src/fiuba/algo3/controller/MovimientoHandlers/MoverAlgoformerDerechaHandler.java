package fiuba.algo3.controller.MovimientoHandlers;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.view.ContenedorJuego;


public class MoverAlgoformerDerechaHandler extends MovimientoHandler {

    public MoverAlgoformerDerechaHandler(ContenedorJuego contenedorJuego) {
        super(contenedorJuego);

    }

    @Override
    Direccion obtenerDireccion() {
        return new DireccionDerecha();
    }
}
