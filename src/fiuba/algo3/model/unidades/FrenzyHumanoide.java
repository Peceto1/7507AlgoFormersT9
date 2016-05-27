package fiuba.algo3.model.unidades;

class FrenzyHumanoide extends EstadoHumanoide{
	private static FrenzyHumanoide instancia = new FrenzyHumanoide();
	
	private FrenzyHumanoide(){
		this.ataque = 10;
		this.rango = 3;
		this.velocidad = 1;
	}
	
	static FrenzyHumanoide getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
    	a_transformar.setEstado(FrenzyAlterno.getInstance());
    }
}