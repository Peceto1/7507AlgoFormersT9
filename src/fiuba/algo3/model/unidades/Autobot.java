package fiuba.algo3.model.unidades;

import java.util.List;

class Autobot extends Algoformer {


    Autobot(String nombre, int vida, Estado estado) {
        super(nombre, vida, estado);
    }


    @Override
    public void atacar(Algoformer atacado) {

    	if (!estado.puedeAtacar(atacado, ubicacion))
    		throw new FueraDeRangoException();

    	this.estado.atacar(atacado, this);	
    }


    @Override
    void recibirAtaque(Autobot otro,int danio) {

    }


    @Override
    void recibirAtaque(Decepticon otro,int danio) {
        recibirDanio(danio);
    }


    @Override
    Boolean esLealA(Algoformer algoformer) {
        return algoformer.esLealA(this);
    }


    @Override
    Boolean esLealA(Autobot algoformer) {
        return true;
    }


    @Override
    Boolean esLealA(Decepticon algoformer) {
        return false;
    }
    
    @Override
    public void combinarse(){
    	List<Algoformer> listaDeAlgoformers = obtenerAlgoformersAdyacentesDelMismoEquipo();
    	Algoformer algoformer1 = listaDeAlgoformers.get(0);
    	Algoformer algoformer2 = listaDeAlgoformers.get(1);
    			
    	estado.combinarse(this, (Autobot)algoformer1, (Autobot) algoformer2);
    	
    }
    
}
