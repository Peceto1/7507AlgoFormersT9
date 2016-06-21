package fiuba.algo3.view;

import fiuba.algo3.controller.MoverAlgoformerDerechaHandler;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.vistas.VistaArena;
import fiuba.algo3.view.vistas.VistaMapaAlgoformers;
import javafx.geometry.Insets;
import fiuba.algo3.view.vistas.VistaBonuses;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ContenedorJuego extends BorderPane {

    Juego juego;
    VBox panelLateral;
    HBox panelAbajo;
    ScrollPane contenedorCentral;
    Canvas canvasAlgoformers;
    Canvas canvasBonuses;
    VistaMapaAlgoformers vistaAlgoformers;
    VistaBonuses vistaBonuses;
    VistaArena vistaArena;
    Background fondoPaneles = new Background(new BackgroundFill(Color.web("#000f3d"), null, null));
    String estiloNegro = "-fx-base: #474747;";
    Text msjError;


    public ContenedorJuego(Juego juego) {
        this.juego = juego;
        crearContenedorCentral();
        crearPanelLateral();
        crearPanelAbajo();
    }


    private void crearPanelLateral() {
        this.panelLateral = new VBox();
        panelLateral.setBackground(fondoPaneles);
        panelLateral.setMinWidth(180);
        panelLateral.setMaxWidth(180);
        this.setLeft(panelLateral);
        dibujarInformacionDeTurno();
        dibujarInformacionDeErrores();
        dibujarBloqueStatsSeleccionado();
        dibujarBloqueTerrenoYBonus();
        dibujarBloqueAlgoformers();
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
        this.vistaBonuses = new VistaBonuses(canvasBonuses);
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


    public void dibujarInformacionDeTurno() {
        VBox panelInformacion = new VBox();
        panelInformacion.setSpacing(10);
        panelInformacion.setPadding(new Insets(10, 0, 5, 10));

        panelInformacion.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: black;");

        Label informacionJugador = new Label();
        informacionJugador.setId("infoJugador");
        informacionJugador.setTextFill(Color.ANTIQUEWHITE);
        informacionJugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        Label informacionTurno = new Label();
        informacionTurno.setId("infoTurno");
        informacionTurno.setTextFill(Color.ANTIQUEWHITE);
        informacionTurno.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        Label informacionEquipo = new Label();
        informacionEquipo.setId("infoEquipo");
        informacionEquipo.setTextFill(Color.ANTIQUEWHITE);
        informacionEquipo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));


        String nombreJug = juego.getJugadorEnTurno().getNombre();
        String equipoJug = juego.getJugadorEnTurno().getEquipo();
        String numeroTurno = Integer.toString(juego.getTurno());

        informacionJugador.setText("Jugador: " + nombreJug);
        informacionTurno.setText("Turno: " + numeroTurno);
        informacionEquipo.setText("Equipo: " + equipoJug);

        panelInformacion.getChildren().addAll(informacionJugador, informacionEquipo, informacionTurno);
        this.panelLateral.getChildren().addAll(panelInformacion);
    }


    private void dibujarInformacionDeErrores() {

        VBox contenedorErrores = new VBox(15);
        contenedorErrores.setPadding(new Insets(15, 0, 0, 10));
        contenedorErrores.setMinHeight(50);
        contenedorErrores.setMaxHeight(50);
        Label titulo = new Label("Información");
        titulo.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        titulo.setTextFill(Color.ANTIQUEWHITE);

        this.msjError = new Text("");
        msjError.setFill(Color.RED);
        msjError.setFont(Font.font("Tahoma", FontPosture.ITALIC, 14));
        msjError.setWrappingWidth(150);
        msjError.setId("msjErrorText");

        VBox espacio = new VBox();
        espacio.setMinHeight(90);
        espacio.setMaxHeight(90);

        contenedorErrores.getChildren().addAll(titulo, msjError);
        this.panelLateral.getChildren().addAll(contenedorErrores, espacio);
    }


    private void dibujarBloqueStatsSeleccionado() {
        VBox contenedorStats = new VBox();
        contenedorStats.setSpacing(10);
        contenedorStats.setPadding(new Insets(0, 0, 0, 10));

        VBox imagen = new VBox();
        imagen.setMinHeight(100);
        imagen.setMaxHeight(100);
        imagen.setMinWidth(100);
        imagen.setMaxWidth(100);
        imagen.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        imagen.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(3, 3, 3, 3))));
        imagen.setAlignment(Pos.CENTER);

        Text vida = new Text("Vida: ");
        vida.setFill(Color.ANTIQUEWHITE);
        Text ataque = new Text("Ataque: ");
        ataque.setFill(Color.ANTIQUEWHITE);
        Text velocidad = new Text("Velocidad: ");
        velocidad.setFill(Color.ANTIQUEWHITE);

        Text cantVida = new Text("100");
        cantVida.setFill(Color.ANTIQUEWHITE);
        cantVida.setStyle("-fx-font-weight: bold;");
        cantVida.setId("statVidaText");
        Text cantAtaque = new Text("15");
        cantAtaque.setFill(Color.ANTIQUEWHITE);
        cantAtaque.setStyle("-fx-font-weight: bold;");
        cantAtaque.setId("statAtkText");
        Text cantVelocidad = new Text("2");
        cantVelocidad.setFill(Color.ANTIQUEWHITE);
        cantVelocidad.setStyle("-fx-font-weight: bold;");
        cantVelocidad.setId("statSpdText");

        GridPane grillaStats = new GridPane();

        grillaStats.addRow(0, vida, cantVida);
        grillaStats.addRow(1, ataque, cantAtaque);
        grillaStats.addRow(2, velocidad, cantVelocidad);

        contenedorStats.getChildren().addAll(imagen, grillaStats);
        this.panelLateral.getChildren().add(contenedorStats);
    }


    private void dibujarBloqueTerrenoYBonus() {
        VBox contenedorTerrenoYBonus = new VBox();
        contenedorTerrenoYBonus.setPadding(new Insets(20, 0, 10, 10));

        GridPane grillaTerrenoYBonus = new GridPane();

        Text terreno = new Text("Terreno: ");
        terreno.setFill(Color.ANTIQUEWHITE);
        Text bonus = new Text("Bonus: ");
        bonus.setFill(Color.ANTIQUEWHITE);

        Text tipoTerreno = new Text("Un terreno");
        tipoTerreno.setFill(Color.ANTIQUEWHITE);
        tipoTerreno.setStyle("-fx-font-weight: bold;");
        tipoTerreno.setId("tipoTerrenoText");
        Text tipoBonus = new Text("Un bonus");
        tipoBonus.setFill(Color.ANTIQUEWHITE);
        tipoBonus.setStyle("-fx-font-weight: bold;");
        tipoBonus.setId("tipoBonusText");

        grillaTerrenoYBonus.addRow(0, terreno, tipoTerreno);
        grillaTerrenoYBonus.addRow(1, bonus, tipoBonus);
        contenedorTerrenoYBonus.getChildren().add(grillaTerrenoYBonus);
        this.panelLateral.getChildren().add(contenedorTerrenoYBonus);
    }


    private void dibujarBloqueAlgoformers() {
        VBox contenedorImagenesAlgoformers = new VBox();
        contenedorImagenesAlgoformers.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: black;");

        contenedorImagenesAlgoformers.setPadding(new Insets(20, 0, 0, 30));

        // ToDO separar en funcion aparte la carga de los profile de los Algoformers

        VBox profileOptimus = new VBox();
        profileOptimus.setMinHeight(50);
        profileOptimus.setMinWidth(50);
        profileOptimus.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        profileOptimus.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 1, 1, 1))));

        VBox profileBumblebee = new VBox();
        profileBumblebee.setMinHeight(50);
        profileBumblebee.setMinWidth(50);
        profileBumblebee.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        profileBumblebee.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 1, 1, 1))));

        VBox profileRatchet = new VBox();
        profileRatchet.setMinHeight(50);
        profileRatchet.setMinWidth(50);
        profileRatchet.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        profileRatchet.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 1, 1, 1))));

        VBox profileMegatron = new VBox();
        profileMegatron.setMinHeight(50);
        profileMegatron.setMinWidth(50);
        profileMegatron.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        profileMegatron.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 1, 1, 1))));

        VBox profileBonecrusher = new VBox();
        profileBonecrusher.setMinHeight(50);
        profileBonecrusher.setMinWidth(50);
        profileBonecrusher.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        profileBonecrusher.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 1, 1, 1))));

        VBox profileFrenzy = new VBox();
        profileFrenzy.setMinHeight(50);
        profileFrenzy.setMinWidth(50);
        profileFrenzy.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        profileFrenzy.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 1, 1, 1))));

        GridPane grillaAlgoformers = new GridPane();
        grillaAlgoformers.setHgap(10);
        grillaAlgoformers.setVgap(10);
        grillaAlgoformers.addColumn(0, profileOptimus, profileBumblebee, profileRatchet);
        grillaAlgoformers.addColumn(1, profileMegatron, profileBonecrusher, profileFrenzy);

        contenedorImagenesAlgoformers.getChildren().add(grillaAlgoformers);
        this.panelLateral.getChildren().add(contenedorImagenesAlgoformers);
    }


    private void dibujarBloqueBotones() {
        HBox contenedorAcciones = new HBox();
        contenedorAcciones.setPadding(new Insets(25, 0, 0, 250));
        HBox contenedorDirecciones = new HBox();
        contenedorDirecciones.setPadding(new Insets(5, 0, 0, 10));
        contenedorDirecciones.setVisible(false);
        GridPane grillaBotonesAcciones = new GridPane();
        GridPane grillaBotonesDirecciones = new GridPane();

        Button moveButton = new Button("Mover");
        moveButton.setMinSize(150, 25);
        moveButton.setMaxSize(150, 25);
        moveButton.setStyle(estiloNegro);
        moveButton.setOnAction( (actionEvent) -> {
            contenedorDirecciones.setVisible(true);
            moveButton.setDisable(true);
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

        // ToDo separar en una funcion aparte la carga de los botones...

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

        rightButton.setOnAction(new MoverAlgoformerDerechaHandler(this.vistaAlgoformers, this.vistaBonuses, this));

        grillaBotonesAcciones.addColumn(0, moveButton, atkButton);
        grillaBotonesAcciones.addColumn(1, transformButton, captureButton);
        grillaBotonesAcciones.setHgap(10);
        grillaBotonesAcciones.setVgap(10);

        grillaBotonesDirecciones.add(upButton, 1, 0);
        //.add(movRestantes, 1, 1);
        grillaBotonesDirecciones.add(leftButton, 0, 1);
        grillaBotonesDirecciones.add(downButton, 1, 2);
        grillaBotonesDirecciones.add(rightButton, 2, 1);

        contenedorAcciones.getChildren().add(grillaBotonesAcciones);
        contenedorDirecciones.getChildren().add(grillaBotonesDirecciones);

        this.panelAbajo.getChildren().addAll(contenedorAcciones, contenedorDirecciones);
    }


    public Text getMsjError() {
        return this.msjError;
    }


    public VBox getPanelLateral() {
        return this.panelLateral;
    }


}
