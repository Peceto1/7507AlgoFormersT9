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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Bonus bonus = (Bonus) o;

		if (efecto != null ? !efecto.equals(bonus.efecto) : bonus.efecto != null) return false;
		return nombreBonus != null ? nombreBonus.equals(bonus.nombreBonus) : bonus.nombreBonus == null;

	}

	@Override
	public int hashCode() {
		int result = efecto != null ? efecto.hashCode() : 0;
		result = 31 * result + (nombreBonus != null ? nombreBonus.hashCode() : 0);
		return result;
	}


	public void setNombre(String string) {
		this.nombreBonus = string;
	}
}
