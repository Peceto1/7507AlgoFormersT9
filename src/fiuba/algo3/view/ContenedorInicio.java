package fiuba.algo3.view;

import fiuba.algo3.view.eventos.BotonJugarEventHandler;
import fiuba.algo3.view.eventos.EntrarConTeclaEnterHandler;
import fiuba.algo3.view.eventos.OpcionSalirEventHandler;
import fiuba.algo3.view.utilities.ReproductorFX;
import fiuba.algo3.view.utilities.ReproductorMusica;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class ContenedorInicio extends BorderPane {

    VentanaDefault ventanaDefault;
    Button botonJugar;
    Button botonSalir;
    ToggleButton botonMute;
    ImageView imagenMute;
    ImageView imagenUnMute;


    public ContenedorInicio(VentanaDefault ventanaDefault) {

        this.ventanaDefault = ventanaDefault;
        this.ventanaDefault.ocultarBarraDeMenu();
        cargarImagenDeFondo();
        cargarImagenesBotones();
        crearBotones();
        cargarMusicaDeFondo();
        this.ventanaDefault.setOnKeyPressed(new EntrarConTeclaEnterHandler(botonJugar));
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
        botonJugar.setStyle("-fx-base: #474747;");
        botonJugar.setOnAction(new BotonJugarEventHandler(this.ventanaDefault));
        botonJugar.requestFocus();
        botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setStyle("-fx-base: #474747;");
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
        ReproductorMusica.playBackGroundTheme(musicFile, true);

        botonMute.setOnAction( (actionEvent) -> {
            if (!ReproductorMusica.isMute()) {
                ReproductorMusica.setMute(true);
                ReproductorFX.setMute(true);
                botonMute.setGraphic(imagenMute);
            }

            else {
                ReproductorMusica.setMute(false);
                ReproductorFX.setMute(false);
                botonMute.setGraphic(imagenUnMute);
            }
        } );
    }
}
