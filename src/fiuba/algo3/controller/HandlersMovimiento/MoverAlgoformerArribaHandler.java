package fiuba.algo3.controller.HandlersMovimiento;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionArriba;
import fiuba.algo3.view.ContenedorJuego;

public class MoverAlgoformerArribaHandler extends HandlerMovimiento{

    public MoverAlgoformerArribaHandler(ContenedorJuego contenedor){
        super(contenedor);
    }

    @Override
    Direccion obtenerDireccion(){
        return new DireccionArriba();
    }

}
