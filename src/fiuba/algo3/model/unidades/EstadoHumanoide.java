package fiuba.algo3.model.unidades;


import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.EfectoTormentaPsionica;
import fiuba.algo3.model.espacio.Punto;

import java.util.ArrayList;
import java.util.List;

abstract class EstadoHumanoide extends Estado{


    @Override
    public void capturarChispa(Algoformer captor) {
        captor.setChispa();
    }


    @Override
    public Superion combinarse(Autobot dioLaOrden, Autobot autobot2, Autobot autobot3) {

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

        // Acordarse de refactorizar ^
        Superion superion = new Superion(vidaSuperion, miembros, new EstadoProto());
        arena.ubicarAlgoformer(superion, ubicacionSuperion);
        return superion;
    }


    @Override
    public Menasor combinarse(Decepticon dioLaOrden, Decepticon autobot2, Decepticon autobot3) {
        List<Decepticon> miembros = new ArrayList<>();
        miembros.add(dioLaOrden);
        miembros.add(autobot2);
        miembros.add(autobot3);

        Punto ubicacionMenasor = dioLaOrden.getUbicacion();
        int vidaMenasor = 0;
        Arena arena = Arena.getInstance();

        for (Decepticon decepticon : miembros) {
            vidaMenasor += decepticon.getVida();
            arena.removerAlgoformerEn(decepticon.getUbicacion());
        }

        // Acordarse de refactorizar ^
        Menasor menasor = new Menasor(vidaMenasor, miembros, new EstadoProto());
        arena.ubicarAlgoformer(menasor, ubicacionMenasor);
        return menasor;
    }


    @Override
    void actualizarEstado(Autobot autobot) {

    }


    @Override
    void actualizarEstado(Decepticon decepticon){

    }


    @Override
    void perderUnMovimiento(){
    	throw new EstadoHumanoideNoPuedeEntrarEnPantanoException();
    }
    
    @Override
	public void aplicarEfecto(EfectoTormentaPsionica efecto){}
}

