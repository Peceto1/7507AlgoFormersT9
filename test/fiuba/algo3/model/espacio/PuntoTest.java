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
        Punto puntoDePrueba = new PuntoTierra(3, 2);
        Punto otroPuntoEnMismasCoordenada = new PuntoTierra(3, 2);

        Assert.assertEquals(puntoDePrueba, otroPuntoEnMismasCoordenada);
    }

    @Test
    public void crearDosPuntosDistintosAlCompararlosSonDistintos() {
        Punto puntoDePruebaTerrestre = new PuntoAire(1, 2);
        Punto puntoAereoEnLasMismasCoordenadas = new PuntoTierra(1, 2);

        Assert.assertNotEquals(puntoDePruebaTerrestre, puntoAereoEnLasMismasCoordenadas);
    }

    @Test
    public void insertarPuntosEnUnHasheableSeHasheanIgualLosPuntosIguales() {
        Set<Punto> setDePuntos = new HashSet<>();
        Punto puntoDePrueba = new PuntoTierra(1, 2);
        Punto otroPuntoConMismasCoordenadas = new PuntoTierra(1, 2);
        setDePuntos.add(puntoDePrueba);

        Assert.assertTrue(setDePuntos.contains(otroPuntoConMismasCoordenadas));
    }

    @Test
    public void insertarUnPuntoEnUnHasheableUnPuntoDiferenteNoSeHasheaIgual() {
        Set<Punto> setDePuntos = new HashSet<>();
        Punto puntoDePruebaAereo = new PuntoAire(2, 2);
        Punto otroPuntoEnMismasCoordenadasTerrestre = new PuntoTierra(2, 2);
        setDePuntos.add(puntoDePruebaAereo);

        Assert.assertFalse(setDePuntos.contains(otroPuntoEnMismasCoordenadasTerrestre));
    }

    @Test
    public void distanciaEntreUnPuntoYSiMismoEsCero() {
        Punto puntoDePrueba = new PuntoTierra(1, 1);
        Assert.assertEquals(puntoDePrueba.distanciaAl(puntoDePrueba), 0);
    }

    @Test
    public void distanciaEntreElCeroYSiMismoEsCero() {
        Punto puntoDeCoordenadasCero = new PuntoTierra(0, 0);
        Assert.assertEquals(puntoDeCoordenadasCero.distanciaAl(puntoDeCoordenadasCero), 0);
    }

    @Test
    public void distanciaEntreDosPuntosA2DeDistanciaHorizontalmenteEs2() {
        Punto puntoDePrueba = new PuntoTierra(1, 4);
        Punto otroPuntoADosDeDistancia = new PuntoTierra(3, 4);
        Assert.assertEquals(puntoDePrueba.distanciaAl(otroPuntoADosDeDistancia), 2);
    }

    @Test
    public void distanciaEntreDosPuntosA3DeDistanciaVerticalmenteEs3() {
        Punto puntoDePrueba = new PuntoTierra(1, 5);
        Punto otroPuntoATresDeDistancia = new PuntoTierra(1, 2);
        Assert.assertEquals(puntoDePrueba.distanciaAl(otroPuntoATresDeDistancia), 3);
    }

    @Test
    public void distanciaEntreDosPuntosA5DeDistanciaEnDiagonalPerfectaEs5() {
        Punto puntoDePrueba = new PuntoTierra(5, 5);
        Punto otroPuntoACincoDeDistancia = new PuntoTierra(10, 10);
        Assert.assertEquals(puntoDePrueba.distanciaAl(otroPuntoACincoDeDistancia), 5);
    }

    @Test
    public void distanciaEntreDosPuntosA4DeDistanciaEnDiagonalNoPerfectaEs4() {
        Punto puntoDePrueba = new PuntoTierra(5, 5);
        Punto otroPuntoACuatroDeDistancia = new PuntoTierra(9, 8);
        Assert.assertEquals(puntoDePrueba.distanciaAl(otroPuntoACuatroDeDistancia), 4);
    }

    @Test
    public void distanciaEntreDosPuntosUnoEnAireYOtroEnTierraEsCero() {
        Punto puntoDePruebaTerrestre = new PuntoTierra(5, 5);
        Punto puntoDePruebaAereo = new PuntoAire(5, 5);
        Assert.assertEquals(puntoDePruebaTerrestre.distanciaAl(puntoDePruebaAereo), 0);
    }

    @Test
    public void distanciaEntreDosPuntosA5DeDistanciaUnoEnAireYOtroEnTierraEs5() {
        Punto puntoDePruebaTerrestre = new PuntoTierra(5, 5);
        Punto puntoDePruebaACincoDeDistanciaAereo = new PuntoAire(10, 10);
        Assert.assertEquals(puntoDePruebaTerrestre.distanciaAl(puntoDePruebaACincoDeDistanciaAereo), 5);
    }

    @Test
    public void obtenerPuntoEnDireccionVerticalHaciaArribaMeDevuelveUnPuntoArribaDelOriginal() {
        Punto puntoDeInicio = new PuntoTierra(1, 1);
        Punto puntoFinal = new PuntoTierra(1, 2);
        Direccion direccionArriba = new DireccionArriba();
        Punto puntoEnDireccionDelInicial = puntoDeInicio.obtenerPuntoEn(direccionArriba);

        Assert.assertEquals(puntoEnDireccionDelInicial, puntoFinal);
    }

    @Test
    public void obtenerPuntoEnDireccionHorizontalHaciaDerechaMeDevuelveUnPuntoALaDerechaDelOriginal() {
        Punto puntoInicial = new PuntoAire(1, 1);
        Punto puntoFinal = new PuntoAire(2, 1);
        Punto puntoEnDireccionDerechaDelInicial = puntoInicial.obtenerPuntoEn(new DireccionDerecha());

        Assert.assertEquals(puntoEnDireccionDerechaDelInicial, puntoFinal);
    }

    @Test
    public void obtenerPuntoEnDireccionDiagonalIzquierdaAbajoMeDevuelveUnPuntoAbajoALaIzquierdaDelOriginal() {
        Punto puntoInicial = new PuntoTierra(5, 5);
        Punto puntoFinal = new PuntoTierra(4, 4);
        Punto puntoEnDireccionIzquierdaAbajoDelInicial = puntoInicial.obtenerPuntoEn(new DireccionIzquierdaAbajo());

        Assert.assertEquals(puntoEnDireccionIzquierdaAbajoDelInicial, puntoFinal);
    }
    
    @Test
    public void testPuntoTierraAscenderDevuelveElPuntoEnAire(){
    	
    	PuntoTierra puntoInicial = new PuntoTierra(4,4);
    	PuntoAire puntoInicialEnAire = new PuntoAire(4,4);
    			
    	PuntoAire puntoAscendido = puntoInicial.ascender();
    	
    	Assert.assertEquals(puntoAscendido, puntoInicialEnAire);
    }
    
    @Test
    public void testPuntoAireDescenderDevuelveElPuntoEnTierra(){
    	
    	PuntoAire puntoInicio = new PuntoAire(8,8);
    	PuntoTierra puntoEnTierra = new PuntoTierra(8,8);
    	
    	PuntoTierra puntoDescendido = puntoInicio.descender();
    	
    	Assert.assertEquals(puntoDescendido, puntoEnTierra);    	
    }
    
    @Test (expected= PuntoAireNoPuedeAscenderException.class)
    public void testPuntoAireNoPuedeAscender(){
    	
    	PuntoAire puntoDePrueba = new PuntoAire(45,20);
    	puntoDePrueba.ascender();
    }
    
    @Test (expected= PuntoTierraNoPuedeDescenderException.class)
    public void testPuntoTierraNoPuedeDescender(){
    	
    	PuntoTierra puntoDePrueba = new PuntoTierra(15,25);
    	puntoDePrueba.descender();
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
