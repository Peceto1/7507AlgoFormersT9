package fiuba.algo3.view.layouts;

import fiuba.algo3.controller.MoverAlgoformerDerechaHandler;
import fiuba.algo3.view.ContenedorJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PanelAbajo extends HBox {

    ContenedorJuego contenedorJuego;
    private String estiloNegro = "-fx-base: #474747;";

    public PanelAbajo(ContenedorJuego contenedorJuego, Background fondoPanel) {
        this.setSpacing(10);
        this.setBackground(fondoPanel);
        this.setMinHeight(120);
        this.setMaxHeight(120);
        this.contenedorJuego = contenedorJuego;
        dibujarBloqueBotones();
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
        this.getChildren().addAll(contenedorAcciones, contenedorDirecciones);
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

        rightButton.setOnAction(new MoverAlgoformerDerechaHandler(this.contenedorJuego));

        grillaBotonesDirecciones.add(upButton, 1, 0);
        //.add(movRestantes, 1, 1);     ToDo agregar movimientos restantes
        grillaBotonesDirecciones.add(leftButton, 0, 1);
        grillaBotonesDirecciones.add(downButton, 1, 2);
        grillaBotonesDirecciones.add(rightButton, 2, 1);

    }


}
