package fiuba.algo3.model.unidades;

class BoneCrusherHumanoide extends EstadoHumanoide {

	private static BoneCrusherHumanoide instancia = new BoneCrusherHumanoide();
	
	private BoneCrusherHumanoide(){
		this.ataque = 30;
		this.rango = 3;
		this.velocidad = 1;
	}
	
	static BoneCrusherHumanoide getInstance(){
		return instancia;
	}
	
    public void transformarse(Algoformer a_transformar){
    	a_transformar.setEstado(BoneCrusherAlterno.getInstance());
    }
}