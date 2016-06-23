package fiuba.algo3.model.arena;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionArriba;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.DireccionDerechaArriba;
import fiuba.algo3.model.espacio.DireccionIzquierda;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;

public class BonusTest {
	
	private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
    private Arena arenaDeJuego = Arena.getInstance();
	
	@Before
	public void before(){
		instanciadorDeAlgoformers.inicializar();
		arenaDeJuego.inicializar();
	}
	
	@Test
	public void AlgoformerQuePasaPorBonusDobleCanionSeLeTriplicaElAtaque(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionInicialOptimus = new PuntoTierra(3,4);
		Punto ubicacionDobleCanion = new PuntoTierra(3,5);
		Punto ubicacionMegatron = new PuntoTierra(4,5);
		Direccion direccionArriba = new DireccionArriba();
		
		arenaDeJuego.setBonusEnPunto(ubicacionDobleCanion, new BonusDobleCanon());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialOptimus);
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
		
		optimus.reiniciarMovimiento();
		optimus.moverseHacia(direccionArriba);
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.atacar(megatron);
		
		Assert.assertEquals((megatron.getVidaMax()-100), megatron.getVida());	
	}
	
	@Test
	public void AlgoformerQuePasaPorBonusDobleCanionMantieneElAtaqueTriplicadoLuegoDeTransformarse(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionInicialOptimus = new PuntoTierra(3,4);
		Punto ubicacionDobleCanion = new PuntoTierra(3,5);
		Punto ubicacionMegatron = new PuntoTierra(4,5);
		Direccion direccionArriba = new DireccionArriba();
		
		arenaDeJuego.setBonusEnPunto(ubicacionDobleCanion, new BonusDobleCanon());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialOptimus);
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
		
		optimus.reiniciarMovimiento();
		optimus.moverseHacia(direccionArriba);
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.transformarse();
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.atacar(megatron);
		
		Assert.assertEquals((megatron.getVidaMax()-30), megatron.getVida());
	}
	
	@Test
	public void AlgoformerQuePasaPorBonusDobleCanionMantieneElEfectoAlTercerTurno(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionInicialOptimus = new PuntoTierra(3,4);
		Punto ubicacionDobleCanion = new PuntoTierra(3,5);
		Punto ubicacionMegatron = new PuntoTierra(4,5);
		Direccion direccionArriba = new DireccionArriba();
		
		arenaDeJuego.setBonusEnPunto(ubicacionDobleCanion, new BonusDobleCanon());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialOptimus);
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
		
		optimus.reiniciarMovimiento();
		optimus.moverseHacia(direccionArriba);
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();

		optimus.atacar(megatron);
		
		Assert.assertEquals((megatron.getVidaMax()-100), megatron.getVida());	
	}
	
	@Test
	public void AlgoformerQuePasaPorBonusDobleCanionPierdeElEfectoLuegoDeTresTurnos(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionInicialOptimus = new PuntoTierra(3,4);
		Punto ubicacionDobleCanion = new PuntoTierra(3,5);
		Punto ubicacionMegatron = new PuntoTierra(4,5);
		Direccion direccionArriba = new DireccionArriba();
		
		arenaDeJuego.setBonusEnPunto(ubicacionDobleCanion, new BonusDobleCanon());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialOptimus);
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
		
		optimus.reiniciarMovimiento();
		optimus.moverseHacia(direccionArriba);
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.atacar(megatron);
		
		Assert.assertEquals((megatron.getVidaMax()-50), megatron.getVida());	
	}
	
	@Test
	public void EfectosDeTormentaPsionicaYDobleCanionModificanElAtaqueCorrectamenteCuandoEstanJuntos(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionInicialOptimus = new PuntoTierra(4,4);
		Punto ubicacionEfectos = new PuntoAire(4,5);
		Punto ubicacionMegatron = new PuntoTierra(4,5);
		
		arenaDeJuego.setBonusEnPunto(ubicacionEfectos, new BonusDobleCanon());
		arenaDeJuego.setTerrenoEnPunto(ubicacionEfectos, new TormentaPsionica());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialOptimus);
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionMegatron);
		
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		
		megatron.resetearStats();
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();

		megatron.atacar(optimus);
		
		Assert.assertEquals((optimus.getVidaMax()-66), optimus.getVida());	
	}
	
	@Test
	public void AlgoformerQuePasaPorBonusFlashGanaMovimientosExtra(){
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionInicialOptimus = new PuntoTierra(3,4);
		Punto ubicacionBonusFlash = new PuntoTierra(4,4);
		Direccion direccionDerecha = new DireccionDerecha();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusFlash, new BonusFlash());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialOptimus);
		optimus.reiniciarMovimiento();
		
		optimus.moverseHacia(direccionDerecha);
		for (int i=0;i<5;i++)
			optimus.moverseHacia(direccionDerecha);
	}
	
	@Test
	public void AlgoformerQuePasaPorBonusFlashEnAlternoGanaVelocidad(){
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Punto ubicacionInicialBonecrusher = new PuntoTierra(50,25);
		Punto ubicacionBonusFlash = new PuntoTierra(49,25);
		Direccion direccionIzquierda = new DireccionIzquierda();
		
		arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionInicialBonecrusher);
		arenaDeJuego.setBonusEnPunto(ubicacionBonusFlash, new BonusFlash());
		
		bonecrusher.reiniciarMovimiento();
		bonecrusher.transformarse();
		
		bonecrusher.reiniciarMovimiento();
		bonecrusher.moverseHacia(direccionIzquierda);
		
		bonecrusher.resetearStats();
		bonecrusher.reiniciarMovimiento();	
		bonecrusher.aplicarEfectos();
		
		for (int i =0; i< 24; i++){
			bonecrusher.moverseHacia(direccionIzquierda);
		}
	}
	
	@Test
	public void TransformacionesNoAfectanAlBonusFlashDuranteLosTurnosQueEstaActivo(){
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Punto ubicacionInicialDeBumblebee = new PuntoTierra(1,1);
		Punto ubicacionDeBonus = new PuntoTierra(2,2);
		Direccion direccionDiagonal = new DireccionDerechaArriba();
		
		arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionInicialDeBumblebee);
		arenaDeJuego.setBonusEnPunto(ubicacionDeBonus, new BonusFlash());
		
		bumblebee.reiniciarMovimiento();
		bumblebee.moverseHacia(direccionDiagonal);
		
		for (int i=0; i<5;i++){
			bumblebee.moverseHacia(direccionDiagonal);
		}
		
		bumblebee.reiniciarMovimiento();
		bumblebee.transformarse();
		
		bumblebee.reiniciarMovimiento();
		bumblebee.aplicarEfectos();
		
		for(int i=0; i<15; i++){
			bumblebee.moverseHacia(direccionDiagonal);
		}
		
		bumblebee.reiniciarMovimiento();
		bumblebee.transformarse();
		
		bumblebee.reiniciarMovimiento();
		bumblebee.aplicarEfectos();
		for(int i=0; i<6; i++){
			bumblebee.moverseHacia(direccionDiagonal);
		}
				
		
		
	}
	
	@Test
	public void AlgoformerQuePasoPorBonusFlashMantieneMovimientosExtraEnElTercerTurno(){
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionInicialOptimus = new PuntoTierra(3,4);
		Punto ubicacionBonusFlash = new PuntoTierra(4,4);
		Direccion direccionDerecha = new DireccionDerecha();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusFlash, new BonusFlash());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialOptimus);
		optimus.reiniciarMovimiento();
		optimus.moverseHacia(direccionDerecha);
		
		optimus.reiniciarMovimiento();
		optimus.transformarse();
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		for (int i=0;i<6;i++)
			optimus.moverseHacia(direccionDerecha);
				
	}
	
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerQuePasoPorBonusFlashNoMantieneMovimientosExtraLuegoDelTercerTurno(){
		Algoformer optimus = instanciadorDeAlgoformers.obtenerOptimus();
		Punto ubicacionInicialOptimus = new PuntoTierra(3,4);
		Punto ubicacionBonusFlash = new PuntoTierra(4,4);
		Direccion direccionDerecha = new DireccionDerecha();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusFlash, new BonusFlash());
		arenaDeJuego.ubicarAlgoformer(optimus, ubicacionInicialOptimus);
		optimus.reiniciarMovimiento();
		optimus.moverseHacia(direccionDerecha);
		
		optimus.reiniciarMovimiento();
		optimus.transformarse();
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		optimus.resetearStats();
		optimus.reiniciarMovimiento();
		optimus.aplicarEfectos();
		
		for (int i=0;i<6;i++)
			optimus.moverseHacia(direccionDerecha);
		}
	
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerConFlashQuePasaPorNebulosaPierdeElTurno(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Punto ubicacionInicialMegatron = new PuntoTierra(3,4);
		Punto ubicacionBonusFlash = new PuntoAire(4,4);
		Punto ubicacionNebulosa = new PuntoAire(5,4);
		Direccion direccionDerecha = new DireccionDerecha();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusFlash, new BonusFlash());
		arenaDeJuego.setTerrenoEnPunto(ubicacionNebulosa, new NebulosaDeAndromeda());
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionInicialMegatron);
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		
		megatron.reiniciarMovimiento();
		megatron.moverseHacia(direccionDerecha);
		megatron.moverseHacia(direccionDerecha);
		
		megatron.moverseHacia(direccionDerecha);
	}
	
	@Test(expected = MovimientoNoValidoException.class)
	public void AlgoformerConFlashQuePasaPorNebulosaPierdeElSiguienteTurno(){
		Algoformer megatron = instanciadorDeAlgoformers.obtenerMegatron();
		Punto ubicacionInicialMegatron = new PuntoTierra(3,4);
		Punto ubicacionBonusFlash = new PuntoAire(4,4);
		Punto ubicacionNebulosa = new PuntoAire(5,4);
		Direccion direccionDerecha = new DireccionDerecha();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusFlash, new BonusFlash());
		arenaDeJuego.setTerrenoEnPunto(ubicacionNebulosa, new NebulosaDeAndromeda());
		arenaDeJuego.ubicarAlgoformer(megatron, ubicacionInicialMegatron);
		megatron.reiniciarMovimiento();
		megatron.transformarse();
		
		megatron.reiniciarMovimiento();
		megatron.moverseHacia(direccionDerecha);
		megatron.moverseHacia(direccionDerecha);
		
		megatron.resetearStats();
		megatron.reiniciarMovimiento();
		megatron.aplicarEfectos();
		
		megatron.moverseHacia(direccionDerecha);
	}
	
	@Test
	public void AlgoformerConBurbujaInmaculadaNoPierdeVida(){
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Punto ubicacionInicialRatchet = new PuntoTierra(3,4);
		Punto ubicacionInicialBoneCrusher = new PuntoTierra(5,4);
		Punto ubicacionBonusBurbuja = new PuntoTierra(4,4);
		Direccion direccionDerecha = new DireccionDerecha();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusBurbuja, new BonusBurbujaInmaculada());
		arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionInicialRatchet);
		arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionInicialBoneCrusher);
		ratchet.reiniciarMovimiento();
		bonecrusher.reiniciarMovimiento();
		
		ratchet.moverseHacia(direccionDerecha);
		
		ratchet.resetearStats();
		bonecrusher.reiniciarMovimiento();
		bonecrusher.aplicarEfectos();
		
		bonecrusher.atacar(ratchet);
		Assert.assertEquals(ratchet.getVidaMax(), ratchet.getVida());
	}
	
	@Test
	public void AlgoformerConBurbujaInmaculadaNoPierdeVidaEnElSegundoTurno(){
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Punto ubicacionInicialRatchet = new PuntoTierra(3,4);
		Punto ubicacionInicialBoneCrusher = new PuntoTierra(5,4);
		Punto ubicacionBonusBurbuja = new PuntoTierra(4,4);
		Direccion direccionDerecha = new DireccionDerecha();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusBurbuja, new BonusBurbujaInmaculada());
		arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionInicialRatchet);
		arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionInicialBoneCrusher);
		ratchet.reiniciarMovimiento();
		bonecrusher.reiniciarMovimiento();
		
		ratchet.moverseHacia(direccionDerecha);
		
		ratchet.resetearStats();
		bonecrusher.reiniciarMovimiento();
		bonecrusher.aplicarEfectos();
		
		bonecrusher.resetearStats();
		ratchet.reiniciarMovimiento();
		ratchet.aplicarEfectos();
		
		ratchet.resetearStats();
		bonecrusher.reiniciarMovimiento();
		bonecrusher.aplicarEfectos();
		
		bonecrusher.atacar(ratchet);
		Assert.assertEquals(ratchet.getVidaMax(), ratchet.getVida());
	}
	
	@Test
	public void AlgoformerConBurbujaInmaculadaPierdeVidaEnElTercerTurno(){
		Algoformer ratchet = instanciadorDeAlgoformers.obtenerRatchet();
		Algoformer bonecrusher = instanciadorDeAlgoformers.obtenerBonecrusher();
		Punto ubicacionInicialRatchet = new PuntoTierra(3,4);
		Punto ubicacionInicialBoneCrusher = new PuntoTierra(5,4);
		Punto ubicacionBonusBurbuja = new PuntoTierra(4,4);
		Direccion direccionDerecha = new DireccionDerecha();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusBurbuja, new BonusBurbujaInmaculada());
		arenaDeJuego.ubicarAlgoformer(ratchet, ubicacionInicialRatchet);
		arenaDeJuego.ubicarAlgoformer(bonecrusher, ubicacionInicialBoneCrusher);
		ratchet.reiniciarMovimiento();
		bonecrusher.reiniciarMovimiento();
		
		ratchet.moverseHacia(direccionDerecha);
		
		ratchet.resetearStats();
		bonecrusher.reiniciarMovimiento();
		bonecrusher.aplicarEfectos();
		
		bonecrusher.resetearStats();
		ratchet.reiniciarMovimiento();
		ratchet.aplicarEfectos();
		
		ratchet.resetearStats();
		bonecrusher.reiniciarMovimiento();
		bonecrusher.aplicarEfectos();
		
		bonecrusher.resetearStats();
		ratchet.reiniciarMovimiento();
		ratchet.aplicarEfectos();
		
		ratchet.resetearStats();
		bonecrusher.reiniciarMovimiento();
		bonecrusher.aplicarEfectos();
		
		bonecrusher.atacar(ratchet);
		Assert.assertEquals((ratchet.getVidaMax()-30), ratchet.getVida());
	}
	
	public void AlgoformerQueCapturaBurbujaLaMantieneLuegoDeTransformarse(){
		Algoformer bumblebee = instanciadorDeAlgoformers.obtenerBumblebee();
		Algoformer frenzy = instanciadorDeAlgoformers.obtenerFrenzy();
		Punto ubicacionInicialBumblebee = new PuntoTierra(19,11);
		Punto ubicacionInicialFrenzy = new PuntoTierra(19,12);
		Punto ubicacionBonusBurbuja = new PuntoTierra(19,13);
		Direccion direccionArriba = new DireccionArriba();
		
		arenaDeJuego.setBonusEnPunto(ubicacionBonusBurbuja, new BonusBurbujaInmaculada());
		arenaDeJuego.ubicarAlgoformer(bumblebee, ubicacionInicialBumblebee);
		arenaDeJuego.ubicarAlgoformer(frenzy, ubicacionInicialFrenzy);
		bumblebee.reiniciarMovimiento();
		frenzy.reiniciarMovimiento();
		
		frenzy.moverseHacia(direccionArriba);
		frenzy.transformarse();
		
		frenzy.resetearStats();
		bumblebee.reiniciarMovimiento();
		bumblebee.aplicarEfectos();
		
		bumblebee.atacar(bumblebee);
		Assert.assertEquals(frenzy.getVidaMax(), frenzy.getVida());
	}
}
