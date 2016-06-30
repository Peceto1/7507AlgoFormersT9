package fiuba.algo3.model.arena;

class NullBonus extends Bonus {
	
	NullBonus(){
		this.efecto = new NullEfecto();
		this.nombreBonus = "Sin Bonus";
	}

}
