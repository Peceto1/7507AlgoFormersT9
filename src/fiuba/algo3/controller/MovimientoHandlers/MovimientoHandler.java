package fiuba.algo3.controller.MovimientoHandlers;


import fiuba.algo3.model.espacio.Direccion;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.MovimientoNoValidoException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

abstract class MovimientoHandler implements EventHandler<ActionEvent> {

    private VistaMapaAlgoformers vistaMapaAlgoformers;
    private VistaMapaBonuses vistaMapaBonuses;
    private ContenedorJuego contenedorJuego;
    private Text msjError;


    public MovimientoHandler(ContenedorJuego contenedorJuego){
        this.vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
        this.vistaMapaBonuses = contenedorJuego.getVistaMapaBonuses();
        this.contenedorJuego = contenedorJuego;
        this.msjError = contenedorJuego.getMsjError();
    }


    public void handle(ActionEvent actionEvent) {

        Algoformer algoformerAMoverse = this.contenedorJuego.getAlgoformerAccionado();
        PuntoPixels ubicacionPixelVieja = this.vistaMapaAlgoformers.getVista(algoformerAMoverse).getUbicacion();

        try {
            algoformerAMoverse.moverseHacia(obtenerDireccion());
        } catch (MovimientoNoValidoException e) {
            this.msjError.setText(e.devolverMensajeError());
            return;
        }

        actualizarMovimientosRestantes(algoformerAMoverse);

        Punto ubicacionNueva = algoformerAMoverse.getUbicacion();
        
        
        VistaAlgoformer vistaAlgoformerAMover = this.vistaMapaAlgoformers.getVista(algoformerAMoverse);
        vistaAlgoformerAMover.actualizar(ubicacionPixelVieja.getX(), ubicacionPixelVieja.getY());

        
        limpiarMsjError();
        vistaMapaBonuses.actualizar(ubicacionNueva);
        contenedorJuego.actualizarStatsLateral(algoformerAMoverse.getUbicacion());
        if (!algoformerAMoverse.estaVivo()){//muerte por espinas
        	limpiarAlgoformerDePantalla(ubicacionNueva,algoformerAMoverse);
        }
    }


    private void actualizarMovimientosRestantes(Algoformer algoformerAMoverse) {
        Label movRestantes = (Label) contenedorJuego.getPanelAbajo().lookup("#movRestantesLabel");

        if (algoformerAMoverse.getMovimientosRestantes() < 0)
            movRestantes.setText("0");

        else
            movRestantes.setText(Integer.toString(algoformerAMoverse.getMovimientosRestantes()));
    }


    private void limpiarMsjError() {
        this.msjError.setText("");
    }
    
    protected void limpiarAlgoformerDePantalla(Punto ubicacion, Algoformer algoformer){
    	ConvertidorPuntoAPixels conversor = new ConvertidorPuntoAPixels();
        PuntoPixels ubicacionPixelsNueva = conversor.convertir(ubicacion);
    	VistaMapaAlgoformers vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
        VistaAlgoformer vistaAlgoformer = vistaMapaAlgoformers.getVista(algoformer);
    	vistaAlgoformer.limpiar(ubicacionPixelsNueva.getX(),ubicacionPixelsNueva.getY());
    }


    abstract Direccion obtenerDireccion();
}
