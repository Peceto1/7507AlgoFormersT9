package fiuba.algo3.view;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.Bonus;
import fiuba.algo3.model.arena.TerrenoAplicable;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.juego.Jugador;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.layouts.PanelAbajo;
import fiuba.algo3.view.layouts.PanelLateral;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;
import fiuba.algo3.view.vistas.VistaArena;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ContenedorJuego extends BorderPane {

    private Juego juego;
    private PanelLateral panelLateral;
    private PanelAbajo panelAbajo;
    private ScrollPane contenedorCentral;
    private Canvas canvasAlgoformers;
    private Canvas canvasBonuses;
    private VistaMapaAlgoformers vistaAlgoformers;
    private VistaMapaBonuses vistaBonuses;
    private VistaArena vistaArena;
    private Background fondoPaneles = new Background(new BackgroundFill(Color.web("#000f3d"), null, null));
    private String estiloNegro = "-fx-base: #474747;";
    private Text msjError;
    Algoformer algoformerSeleccionado;
    TerrenoAplicable terrenoSeleccionado;
    Bonus bonusSeleccionado;
    public Algoformer algoformerAccionado;
    ConvertidorPuntoAPixels conversor;


    public ContenedorJuego(Juego juego) {
        this.juego = juego;
        crearContenedorCentral();
        crearPanelLateral();
        crearPanelAbajo();
        this.conversor = new ConvertidorPuntoAPixels();
    }


    private void crearPanelLateral() {
        this.panelLateral = new PanelLateral(this, fondoPaneles);
        this.setLeft(panelLateral);
    }


    private void crearPanelAbajo() {
        this.panelAbajo = new PanelAbajo(this, fondoPaneles);
        this.setBottom(panelAbajo);
    }


    private void crearContenedorCentral() {
        this.contenedorCentral = new ScrollPane();
        StackPane contenedorCanvases = new StackPane();

        contenedorCanvases.setOnMouseClicked( (mouseEvent) -> {
            seleccionarCasillero(mouseEvent.getX(),mouseEvent.getY());
        } );

        this.canvasBonuses = new Canvas(2040, 2040);
        this.canvasAlgoformers = new Canvas(2040, 2040);

        this.vistaArena = new VistaArena(102, 51);
        this.vistaArena.dibujarArena();
        this.vistaBonuses = new VistaMapaBonuses(canvasBonuses);
        this.vistaBonuses.mostrar();

        this.vistaAlgoformers = new VistaMapaAlgoformers(canvasAlgoformers, juego);
        this.vistaAlgoformers.mostrar();

        contenedorCanvases.getChildren().addAll(vistaArena, canvasBonuses, canvasAlgoformers);
        contenedorCentral.setContent(contenedorCanvases);
        contenedorCentral.setStyle(estiloNegro);
        contenedorCentral.setPannable(true);
        contenedorCentral.setVvalue(0.5);   // Para que el scroll vertical arranque a la mitad
        this.setCenter(contenedorCentral);
    }

    private void seleccionarCasillero(double x, double y) {

        PuntoPixels parPixel = new PuntoPixels((int)x, (int)y);
        Punto ubicacion = conversor.reconvertir(parPixel);

        algoformerSeleccionado = Arena.getInstance().obtenerAlgoformerEn(ubicacion);
        terrenoSeleccionado = Arena.getInstance().devolverTerrenoEn(ubicacion);
        bonusSeleccionado = Arena.getInstance().devolverBonusEn(ubicacion);

    }

    public Text getMsjError() {
        return this.msjError;
    }


    public Juego getJuego() {
        return this.juego;
    }


    public PanelLateral getPanelLateral() {
        return this.panelLateral;
    }

	public PanelAbajo getPanelAbajo() {
		return this.panelAbajo;
	}

    public VistaMapaAlgoformers getVistaMapaAlgoformers() {
        return this.vistaAlgoformers;
    }


    public VistaMapaBonuses getVistaMapaBonuses() {
        return this.vistaBonuses;
    }


    public void setMsjError(Text msjError) {
        this.msjError = msjError;
    }


    public void setearAccionado() {
        this.algoformerAccionado = this.algoformerSeleccionado;
    }

    //METODO FEO
    public Jugador obtenerJugadorEnTurno(){
        return juego.getJugadorEnTurno();
    }
}
