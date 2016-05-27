package fiuba.algo3.model.unidades;

interface Estado {

	void mover();
	void atacar(Algoformer otro);
	void transformar(Algoformer algoformer);
	void capturarChispa();
	void combinarse(Algoformer otro1, Algoformer otro2);

}
