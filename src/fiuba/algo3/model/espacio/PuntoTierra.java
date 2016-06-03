package fiuba.algo3.model.espacio;

public class PuntoTierra extends Punto{

	public PuntoTierra(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y, 0);
	}
	
	public PuntoAire ascender(){
		
		return new PuntoAire(x, y);
	}
	
	public PuntoTierra obtenerPuntoEn(Direccion direccion) {
        return new PuntoTierra(x + direccion.x, y + direccion.y);
    }

}
