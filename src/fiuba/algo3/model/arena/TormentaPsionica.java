package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class TormentaPsionica implements TerrenoAplicable {
	
	private Efecto efecto;


	public TormentaPsionica() {
		efecto = new EfectoTormentaPsionica();
	}
	

	@Override
	public void aplicarseSobre(Algoformer algoformer) {		
		if (algoformer.contieneEfecto(efecto)){
			algoformer.removerEfecto(efecto);
		}

		algoformer.agregarEfecto(efecto);
	}
	
	@Override
	public String devolverTipoTerreno(){
		return "Tormenta";
	}

}
