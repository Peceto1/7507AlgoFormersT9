package fiuba.algo3.model.unidades;


import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;

import java.util.ArrayList;
import java.util.List;

abstract class EstadoHumanoide extends Estado{


    @Override
    public void capturarChispa(Algoformer captor) {
        captor.setChispa();
    }


    @Override
    public void combinarse(Autobot dioLaOrden, Autobot autobot2, Autobot autobot3) {

        List<Autobot> miembros = new ArrayList<>();
        miembros.add(dioLaOrden);
        miembros.add(autobot2);
        miembros.add(autobot3);

        Punto ubicacionSuperion = dioLaOrden.getUbicacion();
        int vidaSuperion = 0;
        Arena arena = Arena.getInstance();

        for (Autobot autobot : miembros) {
            vidaSuperion += autobot.getVida();
            arena.removerAlgoformerEn(autobot.getUbicacion());
        }

        EstadoProto estado = new EstadoProto();

        Superion superion = new Superion(vidaSuperion, miembros, estado);
        estado.setaConstruir(superion);

        arena.ubicarAlgoformer(superion, ubicacionSuperion);
    }


    @Override
    public void combinarse(Decepticon dioLaOrden, Decepticon autobot2, Decepticon autobot3) {


    }
    
	
}

