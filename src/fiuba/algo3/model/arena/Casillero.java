package fiuba.algo3.model.arena;


import fiuba.algo3.model.unidades.Algoformer;

class Casillero {

    private Algoformer contenido;
    private Chispa chispa;
    private Terreno terreno;


    Casillero(Terreno terreno) {
        this.contenido = null;
        this.terreno = terreno;
    }


    Boolean estaOcupado(){
        return this.contenido != null;
    }
    
    void aplicarTerrenoSobre(Algoformer algoformer){
    	this.terreno.aplicarseSobre(algoformer);
    }

    void setTerreno(Terreno nuevo){
    	this.terreno = nuevo;
    }

    void colocar(Algoformer algoformer) {
        this.contenido = algoformer;
        aplicarTerrenoSobre(algoformer);
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

}
