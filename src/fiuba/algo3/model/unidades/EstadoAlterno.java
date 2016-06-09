package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.EfectoTormentaPsionica;


abstract class EstadoAlterno extends Estado {


    @Override
    public void capturarChispa(Algoformer captor) {
        throw new ImposibleCapturarChispaException();
    }

    @Override
    public Superion combinarse(Autobot dioLaOrden, Autobot autobot2, Autobot autobot3) {
        throw new EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException();
    }

    @Override
    public Menasor combinarse(Decepticon dioLaOrden, Decepticon decepticon2, Decepticon decepticon3) {
        throw new EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException();
    }


    @Override
    void actualizarEstado(Autobot autobot) {

    }


    @Override
    void actualizarEstado(Decepticon decepticon) {

    }


    @Override
    public void perderUnMovimiento(){
    	movimiento.restarMovimiento();
    }
    
    @Override
    public void aplicarEfecto(EfectoTormentaPsionica efecto){
    	ataque = (ataqueMax - (ataqueMax*4)/10);
    }

}
