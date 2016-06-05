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
	public void testDireccionArriba() {

		Direccion dire = new DireccionArriba();

		assertTrue(dire.x == 0);
		assertTrue(dire.y == 1);
	}

	@Test
	public void testDireccionIzquierda() {

		Direccion dire = new DireccionIzquierda();

		assertTrue(dire.x == -1);
		assertTrue(dire.y == 0);
	}

	@Test
	public void testDireccionAbajo() {

		Direccion dire = new DireccionAbajo();

		assertTrue(dire.x == 0);
		assertTrue(dire.y == -1);
	}

	@Test
	public void testDireccionDerechaArriba() {

		Direccion dire = new DireccionDerechaArriba();

		assertTrue(dire.x == 1);
		assertTrue(dire.y == 1);
	}

	@Test
	public void testDireccionIzquierdaArriba() {

		Direccion dire = new DireccionIzquierdaArriba();

		assertTrue(dire.x == -1);
		assertTrue(dire.y == 1);
	}

	@Test
	public void testDireccionDerechaAbajo() {

		Direccion dire = new DireccionDerechaAbajo();

		assertTrue(dire.x == 1);
		assertTrue(dire.y == -1);
	}

	@Test
	public void testDireccionIzquierdaAbajo() {

		Direccion dire = new DireccionIzquierdaAbajo();

		assertTrue(dire.x == -1);
		assertTrue(dire.y == -1);
	}

}