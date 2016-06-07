package fiuba.algo3.model.unidades;


import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.espacio.PuntoAireNoPuedeAscenderException;

import java.util.List;

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
    public void combinarse() {
        Arena arena = Arena.getInstance();

        try {
            List<Punto> puntosAdyacentesAlAutobot = ubicacion.obtenerAdyacentes();
        } catch (PuntoAireNoPuedeAscenderException e) {
            throw new EstadoAlternoNoPuedeDarLaOrdenDeCombinarseException();
        }

        /*List<Autobot> autobotsAdyacentes = arena.obtenerAutobots(puntosAdyacentesAlAutobot);

        if (autobotsAdyacentes.size() < 2)
            throw new NoHaySuficientesAlgoformersAdyacentesException();

        Autobot autobot1 = autobotsAdyacentes.get(0);
        Autobot autobot2 = autobotsAdyacentes.get(1);

        this.estado.combinarse(this, autobot1, autobot2);*/
    }


    @Override
    void recibirAtaque(Autobot otro,int danio) {

    }


    @Override
    void recibirAtaque(Decepticon otro,int danio) {
    	recibirDanio(danio);
    }
    
}
