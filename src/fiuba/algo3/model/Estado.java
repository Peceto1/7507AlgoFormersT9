package fiuba.algo3.model;

public interface Estado {

	void mover();
	void atacar(Algoformer algoformer);
	void capturarChispa();
	void combinarse(Algoformer otro1, Algoformer otro2);
}
