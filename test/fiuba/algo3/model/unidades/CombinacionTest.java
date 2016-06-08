package fiuba.algo3.model.unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierra;

public class CombinacionTest {
	
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
		
		Assert.assertEquals(vidaEsperada, superion.getVida());

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
	
	@Test
	public void LaUbicacionDeLosAlgoformersCombinadosQuedaVacia(){
		Punto puntoInicioCentro = new PuntoTierra(9,9);
		Punto puntoDiagonalDeInicio = new PuntoTierra(10,10);
		Punto puntoAbajoDeInicio = new PuntoTierra(9,8);
		
		
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();

		arena.ubicarAlgoformer(optimusPrime, puntoDiagonalDeInicio);
		arena.ubicarAlgoformer(bumblebee, puntoInicioCentro);
		arena.ubicarAlgoformer(ratchet, puntoAbajoDeInicio);
		
		bumblebee.combinarse();
		
		Assert.assertFalse(arena.estaOcupado(puntoAbajoDeInicio));
		Assert.assertFalse(arena.estaOcupado(puntoDiagonalDeInicio));
	}
	
	@Test (expected = NoHaySuficientesAlgoformersAdyacentesException.class)
	public void NoSePuedenCombinarSiAlgoformersNoEstanCerca(){
		Punto puntoInicio = new PuntoTierra(43,30);
		Punto puntoAlejado1 = new PuntoTierra(15,4);
		Punto puntoAlejado2 = new PuntoTierra(8,50);
		
		
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();

		arena.ubicarAlgoformer(optimusPrime, puntoAlejado1);
		arena.ubicarAlgoformer(bumblebee, puntoAlejado2);
		arena.ubicarAlgoformer(ratchet, puntoInicio);
		
		ratchet.combinarse();
	}
	
	@Test (expected = EstadoProtoNoPuedeRealizarAcciones.class)
	public void SuperionNoPuedeMoverseInmediatamenteAlTransformarse(){
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
		superion.reiniciarMovimiento();
		superion.moverseHacia(new DireccionDerecha());
	}
	
	@Test (expected = EstadoProtoNoPuedeRealizarAcciones.class)
	public void SuperionNoPuedeTransformarseMientrasLaCombinacionEstaEnProceso(){
		Punto puntoInicioCentro = new PuntoTierra(1,27);
		Punto puntoAbajoDeInicio = new PuntoTierra(1,26);
		Punto puntoDiagonalDeInicio = new PuntoTierra(2,28);
		
		
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();

		arena.ubicarAlgoformer(bumblebee, puntoInicioCentro);
		arena.ubicarAlgoformer(optimusPrime, puntoDiagonalDeInicio);
		arena.ubicarAlgoformer(ratchet, puntoAbajoDeInicio);
		
		bumblebee.combinarse();
		Algoformer superion = arena.obtenerAlgoformerEn(puntoInicioCentro);	
		superion.transformarse();
	}
	
	@Test (expected = CombinacionNoTieneAlternoException.class)
	public void SuperionNoPuedeTransformarseLuegoDeLaCombinacionFinalizada(){
		Punto puntoInicioCentro = new PuntoTierra(1,27);
		Punto puntoAbajoDeInicio = new PuntoTierra(1,26);
		Punto puntoDiagonalDeInicio = new PuntoTierra(2,28);
		
		
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();

		arena.ubicarAlgoformer(bumblebee, puntoInicioCentro);
		arena.ubicarAlgoformer(optimusPrime, puntoDiagonalDeInicio);
		arena.ubicarAlgoformer(ratchet, puntoAbajoDeInicio);
		
		bumblebee.combinarse();
		Algoformer superion = arena.obtenerAlgoformerEn(puntoInicioCentro);	
		superion.reiniciarMovimiento();
		superion.reiniciarMovimiento();
		superion.reiniciarMovimiento();   //Esto equivaldria al comienzo del turno 3, pasados los 2 turnos que tarda la transformacion.
		
		superion.transformarse();
	}
	
	@Test (expected = EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException.class)
	public void AlgoformerQueDaLaOrdenNoPuedeSerAlterno(){
		Punto puntoInicioCentro = new PuntoTierra(8,8);
		Punto puntoDerechoDeInicio = new PuntoTierra(8,9);
		Punto puntoDiagonalDeInicio = new PuntoTierra(7,7);
		
		
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();

		arena.ubicarAlgoformer(bumblebee, puntoInicioCentro);
		arena.ubicarAlgoformer(optimusPrime, puntoDiagonalDeInicio);
		arena.ubicarAlgoformer(ratchet, puntoDerechoDeInicio);
		
		bumblebee.reiniciarMovimiento();
		bumblebee.transformarse();
		
		bumblebee.combinarse();
	}

	@Test (expected = EstadoProtoNoPuedeRealizarAcciones.class)
	public void MenasorNoPuedeAtacarMientrasEstaTransformandose() {
		Punto puntoDeMenasor = new PuntoTierra(10, 10);
		Punto puntoALaDerecha = new PuntoTierra(11, 10);
		Punto puntoALaIzquierda = new PuntoTierra(9, 10);
		Punto ubicacionOptimus = new PuntoTierra(11, 11);

		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();


		arena.ubicarAlgoformer(megatron, puntoDeMenasor);
		arena.ubicarAlgoformer(frenzy, puntoALaDerecha);
		arena.ubicarAlgoformer(bonecrusher, puntoALaIzquierda);
		arena.ubicarAlgoformer(optimus, ubicacionOptimus);

		megatron.combinarse();

		Algoformer menasor = arena.obtenerAlgoformerEn(puntoDeMenasor);
		menasor.atacar(optimus);
	}

	@Test
	public void MenasorPuedeAtacarLuegoDe2Turnos() {
		Punto puntoDeMenasor = new PuntoTierra(10, 10);
		Punto puntoALaDerecha = new PuntoTierra(11, 10);
		Punto puntoALaIzquierda = new PuntoTierra(9, 10);
		Punto ubicacionOptimus = new PuntoTierra(11, 11);

		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();


		arena.ubicarAlgoformer(megatron, puntoDeMenasor);
		arena.ubicarAlgoformer(frenzy, puntoALaDerecha);
		arena.ubicarAlgoformer(bonecrusher, puntoALaIzquierda);
		arena.ubicarAlgoformer(optimus, ubicacionOptimus);

		megatron.combinarse();

		Algoformer menasor = arena.obtenerAlgoformerEn(puntoDeMenasor);
		menasor.reiniciarMovimiento();
		menasor.reiniciarMovimiento();
		menasor.reiniciarMovimiento();
		menasor.atacar(optimus);

		Assert.assertEquals(500 - 115, optimus.getVida());
	}

	@Test
	public void MenasorPuedeMoverseLuegoDe2Turnos(){
		Punto puntoInicioCentro = new PuntoTierra(25,25);
		Punto puntoDerechoDeInicio = new PuntoTierra(26,25);
		Punto puntoIzquierdoDeInicio = new PuntoTierra(24,25);
		
		
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();

		arena.ubicarAlgoformer(megatron, puntoInicioCentro);
		arena.ubicarAlgoformer(bonecrusher, puntoDerechoDeInicio);
		arena.ubicarAlgoformer(frenzy, puntoIzquierdoDeInicio);

		
		megatron.combinarse();
		Algoformer menasor = arena.obtenerAlgoformerEn(puntoInicioCentro);	
		menasor.reiniciarMovimiento();
		menasor.reiniciarMovimiento();
		menasor.reiniciarMovimiento();
		
		menasor.moverseHacia(new DireccionDerecha());
		Assert.assertEquals(puntoDerechoDeInicio, menasor.getUbicacion());
	}

}
