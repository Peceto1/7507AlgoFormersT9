package fiuba.algo3.model.arena;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionArriba;
import fiuba.algo3.model.espacio.DireccionDerecha;
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
		
		Assert.assertEquals((megatron.getVidaMax()-150), megatron.getVida());	
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
		
		Assert.assertEquals((megatron.getVidaMax()-45), megatron.getVida());
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
		
		Assert.assertEquals((megatron.getVidaMax()-150), megatron.getVida());	
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
		
		Assert.assertEquals((optimus.getVidaMax()-99), optimus.getVida());	
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
	
}
