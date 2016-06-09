package fiuba.algo3.model;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.unidades.AlgoformerPool;
import org.junit.Before;
import org.junit.Test;

public class Entrega02Test {

    private Arena arena = Arena.getInstance();
    private AlgoformerPool instanciadorDeAlgoformers = AlgoformerPool.getInstance();


    @Before
    public void before() {
        arena.inicializar();
        instanciadorDeAlgoformers.inicializar();
    }


    @Test
    public void IntegracionTerrenosYJuego() {

    }



}
