package fiuba.algo3.controller;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.FueraDeRangoException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.utilities.ReproductorFX;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.vistasAlgoformers.VistaAlgoformer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class ClickearEnemigoHandler implements EventHandler<MouseEvent> {

    private Algoformer atacante;
    private ContenedorJuego contenedorJuego;
    private Text msjError;


    public ClickearEnemigoHandler(Algoformer atacante, ContenedorJuego contenedorJuego) {
        this.atacante = atacante;
        this.contenedorJuego = contenedorJuego;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

        this.msjError = contenedorJuego.getMsjError();

        ConvertidorPuntoAPixels conversor = new ConvertidorPuntoAPixels();
        PuntoPixels ubicacionPixelsAtacado = new PuntoPixels((int) mouseEvent.getX(), (int) mouseEvent.getY());
        Punto ubicacionAtacado = conversor.reconvertir(ubicacionPixelsAtacado);
        Algoformer algoformerAtacado = Arena.getInstance().obtenerAlgoformerEn(ubicacionAtacado);
        
        
        try {
            atacante.atacar(algoformerAtacado);
        } catch (NullPointerException e) {
            ReproductorFX.reproducirFX(ReproductorFX.ERROR1);
            msjError.setText("No hay algoformer para atacar");
            rehabilitarAcciones();
        }

        catch (FueraDeRangoException e) {
            ReproductorFX.reproducirFX(ReproductorFX.ERROR1);
            msjError.setText(e.devolverMensajeError());
            rehabilitarAcciones();
        }

        ReproductorFX.reproducirFX(ReproductorFX.ATTACKFX);

        if (algoformerAtacado != null && !algoformerAtacado.estaVivo()){
        	VistaMapaAlgoformers vistaMapaAlgoformers = contenedorJuego.getVistaMapaAlgoformers();
            VistaAlgoformer vistaAtacado = vistaMapaAlgoformers.getVista(algoformerAtacado);
        	vistaAtacado.limpiar(ubicacionPixelsAtacado.getX(),ubicacionPixelsAtacado.getY());
        }
    
        HBox contenedorTerminarTurno = (HBox) this.contenedorJuego.lookup("#ContenedorFinalizarTurno");
        contenedorTerminarTurno.setDisable(false);
        StackPane contenedorCanvases = (StackPane) contenedorJuego.lookup("#contenedorStackPane");
        contenedorCanvases.setOnMouseClicked(new ClickEnMapaHandler(contenedorJuego));
    }
    
    private void rehabilitarAcciones(){
    	HBox contenedorAcciones = (HBox) contenedorJuego.getPanelAbajo().lookup("#contenedorAcciones");
        VBox contenedorCombinarse = (VBox) contenedorJuego.getPanelAbajo().lookup("#contenedorCombinarseVBox");
         
         contenedorAcciones.setDisable(false);
         contenedorCombinarse.setDisable(false);
    }


}
