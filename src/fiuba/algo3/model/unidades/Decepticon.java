package fiuba.algo3.model.unidades;

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
    public void combinarse() {
        // Falta implementar
    }


    @Override
    void recibirAtaque(Decepticon otro,int danio) {

    }


    @Override
    void recibirAtaque(Autobot otro, int danio) {
    	this.vida = this.vida - danio;
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

}
