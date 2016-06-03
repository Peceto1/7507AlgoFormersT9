package fiuba.algo3.model.espacio;

import static org.junit.Assert.*;
import org.junit.Test;

public class DireccionTest {

	@Test
	public void testDireccionDerecha() {
		
		Direccion dire = new DireccionDerecha();
		
		assertTrue(dire.x == 1);
		assertTrue(dire.y == 0);
	}
	
	@Test
	public void testDireccionArriba(){
		
		Direccion dire = new DireccionArriba();
		
		assertTrue(dire.x == 0);
		assertTrue(dire.y == 1);
	}
	
	@Test
	public void testDireccionIzquierda(){
		
		Direccion dire = new DireccionIzquierda();
		
		assertTrue(dire.x == -1);		
		assertTrue(dire.y == 0);
	}
	
	@Test
	public void testDireccionAbajo(){
		
		Direccion dire = new DireccionAbajo();
		
		assertTrue(dire.x == 0);
		assertTrue(dire.y == -1);
	}
	
	@Test
	public void testDireccionDerechaArriba(){
		
		Direccion dire = new DireccionDerechaArriba();
		
		assertTrue(dire.x == 1);
		assertTrue(dire.y == 1);
	}
	
	@Test
	public void testDireccionIzquierdaArriba(){
		
		Direccion dire = new DireccionIzquierdaArriba();
		
		assertTrue(dire.x == -1);
		assertTrue(dire.y == 1);
	}
	
	@Test
	public void testDireccionDerechaAbajo(){
		
		Direccion dire = new DireccionDerechaAbajo();
		
		assertTrue(dire.x == 1);
		assertTrue(dire.y == -1);
	}
	
	@Test
	public void testDireccionIzquierdaAbajo(){
		
		Direccion dire = new DireccionIzquierdaAbajo();
		
		assertTrue(dire.x == -1);
		assertTrue(dire.y == -1);
	}
	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaNoHayDireccion(){
//		
//		new Direccion(0,0);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnX(){
//		
//		new Direccion(2, 0);		
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnY(){
//		
//		new Direccion(0, 2);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXNegativo(){
//		
//		new Direccion(-2, 0);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnYNegativo(){
//		
//		new Direccion(0, -2);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXY(){
//		
//		new Direccion(2,2);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXNegativoY(){
//		
//		new Direccion(-2,2);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXYNegativo(){
//		
//		new Direccion(2, -2);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXNegativoYNegativo(){
//		
//		new Direccion(-2, -2);		
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionValidaEnXInvalidaEnY(){
//		
//		new Direccion(1,2);		
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testdireccionValidaEnXNegativoInvalidaEnY(){
//		
//		new Direccion(-1, 2);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionValidaEnXInvalidaEnYNegativo(){
//		
//		new Direccion(1, -2);		
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionValidaEnXNegativoInvalidaEnYNegativo(){
//		
//		new Direccion(-1, -2);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXValidaEnY(){
//		
//		new Direccion(2, 1);
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXNegativoValidaEnY(){
//		
//		new Direccion(-2, 1);		
//	}
//	
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXValidaEnYNegativo(){
//		
//		new Direccion(2, -1);
//	}
//	 
//	@Test (expected= DireccionInvalidaException.class)
//	public void testDireccionInvalidaEnXNegativoValidaEnYNegativo(){
//		
//		new Direccion(-2, -1);
//	}
}
