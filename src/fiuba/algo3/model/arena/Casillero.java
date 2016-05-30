package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

class Casillero {

    private Algoformer contenido;


    Casillero() {
        this.contenido = null;
    }


    Boolean estaOcupado(){
        return this.contenido != null;
    }


    void colocar(Algoformer algoformer) {
        this.contenido = algoformer;
    }


    Algoformer removerAlgoformer() {
        Algoformer tmp = this.contenido;
        this.contenido = null;
        return tmp;
    }

}
