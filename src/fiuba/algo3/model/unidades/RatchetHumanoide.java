package fiuba.algo3.model.unidades;

class RatchetHumanoide extends EstadoHumanoide {

	private static RatchetHumanoide instancia = new RatchetHumanoide();
	
	private RatchetHumanoide(){
		this.ataque = 5;
		this.rango = 5;
		this.velocidad = 1;
	}
	
	static RatchetHumanoide getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
		movimiento.ascender();
    	a_transformar.setEstado(RatchetAlterno.getInstance());
    }
}