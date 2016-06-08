package fiuba.algo3.model.unidades;

import java.util.List;

public class Decepticon extends Algoformer {


    Decepticon(String nombre, int vida, Estado estado) {
        super(nombre, vida, estado);
    }


    @Override
    public void atacar(Algoformer atacado) {

    	if (!estado.puedeAtacar(atacado, ubicacion))
    		throw new FueraDeRangoException();

        this.estado.atacar(atacado, this);
    }


    @Override
    void recibirAtaque(Decepticon otro,int danio) {

    }


    @Override
    void recibirAtaque(Autobot otro, int danio) {
    	recibirDanio(danio);
    }


    @Override
    Boolean esLealA(Algoformer algoformer) {
        return algoformer.esLealA(this);
    }


    @Override
    Boolean esLealA(Autobot algoformer) {
        return false;
    }


    @Override
    Boolean esLealA(Decepticon algoformer) {
        return true;
    }

    @Override
    public void combinarse(){
    	List<Algoformer> listaDeAlgoformers = nombre();
    	Algoformer algoformer1 = listaDeAlgoformers.get(0);
    	Algoformer algoformer2 = listaDeAlgoformers.get(1);
    			
    	estado.combinarse(this, (Decepticon)algoformer1, (Decepticon) algoformer2);
    	
    }
    
}
