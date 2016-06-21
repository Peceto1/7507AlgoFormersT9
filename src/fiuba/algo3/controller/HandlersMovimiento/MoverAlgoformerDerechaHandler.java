package fiuba.algo3.controller.HandlersMovimiento;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.view.ContenedorJuego;


public class MoverAlgoformerDerechaHandler extends HandlerMovimiento {

    public MoverAlgoformerDerechaHandler(ContenedorJuego contenedorJuego) {
        super(contenedorJuego);

    }

    @Override
    Direccion obtenerDireccion() {
        return new DireccionDerecha();
    }
}
