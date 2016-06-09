package fiuba.algo3.model.unidades;

class BoneCrusherHumanoide extends EstadoHumanoide {

	private static BoneCrusherHumanoide instancia = new BoneCrusherHumanoide();
	
	private BoneCrusherHumanoide(){
		this.ataque = 30;
		this.ataqueMax = ataque;
		this.rango = 3;
		this.velocidad = 1;
	}
	
	static BoneCrusherHumanoide getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
    	a_transformar.setEstado(BoneCrusherAlterno.getInstance());
    }
}
