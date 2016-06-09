package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class TormentaPsionica implements Terreno {
	
	private Efecto efecto;


	public TormentaPsionica() {
		efecto = new EfectoTormentaPsionica();
	}
	

	@Override
	public void aplicarseSobre(Algoformer algoformer) {		
		if (!algoformer.contieneEfecto(efecto)){
			efecto.aplicarSobre(algoformer);
			algoformer.agregarEfecto(efecto);
		}
	}

}
