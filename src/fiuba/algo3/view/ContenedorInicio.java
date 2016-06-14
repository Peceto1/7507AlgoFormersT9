package fiuba.algo3.view;

import fiuba.algo3.view.eventos.OpcionSalirEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorInicio extends VBox {

    Stage stage;
    Scene proximaEscena;
    Button botonJugar;
    Button botonSalir;

    public ContenedorInicio(Stage stage, Scene proximaEscena) {

        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.setAlignment(Pos.CENTER);
        cargarImagenDeFondo();
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
        botonJugar = new Button();
        botonJugar.setText("JUGAR");
        botonJugar.requestFocus();
        botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setOnAction(new OpcionSalirEventHandler());

        this.setSpacing(20);

        this.getChildren().addAll(botonJugar, botonSalir);
    }


    private void cargarMusicaDeFondo() {

        String musicFile = "src/fiuba/algo3/view/resources/sounds/inicioMusic.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }


}
