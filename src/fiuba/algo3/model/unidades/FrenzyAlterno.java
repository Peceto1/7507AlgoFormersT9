package fiuba.algo3.model.unidades;

class FrenzyAlterno extends EstadoAlterno {

	private static FrenzyAlterno instancia = new FrenzyAlterno();
	
	private FrenzyAlterno(){
		this.ataque = 25;
		this.rango = 2;
		this.velocidad = 6;
	}
	
	static FrenzyAlterno getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
    	a_transformar.setEstado(FrenzyHumanoide.getInstance());
    }
}