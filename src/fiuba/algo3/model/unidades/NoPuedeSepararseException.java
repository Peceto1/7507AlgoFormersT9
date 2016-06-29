package fiuba.algo3.model.unidades;

public class NoPuedeSepararseException extends RuntimeException {

    @Override
    public String getMessage(){
        return "Algoformer no se pueden separar";
    }

}
