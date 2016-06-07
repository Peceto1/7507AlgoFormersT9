package fiuba.algo3.model.arena;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.DireccionDerecha;
import fiuba.algo3.model.espacio.DireccionIzquierda;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;

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
}