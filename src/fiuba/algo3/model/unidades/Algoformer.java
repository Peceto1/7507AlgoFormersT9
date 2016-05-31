package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Chispa;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;


public abstract class Algoformer {

	protected String nombre;
	protected int vida;
	protected Estado estado;
	protected Chispa chispa = null;
	protected Punto ubicacion;


	Algoformer(String nombre, int vida, Estado estado) {
		this.nombre = nombre;
		this.vida = vida;
		this.estado = estado;
	}

	
	String getNombre() {
		return this.nombre;
	}


	int getVida() {
		return this.vida;
	}


	void setChispa(Chispa chispa) {
		this.chispa = chispa;
	}


	Punto getUbicacion() {
		return this.ubicacion;
	}


	public void setUbicacion(Punto ubicacion) {
		this.ubicacion = ubicacion;
	}


	public boolean estaVivo() {
		return (this.vida > 0);
	}


	public Boolean tieneChispa() {
		return this.chispa != null;
	}


	public void capturarChispa(Chispa chispa) {
		this.estado.capturarChispa(chispa, this);
	}

	
	Estado getEstado() {
		return this.estado;
	}


	void setEstado(Estado nuevo) {
		this.estado = nuevo;
	}


	public void moverseHacia(Direccion direccion) {
		ubicacion = estado.moverse(direccion);
	}


	public void reiniciarMovimiento() {
		this.estado.reiniciarMovimiento(this.ubicacion);
	}


	public void transformarse() {
		this.estado.transformar(this);
	}

	public abstract void atacar(Algoformer atacado);
	abstract void recibirAtaque(Algoformer atacante, int danio);
	abstract void recibirAtaque(Autobot atacante, int danio);
	abstract void recibirAtaque(Decepticon atacante, int danio);

}
