package fiuba.algo3.model.arena;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;

public class CasilleroTest {

	@Test
	public void testCasilleroCreadoNoEstaOcupado() {
		Casillero casi = new Casillero();
		
		Assert.assertFalse(casi.estaOcupado());
	}
	
	@Test
	public void testCasilleroCreadoNoContieneChispa(){
		Casillero casi = new Casillero();
		
		Assert.assertFalse(casi.contieneChispa());
	}
	
	@Test
	public void testColocarAlgoformerCasilleroEstaOcupado(){
		Casillero casi = new Casillero();
		
		AlgoformerPool pool = AlgoformerPool.getInstance();
		
		casi.colocar(pool.obtenerOptimus());
		
		Assert.assertTrue(casi.estaOcupado());		
	}
	
	@Test
	public void testColocarChispaCasilleroContieneChispa(){
		Casillero casi = new Casillero();
		
		Chispa chispa = new Chispa();
		
		casi.colocar(chispa);
		
		Assert.assertTrue(casi.contieneChispa());		
	}
	
	@Test
	public void testRemoverAlgoformerCasilleroVacioEsNull(){
		Casillero casi = new Casillero();
		
		Assert.assertTrue(casi.removerAlgoformer() == null);		
	}
	
	@Test
	public void testRemoverAlgoformerDevuelveAlgoformerContenido(){
		Casillero casi = new Casillero();
		
		AlgoformerPool pool = AlgoformerPool.getInstance();
		Algoformer algof = pool.obtenerOptimus();
		
		casi.colocar(algof);
		
		Assert.assertTrue(casi.removerAlgoformer() == algof);		
	}
	
	@Test
	public void testRemoverAlgoformerCasilleroEstaVacio(){		
		Casillero casi = new Casillero();
		
		AlgoformerPool pool = AlgoformerPool.getInstance();
		Algoformer algof = pool.obtenerOptimus();
		
		casi.colocar(algof);
		casi.removerAlgoformer();
		
		Assert.assertFalse(casi.estaOcupado());		
	}
	
	
	

}
