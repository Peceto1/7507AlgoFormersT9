package fiuba.algo3.model.unidades;

public abstract class Autobot extends Algoformer {


    Autobot(String nombre, int vida, Estado estado) {
        super(nombre, vida, estado);
    }


    @Override
    public void atacar(Algoformer atacado) {
        this.estado.atacar(atacado, this);
    }


    @Override
    void recibirAtaque(Algoformer atacante,int danio) {
        this.recibirAtaque(atacante,danio);
    }


    @Override
    void recibirAtaque(Autobot otro,int danio) {
        System.out.println("No pasa nada, friendly-fire Autobot-Autobot");
    }


    @Override
    void recibirAtaque(Decepticon otro,int danio) {
    	vida = vida-danio;
        System.out.println("Decepticon ataca a Autobot");
    }

}
