package fiuba.algo3.model;

public abstract class Algoformer {
	String nombre;
	int vida;
	Estado estadoActual;
	Estado alterno;
	
	public Algoformer(String nombre,int vida, Estado estado, Estado alterno){
		this. nombre = nombre;
		this.vida = vida;
		this.estadoActual = estado;
		this.alterno = alterno;
	}
	
	public void mover(){
		estadoActual.mover();
	}
	
	public void atacar(Algoformer otro){
		estadoActual.atacar(otro);
	}
	
	public void perderVida(int cantidad){
		vida = vida-cantidad;
	}
	
	public void transformarse(){
		Estado trancision = estadoActual;
		this.estadoActual = alterno;
		this.alterno = trancision;
	}
}
