package fiuba.algo3.controller.MovimientoHandlers;


import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionAbajo;
import fiuba.algo3.view.ContenedorJuego;

public class MoverAlgoformerAbajoHandler extends MovimientoHandler {

    public MoverAlgoformerAbajoHandler(ContenedorJuego contenedor){
        super(contenedor);
    }

    @Override
    Direccion obtenerDireccion() {
        return new DireccionAbajo();
    }
}
