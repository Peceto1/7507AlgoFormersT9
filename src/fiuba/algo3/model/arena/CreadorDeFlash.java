package fiuba.algo3.model.arena;

public class CreadorDeFlash implements CreadorDeBonus {

	@Override
	public Bonus crearBonus() {
		return new BonusFlash();
	}

}
