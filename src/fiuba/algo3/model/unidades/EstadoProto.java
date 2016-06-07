package fiuba.algo3.model.unidades;

import fiuba.algo3.model.espacio.Punto;

class EstadoProto extends Estado {

	private int turnosRestantesParaCambio;

	
	EstadoProto(){
		ataque = 0;
		rango = 0;
		velocidad = 0;
		turnosRestantesParaCambio = 2;
	}


	@Override
	void reiniciarMovimiento(Punto ubicacion) {
		movimiento = new Movimiento(ubicacion, velocidad);
	}


	@Override
	void actualizarEstado(Algoformer algoformer) {
		if (turnosRestantesParaCambio == 0)
			completarTransformacion(algoformer);

		turnosRestantesParaCambio--;
	}


	private void completarTransformacion(Algoformer algoformer) {
		algoformer.setEstado(EstadoSuperion.getInstance());
	}


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
