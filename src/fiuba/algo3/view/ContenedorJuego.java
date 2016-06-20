package fiuba.algo3.view;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.vistas.VistaArena;
import fiuba.algo3.view.vistas.VistaMapaAlgoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ContenedorJuego extends BorderPane {

    Juego juego;
    VBox panelLateral;
    HBox panelAbajo;
    ScrollPane contenedorCentral;
    Canvas canvasAlgoformers;
    Canvas canvasBonuses;
    Background fondoPaneles = new Background(new BackgroundFill(Color.web("#000f3d"), null, null));
    String estiloNegro = "-fx-base: #474747;";


    public ContenedorJuego(Juego juego) {
        this.juego = juego;
        crearPanelLateral();
        crearPanelAbajo();
        crearContenedorCentral();
        //pruebaDibujar();
    }


    private void crearPanelLateral() {
        this.panelLateral = new VBox();
        panelLateral.setBackground(fondoPaneles);
        panelLateral.setMinWidth(160);
        this.setLeft(panelLateral);
    }


    private void crearPanelAbajo() {
        this.panelAbajo = new HBox();
        panelAbajo.setBackground(fondoPaneles);
        panelAbajo.setMinHeight(115);
        this.setBottom(panelAbajo);
    }


    private void crearContenedorCentral() {
        this.contenedorCentral = new ScrollPane();
        StackPane contenedorCanvases = new StackPane();
        VistaArena vistaArena = new VistaArena(102, 51);

        this.canvasBonuses = new Canvas(2040, 2040);
        this.canvasAlgoformers = new Canvas(2040, 2040);

        contenedorCanvases.getChildren().addAll(vistaArena, canvasBonuses, canvasAlgoformers);
        contenedorCentral.setContent(contenedorCanvases);
        contenedorCentral.setStyle(estiloNegro);
        contenedorCentral.setPannable(true);
        contenedorCentral.setVvalue(0.5);   // Para que el scroll vertical arranque a la mitad
        this.setCenter(contenedorCentral);
    }


    private void pruebaDibujar() {
        GraphicsContext gcBonuses = this.canvasBonuses.getGraphicsContext2D();
        gcBonuses.setFill(Color.GREEN);
        gcBonuses.fillRect(40, 20, 40, 20);
        GraphicsContext gcAlgoformers = this.canvasAlgoformers.getGraphicsContext2D();
        gcAlgoformers.setFill(Color.YELLOW);
        gcAlgoformers.fillOval(60, 30, 10, 10);
    }


}
