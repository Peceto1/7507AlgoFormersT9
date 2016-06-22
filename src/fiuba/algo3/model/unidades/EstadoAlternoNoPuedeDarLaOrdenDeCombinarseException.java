package fiuba.algo3.model.unidades;

public class EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException extends RuntimeException {

    public String devolverMensajeError(){
        return "Alterno no puede combinar";
    }

}
