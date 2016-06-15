package fiuba.algo3.model.arena;

public class CreadorTormentaPsionica implements CreadorDeTerreno {

	@Override
	public TerrenoAplicable crearTerreno() {
		return new TormentaPsionica();
	}

}
