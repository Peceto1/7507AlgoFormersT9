package fiuba.algo3.model.unidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgoformerPool {

	private static Map<String, Autobot> autobots = new HashMap<>();
	private static Map<String, Decepticon> decepticons = new HashMap<>();
	private static Map<String, List<Algoformer>> equipos = new HashMap<>();
	private static AlgoformerPool instancia = new AlgoformerPool();

	
	private String OPTIMUS = "Optimus Prime";
	private String BUMBLEBEE = "Bumblebee";
	private String RATCHET = "Ratchet";
	private String MEGATRON = "Megatron";
	private String FRENZY = "Frenzy";
	private String BONECRUSHER = "Bonecrusher";


	public void inicializar(){

		autobots.put(OPTIMUS, new Autobot(OPTIMUS, 500, OptimusPrimeHumanoide.getInstance()));
		autobots.put(BUMBLEBEE, new Autobot(BUMBLEBEE, 350, BumblebeeHumanoide.getInstance()));
		autobots.put(RATCHET, new Autobot(RATCHET, 150, RatchetHumanoide.getInstance()));
		decepticons.put(MEGATRON, new Decepticon(MEGATRON, 550, MegatronHumanoide.getInstance()));
		decepticons.put(FRENZY, new Decepticon(FRENZY, 400, FrenzyHumanoide.getInstance()));
		decepticons.put(BONECRUSHER, new Decepticon(BONECRUSHER, 200, BoneCrusherHumanoide.getInstance()));
		equipos.put("AUTOBOTS", new ArrayList<>(autobots.values()));
		equipos.put("DECEPTICONS", new ArrayList<>(decepticons.values()));

		resetearEstados();
	}

	private void resetearEstados() {
		OptimusPrimeHumanoide.getInstance().resetearEstado();
		OptimusPrimeAlterno.getInstance().resetearEstado();
		RatchetHumanoide.getInstance().resetearEstado();
		RatchetAlterno.getInstance().resetearEstado();
		BumblebeeAlterno.getInstance().resetearEstado();
		BumblebeeHumanoide.getInstance().resetearEstado();
		MegatronHumanoide.getInstance().resetearEstado();
		MegatronAlterno.getInstance().resetearEstado();
		FrenzyHumanoide.getInstance().resetearEstado();
		FrenzyAlterno.getInstance().resetearEstado();
		BoneCrusherHumanoide.getInstance().resetearEstado();
		BoneCrusherAlterno.getInstance().resetearEstado();
	}


	public static AlgoformerPool getInstance(){
		return instancia;
	}

	
	public Algoformer obtenerOptimus(){
		return autobots.get(OPTIMUS);
	}


	public Algoformer obtenerBumblebee(){
		return autobots.get(BUMBLEBEE);
	}


	public Algoformer obtenerRatchet(){
		return autobots.get(RATCHET);
	}

		
	public Algoformer obtenerMegatron(){
		return decepticons.get(MEGATRON);
	}


	public Algoformer obtenerFrenzy(){
		return decepticons.get(FRENZY);
	}


	public Algoformer obtenerBonecrusher(){
		return decepticons.get(BONECRUSHER);
	}


	public List<Algoformer> obtenerEquipo(String equipo) {
		return equipos.get(equipo);
	}
}
