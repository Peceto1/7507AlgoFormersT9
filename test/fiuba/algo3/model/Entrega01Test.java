package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.FueraDeRangoException;
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
       LETRA: Representa un inciso, es decir, un caso de prueba en particular.
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

    @Test
    public void test03_a_SeUbicaUnAlgoformerEnEstadoAlternoSeMueveYSeVerificaQueSeHayaDesplazadoCorrectamente() {
        Punto partida = new Punto(16, 16, 0);
        Punto llegada = new Punto(8, 8, 1);
        Direccion diagonalAbajoIzq = new Direccion(-1, -1);

        Algoformer megatron = pool.obtenerMegatron();
        arena.ubicarAlgoformer(megatron, partida);
        megatron.reiniciarMovimiento();
        megatron.transformarse();       // Sube al aire, megatron Alterno tiene velocidad 8
        megatron.reiniciarMovimiento();

        // Megatron Alterno tiene velocidad 8
        int cantMovimientos = 8;

        Assert.assertTrue(arena.estaOcupado(new Punto(16, 16, 1)));

        for (int i=0; i<cantMovimientos; i++)
            megatron.moverseHacia(diagonalAbajoIzq);

        Assert.assertTrue(arena.estaOcupado(llegada));
        Assert.assertFalse(arena.estaOcupado(partida));
        Assert.assertFalse(arena.estaOcupado(new Punto(16, 16, 1)));
        Assert.assertFalse(arena.estaOcupado(new Punto(24, 24, 0)));

        // Trato de moverlo nuevamente y lanza excepcion
        try {
            megatron.moverseHacia(diagonalAbajoIzq);
        } catch (MovimientoNoValidoException e) {
            Assert.assertTrue(arena.estaOcupado(llegada));      // Permanece en donde habia quedado
            Assert.assertFalse(arena.estaOcupado(new Punto(7, 7, 1)));  // No se movio de donde estaba
        }
    }

    @Test
    public void test04_a_IntegracionJuegoJugadoresArenaAlgoformersChispa() {

        Juego juego = new Juego();
        juego.crearJugador("Santi", "AUTOBOTS");
        juego.crearJugador("Fran", "DECEPTICONS");
        Assert.assertTrue(arena.estaOcupado(new Punto(1, 27, 0)));
        Assert.assertTrue(arena.estaOcupado(new Punto(1, 26, 0)));
        Assert.assertTrue(arena.estaOcupado(new Punto(1, 25, 0)));
        Assert.assertTrue(arena.estaOcupado(new Punto(51, 27, 0)));
        Assert.assertTrue(arena.estaOcupado(new Punto(51, 26, 0)));
        Assert.assertTrue(arena.estaOcupado(new Punto(51, 25, 0)));

        // ¿Y Ahora que?


    }

    @Test
    public void test05_a_AutobotHumanoideVsDecepticonHumanoide() {
        Algoformer optimus = pool.obtenerOptimus();
        Algoformer megatron = pool.obtenerMegatron();
        Punto inicioOptimus = new Punto(41, 41, 0);       // Inician en lados opuestos del mapa
        Punto inicioMegatron = new Punto(51, 51, 0);
        Direccion diagonalArriba = new Direccion(1, 1);     // Asi se movera Optimus
        Direccion diagonalAbajo = new Direccion(-1, -1);    // Asi se movera Megatron
        int movimientosOptimusAlterno = 5;
        int movimientosMegatronAlterno = 8;

        arena.ubicarAlgoformer(optimus, inicioOptimus);
        optimus.reiniciarMovimiento();
        optimus.transformarse();    // Ambos se transforman para alcanzarse mas rápidamente
        optimus.reiniciarMovimiento();

        arena.ubicarAlgoformer(megatron, inicioMegatron);
        megatron.reiniciarMovimiento();
        megatron.transformarse();
        megatron.reiniciarMovimiento();

        // Optimus se mueve lo más que puede hacia Megatron
        for (int i = 0; i < movimientosOptimusAlterno; i++)
            optimus.moverseHacia(diagonalArriba);       // Queda en (46, 46, 0)

        Assert.assertTrue(arena.estaOcupado(new Punto(46, 46, 0)));

        optimus.reiniciarMovimiento(); // Reinicio su movimiento para su proximo turno

        // Megatron se mueve lo más que puede hacia Optimus
        for (int i = 0; i < movimientosMegatronAlterno; i++)
            megatron.moverseHacia(diagonalAbajo);       // Queda en (43, 43, 1)

        megatron.reiniciarMovimiento(); // Reinicio su movimiento para su proximo turno

        Assert.assertTrue(arena.estaOcupado(new Punto(43, 43, 1)));

        // OPTIMUS YA ESTA EN RANGO, ATACA A MEGATRON (AMBOS EN ESTADO ALTERNO)
        optimus.atacar(megatron);
        optimus.reiniciarMovimiento();  // Termina su turno

        Assert.assertEquals(megatron.getVida(), 550 - 15); // Megatron es dañado en 15

        // MEGATRON NO PUEDE ESPERAR Y ATACA SIN ESTAR EN RANGO DESDE EL AIRE
        try {
            megatron.atacar(optimus);
            megatron.reiniciarMovimiento(); // Termina su turno
        } catch (FueraDeRangoException e) {
            Assert.assertEquals(optimus.getVida(), 500); // LA VIDA DE OPTIMUS NO CAMBIO
        }

        // OPTIMUS ATACA DE NUEVO
        optimus.atacar(megatron);
        optimus.reiniciarMovimiento();  // Termina su turno

        Assert.assertEquals(megatron.getVida(), 550 - 15 * 2);

        megatron.moverseHacia(diagonalArriba);   // Megatron se acerca y ahora esta en rango de ataque.
        megatron.reiniciarMovimiento();
        // Salteo turno de optimus
        megatron.atacar(optimus);   // Megatron ataca a optimus

        Assert.assertEquals(optimus.getVida(), 500 - 55);   // Megatron le hizo daño a optimus
    }
}

