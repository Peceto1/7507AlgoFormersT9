package fiuba.algo3.model.unidades;

public class EstadoEnEspera extends Estado {
	
	private static EstadoEnEspera instancia = new EstadoEnEspera();
	
	private EstadoEnEspera(){
		ataque = 0;
		rango = 0;
		velocidad = 0;
	}
	
	static EstadoEnEspera getInstance(){
		return instancia;
	}

	@Override
	void transformar(Algoformer algoformer) {
		// TODO Auto-generated method stub
		throw new ModoEnEsperaNoSeTransformaException();
	}

	@Override
	void capturarChispa(Algoformer captor) {
		// TODO Auto-generated method stub
		throw new ImposibleCapturarChispaException();
	}

	@Override
	void combinarse(Algoformer otro1, Algoformer otro2) {
		// TODO Auto-generated method stub
		throw new ModoEsperaNoPuedeCombinarseException();
	}
}
