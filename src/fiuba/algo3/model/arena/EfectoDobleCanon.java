package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class EfectoDobleCanon extends Efecto {
	
	public EfectoDobleCanon(){
		this.turnosRestantes = 2;
	}

	@Override
	public void aplicarSobre(Algoformer algoformer) {
		algoformer.aplicarEfecto(this);
	}

	@Override
	public void actualizar() {
		this.turnosRestantes--;
	}
	

}
