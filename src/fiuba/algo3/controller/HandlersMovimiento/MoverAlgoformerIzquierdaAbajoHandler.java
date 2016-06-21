package fiuba.algo3.controller.HandlersMovimiento;


import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionIzquierdaAbajo;
import fiuba.algo3.view.ContenedorJuego;

public class MoverAlgoformerIzquierdaAbajoHandler extends HandlerMovimiento{

    public MoverAlgoformerIzquierdaAbajoHandler(ContenedorJuego contenedor){
        super(contenedor);
    }
    @Override
    Direccion obtenerDireccion(){
        return new DireccionIzquierdaAbajo();
    }

}
