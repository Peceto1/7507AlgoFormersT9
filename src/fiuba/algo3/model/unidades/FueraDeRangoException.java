package fiuba.algo3.model.unidades;

public class FueraDeRangoException extends RuntimeException {

    @Override
    public String getMessage(){
        return "Algoformer fuera de rango";
    }

}
