package fiuba.algo3.model.arena;

import fiuba.algo3.model.espacio.*;
import fiuba.algo3.model.unidades.Algoformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Arena {

    private Map<Punto, Casillero> arena;
    private List<Punto> puntosDeInicioDecepticons;
    private List<Punto> puntosDeInicioAutobots;
    private final int ANCHO = 51;
    private final int ALTO = 51;
    private static Arena instancia = new Arena();
    private Random random = new Random();


    private Arena() {
        this.arena = new HashMap<>();
    }

    public void inicializar() {

        for (int i = 1; i <= ANCHO; i++) {
            for (int j = 1; j <= ALTO; j++) {

                Punto puntoTierra = new PuntoTierra(i, j);
                Casillero casilleroTierra = new Casillero(new Rocoso());
                arena.put(puntoTierra, casilleroTierra);

                Punto puntoAire = new PuntoAire(i, j);
                Casillero casilleroAire = new Casillero(new Nube());
                arena.put(puntoAire, casilleroAire);
            }
        }
        
        puntosDeInicioDecepticons = new ArrayList<>();
        puntosDeInicioAutobots = new ArrayList<>();
        
        puntosDeInicioAutobots.add(new PuntoTierra(1, 25));
        puntosDeInicioAutobots.add(new PuntoTierra(1, 26));
        puntosDeInicioAutobots.add(new PuntoTierra(1, 27));
        
        puntosDeInicioDecepticons.add(new PuntoTierra(51, 27));
        puntosDeInicioDecepticons.add(new PuntoTierra(51, 26));
        puntosDeInicioDecepticons.add( new PuntoTierra(51, 25));
    }


    public int getAncho() {
        return this.ANCHO;
    }


    public int getAlto() {
        return this.ALTO;
    }


    public static Arena getInstance(){
        return instancia;
    }
    
    public void setTerrenoAleatorio(){
    	List<Punto> puntosASetearTerreno = new ArrayList<Punto>(arena.keySet());
    	puntosASetearTerreno.removeAll(puntosDeInicioAutobots);
    	puntosASetearTerreno.removeAll(puntosDeInicioDecepticons);
    	for(Punto actual: puntosASetearTerreno)
    		if (actual.obtenerNivel()==1)
    		setTerrenoAleatorioEnPuntoAire(actual);
    		else
    			setTerrenoAleatorioEnPuntoTierra(actual);
    }    

	private void setTerrenoAleatorioEnPuntoAire(Punto punto) {
		CreadorDeTerrenoAleatorio factoryTerrenos = new CreadorDeTerrenoAleatorio(this.random);
		arena.get(punto).setTerreno(factoryTerrenos.crearTerrenoAereoAleatorio());
	}
	
	private void setTerrenoAleatorioEnPuntoTierra(Punto punto) {
		CreadorDeTerrenoAleatorio factoryTerrenos = new CreadorDeTerrenoAleatorio(this.random);
		arena.get(punto).setTerreno(factoryTerrenos.crearTerrenoTerrestreAleatorio());
	}
    
    public void setBonusAleatorio(){
    	List<Punto> puntosASetearTerreno = new ArrayList<Punto>(arena.keySet());
    	puntosASetearTerreno.removeAll(puntosDeInicioAutobots);
    	puntosASetearTerreno.removeAll(puntosDeInicioDecepticons);
    	CreadorDeBonusAleatorio factoryBonus = new CreadorDeBonusAleatorio(this.random);
    	for(Punto actual: puntosASetearTerreno)
    		arena.get(actual).setBonus(factoryBonus.crearBonusAleatorio());
    }
    
    public void setChispaAleatorio(Punto posicionChispa){
    	obtenerChispa(posicionChispa);
    	Punto nuevaPosicionChispa = new PuntoTierra(26, random.nextInt(ALTO));
    	colocarChispa(nuevaPosicionChispa);
    }


	public void colocarChispa(Punto punto) {
        Casillero casilla_media = arena.get(punto);
        casilla_media.colocar(new Chispa());
    }

    
    public boolean contieneChispa(Punto punto){
    	Casillero buscado = arena.get(punto);
    	return buscado.contieneChispa();
    }

    
	public Chispa obtenerChispa(Punto punto) {
		Casillero buscado = arena.get(punto);
		return buscado.removerChispa();
	}


    public Boolean estaEnArena(Punto punto){
    	return arena.containsKey(punto);
    }


    public Boolean estaOcupado(Punto punto){
    	Casillero aRevisar = arena.get(punto);
    	return aRevisar.estaOcupado();
    }


    public void ubicarAlgoformer(Algoformer algoformer, Punto punto) {

        if (estaOcupado(punto))
            return;

        arena.get(punto).colocar(algoformer);
        algoformer.setUbicacion(punto);
    }

    
    public void setTerrenoEnPunto(Punto punto, TerrenoAplicable terreno){
    	arena.get(punto).setTerreno(terreno);
    }
    
    public void setBonusEnPunto(Punto punto, Bonus bonus){
    	arena.get(punto).setBonus(bonus);
    }


    public Algoformer removerAlgoformerEn(Punto punto) {
        return arena.get(punto).removerAlgoformer();
    }


    public Algoformer obtenerAlgoformerEn(Punto actual) {
        return arena.get(actual).obtenerAlgoformer();
    }


    public List<Algoformer> obtenerAlgoformersEn(List<Punto> puntos) {

        List<Algoformer> algoformers = new ArrayList<>();

        for (Punto actual : puntos) {
            Algoformer algoformer = obtenerAlgoformerEn(actual);

            if (algoformer != null)
                algoformers.add(algoformer);
        }

        return algoformers;
    }
        
    public Punto lugarInicialLibre(){

    	for (Punto punto: puntosDeInicioAutobots){
    		if (!estaOcupado(punto))
    			return punto;
    	}

    	for (Punto punto: puntosDeInicioDecepticons){
    		if (!estaOcupado(punto))
    			return punto;
    	}

    	return null;
    }

    
    public void ubicarTemporalmente(Algoformer algoformerAUbicar, Punto lugar){
    	this.ubicarAlgoformer(algoformerAUbicar, lugar);
    	algoformerAUbicar.reiniciarMovimiento();
    }
    
    public TerrenoAplicable devolverTerrenoEn(Punto punto){
    	Casillero casilleroDelPunto = arena.get(punto);
    	return casilleroDelPunto.getTerreno();
    	
    }

}
