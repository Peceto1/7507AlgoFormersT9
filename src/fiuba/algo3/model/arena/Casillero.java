package fiuba.algo3.model.arena;


import fiuba.algo3.model.unidades.Algoformer;

class Casillero {

    private Algoformer contenido;
    private Chispa chispa;
    private TerrenoAplicable terreno;
    private Bonus bonus;

    Casillero(TerrenoAplicable terreno) {
        this.contenido = null;
        this.terreno = terreno;
        this.bonus = new NullBonus();
    }
    

    Boolean estaOcupado(){
        return this.contenido != null;
    }

    
    private void aplicarTerrenoSobre(Algoformer algoformer){
    	this.terreno.aplicarseSobre(algoformer);
    }
    
    private void aplicarBonusSobre(Algoformer algoformer){
    	this.bonus.aplicarseSobre(algoformer);
    	bonus.setEfecto(new NullEfecto());
    	bonus.setNombre("Sin Bonus");
    }
    

    void setTerreno(TerrenoAplicable nuevo){
    	this.terreno = nuevo;
    }


    void colocar(Algoformer algoformer) {
        aplicarTerrenoSobre(algoformer);
        aplicarBonusSobre(algoformer);
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


	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}


	TerrenoAplicable getTerreno() {
		return this.terreno;
	}


    public Bonus getBonus() {
        return this.bonus;
    }


	Chispa verChispa() {
		return this.chispa;
		
	}
}
