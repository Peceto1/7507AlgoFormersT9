package fiuba.algo3.model.arena;

public class CreadorDeDobleCanon implements CreadorDeBonus {

	@Override
	public Bonus crearBonus() {
		return new BonusDobleCanon();
	}

}
