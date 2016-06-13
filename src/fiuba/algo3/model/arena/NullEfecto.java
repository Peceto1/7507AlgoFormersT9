package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class NullEfecto extends Efecto {
	
	public NullEfecto(){
		turnosRestantes = 0;
	}

	@Override
	public void aplicarSobre(Algoformer algoformer) {
	}

	@Override
	public void actualizar() {
	}

}
