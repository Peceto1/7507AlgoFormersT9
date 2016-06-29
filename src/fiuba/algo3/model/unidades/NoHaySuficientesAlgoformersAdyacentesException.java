package fiuba.algo3.model.unidades;

public class NoHaySuficientesAlgoformersAdyacentesException extends RuntimeException {

    public String devolverMensajeError(){
        return "Las unidades no pueden combinarse";
    }

}
