package fiuba.algo3.model.unidades;

public class EstadoProto extends Estado {
	
	private static EstadoProto instancia = new EstadoProto();
	
	private EstadoProto(){
		ataque = 0;
		rango = 0;
		velocidad = 0;
	}
	
	static EstadoProto getInstance(){
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
