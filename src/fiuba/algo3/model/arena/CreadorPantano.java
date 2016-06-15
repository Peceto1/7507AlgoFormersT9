package fiuba.algo3.model.arena;

public class CreadorPantano implements CreadorDeTerreno {

	@Override
	public TerrenoAplicable crearTerreno() {
		return new Pantano();
	}

}
