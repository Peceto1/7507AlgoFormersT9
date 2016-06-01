package fiuba.algo3.model.espacio;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class PuntoTest {

    @Test
    public void crearDosPuntosIgualesAlCompararlosSonElMismoPunto() {
        Punto punto1 = new Punto(3, 2, 0);
        Punto punto2 = new Punto(3, 2, 0);

        Assert.assertEquals(punto1, punto2);
    }

    @Test
    public void crearDosPuntosDistintosAlCompararlosSonDistintos() {
        Punto punto1 = new Punto(1, 2, 1);
        Punto punto2 = new Punto(1, 2, 0);

        Assert.assertNotEquals(punto1, punto2);
    }

    @Test
    public void insertarPuntosEnUnHasheableSeHasheanIgualLosPuntosIguales() {
        Set<Punto> setDePuntos = new HashSet<>();
        Punto p1 = new Punto(1, 2, 0);
        Punto p2 = new Punto(1, 2, 0);
        setDePuntos.add(p1);

        Assert.assertTrue(setDePuntos.contains(p2));
    }

    @Test
    public void insertarUnPuntoEnUnHasheableUnPuntoDiferenteNoSeHasheaIgual() {
        Set<Punto> setDePuntos = new HashSet<>();
        Punto p1 = new Punto(2, 2, 1);
        Punto p2 = new Punto(2, 2, 2);
        setDePuntos.add(p1);

        Assert.assertFalse(setDePuntos.contains(p2));
    }

    @Test
    public void distanciaEntreUnPuntoYSiMismoEsCero() {
        Punto p1 = new Punto(1, 1, 0);
        Assert.assertEquals(p1.distanciaAl(p1), 0);
    }

    @Test
    public void distanciaEntreElCeroYSiMismoEsCero() {
        Punto cero = new Punto(0, 0, 0);
        Assert.assertEquals(cero.distanciaAl(cero), 0);
    }

    @Test
    public void distanciaEntreDosPuntosA2DeDistanciaHorizontalmenteEs2() {
        Punto p1 = new Punto(1, 4, 0);
        Punto p2 = new Punto(3, 4, 0);
        Assert.assertEquals(p1.distanciaAl(p2), 2);
    }

    @Test
    public void distanciaEntreDosPuntosA2DeDistanciaVerticalmenteEs3() {
        Punto p1 = new Punto(1, 5, 0);
        Punto p2 = new Punto(1, 2, 0);
        Assert.assertEquals(p1.distanciaAl(p2), 3);
    }

    @Test
    public void distanciaEntreDosPuntosA5DeDistanciaEnDiagonalPerfectaEs5() {
        Punto p1 = new Punto(5, 5, 0);
        Punto p2 = new Punto(10, 10, 0);
        Assert.assertEquals(p1.distanciaAl(p2), 5);
    }

    @Test
    public void distanciaEntreDosPuntosA4DeDistanciaEnDiagonalNoPerfectaEs4() {
        Punto p1 = new Punto(5, 5, 0);
        Punto p2 = new Punto(9, 8, 0);
        Assert.assertEquals(p1.distanciaAl(p2), 4);
    }

    @Test
    public void distanciaEntreDosPuntosUnoEnAireYOtroEnTierraEsCero() {
        Punto p1 = new Punto(5, 5, 0);
        Punto p2 = new Punto(5, 5, 1);
        Assert.assertEquals(p1.distanciaAl(p2), 0);
    }

    @Test
    public void distanciaEntreDosPuntosA5DeDistanciaUnoEnAireYOtroEnTierraEs5() {
        Punto p1 = new Punto(5, 5, 0);
        Punto p2 = new Punto(10, 10, 1);
        Assert.assertEquals(p1.distanciaAl(p2), 5);
    }

    @Test
    public void obtenerPuntoEnDireccionVerticalHaciaArribaMeDevuelveUnPuntoArribaDelOriginal() {
        Punto inicio = new Punto(1, 1, 0);
        Punto fin = new Punto(1, 2, 0);
        Direccion arriba = new Direccion(0, 1);
        Punto p2 = inicio.obtenerPuntoEn(arriba);

        Assert.assertEquals(p2, fin);
    }

    @Test
    public void obtenerPuntoEnDireccionHorizontalHaciaDerechaMeDevuelveUnPuntoALaDerechaDelOriginal() {
        Punto inicio = new Punto(1, 1, 1);
        Punto fin = new Punto(2, 1, 1);
        Punto p2 = inicio.obtenerPuntoEn(new Direccion(1, 0));

        Assert.assertEquals(p2, fin);
    }

    @Test
    public void obtenerPuntoEnDireccionDiagonalIzquierdaAbajoMeDevuelveUnPuntoAbajoALaIzquierdaDelOriginal() {
        Punto inicio = new Punto(5, 5, 0);
        Punto fin = new Punto(4, 4, 0);
        Punto p2 = inicio.obtenerPuntoEn(new Direccion(-1, -1));

        Assert.assertEquals(p2, fin);
    }

    @Test (expected = DireccionInvalidaException.class)
    public void crearUnaDireccionConAlgunNumeroMayorAUnoLanzaExcepcion() {
        new Direccion(2, 1);
    }

    @Test (expected = DireccionInvalidaException.class)
    public void crearUnaDireccionConAlgunNumeroMenorAUnoLanzaExcepcion() {
        new Direccion(-5, 1);
    }

    @Test (expected = DireccionInvalidaException.class)
    public void crearUnaDireccionNulaLanzaExcepcion() {
        new Direccion(0, 0);
    }

}
