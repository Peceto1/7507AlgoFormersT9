package fiuba.algo3.view;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.eventos.ApplicationOnKeyHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ContenedorEleccionEquipos extends BorderPane {

    Stage stage;
    BarraDeMenu menuBar;
    Scene proximaEscena;
    Juego juego;
    VBox autobots;
    VBox decepticons;
    VBox panelCentro;

    ContenedorEleccionEquipos(Stage stage, Juego juego, BarraDeMenu menuBar, Scene proximaEscena) {
        this.stage = stage;
        this.menuBar = menuBar;
        this.proximaEscena = proximaEscena;
        this.proximaEscena.setOnKeyPressed(new ApplicationOnKeyHandler(stage, menuBar));
        this.juego = juego;
        setearBarraMenuTop();
        cargarImagenDeFondo();
        crearPanelAutobots();
        crearPanelDecepticons();
        crearPanelCentro();
    }


    private void setearBarraMenuTop() {
        this.setTop(menuBar);
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
        Button autobotsButton = new Button("", new ImageView(autobotsImage));
        autobots.getChildren().add(autobotsButton);
        autobots.setPadding(new Insets(0, 0, 0, 25));
        autobots.setAlignment(Pos.CENTER);
        this.setLeft(autobots);
    }


    private void crearPanelDecepticons() {
        decepticons = new VBox();
        Image decepticonsImage = new Image("file:src/fiuba/algo3/view/resources/images/teamDecepticons.jpg");
        Button decepticonsButton = new Button("", new ImageView(decepticonsImage));
        decepticons.getChildren().add(decepticonsButton);
        decepticons.setPadding(new Insets(0, 25, 0, 0));
        decepticons.setAlignment(Pos.CENTER);
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
        contenedorInput.setMaxWidth(200);
        contenedorInput.setPadding(new Insets(10, 0, 10, 0));
        contenedorInput.setStyle("-fx-background-color:\n" +
                "    linear-gradient(#686868 0%, #3b423b 25%, #505250 75%, #8f8f8f 100%);\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-background-radius: 9;");


        TextField nombreJugador = new TextField();
        nombreJugador.setPromptText("Ingrese su nombre");
        nombreJugador.setMaxWidth(150);


        GridPane formulario = new GridPane();
        formulario.setAlignment(Pos.CENTER_LEFT);
        formulario.setVgap(10);
        formulario.setHgap(10);
        formulario.setPadding(new Insets(5, 5, 5, 10));

        Text jugador = new Text("Jugador 1");
        jugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text informacion = new Text("Elija un equipo");
        informacion.setFont(Font.font("Tahoma", FontWeight.LIGHT, 12));
        formulario.add(jugador, 0, 0);
        formulario.add(nombreJugador, 0, 1);
        formulario.add(informacion, 0, 2);

        contenedorInput.getChildren().addAll(formulario);

        panelCentro.getChildren().addAll(versusImageView, espacio, contenedorInput);
        panelCentro.setAlignment(Pos.TOP_CENTER);
        this.setCenter(panelCentro);
    }


}
