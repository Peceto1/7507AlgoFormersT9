package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;


public class Movimiento {

	Punto ubicacion;
	Arena arena;
	int restantes;


	Movimiento(Punto inicio, int cantMovimientos) {
		this.arena = Arena.getInstance();
		this.ubicacion = inicio;
		this.restantes = cantMovimientos;
	}


	Punto moverseHacia(Direccion direccion) {

		Punto nuevo = ubicacion.obtenerPuntoEn(direccion);

		if (!puede_moverse(nuevo))
			throw new MovimientoNoValidoException();

		Algoformer aUbicar = arena.removerAlgoformerEn(ubicacion);
		arena.ubicarAlgoformer(aUbicar, nuevo);
		ubicacion = nuevo;
		restantes--;

		return ubicacion;
	}


	void descender() {
		Punto nuevo = ubicacion.descender();

		if (!puede_moverse(nuevo))
			throw new MovimientoNoValidoException();

		Algoformer aUbicar = arena.removerAlgoformerEn(ubicacion);
		arena.ubicarAlgoformer(aUbicar, nuevo);
		ubicacion = nuevo;
		restantes = 0;
	}


	private Boolean puede_moverse(Punto punto){
		return (arena.estaEnArena(punto) && !arena.estaOcupado(punto) && restantes > 0);
	}

	public void ascender() {
		Punto nuevo = ubicacion.ascender();

		if (!puede_moverse(nuevo))
			throw new MovimientoNoValidoException();

		Algoformer aUbicar = arena.removerAlgoformerEn(ubicacion);
		arena.ubicarAlgoformer(aUbicar, nuevo);
		ubicacion = nuevo;
		restantes = 0;
	}
}
