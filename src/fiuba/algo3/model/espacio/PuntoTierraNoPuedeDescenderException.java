package fiuba.algo3.model.espacio;


public class PuntoTierraNoPuedeDescenderException extends RuntimeException {

    public String devolverMensajeError(){
        return "Imposible descender";
    }

}
