package fiuba.algo3.model.arena;

public class CreadorEspinas implements CreadorDeTerreno {

	@Override
	public TerrenoAplicable crearTerreno() {
		return new Espinas();
	}

}
