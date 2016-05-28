package fiuba.algo3.model.unidades;

abstract class Estado {

	protected int ataque;
	protected int rango;
	protected int velocidad;


	void mover() {
		// Falta implementar.
	}


	void atacar(Algoformer atacado, Decepticon atacante) {
		atacado.recibirAtaque(atacante, ataque);
	}


	void atacar(Algoformer atacado, Autobot atacante) {
		atacado.recibirAtaque(atacante, ataque);
	}


	abstract void transformar(Algoformer algoformer);
	abstract void capturarChispa();
	abstract void combinarse(Algoformer otro1, Algoformer otro2);

}
