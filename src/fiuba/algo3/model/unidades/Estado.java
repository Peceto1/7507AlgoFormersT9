package fiuba.algo3.model.unidades;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;

import java.util.List;

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

    
    Boolean puedeAtacar(Algoformer atacado, Punto origenDeAtaque){
    	Punto ubicacionDeAtacado = atacado.getUbicacion();
    	int distanciaEntreAlgoformers = origenDeAtaque.distanciaAl(ubicacionDeAtacado);
    	return distanciaEntreAlgoformers <= rango;
    }

	abstract void transformar(Algoformer algoformer);
	abstract void capturarChispa(Algoformer captor);
	abstract void combinarse(Autobot dioLaOrden, Autobot autobot2, Autobot autobot3);
	abstract void combinarse(Decepticon dioLaOrden, Decepticon autobot2, Decepticon autobot3);

}
