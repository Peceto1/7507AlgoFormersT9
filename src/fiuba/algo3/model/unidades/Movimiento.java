package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;


class Movimiento {

	private Punto ubicacion;
	private Arena arena;
	private int restantes;


	Movimiento(Punto inicio, int cantMovimientos) {
		this.arena = Arena.getInstance();
		this.ubicacion = inicio;
		this.restantes = cantMovimientos;
	}
	
	int getMovimientosRestantes(){
		return restantes;
	}


	Punto moverseHacia(Direccion direccion) {
		
		Punto nuevo = ubicacion.obtenerPuntoEn(direccion);

		if (!puede_moverse(nuevo))
			throw new MovimientoNoValidoException();
		
		try{
		actualizarUbicacion(nuevo);
		restarMovimiento();
		}
		catch(EstadoHumanoideNoPuedeEntrarEnPantanoException e){
			throw new MovimientoNoValidoException();
		}
		return ubicacion;
	}


	void descender() {
		Punto nuevo = ubicacion.descender();

		if (!puede_moverse(nuevo))
			throw new MovimientoNoValidoException();

		actualizarUbicacion(nuevo);
	}


	void ascender() {
		Punto nuevo = ubicacion.ascender();

		if (!puede_moverse(nuevo))
			throw new MovimientoNoValidoException();

		actualizarUbicacion(nuevo);
	}


	private void actualizarUbicacion(Punto nuevo) {
		Algoformer aUbicar = arena.removerAlgoformerEn(ubicacion);
		arena.ubicarAlgoformer(aUbicar, nuevo);
		ubicacion = nuevo;
	}


	private Boolean puede_moverse(Punto punto){
		return (arena.estaEnArena(punto) && !arena.estaOcupado(punto) && restantes > 0);
	}

	public void restarMovimiento() {
		restantes--;	
	}

	public void perderTurno() {
		restantes = 0;
	}
}
