package fiuba.algo3.model.arena;

public class CreadorNube implements CreadorDeTerreno {

	@Override
	public TerrenoAplicable crearTerreno() {
		return new Nube();
	}

}
