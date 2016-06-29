package fiuba.algo3.view;

import fiuba.algo3.controller.BotonComenzarBatallaHandler;
import fiuba.algo3.controller.ElegirAutobotsHandler;
import fiuba.algo3.controller.ElegirDecepticonsHandler;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.utilities.ReproductorFX;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class ContenedorEleccionEquipos extends BorderPane {

    VentanaDefault ventanaDefault;
    VBox autobots;
    VBox decepticons;
    VBox panelCentro;
    VBox panelAbajo;
    TextField nombreJugador;
    Text nroJugador;
    Label msjError;
    Button autobotsButton;
    Button decepticonsButton;
    Button botonComenzarBatalla;
    Juego juego;

    public ContenedorEleccionEquipos(VentanaDefault ventanaDefault, Juego juego) {
        this.ventanaDefault = ventanaDefault;
        this.juego = juego;
        cargarImagenDeFondo();
        crearPanelCentro();
        crearPanelAutobots();
        crearPanelDecepticons();
        this.ventanaDefault.setOnKeyPressed(new ErrorAlPresionarEnterHandler());
    }


    private void cargarImagenDeFondo() {
        Image battleImage = new Image("file:src/fiuba/algo3/view/resources/images/teamSelection.jpg");
        BackgroundImage fondoCentro = new BackgroundImage(battleImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoCentro);
        this.setBackground(fondo);
    }


    private void crearPanelAutobots() {
        autobots = new VBox();
        Image autobotsImage = new Image("file:src/fiuba/algo3/view/resources/images/teamAutobots.jpg");
        this.autobotsButton = new Button("ELEGIR AUTOBOTS", new ImageView(autobotsImage));
        autobotsButton.setContentDisplay(ContentDisplay.BOTTOM);
        autobotsButton.setFocusTraversable(false);
        autobotsButton.setStyle("-fx-font: 20 tahoma;-fx-font-weight: bold;-fx-base: #474747;");
        autobotsButton.setOnAction(new ElegirAutobotsHandler(juego, nombreJugador, autobotsButton, msjError, nroJugador, panelAbajo, ventanaDefault));
        autobots.getChildren().add(autobotsButton);
        autobots.setPadding(new Insets(0, 0, 0, 25));
        autobots.setAlignment(Pos.CENTER);
        autobotsButton.setMinSize(320, 645);
        autobotsButton.setMaxSize(320, 645);
        this.setLeft(autobots);
    }


    private void crearPanelDecepticons() {
        decepticons = new VBox();
        Image decepticonsImage = new Image("file:src/fiuba/algo3/view/resources/images/teamDecepticons.jpg");
        this.decepticonsButton = new Button("ELEGIR DECEPTICONS", new ImageView(decepticonsImage));
        decepticonsButton.setContentDisplay(ContentDisplay.BOTTOM);
        decepticonsButton.setFocusTraversable(false);
        decepticonsButton.setStyle("-fx-font: 20 tahoma;-fx-font-weight: bold;-fx-base: #474747;");
        decepticonsButton.setOnAction(new ElegirDecepticonsHandler(juego, nombreJugador, decepticonsButton, msjError, nroJugador, panelAbajo, ventanaDefault));
        decepticons.getChildren().add(decepticonsButton);
        decepticons.setPadding(new Insets(0, 25, 0, 0));
        decepticons.setAlignment(Pos.CENTER);
        decepticonsButton.setMinSize(320, 645);
        decepticonsButton.setMaxSize(320, 645);
        this.setRight(decepticons);
    }


    private void crearPanelCentro() {
        panelCentro = new VBox();
        Image versusImage = new Image("file:src/fiuba/algo3/view/resources/images/vs.png");
        ImageView versusImageView = new ImageView(versusImage);
        versusImageView.setPreserveRatio(true);
        versusImageView.setFitWidth(200);

        VBox espacio = new VBox();
        espacio.setAlignment(Pos.CENTER);
        espacio.setPadding(new Insets(200, 0, 0, 0));

        VBox contenedorInput = new VBox();
        contenedorInput.setAlignment(Pos.CENTER);
        contenedorInput.setSpacing(10);
        contenedorInput.setMaxWidth(235);
        contenedorInput.setPadding(new Insets(10, 0, 10, 0));
        contenedorInput.setStyle("-fx-background-color:\n" +
                "    linear-gradient(#686868 0%, #3b423b 25%, #505250 75%, #8f8f8f 100%);\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-background-radius: 9;");


        this.nombreJugador = new TextField();
        nombreJugador.setPromptText("Ingrese su nombre");
        nombreJugador.setMaxWidth(150);
        nombreJugador.setFocusTraversable(false);

        // NO PERMITO TEXTOS MAYORES A 10 CARACTERES
        nombreJugador.lengthProperty().addListener( (observable, oldValue, newValue) -> {
                if (newValue.intValue() > oldValue.intValue()) {

                    if (nombreJugador.getText().length() >= 10)
                        nombreJugador.setText(nombreJugador.getText().substring(0, 10));
                }
            });

        Button botonLimpiar = new Button("Limpiar");
        botonLimpiar.setStyle("-fx-font: 10 arial; -fx-base: #b6e7c9;");

        botonLimpiar.setOnAction( (actionEvent) -> {
            nombreJugador.clear();
            nombreJugador.requestFocus();
        } );


        GridPane formulario = new GridPane();
        formulario.setAlignment(Pos.TOP_CENTER);
        formulario.setVgap(10);
        formulario.setHgap(8);
        formulario.setPadding(new Insets(5, 10, 5, 10));

        this.nroJugador = new Text("Jugador 1");
        nroJugador.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        nroJugador.setFill(Color.ANTIQUEWHITE);
        Text informacion = new Text("Elija un equipo");
        informacion.setFont(Font.font("Tahoma", FontWeight.LIGHT, 12));
        informacion.setFill(Color.ANTIQUEWHITE);
        formulario.add(nroJugador, 0, 0);
        formulario.add(nombreJugador, 0, 1);
        formulario.add(informacion, 0, 2);
        formulario.add(botonLimpiar, 1, 2);

        this.msjError = new Label("");
        msjError.setAlignment(Pos.CENTER);
        msjError.setTextAlignment(TextAlignment.CENTER);
        msjError.setTextFill(Color.web("#9f0000"));
        msjError.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        msjError.setMinSize(100, 30);
        msjError.setWrapText(true);

        contenedorInput.getChildren().addAll(formulario, msjError);

        this.panelAbajo = new VBox(20);
        this.panelAbajo.setPadding(new Insets(40, 0, 0, 0));
        this.panelAbajo.setAlignment(Pos.CENTER);

        VBox panelElecciones = new VBox();
        panelElecciones.setSpacing(0);
        panelElecciones.setAlignment(Pos.CENTER);
        panelElecciones.setId("eleccionesVBox");

        this.botonComenzarBatalla = new Button("Comenzar Batalla");
        this.botonComenzarBatalla.setStyle("-fx-font: 24 arial; -fx-base: #64a500;");
        this.botonComenzarBatalla.setVisible(false);
        this.botonComenzarBatalla.setId("botonComenzarBatalla");
        this.botonComenzarBatalla.setOnAction(new BotonComenzarBatallaHandler(ventanaDefault, juego, botonComenzarBatalla));

        this.panelAbajo.getChildren().addAll(panelElecciones, botonComenzarBatalla);

        panelCentro.getChildren().addAll(versusImageView, espacio, contenedorInput, panelAbajo);
        panelCentro.setAlignment(Pos.TOP_CENTER);
        this.setCenter(panelCentro);
        botonLimpiar.requestFocus();
    }


    private class ErrorAlPresionarEnterHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent keyEvent) {

            if (!keyEvent.getCode().equals(KeyCode.ENTER))
                return;

            ReproductorFX.reproducirFX(ReproductorFX.ERROR1);
            msjError.setText("Ingrese su nombre y luego seleccione un equipo");
        }

    }
}
