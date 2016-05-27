package fiuba.algo3.model.unidades;

import fiuba.algo3.model.unidades.Algoformer;

public interface Estado {

	void mover();
	void atacar(Algoformer algoformer);
	void capturarChispa();
	void combinarse(Algoformer otro1, Algoformer otro2);
}
