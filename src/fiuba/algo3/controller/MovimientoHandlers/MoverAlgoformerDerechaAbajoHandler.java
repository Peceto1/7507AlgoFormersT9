package fiuba.algo3.controller.MovimientoHandlers;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerechaAbajo;
import fiuba.algo3.view.ContenedorJuego;


public class MoverAlgoformerDerechaAbajoHandler extends MovimientoHandler {

    public MoverAlgoformerDerechaAbajoHandler(ContenedorJuego contenedor){
        super(contenedor);
    }

    @Override
    Direccion obtenerDireccion(){
        return new DireccionDerechaAbajo();
    }

}