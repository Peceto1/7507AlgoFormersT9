package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public abstract class Efecto {
	
		int turnosRestantes;

		public abstract void aplicarSobre(Algoformer algoformer);

		public abstract void actualizar();
		
		public boolean LlegoElContadorDeTurnosRestantesACero(){
			return (turnosRestantes == 0);
		}

		@Override
		public int hashCode() {
			return super.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}
		
		

}
