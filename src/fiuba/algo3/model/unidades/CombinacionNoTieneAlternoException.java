package fiuba.algo3.model.unidades;

public class CombinacionNoTieneAlternoException extends RuntimeException {

    @Override
    public String getMessage(){
        return "La combinacion no puede transformarse!";
    }
}
