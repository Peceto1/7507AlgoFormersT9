package fiuba.algo3.model.unidades;

public class BoneCrusherAlterno implements Estado {

    private int ataque;
    private int rango;
    private int velocidad;

    public BoneCrusherAlterno() {
        this.ataque = 30;
        this.rango = 3;
        this.velocidad = 8;
    }


    @Override
    public void mover() {

    }

    @Override
    public void atacar(Algoformer otro) {
        System.out.println("Llegué a atacar de ESTADO");
    }

    public void transformar(Algoformer algoformer) {

    }

    public void capturarChispa() {

    }

    public void combinarse(Algoformer otro1, Algoformer otro2) {

    }

}
