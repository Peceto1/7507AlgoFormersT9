package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public class EfectoBurbujaInmaculada extends Efecto {
	
	EfectoBurbujaInmaculada(){
		this.turnosRestantes = 2;
	}

	@Override
	public void aplicarSobre(Algoformer algoformer) {
		algoformer.aplicarEfecto(this);
		if (turnosRestantes == 0)
			algoformer.desactivarBurbuja();
	}

	@Override
	public void actualizar() {
		this.turnosRestantes--;
		
	}

}
