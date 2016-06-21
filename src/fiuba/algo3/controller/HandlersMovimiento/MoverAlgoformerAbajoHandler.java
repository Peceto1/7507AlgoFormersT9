package fiuba.algo3.controller.HandlersMovimiento;


import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionAbajo;
import fiuba.algo3.view.ContenedorJuego;

public class MoverAlgoformerAbajoHandler extends HandlerMovimiento{

    public MoverAlgoformerAbajoHandler(ContenedorJuego contenedor){
        super(contenedor);
    }

    @Override
    Direccion obtenerDireccion() {
        return new DireccionAbajo();
    }
}
