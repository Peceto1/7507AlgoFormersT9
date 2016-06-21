package fiuba.algo3.controller.HandlersMovimiento;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerechaArriba;
import fiuba.algo3.view.ContenedorJuego;

public class MoverAlgoformerDerechaArribaHandler extends HandlerMovimiento{

    public MoverAlgoformerDerechaArribaHandler(ContenedorJuego contenedor){
        super(contenedor);
    }

    @Override
    Direccion obtenerDireccion(){
        return new DireccionDerechaArriba();
    }

}
