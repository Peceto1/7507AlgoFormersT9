package fiuba.algo3.model.unidades;

public abstract class Algoformer {

	protected String nombre;
	protected int vida;
	protected Estado estado;


	Algoformer(String nombre, int vida, Estado estado) {
		this.nombre = nombre;
		this.vida = vida;
		this.estado = estado;
	}


	Estado getEstado() {
		return this.estado;
	}


	void setEstado(Estado nuevo) {
		this.estado = nuevo;
	}


	public void mover() {
		estado.mover();
	}


	public void transformarse() {
		this.estado.transformar(this);
	}


	public void atacar(Algoformer otro) {
		this.estado.atacar(otro);
	}


	abstract void recibirAtaque(Autobot otro);
	abstract void recibirAtaque(Decepticon otro);
}
