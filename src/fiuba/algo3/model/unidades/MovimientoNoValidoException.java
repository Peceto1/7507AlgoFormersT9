package fiuba.algo3.model.unidades;

public class MovimientoNoValidoException extends RuntimeException {

    public String devolverMensajeError(){
        return "Movimiento inválido";
    }

}
