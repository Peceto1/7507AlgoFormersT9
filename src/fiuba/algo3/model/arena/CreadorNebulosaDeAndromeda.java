package fiuba.algo3.model.arena;

public class CreadorNebulosaDeAndromeda implements CreadorDeTerreno {

	@Override
	public TerrenoAplicable crearTerreno() {
		return new NebulosaDeAndromeda();
	}

}
