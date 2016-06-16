package fiuba.algo3.model.arena;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreadorDeBonusAleatorio {
	Random random;
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
	
	CreadorDeBonusAleatorio(Random random){
		this.random =random;
	}
	
	public Bonus crearBonusAleatorio(){
		int indice = random.nextInt(bonuses.size());
		return bonuses.get(indice).crearBonus();
	}

}
