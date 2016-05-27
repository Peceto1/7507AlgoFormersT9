package fiuba.algo3.model.unidades;

public class OptimusPrimeAlterno implements Estado {

    private int ataque;
    private int rango;
    private int velocidad;


    public OptimusPrimeAlterno() {
        this.ataque = 15;
        this.rango = 4;
        this.velocidad = 5;
    }


    @Override
    public void mover() {

    }


    @Override
    public void atacar(Algoformer otro, Autobot atacante) {
        otro.recibirAtaque(atacante);
    }


    @Override
    public void atacar(Algoformer otro, Decepticon atacante) {
        otro.recibirAtaque(atacante);
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
