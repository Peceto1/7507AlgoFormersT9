package fiuba.algo3.model.juego;

public class EquipoNoDisponibleException extends RuntimeException {

    public String devolverMensajeError(){
        return "No se puede seleccionar el equipo";
    }

}
