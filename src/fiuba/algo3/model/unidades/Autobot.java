package fiuba.algo3.model.unidades;

public abstract class Autobot extends Algoformer {


    Autobot(String nombre, int vida, Estado estado) {
        super(nombre, vida, estado);
    }

    @Override
    void recibirAtaque(Autobot otro) {
        System.out.println("No pasa nada, friendly-fire");
    }


    @Override
    void recibirAtaque(Decepticon otro) {
        System.out.println("Decepticon ataca a Autobot");
    }

}
