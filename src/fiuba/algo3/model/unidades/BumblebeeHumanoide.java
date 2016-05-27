package fiuba.algo3.model.unidades;

class BumblebeeHumanoide extends EstadoHumanoide {

	private static BumblebeeHumanoide instancia = new BumblebeeHumanoide();
	
	private BumblebeeHumanoide(){
		this.ataque = 40;
		this.rango = 1;
		this.velocidad = 2;
	}
	
	static BumblebeeHumanoide getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
    	a_transformar.setEstado(BumblebeeAlterno.getInstance());
    }
}
