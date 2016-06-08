package fiuba.algo3.model.unidades;

class EstadoSuperion extends EstadoHumanoide {

    private static EstadoSuperion instancia = new EstadoSuperion();


    private EstadoSuperion() {
        this.ataque = 100;
        this.rango = 2;
        this.velocidad = 3;
    }


    static EstadoSuperion getInstance() {
        return instancia;
    }


    @Override
    public void transformar(Algoformer a_transformar) {
        throw new CombinacionNoTieneAlternoException();
    }


}
