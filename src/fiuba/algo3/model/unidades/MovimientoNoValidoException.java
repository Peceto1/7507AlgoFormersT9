package fiuba.algo3.model.unidades;

public class MovimientoNoValidoException extends RuntimeException {

    @Override
    public String getMessage(){
        return "Movimiento inválido";
    }

}
