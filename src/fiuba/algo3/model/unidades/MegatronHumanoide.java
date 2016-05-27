package fiuba.algo3.model.unidades;

class MegatronHumanoide extends EstadoHumanoide{
	private static MegatronHumanoide instancia = new MegatronHumanoide();
	
	private MegatronHumanoide(){
		this.ataque = 10;
		this.rango = 3;
		this.velocidad = 1;
	}
	
	static MegatronHumanoide getInstance(){
		return instancia;
	}
}