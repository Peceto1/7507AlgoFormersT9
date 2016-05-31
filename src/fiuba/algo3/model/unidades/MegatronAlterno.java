package fiuba.algo3.model.unidades;

class MegatronAlterno extends EstadoAlterno{
	private static MegatronAlterno instancia = new MegatronAlterno();
	
	private MegatronAlterno(){
		this.ataque = 55;
		this.rango = 2;
		this.velocidad = 8;
	}
	
	static MegatronAlterno getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
		movimiento.descender();
    	a_transformar.setEstado(MegatronHumanoide.getInstance());
    }
}