package fiuba.algo3.model.arena;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;

public class CasilleroTest {

	@Test
	public void testCasilleroCreadoNoEstaOcupado() {
		Casillero casilleroDePrueba = new Casillero();
		
		Assert.assertFalse(casilleroDePrueba.estaOcupado());
	}
	
	@Test
	public void testCasilleroCreadoNoContieneChispa(){
		Casillero casilleroDePrueba = new Casillero();
		
		Assert.assertFalse(casilleroDePrueba.contieneChispa());
	}
	
	@Test
	public void testColocarAlgoformerCasilleroEstaOcupado(){
		Casillero casilleroDePrueba = new Casillero();
		
		AlgoformerPool instanciadorDeAlgoformer = AlgoformerPool.getInstance();
		
		casilleroDePrueba.colocar(instanciadorDeAlgoformer.obtenerOptimus());
		
		Assert.assertTrue(casilleroDePrueba.estaOcupado());		
	}
	
	@Test
	public void testColocarChispaCasilleroContieneChispa(){
		Casillero casilleroDePrueba = new Casillero();
		
		Chispa chispa = new Chispa();
		
		casilleroDePrueba.colocar(chispa);
		
		Assert.assertTrue(casilleroDePrueba.contieneChispa());		
	}
	
	@Test
	public void testRemoverAlgoformerCasilleroVacioEsNull(){
		Casillero casilleroDePrueba = new Casillero();
		
		Assert.assertTrue(casilleroDePrueba.removerAlgoformer() == null);		
	}
	
	@Test
	public void testRemoverAlgoformerDevuelveAlgoformerContenido(){
		Casillero casilleroDePrueba = new Casillero();
		
		AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		
		casilleroDePrueba.colocar(optimusPrime);
		
		Assert.assertTrue(casilleroDePrueba.removerAlgoformer() == optimusPrime);		
	}
	
	@Test
	public void testRemoverAlgoformerCasilleroEstaVacio(){		
		Casillero casilleroDePrueba = new Casillero();
		
		AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();
		Algoformer optimusPrime = instanciadorDeAlgoformers.obtenerOptimus();
		
		casilleroDePrueba.colocar(optimusPrime);
		casilleroDePrueba.removerAlgoformer();
		
		Assert.assertFalse(casilleroDePrueba.estaOcupado());		
	}
	
	
	

}
