package fiuba.algo3.view;

import fiuba.algo3.view.eventos.OpcionSalirEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


public class ContenedorInicio extends BorderPane {

    Stage stage;
    Scene proximaEscena;
    Button botonJugar;
    Button botonSalir;
    ToggleButton botonMute;
    ImageView imagenMute;
    ImageView imagenUnMute;

    public ContenedorInicio(Stage stage, Scene proximaEscena) {

        this.stage = stage;
        this.proximaEscena = proximaEscena;
        cargarImagenDeFondo();
        cargarImagenesBotones();
        crearBotones();
        cargarMusicaDeFondo();
    }


    private void cargarImagenDeFondo() {
        Image transformersImage = new Image("file:src/fiuba/algo3/view/resources/images/inicio.jpg");
        BackgroundImage fondoInicio = new BackgroundImage(transformersImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoInicio);
        this.setBackground(fondo);
    }


    private void crearBotones() {

        VBox botonesCentro = new VBox();
        botonesCentro.setAlignment(Pos.CENTER);
        botonesCentro.setSpacing(20);
        this.setCenter(botonesCentro);

        VBox botonesAbajo = new VBox();
        botonesAbajo.setAlignment(Pos.BOTTOM_RIGHT);
        this.setBottom(botonesAbajo);

        botonJugar = new Button();
        botonJugar.setText("JUGAR");
        botonJugar.setPadding(new Insets(15, 15, 15, 15));
        botonJugar.setOnAction(new OpcionJugarEventHandler(this.stage, this.proximaEscena));
        botonJugar.requestFocus();
        botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setOnAction(new OpcionSalirEventHandler());


        botonesCentro.getChildren().addAll(botonJugar, botonSalir);
        botonesAbajo.getChildren().add(botonMute);
    }


    private void cargarImagenesBotones() {
        Image imagen = new Image("file:src/fiuba/algo3/view/resources/images/unmute.png");
        imagenUnMute = new ImageView(imagen);
        botonMute = new ToggleButton("", imagenUnMute);
        botonMute.setStyle("-fx-background-color: transparent;");

        Image imagen2 = new Image("file:src/fiuba/algo3/view/resources/images/mute.png");
        imagenMute = new ImageView(imagen2);
    }


    private void cargarMusicaDeFondo() {

        String musicFile = "src/fiuba/algo3/view/resources/sounds/inicioMusic.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        botonMute.setOnAction(new OpcionMuteEventHandler(mediaPlayer));
    }


    private class OpcionMuteEventHandler implements EventHandler<ActionEvent> {

        MediaPlayer mediaPlayer;

        OpcionMuteEventHandler(MediaPlayer mediaPlayer) {
            this.mediaPlayer = mediaPlayer;
        }

        @Override
        public void handle(ActionEvent actionEvent) {

            if (!mediaPlayer.isMute()) {
                this.mediaPlayer.setMute(true);
                botonMute.setGraphic(imagenMute);
            }

            else {
                this.mediaPlayer.setMute(false);
                botonMute.setGraphic(imagenUnMute);
            }
        }

    }


    private class OpcionJugarEventHandler implements EventHandler<ActionEvent> {

        Stage stage;
        Scene escenaJuego;

        OpcionJugarEventHandler(Stage stage, Scene escenaJuego) {
            this.stage = stage;
            this.escenaJuego = escenaJuego;
        }


        @Override
        public void handle(ActionEvent actionEvent) {
            this.stage.setScene(escenaJuego);
            this.stage.setFullScreen(true);
        }

    }

}
