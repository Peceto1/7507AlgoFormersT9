package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;


public class Movimiento {

	Punto ubicacion;
	Arena arena;
	int restantes;


	Movimiento(Punto inicio, int cantMovimientos) {
		arena = Arena.getInstance();
		ubicacion = inicio;
	}


	void moverseHacia(Direccion direccion) {

		Punto nuevo = ubicacion.obtenerPuntoEn(direccion);

		if (!puede_moverse(nuevo))
			//TERMINAR TURNO

		ubicacion = nuevo;
		restantes--;
	}


	private Boolean puede_moverse(Punto punto){
		return ((!arena.estaEnArena(punto) || arena.estaOcupado(punto)) && restantes != 0);
	}
		
}
