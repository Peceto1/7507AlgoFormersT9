package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

class Espinas implements Terreno {

	@Override
	public void aplicarseSobre(Algoformer algoformer) {
		int danio = algoformer.getVidaMax()/20;		// 5% = *5/100 = 1/20
		algoformer.recibirDanio(danio);
	}

}
