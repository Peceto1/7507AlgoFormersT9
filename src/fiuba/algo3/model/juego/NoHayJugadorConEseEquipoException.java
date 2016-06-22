package fiuba.algo3.model.juego;

public class NoHayJugadorConEseEquipoException extends RuntimeException {

    public String devolverMensajeError(){
        return "Ningun jugador posee el equipo";
    }

}
