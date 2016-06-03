package fiuba.algo3.model.espacio;

public class PuntoAire extends Punto{

	public PuntoAire(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y, 1);
	}
	
	@Override
	public PuntoTierra descender(){
		
		return new PuntoTierra(x, y);
	}
	
	public PuntoAire obtenerPuntoEn(Direccion direccion) {
        return new PuntoAire(x + direccion.x, y + direccion.y);
    }

}
