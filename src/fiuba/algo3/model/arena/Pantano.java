package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class Pantano implements Terreno {
	
	public Pantano(){}

	@Override
	public void aplicarseSobre(Algoformer algoformer) {
		algoformer.perderUnMovimiento();
	}
}
