package fiuba.algo3.controller.HandlersMovimiento;


import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

abstract class HandlerMovimiento implements EventHandler<ActionEvent> {

    private VistaMapaAlgoformers vistaMapaAlgoformers;
    private VistaMapaBonuses vistaMapaBonuses;
    private ContenedorJuego contenedorJuego;
    private Text msjError;

    public HandlerMovimiento(ContenedorJuego contenedorJuego){
        this.vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
        this.vistaMapaBonuses = contenedorJuego.getVistaMapaBonuses();
        this.contenedorJuego = contenedorJuego;
        this.msjError = contenedorJuego.getMsjError();
    }

    public void handle(ActionEvent actionEvent) {

        //Algoformer algoformerAMoverse; //Ver como conseguirlo

        //AlgoformerPool pool = AlgoformerPool.getInstance();
        //Algoformer bumblebee = pool.obtenerBumblebee();


        Algoformer algoformerAMoverse = this.contenedorJuego.algoformerSeleccionado;

        if (algoformerAMoverse == null){
            return;
        }

        PuntoPixels ubicacionPixelVieja = this.vistaMapaAlgoformers.getVista(algoformerAMoverse).getUbicacion();

        try {
            algoformerAMoverse.moverseHacia(obtenerDireccion());
        } catch (MovimientoNoValidoException e) {
            this.msjError.setText("No se puede mover");
            return;
        }

        Punto ubicacionNueva = algoformerAMoverse.getUbicacion();
        VistaAlgoformer a = this.vistaMapaAlgoformers.getVista(algoformerAMoverse);

        a.actualizar(ubicacionPixelVieja.getX(), ubicacionPixelVieja.getY());

        //
        this.msjError.setText("");
        vistaMapaBonuses.actualizar(ubicacionNueva);
    }

    abstract Direccion obtenerDireccion();

}
