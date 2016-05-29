package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.Chispa;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;


public abstract class Algoformer {

	protected String nombre;
	protected int vida;
	protected Estado estado;
	protected Chispa chispa = null;
	protected Punto posicion;
	protected Movimiento movimiento;

	Algoformer(String nombre, int vida, Estado estado) {
		this.nombre = nombre;
		this.vida = vida;
		this.estado = estado;
	}
	
	String getNombre(){
		return this.nombre;
	}


	int getVida(){
		return this.vida;
	}


	void setChispa(Chispa chispa) {
		this.chispa = chispa;
	}


	boolean estaVivo(){
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


	public void mover(Direccion direccion) {
		estado.mover(direccion);
	}


	public void transformarse() {
		this.estado.transformar(this);
	}


	public abstract void atacar(Algoformer atacado);
	abstract void recibirAtaque(Algoformer atacante,int danio);
	abstract void recibirAtaque(Autobot atacante,int danio);
	abstract void recibirAtaque(Decepticon atacante,int danio);

}
