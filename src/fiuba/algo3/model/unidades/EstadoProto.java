package fiuba.algo3.model.unidades;

import fiuba.algo3.model.espacio.Punto;

class EstadoProto extends Estado {

	private int turnosRestantesParaCambio;
	private Algoformer aConstruir;

	
	EstadoProto(){
		ataque = 0;
		rango = 0;
		velocidad = 0;
		turnosRestantesParaCambio = 2;
	}


	void setaConstruir(Algoformer algoformer) {
		this.aConstruir = algoformer;
	}


	@Override
	void reiniciarMovimiento(Punto ubicacion) {
		movimiento = new Movimiento(ubicacion, velocidad);
		// actualizarEstado();
	}


	/*private void actualizarEstado(Algoformer) {
		if (turnosRestantesParaCambio == 0)
			completarTransformacion();

		turnosRestantesParaCambio--;
	}*/		// ---> Necesitaria conocer al Algoformer... como hacemos?


	@Override
	void transformar(Algoformer algoformer) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}


	@Override
	void capturarChispa(Algoformer captor) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}


	@Override
	void combinarse(Autobot dioLaOrden, Autobot autobot2, Autobot autobot3) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}


	@Override
	void combinarse(Decepticon dioLaOrden, Decepticon autobot2, Decepticon autobot3) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}

}
