package fiuba.algo3.model.espacio;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PuntoTest {

    @Test
    public void crearDosPuntosIgualesAlCompararlosSonElMismoPunto() {
        Punto punto1 = new PuntoTierra(3, 2);
        Punto punto2 = new PuntoTierra(3, 2);

        Assert.assertEquals(punto1, punto2);
    }

    @Test
    public void crearDosPuntosDistintosAlCompararlosSonDistintos() {
        Punto punto1 = new PuntoAire(1, 2);
        Punto punto2 = new PuntoTierra(1, 2);

        Assert.assertNotEquals(punto1, punto2);
    }

    @Test
    public void insertarPuntosEnUnHasheableSeHasheanIgualLosPuntosIguales() {
        Set<Punto> setDePuntos = new HashSet<>();
        Punto p1 = new PuntoTierra(1, 2);
        Punto p2 = new PuntoTierra(1, 2);
        setDePuntos.add(p1);

        Assert.assertTrue(setDePuntos.contains(p2));
    }

    @Test
    public void insertarUnPuntoEnUnHasheableUnPuntoDiferenteNoSeHasheaIgual() {
        Set<Punto> setDePuntos = new HashSet<>();
        Punto p1 = new PuntoAire(2, 2);
        Punto p2 = new PuntoTierra(2, 2);
        setDePuntos.add(p1);

        Assert.assertFalse(setDePuntos.contains(p2));
    }

    @Test
    public void distanciaEntreUnPuntoYSiMismoEsCero() {
        Punto p1 = new PuntoTierra(1, 1);
        Assert.assertEquals(p1.distanciaAl(p1), 0);
    }

    @Test
    public void distanciaEntreElCeroYSiMismoEsCero() {
        Punto cero = new PuntoTierra(0, 0);
        Assert.assertEquals(cero.distanciaAl(cero), 0);
    }

    @Test
    public void distanciaEntreDosPuntosA2DeDistanciaHorizontalmenteEs2() {
        Punto p1 = new PuntoTierra(1, 4);
        Punto p2 = new PuntoTierra(3, 4);
        Assert.assertEquals(p1.distanciaAl(p2), 2);
    }

    @Test
    public void distanciaEntreDosPuntosA2DeDistanciaVerticalmenteEs3() {
        Punto p1 = new PuntoTierra(1, 5);
        Punto p2 = new PuntoTierra(1, 2);
        Assert.assertEquals(p1.distanciaAl(p2), 3);
    }

    @Test
    public void distanciaEntreDosPuntosA5DeDistanciaEnDiagonalPerfectaEs5() {
        Punto p1 = new PuntoTierra(5, 5);
        Punto p2 = new PuntoTierra(10, 10);
        Assert.assertEquals(p1.distanciaAl(p2), 5);
    }

    @Test
    public void distanciaEntreDosPuntosA4DeDistanciaEnDiagonalNoPerfectaEs4() {
        Punto p1 = new PuntoTierra(5, 5);
        Punto p2 = new PuntoTierra(9, 8);
        Assert.assertEquals(p1.distanciaAl(p2), 4);
    }

    @Test
    public void distanciaEntreDosPuntosUnoEnAireYOtroEnTierraEsCero() {
        Punto p1 = new PuntoTierra(5, 5);
        Punto p2 = new PuntoAire(5, 5);
        Assert.assertEquals(p1.distanciaAl(p2), 0);
    }

    @Test
    public void distanciaEntreDosPuntosA5DeDistanciaUnoEnAireYOtroEnTierraEs5() {
        Punto p1 = new PuntoTierra(5, 5);
        Punto p2 = new PuntoAire(10, 10);
        Assert.assertEquals(p1.distanciaAl(p2), 5);
    }

    @Test
    public void obtenerPuntoEnDireccionVerticalHaciaArribaMeDevuelveUnPuntoArribaDelOriginal() {
        Punto inicio = new PuntoTierra(1, 1);
        Punto fin = new PuntoTierra(1, 2);
        Direccion arriba = new DireccionArriba();
        Punto p2 = inicio.obtenerPuntoEn(arriba);

        Assert.assertEquals(p2, fin);
    }

    @Test
    public void obtenerPuntoEnDireccionHorizontalHaciaDerechaMeDevuelveUnPuntoALaDerechaDelOriginal() {
        Punto inicio = new PuntoAire(1, 1);
        Punto fin = new PuntoAire(2, 1);
        Punto p2 = inicio.obtenerPuntoEn(new DireccionDerecha());

        Assert.assertEquals(p2, fin);
    }

    @Test
    public void obtenerPuntoEnDireccionDiagonalIzquierdaAbajoMeDevuelveUnPuntoAbajoALaIzquierdaDelOriginal() {
        Punto inicio = new PuntoTierra(5, 5);
        Punto fin = new PuntoTierra(4, 4);
        Punto p2 = inicio.obtenerPuntoEn(new DireccionIzquierdaAbajo());

        Assert.assertEquals(p2, fin);
    }
    
    @Test
    public void testPuntoTierraAscenderDevuelveElPuntoEnAire(){
    	
    	PuntoTierra puntoInicio = new PuntoTierra(4,4);
    	PuntoAire puntoEnAire = new PuntoAire(4,4);
    			
    	PuntoAire puntoAscendido = puntoInicio.ascender();
    	
    	Assert.assertEquals(puntoAscendido, puntoEnAire);
    }
    
    @Test
    public void testPuntoAireDescenderDevuelveElPuntoEnTierra(){
    	
    	PuntoAire puntoInicio = new PuntoAire(8,8);
    	PuntoTierra puntoEnTierra = new PuntoTierra(8,8);
    	
    	PuntoTierra puntoDescendido = puntoInicio.descender(); //como el rojo
    	
    	Assert.assertEquals(puntoDescendido, puntoEnTierra);    	
    }
    
    @Test (expected= PuntoAireNoPuedeAscenderException.class)
    public void testPuntoAireNoPuedeAscender(){
    	
    	PuntoAire punto = new PuntoAire(45,20);
    	punto.ascender();
    }
    
    @Test (expected= PuntoTierraNoPuedeDescenderException.class)
    public void testPuntoTierraNoPuedeDescender(){
    	
    	PuntoTierra punto = new PuntoTierra(15,25);
    	punto.descender();
    }

    @Test
    public void obtenerAdyacentesAEnDeUnPuntoDevuelveUnaListaConTodosSusAdyacentesEnAireYEnTierra() {
        Punto puntoTierra = new PuntoTierra(5, 5);
        Punto puntosAdyacentes[] = {new PuntoAire(5,5), new PuntoAire(6,5), new PuntoAire(6,6),
                                    new PuntoAire(5,6), new PuntoAire(4,6), new PuntoAire(4,5),
                                    new PuntoAire(4,4), new PuntoAire(5,4), new PuntoAire(6,4),
                                    new PuntoTierra(6,5), new PuntoTierra(6,6),
                                    new PuntoTierra(5,6), new PuntoTierra(4,6), new PuntoTierra(4,5),
                                    new PuntoTierra(4,4), new PuntoTierra(5,4), new PuntoTierra(6,4),
                                    };

        List<Punto> listaAdyacentes = Arrays.asList(puntosAdyacentes);

        List<Punto> puntosAdyacentes2 = puntoTierra.obtenerAdyacentes();

        Assert.assertTrue(puntosAdyacentes2.containsAll(listaAdyacentes));
        Assert.assertEquals(puntosAdyacentes2.size(), listaAdyacentes.size());
    }
}
