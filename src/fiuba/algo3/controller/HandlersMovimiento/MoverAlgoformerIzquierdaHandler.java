package fiuba.algo3.controller.HandlersMovimiento;


import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionIzquierda;
import fiuba.algo3.view.ContenedorJuego;

public class MoverAlgoformerIzquierdaHandler extends HandlerMovimiento{

    public MoverAlgoformerIzquierdaHandler(ContenedorJuego contenedor){
        super(contenedor);
    }

    @Override
    Direccion obtenerDireccion() {
        return new DireccionIzquierda();
    }
}
