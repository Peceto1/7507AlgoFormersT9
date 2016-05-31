package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega01Test {

    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();

    @Before
    public void before() {
        pool.inicializar();
        arena.inicializar();
    }


    /* ESTOS TESTS SON TESTS DE INTEGRACION QUE PIDE EL ENUNCIADO
       CADA TEST TIENE UN NUMERO Y UNA LETRA ANTES DE SU TITULO
       NUMERO: Representa cual es el test del enunciado.
       LETRA: Representa un inciso, es decir, se prueba con un algoformer.
                Si les parece necesario agregar más incisos pueden hacerlo.
     */


    @Test
    public void test01_a_SeUbicaAlgoformerHumanoideEnUnCasilleroAlMoverseSeMueveAcorde() {
        Punto partida = new Punto(10, 10, 0);
        Punto intermedio = new Punto(11, 10, 0);
        Punto llegada = new Punto(12, 10, 0);       // Optimus tiene velocidad 2 en Humanoide
        Direccion derecha = new Direccion(1, 0);    // Se moverá hacia la derecha

        Assert.assertFalse(arena.estaOcupado(partida));    // No hay algoformer aún.

        Algoformer optimus = pool.obtenerOptimus();     // Algoformer por defecto en Estado Humanoide
        arena.ubicarAlgoformer(optimus, partida);       // Lo ubico en el punto de partida

        Assert.assertTrue(arena.estaOcupado(partida));      // Se ubicó correctamente

        optimus.reiniciarMovimiento();  // Inicializo su turno para moverse
        optimus.moverseHacia(derecha);  // Se mueve un casillero a la derecha

        Assert.assertTrue(arena.estaOcupado(intermedio));     // Ahora optimus se encuentra uno a la derecha
        Assert.assertFalse(arena.estaOcupado(partida));     // Ya no se encuentra más en el punto de partida

        optimus.moverseHacia(derecha);  // Se mueve nuevamente a la derecha.

        Assert.assertTrue(arena.estaOcupado(llegada));      // Llegó al punto de destino
        Assert.assertFalse(arena.estaOcupado(intermedio));

        try {
            optimus.moverseHacia(derecha);      // Trato de moverlo aunque se le acabaron sus movimientos
        }
        catch (MovimientoNoValidoException e) {
            Assert.assertFalse(arena.estaOcupado(partida));     // No se encuentra en el punto de partida
            Assert.assertFalse(arena.estaOcupado(intermedio));  // No se encuentra en el punto de paso
            Assert.assertTrue(arena.estaOcupado(llegada));      // Se encuentra en el punto de llegada
        }

    }

    @Test
    public void test02_a_SeUbicaUnAlgoformerHumanoideSeLoTransformaYSeVerificaQueSePuedaTransformarEnAmbasDirecciones() {
        Punto partida = new Punto(1, 1, 0);
        Punto partidaEnAire = new Punto(1, 1, 1);

        Algoformer megatron = pool.obtenerMegatron();
        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();     // Inicializo su movimiento

        Assert.assertTrue(arena.estaOcupado(partida));          // Se encuentra donde lo ubique
        Assert.assertFalse(arena.estaOcupado(partidaEnAire));   // No se encuentra en el aire

        megatron.transformarse();   // Lo transformo a su estado Alterno (volador)
        megatron.reiniciarMovimiento(); // Inicializo su movimiento

        Assert.assertFalse(arena.estaOcupado(partida));         // No se encuentra más en la tierra
        Assert.assertTrue(arena.estaOcupado(partidaEnAire));    // Se encuentra en el aire

        megatron.transformarse();   // Lo transformo nuevamente a Humanoide y debe descender
        Assert.assertTrue(arena.estaOcupado(partida));
        Assert.assertFalse(arena.estaOcupado(partidaEnAire));
    }


}
