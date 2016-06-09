package fiuba.algo3.model.unidades;


import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoTierraNoPuedeDescenderException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Menasor extends Decepticon {

    private List<Algoformer> miembros;


    Menasor(int vida, List<Decepticon> miembros, Estado estadoProto) {
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

        estado.verificarProto();

        Arena arena = Arena.getInstance();
        arena.removerAlgoformerEn(this.ubicacion);

        distribuirDanioEntreMiembros();
        removerMuertos();

        for (Algoformer miembro : this.miembros){
        	arena.ubicarTemporalmente(miembro, arena.lugarInicialLibre());
            try{
                pasarAHumanoide(miembro);
            }catch(PuntoTierraNoPuedeDescenderException e){
            	Punto puntoTierra = miembro.getUbicacion();
            	Punto puntoAire = puntoTierra.ascender();
            	arena.ubicarAlgoformer(miembro, puntoAire);
            	arena.removerAlgoformerEn(puntoTierra);
            	miembro.reiniciarMovimiento();
            	miembro.transformarse();
            }
            arena.removerAlgoformerEn(miembro.getUbicacion());
        }

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


    private void distribuirDanioEntreMiembros() {

        int dmgTotal = this.vidaMax - this.vida;
        int dmgParcial = dmgTotal/this.miembros.size();

        for (Algoformer miembro : this.miembros)
            miembro.recibirDanio(dmgParcial);
    }


    private void removerMuertos() {
        Iterator<Algoformer> iter = this.miembros.iterator();

        while (iter.hasNext()) {
            Algoformer actual = iter.next();

            if (!actual.estaVivo())
                iter.remove();
        }
    }


}
