package fiuba.algo3.model.unidades;


import java.util.ArrayList;
import java.util.List;

class Superion extends Autobot {

    private List<Autobot> miembros;


    Superion(int vida, List<Autobot> miembros, Estado estadoProto) {
        super("Superion", vida, estadoProto);
        this.miembros = new ArrayList<>(miembros);
    }


    @Override
    public void reiniciarMovimiento() {
        this.estado.reiniciarMovimiento(ubicacion);
        this.estado.actualizarEstado(this);
    }


}
