package fiuba.algo3.model.arena;

import fiuba.algo3.model.unidades.Algoformer;

public abstract class Bonus {
	Efecto efecto;
	String nombreBonus;
	
	
	public void aplicarseSobre(Algoformer algoformer) {		
		if (algoformer.contieneEfecto(efecto)){
			algoformer.removerEfecto(efecto);
		}
		else{
			efecto.aplicarSobre(algoformer);
		}

		algoformer.agregarEfecto(efecto);
	}


	public void setEfecto(Efecto nuevo) {
		this.efecto = nuevo;
	}


	public String getNombreBonus(){
		return nombreBonus;
	}

}
