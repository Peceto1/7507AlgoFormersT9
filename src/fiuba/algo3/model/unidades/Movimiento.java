package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;


public class Movimiento {

	Punto ubicacion;
	Arena arena_de_juego;
	int movimientos_restantes;
	
	Movimiento(Punto punto_inicial, int movimientos_posibles){
		arena_de_juego = Arena.getInstance();	
		ubicacion = punto_inicial;
	}
	
	void moverse_hacia(Direccion direccion){
		Punto nuevo_punto = ubicacion.obtenerPuntoEn(direccion);
		if (!puede_moverse(nuevo_punto)){
			//TERMINAR TURNO
		}
		ubicacion = nuevo_punto;	
		movimientos_restantes --;
	}
	
	private Boolean puede_moverse(Punto punto){
		return ((!arena_de_juego.estaEnArena(punto) || arena_de_juego.estaOcupado(punto)) && movimientos_restantes != 0);
	}
		
}
