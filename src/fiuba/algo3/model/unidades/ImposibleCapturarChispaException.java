package fiuba.algo3.model.unidades;

public class ImposibleCapturarChispaException extends RuntimeException{

    @Override
    public String getMessage(){
        return "Imposible capturar chispa";
    }

}
