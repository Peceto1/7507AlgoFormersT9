package fiuba.algo3.model.juego;

public class JugadorNoPuedeObtenerAlgoformerContrarioException extends RuntimeException {

    public String devolverMensajeError(){
        return "No puede usar algoformers enemigos";
    }

}
