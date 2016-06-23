package fiuba.algo3.controller;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.FueraDeRangoException;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
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
            msjError.setText("No hay algoformer para atacar");
        }

        catch (FueraDeRangoException e) {
            msjError.setText(e.devolverMensajeError());
        }

        if (algoformerAtacado != null && !algoformerAtacado.estaVivo())
            System.out.println("Borrar Algoformer");

        // ToDo Borrar algoformer del mapa si murio
        // ToDo Deshabilitar boton finalizar turno para evitar que la Flasheada quede en estado invalido

        StackPane contenedorCanvases = (StackPane) contenedorJuego.lookup("#contenedorStackPane");
        contenedorCanvases.setOnMouseClicked(new ClickEnMapaHandler(contenedorJuego));
    }


}
