package fiuba.algo3.view;

import fiuba.algo3.controller.MoverAlgoformerDerechaHandler;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.vistas.VistaArena;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import fiuba.algo3.view.vistas.VistaMapaBonuses;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    VistaMapaAlgoformers vistaAlgoformers;
    VistaMapaBonuses vistaBonuses;
    VistaArena vistaArena;
    Background fondoPaneles = new Background(new BackgroundFill(Color.web("#000f3d"), null, null));
    String estiloNegro = "-fx-base: #474747;";


    public ContenedorJuego(Juego juego) {
        this.juego = juego;
        crearContenedorCentral();
        crearPanelLateral();
        crearPanelAbajo();
        //pruebaDibujar();
    }


    private void crearPanelLateral() {
        this.panelLateral = new VBox();
        panelLateral.setBackground(fondoPaneles);
        panelLateral.setMinWidth(160);
        this.setLeft(panelLateral);
        dibujarInformacionDeTurno();
        dibujarInformacionDeErrores();
    }


    private void crearPanelAbajo() {
        this.panelAbajo = new HBox();
        panelAbajo.setBackground(fondoPaneles);
        panelAbajo.setMinHeight(115);
        this.setBottom(panelAbajo);


        Button moverse = new Button("Mover Derecha");
        moverse.setOnAction(new MoverAlgoformerDerechaHandler(this.vistaAlgoformers, this.vistaBonuses));
        panelAbajo.getChildren().add(moverse);
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


    private void pruebaDibujar() {
        GraphicsContext gcBonuses = this.canvasBonuses.getGraphicsContext2D();
        gcBonuses.setFill(Color.GREEN);
        gcBonuses.fillRect(40, 20, 40, 20);
        GraphicsContext gcAlgoformers = this.canvasAlgoformers.getGraphicsContext2D();
        gcAlgoformers.setFill(Color.YELLOW);
        gcAlgoformers.fillOval(60, 30, 10, 10);
    }


    public void dibujarInformacionDeTurno() {
        VBox panelInformacion = new VBox();
        panelInformacion.setSpacing(10);
        panelInformacion.setPadding(new Insets(10, 0, 5, 10));
        double ancho = this.getLeft().getLayoutBounds().getWidth();
        panelInformacion.setMinWidth(ancho);
        panelInformacion.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 5;" +
                "-fx-border-color: black;");


        Label informacionJugador = new Label();
        Label informacionTurno = new Label();
        Label informacionEquipo = new Label();

        String nombreJug = juego.getJugadorEnTurno().getNombre();
        String equipoJug = juego.getJugadorEnTurno().getEquipo();
        String numeroTurno = Integer.toString(juego.getTurno());

        informacionJugador.setText("Jugador: " + nombreJug); //Agregar nombre de jugadores.
        informacionJugador.setStyle("-fx-base: #474747;");

        informacionTurno.setStyle("-fx-base: #474747;");
        informacionTurno.setText("Turno: " + numeroTurno);

        informacionEquipo.setStyle("-fx-base: #474747;");
        informacionEquipo.setText("Equipo: " + equipoJug);

        panelInformacion.getChildren().addAll(informacionJugador, informacionEquipo, informacionTurno);
        this.panelLateral.getChildren().addAll(panelInformacion);
    }


    private void dibujarInformacionDeErrores() {

    }


}
