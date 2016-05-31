package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Chispa;

abstract class EstadoHumanoide extends Estado{


    @Override
    public void capturarChispa(Chispa chispa, Algoformer captor) {
        captor.setChispa(chispa);
    }

    @Override
    public void combinarse(Algoformer otro1, Algoformer otro2) {
        // Puede dar la orden para combinarse con los demás.
    }
    
	
}

