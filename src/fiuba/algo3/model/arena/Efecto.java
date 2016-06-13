package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public abstract class Efecto {
	
	int turnosRestantes;

		
	public boolean LlegoElContadorDeTurnosRestantesACero() {
		return (turnosRestantes == 0);
	}


	public abstract void aplicarSobre(Algoformer algoformer);
	public abstract void actualizar();


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		return true;
	}


	@Override
	public int hashCode() {
		return turnosRestantes;
	}
}
