package fiuba.algo3.model.unidades;

public class EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException extends RuntimeException {

    @Override
    public String getMessage(){
        return "Alterno no puede combinar";
    }

}
