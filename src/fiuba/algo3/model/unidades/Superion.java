package fiuba.algo3.model.unidades;


import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;

import java.util.ArrayList;
import java.util.List;

class Superion extends Autobot {

    private List<Algoformer> miembros;


    Superion(int vida, List<Autobot> miembros, Estado estadoProto) {
        super("Superion", vida, estadoProto);
        this.miembros = new ArrayList<>(miembros);
    }


    @Override
    public void reiniciarMovimiento() {
        this.estado.reiniciarMovimiento(ubicacion);
        this.estado.actualizarEstado(this);
    }


    @Override
    public Superion combinarse() {
        throw new CombinacionYaSeEncuentraCombinadaException();
    }


    @Override
    public List<Algoformer> separarse() {

        List<Punto> puntosAdyacentesLibres = obtenerPuntosAdyacentesLibres(ubicacion.obtenerAdyacentesEnTierra());

        if (puntosAdyacentesLibres.size() < 2)
            throw new NoPuedeSepararseException();

        this.estado.verificarProto();

        Arena arena = Arena.getInstance();
        arena.removerAlgoformerEn(this.ubicacion);

        distribuirDanioEntreMiembros(this.miembros);
        removerMuertos(this.miembros);
        transformarAlternosAHumanoide(this.miembros);

        Algoformer primero = this.miembros.remove(0);
        arena.ubicarAlgoformer(primero, this.ubicacion);

        int i = 0;
        for (Algoformer miembro : this.miembros) {
            arena.ubicarAlgoformer(miembro, puntosAdyacentesLibres.get(i));
            i++;
        }

        this.miembros.add(primero);
        return new ArrayList<>(this.miembros);
    }

}
