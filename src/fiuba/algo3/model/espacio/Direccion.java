package fiuba.algo3.model.espacio;

public abstract class Direccion {

    int x;
    int y;


    public Direccion(int x, int y) {

        if (Math.abs(x) > 1 || Math.abs(y) > 1 || Math.abs(x) + Math.abs(y) < 1)
            throw new DireccionInvalidaException();

        this.x = x;
        this.y = y;
    }


    static Direccion[] crearDireccionesEnTodoSentido() {
        Direccion direcciones[] = { new DireccionArriba(), new DireccionAbajo(),
                                    new DireccionIzquierda(), new DireccionDerecha(),
                                    new DireccionDerechaAbajo(), new DireccionIzquierdaAbajo(),
                                    new DireccionDerechaArriba(), new DireccionIzquierdaArriba()
                                    };
        return direcciones;
    }

}
