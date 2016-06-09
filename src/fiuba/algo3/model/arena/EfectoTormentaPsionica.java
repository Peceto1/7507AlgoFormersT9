package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class EfectoTormentaPsionica extends Efecto {
	
	EfectoTormentaPsionica(){
		turnosRestantes = 1;
	}


	@Override
	public void aplicarSobre(Algoformer algoformer) {
		algoformer.aplicarEfecto(this);
	}


	@Override
	public void actualizar() {}

}
