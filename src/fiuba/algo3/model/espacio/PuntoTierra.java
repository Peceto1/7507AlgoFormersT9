package fiuba.algo3.model.espacio;

public class PuntoTierra extends Punto {

	public PuntoTierra(int x, int y) {
		super(x, y, 0);
	}
	
	@Override
	public PuntoAire ascender(){
		
		return new PuntoAire(x, y);
	}
	
	@Override
	public PuntoTierra descender(){
		
		throw new PuntoTierraNoPuedeDescenderException();
	}
	
	@Override
	public PuntoTierra obtenerPuntoEn(Direccion direccion) {
        return new PuntoTierra(x + direccion.x, y + direccion.y);
    }

}
