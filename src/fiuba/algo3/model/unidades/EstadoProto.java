package fiuba.algo3.model.unidades;

import fiuba.algo3.model.espacio.Punto;

class EstadoProto extends Estado {

	private int turnosRestantesParaCambio = 2;
	private static EstadoProto instancia = new EstadoProto();

	
	private EstadoProto(){
		ataque = 0;
		rango = 0;
		velocidad = 0;
	}
	
	static EstadoProto getInstance(){
		return instancia;
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
	void combinarse(Algoformer otro1, Algoformer otro2) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}
}
