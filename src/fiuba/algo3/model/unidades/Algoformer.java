package fiuba.algo3.model.unidades;

import fiuba.algo3.model.arena.*;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAireNoPuedeAscenderException;
import fiuba.algo3.model.espacio.PuntoTierraNoPuedeDescenderException;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.*;


public abstract class Algoformer {

	String nombre;
	int vida;
	int vidaMax;
	Estado estado;
	Chispa chispa;
	Punto ubicacion;
	List<Efecto> efectos;
	boolean tiene_burbuja;
	SimpleIntegerProperty vidaProperty;


	Algoformer(String nombre, int vida, Estado estado) {
		this.nombre = nombre;
		this.vida = vida;
		this.vidaMax = vida;
		this.estado = estado;
		this.efectos = new LinkedList<>();
		this.tiene_burbuja = false;
		this.vidaProperty = new SimpleIntegerProperty(this.vida);
	}

	
	public String getNombre() {
		return this.nombre;
	}


	public int getVida() {
		return this.vida;
	}


	public int getVidaMax(){
		return this.vidaMax;
	}


	public int getAtk(){
		return estado.ataque;
	}

	
	public int getSpd(){
		return estado.velocidad;
	}

	
	public int getRange(){
		return estado.rango;
	}


	public int getMovimientosRestantes() {
		return this.estado.movimiento.getMovimientosRestantes();
	}


	public SimpleIntegerProperty vidaProperty() {
		return this.vidaProperty;
	}


	void setChispa() {
		if (!Arena.getInstance().contieneChispa(ubicacion)){
			throw new ImposibleCapturarChispaException();
		}
		chispa = Arena.getInstance().obtenerChispa(ubicacion);
	}


	public Punto getUbicacion() {
		return this.ubicacion;
	}


	public void setUbicacion(Punto ubicacion) {
		this.ubicacion = ubicacion;
	}


	public boolean estaVivo() {
		return (this.vida > 0);
	}


	public boolean tieneChispa() {
		return (this.chispa != null);
	}


	public void capturarChispa() {
		this.estado.capturarChispa(this);
	}

	
	Estado getEstado() {
		return this.estado;
	}


	void setEstado(Estado nuevo) {
		this.estado = nuevo;
	}


	public void moverseHacia(Direccion direccion) {
		if (!estaVivo())
			throw new MovimientoNoValidoException();
		ubicacion = estado.moverse(direccion);
	}


	public void reiniciarMovimiento() {
		this.estado.reiniciarMovimiento(this.ubicacion);
	}


	public void transformarse() {
		this.estado.transformar(this);
	}


	public void recibirDanio(int danio){
		this.vida = vida - danio;
		this.vidaProperty().set(this.vida);
	}


	public void perderUnMovimiento() {
		estado.perderUnMovimiento();	
	}

	
	List<Algoformer> obtenerAlgoformersAdyacentesDelMismoEquipo(){
		Arena arena = Arena.getInstance();
		List<Punto> puntosAdyacentesAlAlgoformer;

		try {
			puntosAdyacentesAlAlgoformer = ubicacion.obtenerAdyacentes();
		} catch (PuntoAireNoPuedeAscenderException e) {
			throw new EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException();
		}

		List<Algoformer> algoformersAdyacentes = arena.obtenerAlgoformersEn(puntosAdyacentesAlAlgoformer);

		// Filtro por equipo
		ListIterator<Algoformer> iter = algoformersAdyacentes.listIterator();
		while (iter.hasNext()) {
			Algoformer algoformerAdyacente = iter.next();

			if (!this.esLealA(algoformerAdyacente))
				iter.remove();
		}

		if (algoformersAdyacentes.size() < 2)
			throw new NoHaySuficientesAlgoformersAdyacentesException();

		return algoformersAdyacentes;
	}


	List<Punto> obtenerPuntosAdyacentesLibres(List<Punto> adyacentes) {

		Arena arena = Arena.getInstance();

		Iterator<Punto> iter = adyacentes.iterator();
		while (iter.hasNext()) {
			Punto actual = iter.next();

			if (arena.estaOcupado(actual))
				iter.remove();
		}

		return adyacentes;
	}


	public void agregarEfecto(Efecto efecto) {
		efectos.add(efecto);
	}


	public void aplicarEfectos() {
		Iterator<Efecto> iter = efectos.listIterator();

		while (iter.hasNext()){
			Efecto actual = iter.next();
			actual.actualizar();
			actual.aplicarSobre(this);

			if (actual.LlegoElContadorDeTurnosRestantesACero())
				iter.remove();
		}
	}


	public void limpiarEfectos(){
		Iterator<Efecto> iter = efectos.listIterator();
		
		while (iter.hasNext()){
			Efecto actual = iter.next();
			if (!actual.EsPermanente())
				iter.remove();
		}
		desactivarBurbuja();
		resetearStats();
	}


	public boolean contieneEfecto(Efecto efecto) {
		return efectos.contains(efecto);
	}


	public void removerEfecto(Efecto efecto) {
		efectos.remove(efecto);
	}


	public void aplicarEfecto(EfectoTormentaPsionica efecto) {
		estado.aplicarEfecto(efecto);
	}


	public void aplicarEfecto(EfectoDobleCanon efecto) {
		estado.aplicarEfecto(efecto);
	}


	public void aplicarEfecto(EfectoFlash efecto) {
		estado.aplicarEfecto(efecto);
	}


	public void aplicarEfecto(EfectoNebulosaDeAndromeda efecto) {
		this.estado.perderTurno();
	}


	public void aplicarEfecto(EfectoBurbujaInmaculada efectoBurbujaInmaculada) {
		this.tiene_burbuja=true;
	}


	public List<Algoformer> separarse() {
		throw new NoPuedeSepararseException();
	}


	void transformarAlternosAHumanoide(List<Algoformer> miembros) {

		Arena arena = Arena.getInstance();

		for (Algoformer miembro : miembros){
			arena.ubicarTemporalmente(miembro, arena.lugarInicialLibre());
			try {
				pasarAHumanoide(miembro);
				// En caso de que sea volador
			} catch (PuntoTierraNoPuedeDescenderException e) {
				Punto puntoTierra = miembro.getUbicacion();
				Punto puntoAire = puntoTierra.ascender();
				arena.ubicarAlgoformer(miembro, puntoAire);
				arena.removerAlgoformerEn(puntoTierra);
				miembro.reiniciarMovimiento();
				miembro.transformarse();
			}
			arena.removerAlgoformerEn(miembro.getUbicacion());
		}
	}


	void removerMuertos(List<Algoformer> miembros) {
		Iterator<Algoformer> iter = miembros.iterator();

		while (iter.hasNext()) {
			Algoformer actual = iter.next();

			if (!actual.estaVivo())
				iter.remove();
		}
	}


	void distribuirDanioEntreMiembros(List<Algoformer> miembros) {

		int dmgTotal = this.vidaMax - this.vida;
		int dmgParcial = dmgTotal/miembros.size();

		for (Algoformer miembro : miembros)
			miembro.recibirDanio(dmgParcial);
	}


	void pasarAHumanoide(Algoformer algoformer) {
		algoformer.estado.pasarAHumanoide(algoformer);
	}


	public void resetearStats() {
		estado.resetearEstado();
	}


	public void desactivarBurbuja() {
		this.tiene_burbuja = false;
	}


	public abstract Algoformer combinarse();
	public abstract void atacar(Algoformer atacado);
	abstract void recibirAtaque(Autobot atacante, int danio);
	abstract void recibirAtaque(Decepticon atacante, int danio);
	abstract Boolean esLealA(Algoformer algoformer);
	abstract Boolean esLealA(Autobot algoformer);
	abstract Boolean esLealA(Decepticon algoformer);
}
