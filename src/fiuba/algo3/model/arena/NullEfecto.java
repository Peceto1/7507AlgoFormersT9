package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

class NullEfecto extends Efecto {
	
	NullEfecto(){
		turnosRestantes = 0;
	}

	@Override
	public void aplicarSobre(Algoformer algoformer) {
	}

	@Override
	public void actualizar() {
	}

}
