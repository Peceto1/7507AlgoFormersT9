package fiuba.algo3.model.juego;

public class YaExisteJugadorConEseNombreException extends RuntimeException {

    public String devolverMensajeError(){
        return "Ya existe jugador con ese nombre";
    }
}
