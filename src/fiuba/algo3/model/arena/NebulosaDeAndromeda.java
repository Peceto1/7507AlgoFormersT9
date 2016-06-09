package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class NebulosaDeAndromeda implements Terreno {
	
	private Efecto efecto;


	public NebulosaDeAndromeda() {
		this.efecto = new EfectoNebulosaDeAndromeda();
	}


	@Override
	public void aplicarseSobre(Algoformer algoformer) {
		algoformer.agregarEfecto(efecto);
		efecto.aplicarSobre(algoformer);
	}

}
