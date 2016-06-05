package fiuba.algo3.model.unidades;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.*;

public class EstadoEnEsperaTests {
	
	private AlgoformerPool pool = AlgoformerPool.getInstance();
	private Arena arena = Arena.getInstance();
	private EstadoProto estado = EstadoProto.getInstance();
	
	@Before
	public void before(){
		pool.inicializar();
		arena.inicializar();
	}

	@Test (expected= EstadoProtoNoPuedeRealizarAcciones.class)
	public void testModoEsperaNoSeTransforma() {		
				
		Algoformer optimus = pool.obtenerOptimus();
			
		estado.transformar(optimus);
	}
	
	@Test (expected= EstadoProtoNoPuedeRealizarAcciones.class)
	public void testModoEsperaNoPuedeCapturarChispa(){		
		
		Algoformer optimus = pool.obtenerOptimus();
				
		estado.capturarChispa(optimus);
	}
	
	@Test (expected= EstadoProtoNoPuedeRealizarAcciones.class)
	public void testModoEsperaNoSePuedeCombinar(){		
		
		Algoformer optimus = pool.obtenerOptimus();
		Algoformer bumble = pool.obtenerBumblebee();
						
		estado.combinarse(optimus, bumble);
	}
	
	@Test
	public void testModoEsperaAtaqueAutobotvsAutobotNoRecibeDanio(){
		
		Autobot optimus = (Autobot) pool.obtenerOptimus();
		Autobot bumble = (Autobot) pool.obtenerBumblebee();
		
		estado.atacar(optimus, bumble);
		
		Assert.assertEquals(bumble.getVida(), 350);
	}
	
	@Test
	public void testModoEsperaAtaqueAutobovsDecepticonNoRecibeDanio(){
		
		Autobot optimus = (Autobot) pool.obtenerOptimus();
		Decepticon megatron = (Decepticon) pool.obtenerMegatron();
		
		estado.atacar(optimus, megatron);
		
		Assert.assertEquals(optimus.getVida(), 500);
	}
	
	@Test
	public void testModoEsperaNoPuedeAtacarRangosRealesMayoresA1(){
		
		Algoformer optimus = pool.obtenerOptimus();
		Punto optimusPos = new PuntoTierra(26,1);
        arena.ubicarAlgoformer(optimus, optimusPos);
        
        Punto puntoOrigen = new PuntoTierra(27,1);
        
        Assert.assertFalse(estado.puedeAtacar(optimus, puntoOrigen));
	}
	
	@Test
	public void testModoEsperaPuedeAtacarDistancia0(){
		
		Algoformer optimus = pool.obtenerOptimus();
		Punto optimusPos = new PuntoTierra(26,1);
        arena.ubicarAlgoformer(optimus, optimusPos);      
        
        Assert.assertTrue(estado.puedeAtacar(optimus, optimusPos));
	}

}
