package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class TormentaPsionica implements Terreno {
	
	Efecto efecto;
	
	TormentaPsionica(){
		efecto = new EfectoTormentaPsionica();
	}

	@Override
	public void aplicarseSobre(Algoformer algoformer) {		
		algoformer.agregarEfecto(efecto);
		algoformer.reducirAtaquePorcentaje(40);
	}

}
