package fiuba.algo3.model.jugador;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerechaAbajo;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.EstadoProtoNoPuedeRealizarAcciones;
import fiuba.algo3.model.unidades.NoHaySuficientesAlgoformersAdyacentesException;

public class JugadorTest {

	AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
	
	@Test
	public void jugadorCombinaExitosamenteASusalgoformers(){
		Juego nuevoJuego = new Juego();
		Punto puntoDeLaCombinacion = new PuntoTierra(1,26);
		nuevoJuego.crearJugador("Guille", "AUTOBOTS");
		nuevoJuego.comenzarPartida();
		Jugador jugador = nuevoJuego.getJugadorEnTurno();
	
		jugador.combinarAlgoformers();
		Assert.assertEquals("Superion",jugador.obtenerAlgoformerEn(puntoDeLaCombinacion).getNombre());
	}
	
	@Test (expected = NoHaySuficientesAlgoformersAdyacentesException.class)
	public void NoSePuedenCombinar(){
		Juego nuevoJuego = new Juego();
		nuevoJuego.crearJugador("Guille", "AUTOBOTS");
		nuevoJuego.comenzarPartida();
		Jugador jugador = nuevoJuego.getJugadorEnTurno();
		Punto puntoInicialDeBumblebee = new PuntoTierra(1,25);
		Direccion diagonal = new DireccionDerechaAbajo();
		
		Algoformer bumblebee = jugador.obtenerAlgoformerEn(puntoInicialDeBumblebee);
		bumblebee.moverseHacia(diagonal);
		bumblebee.moverseHacia(diagonal);
		jugador.combinarAlgoformers();
	}
	
	@Test
	public void listaDeAlgoformersDeJugadorTrasCombinarseContiene1Solo(){
		Juego nuevoJuego = new Juego();
		nuevoJuego.crearJugador("Guille", "DECEPTICONS");
		nuevoJuego.comenzarPartida();
		Jugador jugador = nuevoJuego.getJugadorEnTurno();
		
		Assert.assertEquals(3, jugador.cantidadAlgoformers());
		jugador.combinarAlgoformers();
		Assert.assertEquals(1, jugador.cantidadAlgoformers());
	}
	
	@Test (expected = EstadoProtoNoPuedeRealizarAcciones.class)
	public void jugadorNoPuedeSepararAlgoformersInmediatamenteTrasCombinarlos(){
		Juego nuevoJuego = new Juego();
		nuevoJuego.crearJugador("Guille", "DECEPTICONS");
		nuevoJuego.comenzarPartida();
		Jugador jugador = nuevoJuego.getJugadorEnTurno();
		
		jugador.combinarAlgoformers();
		jugador.separarAlgoformers();
	}
	
	@Test
	public void listaDeAlgoformersDeJugadorContiene3AlgoformersTrasSepararse(){
		Juego nuevoJuego = new Juego();
		nuevoJuego.crearJugador("Guille", "DECEPTICONS");
		nuevoJuego.comenzarPartida();
		Jugador jugador = nuevoJuego.getJugadorEnTurno();
		
		jugador.combinarAlgoformers();
		nuevoJuego.finalizarTurno();
		nuevoJuego.finalizarTurno();
		nuevoJuego.finalizarTurno();
		jugador.separarAlgoformers();
		Assert.assertEquals(3, jugador.cantidadAlgoformers());
	}
}
