package fiuba.algo3.model.unidades;

class EstadoMenasor extends EstadoHumanoide {

    private static EstadoMenasor instancia = new EstadoMenasor();


    private EstadoMenasor() {
        this.ataque = 115;
        this.rango = 2;
        this.velocidad = 2;
    }


    static EstadoMenasor getInstance() {
        return instancia;
    }


    @Override
    public void transformar(Algoformer a_transformar) {
        throw new CombinacionNoTieneAlternoException();
    }

}
