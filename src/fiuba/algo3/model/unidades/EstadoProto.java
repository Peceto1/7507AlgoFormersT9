package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.EfectoTormentaPsionica;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;

class EstadoProto extends Estado {

	private int turnosRestantesParaCambio;

	
	public EstadoProto(){
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
	void actualizarEstado(Autobot autobot) {
		if (turnosRestantesParaCambio == 0)
			completarTransformacion(autobot);

		turnosRestantesParaCambio--;
	}


	@Override
	void actualizarEstado(Decepticon decepticon) {
		if (turnosRestantesParaCambio == 0)
			completarTransformacion(decepticon);

		turnosRestantesParaCambio--;
	}


	private void completarTransformacion(Autobot algoformer) {
		algoformer.setEstado(EstadoSuperion.getInstance());
		algoformer.reiniciarMovimiento();
	}


	private void completarTransformacion(Decepticon algoformer) {
		algoformer.setEstado(EstadoMenasor.getInstance());
		algoformer.reiniciarMovimiento();
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
	void perderUnMovimiento() {
	}


	@Override
	Punto moverse(Direccion direccion) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}


	@Override
	Boolean puedeAtacar(Algoformer atacado, Punto origenDeAtaque) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}


	@Override
	Superion combinarse(Autobot dioLaOrden, Autobot autobot2, Autobot autobot3) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}


	@Override
	Menasor combinarse(Decepticon dioLaOrden, Decepticon autobot2, Decepticon autobot3) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}


	@Override
	void pasarAHumanoide(Algoformer algoformer) {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}


	@Override
	void verificarProto() {
		throw new EstadoProtoNoPuedeRealizarAcciones();
	}

	
	@Override
	public void aplicarEfecto(EfectoTormentaPsionica efecto){}

}
