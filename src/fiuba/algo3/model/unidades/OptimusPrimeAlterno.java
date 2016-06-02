package fiuba.algo3.model.unidades;

class OptimusPrimeAlterno extends EstadoAlterno {

	private static OptimusPrimeAlterno instancia = new OptimusPrimeAlterno();

    private OptimusPrimeAlterno() {
        this.ataque = 15;
        this.rango = 4;
        this.velocidad = 5;
    }
    
	static OptimusPrimeAlterno getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
    	a_transformar.setEstado(OptimusPrimeHumanoide.getInstance());
    }
}
