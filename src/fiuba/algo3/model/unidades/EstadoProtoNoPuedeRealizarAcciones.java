package fiuba.algo3.model.unidades;

public class EstadoProtoNoPuedeRealizarAcciones extends RuntimeException {

    @Override
    public String getMessage(){
        return "La combinacion no puede realizar acciones todavia!";
    }
}
