package fiuba.algo3.controller.MovimientoHandlers;


import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionIzquierda;
import fiuba.algo3.view.ContenedorJuego;

public class MoverAlgoformerIzquierdaHandler extends MovimientoHandler {

    public MoverAlgoformerIzquierdaHandler(ContenedorJuego contenedor){
        super(contenedor);
    }

    @Override
    Direccion obtenerDireccion() {
        return new DireccionIzquierda();
    }
}
