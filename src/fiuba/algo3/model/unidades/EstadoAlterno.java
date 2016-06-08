package fiuba.algo3.model.unidades;


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
    public void combinarse(Decepticon dioLaOrden, Decepticon decepticon2, Decepticon decepticon3) {
        throw new EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException();
    }


    @Override
    void actualizarEstado(Algoformer algoformer) {

    }
    
    @Override
    public void empantanar(){
    	movimiento.restarMovimiento();
    }

}
