package fiuba.algo3.model.espacio;

import static org.junit.Assert.*;
import org.junit.Test;

public class DireccionTest {

	@Test
	public void testDireccionEnX() {
		
		Direccion dire = new Direccion(1, 0);
		
		assertTrue(dire.x == 1);
		assertTrue(dire.y == 0);
	}
	
	@Test
	public void testDireccionEnY(){
		
		Direccion dire = new Direccion(0, 1);
		
		assertTrue(dire.x == 0);
		assertTrue(dire.y == 1);
	}
	
	@Test
	public void testDireccionEnXNegativo(){
		
		Direccion dire = new Direccion(-1,0);
		
		assertTrue(dire.x == -1);		
		assertTrue(dire.y == 0);
	}
	
	@Test
	public void testDireccionEnYNegativo(){
		
		Direccion dire = new Direccion(0, -1);
		
		assertTrue(dire.x == 0);
		assertTrue(dire.y == -1);
	}
	
	@Test
	public void testDireccionEnXY(){
		
		Direccion dire = new Direccion(1, 1);
		
		assertTrue(dire.x == 1);
		assertTrue(dire.y == 1);
	}
	
	@Test
	public void testDireccionEnXNegativoY(){
		
		Direccion dire = new Direccion(-1, 1);
		
		assertTrue(dire.x == -1);
		assertTrue(dire.y == 1);
	}
	
	@Test
	public void testDireccionEnXYNegativo(){
		
		Direccion dire = new Direccion(1, -1);
		
		assertTrue(dire.x == 1);
		assertTrue(dire.y == -1);
	}
	
	@Test
	public void testDireccionEnXNegativoYNegativo(){
		
		Direccion dire = new Direccion(-1, -1);
		
		assertTrue(dire.x == -1);
		assertTrue(dire.y == -1);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaNoHayDireccion(){
		
		new Direccion(0,0);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnX(){
		
		new Direccion(2, 0);		
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnY(){
		
		new Direccion(0, 2);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXNegativo(){
		
		new Direccion(-2, 0);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnYNegativo(){
		
		new Direccion(0, -2);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXY(){
		
		new Direccion(2,2);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXNegativoY(){
		
		new Direccion(-2,2);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXYNegativo(){
		
		new Direccion(2, -2);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXNegativoYNegativo(){
		
		new Direccion(-2, -2);		
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionValidaEnXInvalidaEnY(){
		
		new Direccion(1,2);		
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testdireccionValidaEnXNegativoInvalidaEnY(){
		
		new Direccion(-1, 2);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionValidaEnXInvalidaEnYNegativo(){
		
		new Direccion(1, -2);		
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionValidaEnXNegativoInvalidaEnYNegativo(){
		
		new Direccion(-1, -2);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXValidaEnY(){
		
		new Direccion(2, 1);
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXNegativoValidaEnY(){
		
		new Direccion(-2, 1);		
	}
	
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXValidaEnYNegativo(){
		
		new Direccion(2, -1);
	}
	 
	@Test (expected= DireccionInvalidaException.class)
	public void testDireccionInvalidaEnXNegativoValidaEnYNegativo(){
		
		new Direccion(-2, -1);
	}
}
