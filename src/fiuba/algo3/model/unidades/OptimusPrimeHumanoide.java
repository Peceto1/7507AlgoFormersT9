package fiuba.algo3.model.unidades;

class OptimusPrimeHumanoide extends EstadoHumanoide {

	private static OptimusPrimeHumanoide instancia = new OptimusPrimeHumanoide();
	
	private OptimusPrimeHumanoide(){
		this.ataque = 50;
		this.ataqueMax = ataque;
		this.rango = 2;
		this.velocidad = 2;
	}
	
	static OptimusPrimeHumanoide getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
    	a_transformar.setEstado(OptimusPrimeAlterno.getInstance());
    }
}
