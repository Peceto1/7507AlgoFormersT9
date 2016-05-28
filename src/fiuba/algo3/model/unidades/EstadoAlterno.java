package fiuba.algo3.model.unidades;

abstract class EstadoAlterno extends Estado {


    @Override
    public void capturarChispa() {
        // No puede capturarla.
    }


    @Override
    public void combinarse(Algoformer otro1, Algoformer otro2) {
        // No puede dar la orden de combinarse si está en Alterno.
    }

	
}
