package fiuba.algo3.model.unidades;

public class EstadoProtoNoPuedeRealizarAcciones extends RuntimeException {

    public String devolverMensajeError(){
        return "La combinacion no puede realizar acciones todavia!";
    }
}
