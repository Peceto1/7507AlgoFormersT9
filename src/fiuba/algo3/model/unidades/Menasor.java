package fiuba.algo3.model.unidades;


import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierraNoPuedeDescenderException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menasor extends Decepticon {

    private List<Algoformer> miembros;


    public Menasor(int vida, List<Decepticon> miembros, Estado estadoProto) {
        super("Menasor", vida, estadoProto);
        this.miembros = new ArrayList<>(miembros);
    }


    @Override
    public void reiniciarMovimiento() {
        this.estado.reiniciarMovimiento(ubicacion);
        this.estado.actualizarEstado(this);
    }


    @Override
    public Menasor combinarse() {
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

    @Override
    public boolean equals(Object o) {
        return ((Algoformer)o).getNombre() == this.getNombre();

    }

    @Override
    public int hashCode() {
        return 0;
    }
}
