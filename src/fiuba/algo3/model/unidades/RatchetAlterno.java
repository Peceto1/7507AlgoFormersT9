package fiuba.algo3.model.unidades;

class RatchetAlterno extends EstadoAlterno {

	private static RatchetAlterno instancia = new RatchetAlterno();
	
	private RatchetAlterno(){
		this.ataque = 35;
		this.ataqueMax = ataque;
		this.rango = 2;
		this.velocidad = 8;
	}
	
	static RatchetAlterno getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar){
		movimiento.descender();
    	a_transformar.setEstado(RatchetHumanoide.getInstance());
    }
}