package fiuba.algo3.model.arena;

public class CreadorRocoso implements CreadorDeTerreno {

	@Override
	public TerrenoAplicable crearTerreno() {
		return new Rocoso();
	}

}
