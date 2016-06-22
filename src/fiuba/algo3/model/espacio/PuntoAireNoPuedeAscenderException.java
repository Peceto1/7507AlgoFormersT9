package fiuba.algo3.model.espacio;

public class PuntoAireNoPuedeAscenderException extends RuntimeException {

    public String devolverMensajeError(){
        return "Imposible ascender";
    }

}
