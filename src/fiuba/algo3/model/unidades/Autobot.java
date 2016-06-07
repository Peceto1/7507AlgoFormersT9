package fiuba.algo3.model.unidades;


public class Autobot extends Algoformer {


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
    
}
