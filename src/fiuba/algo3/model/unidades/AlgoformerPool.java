package fiuba.algo3.model.unidades;

import java.util.HashMap;
import java.util.Map;

public class AlgoformerPool {

	private static Map<String, Algoformer> mapa = new HashMap<>();
	private static AlgoformerPool instancia = new AlgoformerPool();
	
	private String OPTIMUS = "Optimus Prime";
	private String BUMBLEBEE = "Bumblebee";
	private String RATCHET = "Ratchet";
	private String MEGATRON = "Megatron";
	private String FRENZY = "Frenzy";
	private String BONECRUSHER = "Bonecrusher";
	
	
	private AlgoformerPool(){
		this.inicializar();
	}
	
	public void inicializar(){

		mapa.put(OPTIMUS, new Autobot(OPTIMUS, 500, OptimusPrimeAlterno.getInstance()));
		mapa.put(BUMBLEBEE,new Autobot(BUMBLEBEE,350,BumblebeeAlterno.getInstance()));
		mapa.put(RATCHET, new Autobot(RATCHET, 150, RatchetAlterno.getInstance()));
		mapa.put(MEGATRON,new Decepticon(MEGATRON,550, MegatronAlterno.getInstance()));
		mapa.put(FRENZY,new Decepticon(FRENZY, 400, FrenzyAlterno.getInstance()));
		mapa.put(BONECRUSHER, new Decepticon(BONECRUSHER,200,BoneCrusherAlterno.getInstance()));
		
	}


	static AlgoformerPool getInstance(){
		return instancia;
	}

	
	public Algoformer obtenerOptimus(){
		return mapa.get(OPTIMUS);	
	}


	public Algoformer obtenerBumblebee(){
		return mapa.get(BUMBLEBEE);	
	}


	public Algoformer obtenerRatchet(){
		return mapa.get(RATCHET);
	}

		
	public Algoformer obtenerMegatron(){
		return mapa.get(MEGATRON);	
	}


	public Algoformer obtenerFrenzy(){
		return mapa.get(FRENZY);	
	}


	public Algoformer obtenerBonecrusher(){
		return mapa.get(BONECRUSHER);	
	}
	
}
