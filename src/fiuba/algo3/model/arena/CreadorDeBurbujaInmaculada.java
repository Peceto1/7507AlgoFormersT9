package fiuba.algo3.model.arena;

public class CreadorDeBurbujaInmaculada implements CreadorDeBonus {

	@Override
	public Bonus crearBonus() {
		return new BonusBurbujaInmaculada();
	}

}
