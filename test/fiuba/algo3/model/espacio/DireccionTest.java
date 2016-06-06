package fiuba.algo3.model.espacio;

import static org.junit.Assert.*;
import org.junit.Test;

public class DireccionTest {

	@Test
	public void DireccionDerechaTieneLasCoordenadasCorrectas() {

		Direccion direccionDerecha = new DireccionDerecha();

		assertTrue(direccionDerecha.x == 1);
		assertTrue(direccionDerecha.y == 0);
	}

	@Test
	public void DireccionArribaTieneLasCoordenadasCorrectas() {

		Direccion direccionArriba = new DireccionArriba();

		assertTrue(direccionArriba.x == 0);
		assertTrue(direccionArriba.y == 1);
	}

	@Test
	public void DireccionIzquierdaTieneLasCoordenadasCorrectas() {

		Direccion direccionIzquierda = new DireccionIzquierda();

		assertTrue(direccionIzquierda.x == -1);
		assertTrue(direccionIzquierda.y == 0);
	}

	@Test
	public void DireccionAbajoTieneLasCoordenadasCorrectas() {

		Direccion direccionAbajo = new DireccionAbajo();

		assertTrue(direccionAbajo.x == 0);
		assertTrue(direccionAbajo.y == -1);
	}

	@Test
	public void DireccionDerechaArribaTieneLasCoordenadasCorrectas() {

		Direccion direccionDiagonalDerechaArriba = new DireccionDerechaArriba();

		assertTrue(direccionDiagonalDerechaArriba.x == 1);
		assertTrue(direccionDiagonalDerechaArriba.y == 1);
	}

	@Test
	public void DireccionIzquierdaArribaTieneLasCoordenadasCorrectas() {

		Direccion direccionDiagonalIzquierdaAbajo = new DireccionIzquierdaArriba();

		assertTrue(direccionDiagonalIzquierdaAbajo.x == -1);
		assertTrue(direccionDiagonalIzquierdaAbajo.y == 1);
	}

	@Test
	public void DireccionDerechaAbajoTieneLasCoordenadasCorrectas() {

		Direccion direccionDiagonalDerechaAbajo = new DireccionDerechaAbajo();

		assertTrue(direccionDiagonalDerechaAbajo.x == 1);
		assertTrue(direccionDiagonalDerechaAbajo.y == -1);
	}

	@Test
	public void DireccionIzquierdaAbajoTieneLasCoordenadasCorrectas() {

		Direccion direccionDiagonalIzquierdaAbajo = new DireccionIzquierdaAbajo();

		assertTrue(direccionDiagonalIzquierdaAbajo.x == -1);
		assertTrue(direccionDiagonalIzquierdaAbajo.y == -1);
	}

}