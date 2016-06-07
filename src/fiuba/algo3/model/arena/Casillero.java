package fiuba.algo3.model.arena;


import fiuba.algo3.model.unidades.Algoformer;

class Casillero {

    private Algoformer contenido;
    private Chispa chispa;


    Casillero() {
        this.contenido = null;
    }


    Boolean estaOcupado(){
        return this.contenido != null;
    }


    void colocar(Algoformer algoformer) {
        this.contenido = algoformer;
    }
    
    void colocar(Chispa chispa){
    	this.chispa = chispa;
    }

    boolean contieneChispa(){
    	return this.chispa != null;
    }

    Algoformer removerAlgoformer() {
        Algoformer tmp = this.contenido;
        this.contenido = null;
        return tmp;
    }


	Chispa removerChispa() {
		Chispa tmp = this.chispa;
        this.chispa = null;
		return tmp;
	}


    Algoformer obtenerAlgoformer() {
        return this.contenido;
    }
}
