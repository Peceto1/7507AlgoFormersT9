package fiuba.algo3.model.arena;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreadorDeBonusAleatorio {
	private static CreadorDeBonusAleatorio instancia = new CreadorDeBonusAleatorio();
	private Random random = new Random();
	private List<CreadorDeBonus> bonuses = Arrays.asList(
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorNullBonus(),
			new CreadorDeBurbujaInmaculada(),
			new CreadorDeDobleCanon(),
			new CreadorDeFlash());
	//Ajustar repeticion de NullBonus para controlar la 
	//cantidad de bonuses que parecen en el mapa
	
	static CreadorDeBonusAleatorio getInstance(){
		return instancia;
	}
	
	public Bonus crearBonusAleatorio(){
		int indice = random.nextInt(bonuses.size());
		return bonuses.get(indice).crearBonus();
	}

}
