package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierra;

public class SuperionTest {
	
	private Arena arena = Arena.getInstance();
	private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
	
	@Before
	public void before(){
		arena.inicializar();
		instanciadorDeAlgoformers.inicializar();
	}
	
	@Test
	public void VidaDelSuperionEsLaSumaDeLaVidaDeLosMiembros(){
		Punto puntoInicioCentro = new PuntoTierra(25,25);
		Punto puntoDerechoDeInicio = new PuntoTierra(26,25);
		Punto puntoIzquierdoDeInicio = new PuntoTierra(24,25);
		
		
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();

		arena.ubicarAlgoformer(optimusPrime, puntoInicioCentro);
		arena.ubicarAlgoformer(bumblebee, puntoDerechoDeInicio);
		arena.ubicarAlgoformer(ratchet, puntoIzquierdoDeInicio);
		
		optimusPrime.combinarse();
		Algoformer superion = arena.obtenerAlgoformerEn(puntoInicioCentro);
		int vidaEsperada = optimusPrime.getVida() + ratchet.getVida() + bumblebee.getVida();
		
		Assert.assertEquals(vidaEsperada,superion.getVida());

	}
	
	@Test
	public void LaCombinacionSeRealizaEnElLugarDelQueDioLaOrden(){
		Punto puntoInicioCentro = new PuntoTierra(1,1);
		Punto puntoDiagonalDeInicio = new PuntoTierra(2,2);
		Punto puntoArribaDeInicio = new PuntoTierra(1,2);
		
		
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();

		arena.ubicarAlgoformer(optimusPrime, puntoInicioCentro);
		arena.ubicarAlgoformer(bumblebee, puntoDiagonalDeInicio);
		arena.ubicarAlgoformer(ratchet, puntoArribaDeInicio);
		
		ratchet.reiniciarMovimiento();
		ratchet.transformarse();
		
		optimusPrime.combinarse();
		Algoformer superion = arena.obtenerAlgoformerEn(puntoInicioCentro);

		Assert.assertEquals(optimusPrime.getUbicacion(), superion.getUbicacion());
	}
}
