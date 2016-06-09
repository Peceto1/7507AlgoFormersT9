package fiuba.algo3.model.arena;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.DireccionIzquierda;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;

public class TerrenoTest {
	
	private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arenaDeJuego = Arena.getInstance();
	
	@Before
	public void before(){
		instanciadorDeAlgoformers.inicializar();
		arenaDeJuego.inicializar();
	}
	
	@Test
	public void AutoformerQueSeUbicaEnSuperficieRocosaNoRecibeDanio(){
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Punto ubicacionConTerrenoRocoso = new PuntoTierra(26,1);
		arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionConTerrenoRocoso);
		Assert.assertEquals(bonecrusher.getVida(),bonecrusher.getVidaMax());  
	}
	
	@Test
	public void AutoformerQueSeUbicaEnSuperficieDeNubeNoRecibeDanio(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Punto ubicacionEnTierraAbajoDeNubes = new PuntoTierra(3,5);
		arenaDeJuego.ubicarAlgoformer(megatron,ubicacionEnTierraAbajoDeNubes);
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		Assert.assertEquals(megatron.getVida(), megatron.getVidaMax());		
	}
	
	@Test
	public void AutoformerQueSeUbicaEnEspinasPierdeUnCincoPorCientoDeSuVidaMaxima(){
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		int VidaMaxOptimus = optimus.getVidaMax();
		Punto ubicacionConEspinas = new PuntoTierra(1,2);
		arenaDeJuego.setTerrenoEnPunto(ubicacionConEspinas, new Espinas());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionConEspinas);
		Assert.assertEquals(optimus.getVida(), (VidaMaxOptimus-(VidaMaxOptimus/20)));
	}
	
	@Test
	public void AutoformerQueSeMueveNuevamentePorTerrenoConEspinasVuelveAPerderUnCincoPorCientoDeVidaMaximaYNoDeActual(){
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		int VidaMaxBumblebee = bumblebee.getVidaMax();
		Punto ubicacionConEspinas = new PuntoTierra(3,13);
		Direccion direccionIzquierda = new DireccionIzquierda();
		Direccion direccionDerecha = new DireccionDerecha();
		arenaDeJuego.setTerrenoEnPunto(ubicacionConEspinas, new Espinas());
		arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionConEspinas);
		bumblebee.reiniciarMovimiento();
		bumblebee.moverseHacia(direccionDerecha);
		bumblebee.moverseHacia(direccionIzquierda);
		Assert.assertEquals(bumblebee.getVida(), VidaMaxBumblebee-VidaMaxBumblebee/20-VidaMaxBumblebee/20);		
	}
	
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerNoEntraEnTerrenoPantanosoEnModoHumanoide(){
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Punto ubicacionPantanosa = new PuntoTierra(2,3);
		Punto ubicacionInicialDeBumblebee = new PuntoTierra(3,3);
		Direccion direccionIzquierda = new DireccionIzquierda();
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionPantanosa, new Pantano());
		arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionInicialDeBumblebee);
		bumblebee.reiniciarMovimiento();
		bumblebee.moverseHacia(direccionIzquierda);		
	}
	
	@Test
	public void AlgoformerHumanoideNoSeMueveSiIntentaEntrarAPantano(){
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Punto ubicacionPantanosa = new PuntoTierra(2,3);
		Punto ubicacionInicialDeBumblebee = new PuntoTierra(3,3);
		Direccion direccionIzquierda = new DireccionIzquierda();
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionPantanosa, new Pantano());
		arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionInicialDeBumblebee);
		bumblebee.reiniciarMovimiento();
		try{
			bumblebee.moverseHacia(direccionIzquierda);		
		} catch(MovimientoNoValidoException e){
			Assert.assertTrue(arenaDeJuego.estaOcupado(ubicacionInicialDeBumblebee));
		}
	}
	
	
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerEnEstadoAlternoPierdeUnMovimientoExtraCuandoEntraAlPantano(){
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionPantanosa = new PuntoTierra(3,3);
		Punto ubicacionInicialDeOptimus = new PuntoTierra(2,3);
		Direccion direccionDerecha = new DireccionDerecha();
		arenaDeJuego.setTerrenoEnPunto(ubicacionPantanosa, new Pantano());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialDeOptimus);
		optimus.reiniciarMovimiento();
		optimus.transformarse();
		int velocidadOptimus = 5;
		optimus.reiniciarMovimiento();
		for (int i=0; i<velocidadOptimus; i++){
			optimus.moverseHacia(direccionDerecha);
		}
	}
		
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerEnEstadoAlternoQueTerminaSuTurnoEnPantanoPierdeUnMovimientoEnSuProximioTurno(){
		Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
		Punto ubicacionPantanosa = new PuntoTierra(15,5);
		Punto ubicacionInicialFrenzy = new PuntoTierra(9,5);
		Direccion direccionerecha = new DireccionDerecha();
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionPantanosa, new Pantano());
		arenaDeJuego.ubicarAlgoformer(frenzy, ubicacionInicialFrenzy);
		frenzy.reiniciarMovimiento();
		frenzy.transformarse();
		frenzy.reiniciarMovimiento();
		
		int velocidadFrenzyAlterno = 6;
		for (int i=0; i<velocidadFrenzyAlterno;i++){
			frenzy.moverseHacia(direccionerecha);
		}
		
		frenzy.reiniciarMovimiento();
		for (int i=0; i<velocidadFrenzyAlterno;i++){
			frenzy.moverseHacia(direccionerecha);
		}
	}
	
	@Test //Demostracion de que le faltan movimientos en el segundo for en el Test Anterior
	public void AlgoformerEnEstadoAlternoPuedeTerminarSuTurnoEnPantanoUsandoTodosSusMovimientos(){
		Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
		Punto ubicacionPantanosa = new PuntoTierra(15,5);
		Punto ubicacionInicialFrenzy = new PuntoTierra(9,5);
		Direccion direccionerecha = new DireccionDerecha();
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionPantanosa, new Pantano());
		arenaDeJuego.ubicarAlgoformer(frenzy, ubicacionInicialFrenzy);
		frenzy.reiniciarMovimiento();
		frenzy.transformarse();
		frenzy.reiniciarMovimiento();
		
		int velocidadFrenzyAlterno = 6;
		for (int i=0; i<velocidadFrenzyAlterno;i++){
			frenzy.moverseHacia(direccionerecha);
		}
	}
	
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerQuePasaPorLaNebulosaDeAndromenaPierdeElPrimerTurno(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Punto ubicacionNebulosa = new PuntoAire(4,5);
		Punto ubicacionInicialMegatron = new PuntoTierra(5,5);
		Direccion direccionIzquierda = new DireccionIzquierda();
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionNebulosa,new NebulosaDeAndromeda());
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionInicialMegatron);
		
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		megatron.reiniciarMovimiento();
		
		megatron.moverseHacia(direccionIzquierda); //Paso por la nebulosa
		
		megatron.moverseHacia(direccionIzquierda);
	}
	
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerQuePasaPorLaNebulosaDeAndromenaPierdeElSegundoTurno(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Punto ubicacionNebulosa = new PuntoAire(4,5);
		Punto ubicacionInicialMegatron = new PuntoTierra(5,5);
		Direccion direccionIzquierda = new DireccionIzquierda();
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionNebulosa,new NebulosaDeAndromeda());
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionInicialMegatron);
		
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		megatron.reiniciarMovimiento();
		
		megatron.moverseHacia(direccionIzquierda); //Paso por la nebulosa
		
		megatron.reiniciarMovimiento();//Estos dos comandos simbolizan el inicio de un nuevo turno
		megatron.aplicarEfectos();
		
		megatron.moverseHacia(direccionIzquierda);
	}
	
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerQuePasaPorLaNebulosaDeAndromenaPierdeElTercerTurno(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Punto ubicacionNebulosa = new PuntoAire(4,5);
		Punto ubicacionInicialMegatron = new PuntoTierra(5,5);
		Direccion direccionIzquierda = new DireccionIzquierda();
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionNebulosa,new NebulosaDeAndromeda());
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionInicialMegatron);
		
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		megatron.reiniciarMovimiento();
		
		megatron.moverseHacia(direccionIzquierda); //Paso por la nebulosa
		
		megatron.reiniciarMovimiento();//Estos dos comandos simbolizan el inicio de un nuevo turno
		megatron.aplicarEfectos();
		
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();
		
		megatron.moverseHacia(direccionIzquierda);
	}
	
	@Test
	public void AlgoformerQuePasaPorLaNebulosaDeAndromenaNoPierdeElCuartoTurno(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Punto ubicacionNebulosa = new PuntoAire(4,5);
		Punto ubicacionInicialMegatron = new PuntoTierra(5,5);
		Direccion direccionIzquierda = new DireccionIzquierda();
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionNebulosa,new NebulosaDeAndromeda());
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionInicialMegatron);
		
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		megatron.reiniciarMovimiento();
		
		megatron.moverseHacia(direccionIzquierda); //Paso por la nebulosa
		
		megatron.reiniciarMovimiento();//Estos dos comandos simbolizan el inicio de un nuevo turno
		megatron.aplicarEfectos();
		
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();
		
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();
		
		megatron.moverseHacia(direccionIzquierda);
	}
	
	@Test
	public void AlgoformerQuePasaPorTormentaPsionicaTieneSuAtaqueReducido(){
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Punto ubicacionTormenta = new PuntoAire(2,2);
		Punto ubicacionBonecrusher = new PuntoTierra(3,2);
		
		int danioInicialRatchetAlterno = 35;
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionTormenta, new TormentaPsionica());
		arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBonecrusher);
		arenaDeJuego.ubicarAlgoformer(ratchet, new PuntoTierra(2,2));
		ratchet.reiniciarMovimiento();
		ratchet.transformarse();
		
		ratchet.reiniciarMovimiento();
		ratchet.aplicarEfectos();
		
		ratchet.atacar(bonecrusher);
		Assert.assertEquals(bonecrusher.getVida(), (bonecrusher.getVidaMax()-((danioInicialRatchetAlterno - (danioInicialRatchetAlterno *4)/10))) );
	}
	
	@Test
	public void algoformerQuePasaPorTormentaPsionicaQuedaConElAtaqueReducidoPorElRestoDeLaPartida(){
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Punto ubicacionTormenta = new PuntoAire(2,2);
		Punto ubicacionBonecrusher = new PuntoTierra(3,2);
		
		int danioInicialRatchetAlterno = 35;
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionTormenta, new TormentaPsionica());
		arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionBonecrusher);
		arenaDeJuego.ubicarAlgoformer(ratchet, new PuntoTierra(2,2));
		ratchet.reiniciarMovimiento();
		ratchet.transformarse();
		
		for(int i=0; i<50; i++){ //50: cantidad de turnos que voy a pasar
			ratchet.reiniciarMovimiento();
			ratchet.aplicarEfectos();
		}
		
		ratchet.atacar(bonecrusher);
		Assert.assertEquals(bonecrusher.getVida(), (bonecrusher.getVidaMax()-((danioInicialRatchetAlterno - (danioInicialRatchetAlterno *4)/10))) );		
	}
	
	@Test
	public void AlgoformerQueVuelveAPasarPorTormentaPsionicaNoVuelveASufrirSusEfectos(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionTormenta1 = new PuntoAire(2,2);
		Punto ubicacionTormenta2 = new PuntoAire (1,2);
		Direccion direccionIzquierda = new DireccionIzquierda();
		Punto ubicacionOptimus = new PuntoTierra(3,2);
		
		int danioInicialMegatronAlterno = 55;
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionTormenta1, new TormentaPsionica());
		arenaDeJuego.setTerrenoEnPunto(ubicacionTormenta2, new TormentaPsionica());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionOptimus);
		arenaDeJuego.ubicarAlgoformer(megatron, new PuntoTierra(2,2));
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();
		
		megatron.moverseHacia(direccionIzquierda);
		
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();

		
		megatron.atacar(optimus);
		Assert.assertEquals(optimus.getVida(), (optimus.getVidaMax()-((danioInicialMegatronAlterno - (danioInicialMegatronAlterno *4)/10))) );	
	}
	
	@Test
	public void TormentaPsionicaSoloAfectaElAtaqueDeAlgoformerEnEstadoAlterno(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionTormenta1 = new PuntoAire(2,2);
		Punto ubicacionOptimus = new PuntoTierra(3,2);
		
		int danioInicialMegatronHumanoide = 10;
		
		arenaDeJuego.setTerrenoEnPunto(ubicacionTormenta1, new TormentaPsionica());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionOptimus);
		arenaDeJuego.ubicarAlgoformer(megatron, new PuntoTierra(2,2));
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();
		
		megatron.transformarse();
		
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();
		
		

		
		megatron.atacar(optimus);
		Assert.assertEquals(optimus.getVida(), (optimus.getVidaMax()- danioInicialMegatronHumanoide) );
	}
	
	@Test
	public void UnidadAereaNoEsAfectadaPorEspinas(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Punto puntoInicialDeMegatron = new PuntoTierra(20,20);
		Punto zonaEspinosa = new PuntoTierra(21,20);
		Direccion derecha = new DireccionDerecha();
		
		arenaDeJuego.setTerrenoEnPunto(zonaEspinosa, new Espinas());
		arenaDeJuego.ubicarAlgoformer(megatron, puntoInicialDeMegatron);
		
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		megatron.reiniciarMovimiento();
		megatron.moverseHacia(derecha);
		megatron.moverseHacia(derecha);
		
		Assert.assertEquals(550, megatron.getVida());	
	}
	
	@Test
	public void UnidadAereaNoEsAfectadaPorPantano(){
		Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
		Punto puntoInicialDeMegatron = new PuntoTierra(17,2);
		Punto zonaEspinosa = new PuntoTierra(18,2);
		Direccion derecha = new DireccionDerecha();
		
		arenaDeJuego.setTerrenoEnPunto(zonaEspinosa, new Pantano());
		arenaDeJuego.ubicarAlgoformer(frenzy, puntoInicialDeMegatron);
		
		frenzy.reiniciarMovimiento();
		frenzy.transformarse();
		frenzy.reiniciarMovimiento();
		frenzy.moverseHacia(derecha);
		frenzy.moverseHacia(derecha);
		
		Assert.assertEquals(400, frenzy.getVida());	
	}
	
}