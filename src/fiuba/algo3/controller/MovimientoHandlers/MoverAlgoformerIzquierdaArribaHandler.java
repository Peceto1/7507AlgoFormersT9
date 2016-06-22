package fiuba.algo3.controller.MovimientoHandlers;


import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionIzquierdaArriba;
import fiuba.algo3.view.ContenedorJuego;

public class MoverAlgoformerIzquierdaArribaHandler extends MovimientoHandler {

    public MoverAlgoformerIzquierdaArribaHandler(ContenedorJuego contenedor){
        super(contenedor);
    }

    public Direccion obtenerDireccion(){
        return new DireccionIzquierdaArriba();
    }

}
