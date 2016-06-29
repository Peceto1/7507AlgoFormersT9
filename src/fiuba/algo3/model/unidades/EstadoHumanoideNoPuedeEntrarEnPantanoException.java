package fiuba.algo3.model.unidades;

public class EstadoHumanoideNoPuedeEntrarEnPantanoException extends RuntimeException {

    @Override
    public String getMessage(){
        return "Humanoide no puede entrar en pantano";
    }

}
