package fiuba.algo3.model.unidades;


import fiuba.algo3.model.espacio.Punto;

import java.util.List;

abstract class EstadoAlterno extends Estado {


    @Override
    public void capturarChispa(Algoformer captor) {
        throw new ImposibleCapturarChispaException();
    }


    @Override
    public void combinarse(Autobot dioLaOrden, Autobot autobot2, Autobot autobot3) {
        
    	throw new EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException();
    }


    @Override
    public void combinarse(Decepticon decepticon1, Decepticon decepticon2, Decepticon decepticon3) {

        throw new EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException();
    }

}
