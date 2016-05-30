package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovimientoTest {

    private AlgoformerPool pool = AlgoformerPool.getInstance();
    private Arena arena = Arena.getInstance();


    @Before
    public void before() {
        pool.inicializar();
        arena.inicializar();
    }


    /*@Test
    public void test1() {
        Punto partida = new Punto(2, 2, 0);
        Punto llegada = new Punto(3, 2, 0);
        Direccion derecha = new Direccion(1, 0);

        Algoformer optimus = pool.obtenerOptimus();
        arena.ubicarAlgoformer(optimus, partida);
        optimus.reiniciarMovimiento();
        optimus.moverseHacia(derecha);
        Assert.assertEquals(optimus.getUbicacion(), llegada);
    }

    /*@Test
    public void test2() {

        Punto partida = new Punto(1, 1, 0);
        Direccion derecha = new Direccion(1, 0);

        Arena arena = Arena.getInstance();
        Algoformer optimus = pool.obtenerOptimus();

        int cantMovimientos = optimus.getVelocidad();
        for (int i=0; i<cantMovimientos; i++)
            optimus.mover(derecha);



        optimus.mover(derecha); // ---> Lanzar excepcion o no moverlo at all.
    }*/


}
