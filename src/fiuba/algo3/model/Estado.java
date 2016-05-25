package fiuba.algo3.model;

public interface Estado {

	public void mover();
	public void atacar(Algoformer algoformer);
	public void capturarChispa();
	public void combinarse(Algoformer otro1, Algoformer otro2);
}
