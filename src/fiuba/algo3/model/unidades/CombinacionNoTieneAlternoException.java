package fiuba.algo3.model.unidades;

public class CombinacionNoTieneAlternoException extends RuntimeException {

    public String devolverMensajeError(){
        return "La combinacion no puede transformarse!";
    }
}
