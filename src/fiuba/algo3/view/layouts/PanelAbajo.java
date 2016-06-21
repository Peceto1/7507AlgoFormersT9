package fiuba.algo3.view.layouts;

import fiuba.algo3.controller.BotonTerminarTurnoHandler;
import fiuba.algo3.controller.HandlersMovimiento.*;
import fiuba.algo3.view.ContenedorJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
        crearBotonFinalizarTurno();
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

        Image upRightImage = new Image("file:src/fiuba/algo3/view/resources/images/upRight.png");
        ImageView upRightImageView = new ImageView(upRightImage);
        upRightImageView.setPreserveRatio(true);
        upRightImageView.setFitWidth(25);
        Button upRightButton = new Button("", upRightImageView);

        Image upLeftImage = new Image("file:src/fiuba/algo3/view/resources/images/upLeft.png");
        ImageView upLeftImageView = new ImageView(upLeftImage);
        upLeftImageView.setPreserveRatio(true);
        upLeftImageView.setFitWidth(25);
        Button upLeftButton = new Button("", upLeftImageView);

        Image downLeftImage = new Image("file:src/fiuba/algo3/view/resources/images/downLeft.png");
        ImageView downLeftImageView = new ImageView(downLeftImage);
        downLeftImageView.setPreserveRatio(true);
        downLeftImageView.setFitWidth(25);
        Button downLeftButton = new Button("", downLeftImageView);

        Image downRightImage = new Image("file:src/fiuba/algo3/view/resources/images/downRight.png");
        ImageView downRightImageView = new ImageView(downRightImage);
        downRightImageView.setPreserveRatio(true);
        downRightImageView.setFitWidth(25);
        Button downRightButton = new Button("", downRightImageView);

        rightButton.setOnAction(new MoverAlgoformerDerechaHandler(contenedorJuego));
        leftButton.setOnAction(new MoverAlgoformerIzquierdaHandler(contenedorJuego));
        upButton.setOnAction(new MoverAlgoformerAbajoHandler(contenedorJuego));
        downButton.setOnAction(new MoverAlgoformerArribaHandler(contenedorJuego));
        upRightButton.setOnAction(new MoverAlgoformerDerechaAbajoHandler(contenedorJuego));
        upLeftButton.setOnAction(new MoverAlgoformerIzquierdaAbajoHandler(contenedorJuego));
        downLeftButton.setOnAction(new MoverAlgoformerIzquierdaArribaHandler(contenedorJuego));
        downRightButton.setOnAction(new MoverAlgoformerDerechaArribaHandler(contenedorJuego));
        // ToDo agregar setOnAction del resto de los botones
        /*upRightButton;
        upLeftButton;
        downLeftButton;
        downRightButton;*/

        grillaBotonesDirecciones.add(upButton, 1, 0);
        //.add(movRestantes, 1, 1);     ToDo agregar movimientos restantes
        grillaBotonesDirecciones.add(leftButton, 0, 1);
        grillaBotonesDirecciones.add(downButton, 1, 2);
        grillaBotonesDirecciones.add(rightButton, 2, 1);
        grillaBotonesDirecciones.add(upRightButton, 2, 0);
        grillaBotonesDirecciones.add(upLeftButton, 0, 0);
        grillaBotonesDirecciones.add(downLeftButton, 0, 2);
        grillaBotonesDirecciones.add(downRightButton, 2, 2);
    }


    private void crearBotonFinalizarTurno() {
        VBox contenedorFinalizarTurno = new VBox();
        Button finalizarTurnoButton = new Button("Finalizar\nTurno");
        finalizarTurnoButton.setOnAction(new BotonTerminarTurnoHandler(contenedorJuego.getPanelLateral(), contenedorJuego.getJuego()));

        contenedorFinalizarTurno.getChildren().add(finalizarTurnoButton);
        this.getChildren().add(contenedorFinalizarTurno);
    }


}
