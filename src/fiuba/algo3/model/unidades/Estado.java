package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Chispa;
import fiuba.algo3.model.espacio.Direccion;

abstract class Estado {

	protected int ataque;
	protected int rango;
	protected int velocidad;


	void atacar(Algoformer atacado, Decepticon atacante) {
		atacado.recibirAtaque(atacante, ataque);
	}


	void atacar(Algoformer atacado, Autobot atacante) {
		atacado.recibirAtaque(atacante, ataque);
	}


	void moverse(Algoformer algoformer, Direccion direccion) {

	}


	abstract void transformar(Algoformer algoformer);
	abstract void capturarChispa(Chispa chispa, Algoformer captor);
	abstract void combinarse(Algoformer otro1, Algoformer otro2);

}
