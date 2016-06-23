package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.EfectoDobleCanon;
import fiuba.algo3.model.arena.EfectoFlash;
import fiuba.algo3.model.arena.EfectoTormentaPsionica;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;

abstract class Estado {

	protected int ataque;
	protected int ataqueMax;
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
		
		if (movimiento != null){
			movimiento = new Movimiento(ubicacion,Math.min(velocidad, (velocidad+movimiento.getMovimientosRestantes())));
			return;
		}
		movimiento = new Movimiento(ubicacion,velocidad);
	}

    
    Boolean puedeAtacar(Algoformer atacado, Punto origenDeAtaque){
    	Punto ubicacionDeAtacado = atacado.getUbicacion();
    	int distanciaEntreAlgoformers = origenDeAtaque.distanciaAl(ubicacionDeAtacado);
    	return distanciaEntreAlgoformers <= rango;
    }


	void perderTurno() {
		movimiento.perderTurno();
	}


	void resetearEstado() {
		this.ataque = this.ataqueMax;
	}


	void verificarProto() {

	}
	
	void aplicarEfecto(EfectoDobleCanon efecto){
		this.ataque = (this.ataque*2);
	}
	
	public void aplicarEfecto(EfectoFlash efecto) {
		this.movimiento.agregarMovimientos((this.velocidad*2));
	}


	abstract void transformar(Algoformer algoformer);
	abstract void capturarChispa(Algoformer captor);
	abstract Superion combinarse(Autobot dioLaOrden, Autobot autobot2, Autobot autobot3);
	abstract Menasor combinarse(Decepticon dioLaOrden, Decepticon decepticon2, Decepticon decepticon3);
	abstract void actualizarEstado(Autobot algoformer);
	abstract void actualizarEstado(Decepticon algoformer);
	abstract void perderUnMovimiento();
	abstract void aplicarEfecto(EfectoTormentaPsionica efecto);
	abstract  void pasarAHumanoide(Algoformer algoformer);
}
