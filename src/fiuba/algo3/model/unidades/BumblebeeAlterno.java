package fiuba.algo3.model.unidades;

public class BumblebeeAlterno implements Estado {


    private int ataque;
    private int rango;
    private int velocidad;


    public BumblebeeAlterno() {
        this.ataque = 20;
        this.rango = 3;
        this.velocidad = 5;
    }


    @Override
    public void mover() {

    }


    @Override
    public void atacar(Algoformer otro, Autobot atacante) {
        otro.recibirAtaque(atacante,ataque);
    }


    @Override
    public void atacar(Algoformer otro, Decepticon atacante) {
        otro.recibirAtaque(atacante,ataque);
    }


    @Override
    public void transformar(Algoformer algoformer) {

    }


    @Override
    public void capturarChispa() {

    }


    @Override
    public void combinarse(Algoformer otro1, Algoformer otro2) {

    }

}
