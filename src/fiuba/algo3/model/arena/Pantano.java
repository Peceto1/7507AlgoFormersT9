package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

class Pantano implements Terreno {

	@Override
	public void aplicarseSobre(Algoformer algoformer) {
		algoformer.perderUnMovimiento();
	}
}
