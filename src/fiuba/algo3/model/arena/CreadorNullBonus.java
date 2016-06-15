package fiuba.algo3.model.arena;

public class CreadorNullBonus implements CreadorDeBonus {

	@Override
	public Bonus crearBonus() {
		return new NullBonus();
	}

}
