package fiuba.algo3.model.unidades;

public class FueraDeRangoException extends RuntimeException {

    public String devolverMensajeError(){
        return "Limite de la arena";
    }

}
