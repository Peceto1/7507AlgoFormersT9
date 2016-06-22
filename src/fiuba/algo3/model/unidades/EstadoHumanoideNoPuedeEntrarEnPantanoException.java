package fiuba.algo3.model.unidades;

public class EstadoHumanoideNoPuedeEntrarEnPantanoException extends RuntimeException {

    public String devolverMensajeError(){
        return "Humanoide no puede entrar en pantano";
    }

}
