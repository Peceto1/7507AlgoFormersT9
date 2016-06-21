package fiuba.algo3.view;

import fiuba.algo3.controller.MoverAlgoformerDerechaHandler;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.layouts.PanelLateral;
import fiuba.algo3.view.vistas.VistaArena;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ContenedorJuego extends BorderPane {

    private Juego juego;
    private VBox panelLateral;
    private HBox panelAbajo;
    private ScrollPane contenedorCentral;
    private Canvas canvasAlgoformers;
    private Canvas canvasBonuses;
    private VistaMapaAlgoformers vistaAlgoformers;
    private VistaMapaBonuses vistaBonuses;
    private VistaArena vistaArena;
    private Background fondoPaneles = new Background(new BackgroundFill(Color.web("#000f3d"), null, null));
    private String estiloNegro = "-fx-base: #474747;";
    private Text msjError;


    public ContenedorJuego(Juego juego) {
        this.juego = juego;
        crearContenedorCentral();
        crearPanelLateral();
        crearPanelAbajo();
    }


    private void crearPanelLateral() {
        this.panelLateral = new PanelLateral(this, fondoPaneles);
        this.setLeft(panelLateral);
    }


    private void crearPanelAbajo() {
        this.panelAbajo = new HBox(10);
        panelAbajo.setBackground(fondoPaneles);
        panelAbajo.setMinHeight(120);
        panelAbajo.setMaxHeight(120);
        this.setBottom(panelAbajo);
        dibujarBloqueBotones();
    }


    private void crearContenedorCentral() {
        this.contenedorCentral = new ScrollPane();
        StackPane contenedorCanvases = new StackPane();

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


    private void dibujarBloqueBotones() {
        HBox contenedorAcciones = new HBox();
        contenedorAcciones.setPadding(new Insets(25, 0, 0, 250));
        HBox contenedorDirecciones = new HBox();
        contenedorDirecciones.setPadding(new Insets(5, 0, 0, 10));
        contenedorDirecciones.setVisible(false);
        GridPane grillaBotonesAcciones = new GridPane();
        grillaBotonesAcciones.setHgap(10);
        grillaBotonesAcciones.setVgap(10);
        GridPane grillaBotonesDirecciones = new GridPane();

        crearBotonesDeAcciones(contenedorAcciones, grillaBotonesAcciones, contenedorDirecciones);
        crearBotonesDeDirecciones(grillaBotonesDirecciones);

        contenedorAcciones.getChildren().add(grillaBotonesAcciones);
        contenedorDirecciones.getChildren().add(grillaBotonesDirecciones);
        this.panelAbajo.getChildren().addAll(contenedorAcciones, contenedorDirecciones);
    }


    private void crearBotonesDeAcciones(HBox contenedorAcciones, GridPane grillaBotonesAcciones, HBox contenedorDirecciones) {

        Button moveButton = new Button("Mover");
        moveButton.setMinSize(150, 25);
        moveButton.setMaxSize(150, 25);
        moveButton.setStyle(estiloNegro);

        moveButton.setOnAction( (actionEvent) -> {
            contenedorDirecciones.setVisible(true);
            contenedorAcciones.setDisable(true);
        } );

        Button atkButton = new Button("Atacar");
        atkButton.setMinSize(150, 25);
        atkButton.setMaxSize(150, 25);
        atkButton.setStyle(estiloNegro);
        Button transformButton = new Button("Transformar");
        transformButton.setMinSize(150, 25);
        transformButton.setMaxSize(150, 25);
        transformButton.setStyle(estiloNegro);
        Button captureButton = new Button("Capturar Chispa");
        captureButton.setMinSize(150, 25);
        captureButton.setMaxSize(150, 25);
        captureButton.setStyle(estiloNegro);

        grillaBotonesAcciones.addColumn(0, moveButton, atkButton);
        grillaBotonesAcciones.addColumn(1, transformButton, captureButton);
    }


    private void crearBotonesDeDirecciones(GridPane grillaBotonesDirecciones) {

        Image upImage = new Image("file:src/fiuba/algo3/view/resources/images/up.png");
        ImageView upImageView = new ImageView(upImage);
        upImageView.setPreserveRatio(true);
        upImageView.setFitWidth(25);
        Button upButton = new Button("", upImageView);

        Image leftImage = new Image("file:src/fiuba/algo3/view/resources/images/left.png");
        ImageView leftImageView = new ImageView(leftImage);
        leftImageView.setPreserveRatio(true);
        leftImageView.setFitWidth(25);
        Button leftButton = new Button("", leftImageView);

        Image downImage = new Image("file:src/fiuba/algo3/view/resources/images/down.png");
        ImageView downImageView = new ImageView(downImage);
        downImageView.setPreserveRatio(true);
        downImageView.setFitWidth(25);
        Button downButton = new Button("", downImageView);

        Image rightImage = new Image("file:src/fiuba/algo3/view/resources/images/right.png");
        ImageView rightImageView = new ImageView(rightImage);
        rightImageView.setPreserveRatio(true);
        rightImageView.setFitWidth(25);
        Button rightButton = new Button("", rightImageView);

        rightButton.setOnAction(new MoverAlgoformerDerechaHandler(this));

        grillaBotonesDirecciones.add(upButton, 1, 0);
        //.add(movRestantes, 1, 1);     ToDo agregar movimientos restantes
        grillaBotonesDirecciones.add(leftButton, 0, 1);
        grillaBotonesDirecciones.add(downButton, 1, 2);
        grillaBotonesDirecciones.add(rightButton, 2, 1);

    }


    public Text getMsjError() {
        return this.msjError;
    }


    public Juego getJuego() {
        return this.juego;
    }


    public VBox getPanelLateral() {
        return this.panelLateral;
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
}
