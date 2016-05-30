package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Chispa;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;

abstract class Estado {

	protected int ataque;
	protected int rango;
	protected int velocidad;
	protected Movimiento movimiento;


	void atacar(Algoformer atacado, Decepticon atacante) {
		atacado.recibirAtaque(atacante, ataque);
	}


	void atacar(Algoformer atacado, Autobot atacante) {
		atacado.recibirAtaque(atacante, ataque);
	}


	Punto moverse(Direccion direccion) {
		return movimiento.moverseHacia(direccion);
	}


	void reiniciarMovimiento(Punto ubicacion) {
		movimiento = new Movimiento(ubicacion, velocidad);
	}


	abstract void transformar(Algoformer algoformer);
	abstract void capturarChispa(Chispa chispa, Algoformer captor);
	abstract void combinarse(Algoformer otro1, Algoformer otro2);

}
