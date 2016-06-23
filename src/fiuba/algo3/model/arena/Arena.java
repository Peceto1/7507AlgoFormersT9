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
    private Punto ubicacionChispa = new PuntoTierra(26,26);
    private Random random = new Random();
    private static final int CANTIDAD_TRAMPAS = (2000);
    private static final int CANTIDAD_BONUS = (100);


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
    
    public static Arena getInstance(){
        return instancia;
    }

    public int getAncho() {
        return this.ANCHO;
    }
    
    public Punto getUbicacionChispa(){
    	return this.ubicacionChispa;
    }


    public int getAlto() {
        return this.ALTO;
    }
    
	public Chispa getChispa() {
		return arena.get(ubicacionChispa).verChispa();
	}
    
    public void setTerrenoAleatorio(){
    	List<Punto> puntosASetearTerreno = new ArrayList<>(arena.keySet());
    	
    	for (Punto puntoActual: puntosDeInicioAutobots){
    		puntosASetearTerreno.remove(puntoActual);
    		puntosASetearTerreno.remove(puntoActual.ascender());
    	}
    	for (Punto puntoActual: puntosDeInicioDecepticons){
    		puntosASetearTerreno.remove(puntoActual);
    		puntosASetearTerreno.remove(puntoActual.ascender());
    	}
    	puntosASetearTerreno.remove(ubicacionChispa);
    	puntosASetearTerreno.remove(ubicacionChispa.ascender());
    	
    	for (int i=0; i<CANTIDAD_TRAMPAS;i++){
    		Punto puntoElegido = puntosASetearTerreno.get(random.nextInt(puntosASetearTerreno.size()));
    		if (puntoElegido.obtenerNivel()==1)
    	    	setTerrenoAleatorioEnPuntoAire(puntoElegido);
    	    else
    	    	setTerrenoAleatorioEnPuntoTierra(puntoElegido);
    	}

    }    

	private void setTerrenoAleatorioEnPuntoAire(Punto punto) {
		int indice = random.nextInt(2);
		if (indice == 0){
			setTerrenoEnPunto(punto,new NebulosaDeAndromeda());
			return;
		}
		setTerrenoEnPunto(punto,new TormentaPsionica());
		
	}
	
	private void setTerrenoAleatorioEnPuntoTierra(Punto punto) {
		int indice = random.nextInt(2);
		if (indice == 0){
			setTerrenoEnPunto(punto,new Espinas());
			return;
		}
		setTerrenoEnPunto(punto,new Pantano());	
	}
	
    public void setTerrenoEnPunto(Punto punto, TerrenoAplicable terreno){
    	arena.get(punto).setTerreno(terreno);
    }
    
    
    public void setBonusAleatorio(){
    	List<Punto> puntosASetearBonus = new ArrayList<>(arena.keySet());
    	
    	for (Punto puntoActual: puntosDeInicioAutobots){
    		puntosASetearBonus.remove(puntoActual);
    		puntosASetearBonus.remove(puntoActual.ascender());
    	}
    	for (Punto puntoActual: puntosDeInicioDecepticons){
    		puntosASetearBonus.remove(puntoActual);
    		puntosASetearBonus.remove(puntoActual.ascender());
    	}
    	puntosASetearBonus.remove(ubicacionChispa);
    	puntosASetearBonus.remove(ubicacionChispa.ascender());
    	
    	for (int i=0; i<CANTIDAD_BONUS;i++){
    		Punto puntoElegido = puntosASetearBonus.get(random.nextInt(puntosASetearBonus.size()));
    		setBonusAleatorioEnPunto(puntoElegido);
    	}
    }
    
    private void setBonusAleatorioEnPunto(Punto punto){
    	int indice = random.nextInt(3);
		
		if (indice == 0){
			setBonusEnPunto(punto,new BonusBurbujaInmaculada());
			return;
		}
		if (indice == 1){
		setBonusEnPunto(punto,new BonusFlash());
		return;
		}
		setBonusEnPunto(punto,new BonusDobleCanon());
    }
    
    public void setBonusEnPunto(Punto punto, Bonus bonus){
    	arena.get(punto).setBonus(bonus);
    }
    
    public Punto setChispaAleatorio(){
    	obtenerChispa(ubicacionChispa);
    	Punto nuevaPosicionChispa = new PuntoTierra(26, random.nextInt(ALTO+1));
    	setTerrenoEnPunto(nuevaPosicionChispa,new Rocoso());
    	colocarChispa(nuevaPosicionChispa);
    	this.ubicacionChispa = nuevaPosicionChispa;
    	return nuevaPosicionChispa;
    }

    public void colocarChispa(){
    	Casillero casilla_media = arena.get(ubicacionChispa);
        casilla_media.colocar(new Chispa());
    }

	public void colocarChispa(Punto punto) {
        Casillero casilla_media = arena.get(punto);
        casilla_media.colocar(new Chispa());
        this.ubicacionChispa = punto;
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


    public Bonus devolverBonusEn(Punto punto) {
        Casillero casillero = arena.get(punto);
        return casillero.getBonus();
    }
}
