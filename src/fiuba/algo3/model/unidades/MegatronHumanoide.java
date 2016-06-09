package fiuba.algo3.model.unidades;

class MegatronHumanoide extends EstadoHumanoide {

	private static MegatronHumanoide instancia = new MegatronHumanoide();
	
	private MegatronHumanoide(){
		this.ataque = 10;
		this.ataqueMax=ataque;
		this.rango = 3;
		this.velocidad = 1;
	}
	
	static MegatronHumanoide getInstance(){
		return instancia;
	}
	
	@Override
    public void transformar(Algoformer a_transformar) {
		a_transformar.setEstado(MegatronAlterno.getInstance());
		reiniciarMovimiento(a_transformar.getUbicacion());
		movimiento.ascender();
    }
}