package fiuba.algo3.model.espacio;

public class PuntoAire extends Punto{

	public PuntoAire(int x, int y) {
		super(x, y, 1);
	}
	
	@Override
	public PuntoTierra descender(){
		
		return new PuntoTierra(x, y);
	}
	
	@Override
	public PuntoAire ascender() throws PuntoAireNoPuedeAscenderException{
		
		throw new PuntoAireNoPuedeAscenderException();
	}

	
	@Override
	public PuntoAire obtenerPuntoEn(Direccion direccion) {
        return new PuntoAire(x + direccion.x, y + direccion.y);
    }

}
