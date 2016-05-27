package fiuba.algo3.model.unidades;

class BoneCrusherAlterno extends EstadoAlterno {

	private static BoneCrusherAlterno instancia = new BoneCrusherAlterno();
	
    private BoneCrusherAlterno() {
        this.ataque = 30;
        this.rango = 3;
        this.velocidad = 8;
    }
    
    @Override
    public void transformar(Algoformer a_transformar){
    	a_transformar.setEstado(BoneCrusherHumanoide.getInstance());
    }
    
    
	static BoneCrusherAlterno getInstance(){
		return instancia;
	}
  
}
