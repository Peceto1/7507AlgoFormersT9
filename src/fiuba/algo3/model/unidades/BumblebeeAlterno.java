package fiuba.algo3.model.unidades;

class BumblebeeAlterno extends EstadoAlterno {

	private static BumblebeeAlterno instancia = new BumblebeeAlterno();

    private BumblebeeAlterno() {
        this.ataque = 20;
        this.rango = 3;
        this.velocidad = 5;
    }


	static BumblebeeAlterno getInstance(){
		return instancia;
	}

	
	@Override
    public void transformar(Algoformer a_transformar){
    	a_transformar.setEstado(BumblebeeHumanoide.getInstance());
    }
}
