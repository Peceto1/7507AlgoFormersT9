package fiuba.algo3.model.unidades;

abstract class EstadoAlterno implements Estado {

	protected int ataque;
    protected int rango;
    protected int velocidad;
	
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
