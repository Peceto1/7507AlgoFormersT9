package fiuba.algo3.model.unidades;

public class NoHaySuficientesAlgoformersAdyacentesException extends RuntimeException {

    @Override
    public String getMessage(){
        return "Las unidades no pueden combinarse";
    }

}
