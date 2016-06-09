package fiuba.algo3.model.unidades;


import java.util.ArrayList;
import java.util.List;

class Menasor extends Decepticon {

    private List<Decepticon> miembros;


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
    public void separarse() {
        System.out.println("Separar Menasor Debe Implementarse");
    }


}
