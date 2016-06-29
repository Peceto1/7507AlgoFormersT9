package fiuba.algo3.view.layouts;

import fiuba.algo3.model.arena.Bonus;
import fiuba.algo3.model.arena.TerrenoAplicable;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import fiuba.algo3.view.ContenedorJuego;
import fiuba.algo3.view.eventos.ProfileOnClickHandler;
import fiuba.algo3.view.vistas.VistaProfileAlgoformers;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PanelLateral extends VBox {

    private ContenedorJuego contenedorJuego;
    private Text msjError;
    private VistaProfileAlgoformers vistaProfiles;

    public PanelLateral(ContenedorJuego contenedorJuego, Background fondoPanel) {
        this.contenedorJuego = contenedorJuego;
        this.msjError = contenedorJuego.getMsjError();
        this.setBackground(fondoPanel);
        this.setMinWidth(180);
        this.setMaxWidth(180);
        this.vistaProfiles = new VistaProfileAlgoformers();
        dibujarInformacionDeTurno();
        dibujarInformacionDeErrores();
        dibujarBloqueStatsSeleccionado();
        dibujarBloqueTerrenoYBonus();
        dibujarBloqueAlgoformers();
    }


	private void dibujarInformacionDeTurno() {
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

        Juego juego = this.contenedorJuego.getJuego();

        String nombreJug = juego.getJugadorEnTurno().getNombre();
        String equipoJug = juego.getJugadorEnTurno().getEquipo();
        String numeroTurno = Integer.toString(juego.getTurno());

        informacionJugador.setText("Jugador: " + nombreJug);
        informacionTurno.setText("Turno: " + numeroTurno);
        informacionEquipo.setText("Equipo: " + equipoJug);

        panelInformacion.getChildren().addAll(informacionJugador, informacionEquipo, informacionTurno);
        this.getChildren().addAll(panelInformacion);
    }


    private void dibujarInformacionDeErrores() {

        VBox contenedorErrores = new VBox(10);
        contenedorErrores.setPadding(new Insets(10, 0, 0, 10));
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
        this.contenedorJuego.setMsjError(msjError);

        VBox espacio = new VBox();
        espacio.setMinHeight(50);
        espacio.setMaxHeight(50);

        contenedorErrores.getChildren().addAll(titulo, msjError);
        this.getChildren().addAll(contenedorErrores, espacio);
    }


    private void dibujarBloqueStatsSeleccionado() {
        VBox contenedorStats = new VBox();
        contenedorStats.setSpacing(10);
        contenedorStats.setPadding(new Insets(0, 0, 0, 10));
        
        Text nombre = new Text("");
        nombre.setFill(Color.ANTIQUEWHITE);
        nombre.setStyle("-fx-font-weight: bold;");
        nombre.setId("statNombre");
        

        VBox imagen = new VBox();
        imagen.setId("imagenStatsVBox");
        imagen.setMinSize(100, 100);
        imagen.setMaxSize(100, 100);
        imagen.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        imagen.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(3, 3, 3, 3))));
        imagen.setAlignment(Pos.CENTER);

        Text vida = new Text("Vida: ");
        vida.setFill(Color.ANTIQUEWHITE);
        Text ataque = new Text("Ataque: ");
        ataque.setFill(Color.ANTIQUEWHITE);
        Text rango = new Text("Rango: ");
        rango.setFill(Color.ANTIQUEWHITE);
        Text velocidad = new Text("Velocidad: ");
        velocidad.setFill(Color.ANTIQUEWHITE);

        Text cantVida = new Text("");
        cantVida.setFill(Color.ANTIQUEWHITE);
        cantVida.setStyle("-fx-font-weight: bold;");
        cantVida.setId("statVidaText");
        Text cantAtaque = new Text("");
        cantAtaque.setFill(Color.ANTIQUEWHITE);
        cantAtaque.setStyle("-fx-font-weight: bold;");
        cantAtaque.setId("statAtkText");
        Text cantRango = new Text("");
        cantRango.setFill(Color.ANTIQUEWHITE);
        cantRango.setStyle("-fx-font-weight: bold;");
        cantRango.setId("statRngText");
        Text cantVelocidad = new Text("");
        cantVelocidad.setFill(Color.ANTIQUEWHITE);
        cantVelocidad.setStyle("-fx-font-weight: bold;");
        cantVelocidad.setId("statSpdText");

        GridPane grillaStats = new GridPane();

        grillaStats.addRow(0, vida, cantVida);
        grillaStats.addRow(1, ataque, cantAtaque);
        grillaStats.addRow(2, rango, cantRango);
        grillaStats.addRow(3, velocidad, cantVelocidad);

        contenedorStats.getChildren().addAll(nombre,imagen, grillaStats);
        this.getChildren().add(contenedorStats);
    }


    private void dibujarBloqueTerrenoYBonus() {
        VBox contenedorTerrenoYBonus = new VBox();
        contenedorTerrenoYBonus.setPadding(new Insets(20, 0, 10, 10));

        GridPane grillaTerrenoYBonus = new GridPane();

        Text terreno = new Text("Terreno: ");
        terreno.setFill(Color.ANTIQUEWHITE);
        Text bonus = new Text("Bonus: ");
        bonus.setFill(Color.ANTIQUEWHITE);

        Text tipoTerreno = new Text("");
        tipoTerreno.setFill(Color.ANTIQUEWHITE);
        tipoTerreno.setStyle("-fx-font-weight: bold;");
        tipoTerreno.setId("tipoTerrenoText");
        Text tipoBonus = new Text("");
        tipoBonus.setFill(Color.ANTIQUEWHITE);
        tipoBonus.setStyle("-fx-font-weight: bold;");
        tipoBonus.setId("tipoBonusText");

        grillaTerrenoYBonus.addRow(0, terreno, tipoTerreno);
        grillaTerrenoYBonus.addRow(1, bonus, tipoBonus);
        contenedorTerrenoYBonus.getChildren().add(grillaTerrenoYBonus);
        this.getChildren().add(contenedorTerrenoYBonus);
    }


    private void dibujarBloqueAlgoformers() {
        VBox contenedorImagenesAlgoformers = new VBox();
        contenedorImagenesAlgoformers.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: black;");

        contenedorImagenesAlgoformers.setPadding(new Insets(10, 0, 10, 30));

        AlgoformerPool poolSingleton = AlgoformerPool.getInstance();
        Algoformer optimus = poolSingleton.obtenerOptimus();
        Algoformer bumblebee = poolSingleton.obtenerBumblebee();
        Algoformer ratchet = poolSingleton.obtenerRatchet();
        Algoformer megatron = poolSingleton.obtenerMegatron();
        Algoformer bonecrusher = poolSingleton.obtenerBonecrusher();
        Algoformer frenzy = poolSingleton.obtenerFrenzy();

        Button profileOptimus = new Button("", vistaProfiles.getVista(optimus, 50));
        setearBoton(profileOptimus, optimus);
        
        Button profileBumblebee = new Button("", vistaProfiles.getVista(poolSingleton.obtenerBumblebee(), 50));
        setearBoton(profileBumblebee, bumblebee);
        
        Button profileRatchet = new Button("", vistaProfiles.getVista(poolSingleton.obtenerRatchet(), 50));
        setearBoton(profileRatchet, ratchet);
        
        Button profileMegatron = new Button("", vistaProfiles.getVista(poolSingleton.obtenerMegatron(), 50));
        setearBoton(profileMegatron, megatron);
        
        Button profileBonecrusher = new Button("", vistaProfiles.getVista(poolSingleton.obtenerBonecrusher(), 50));
        setearBoton(profileBonecrusher, bonecrusher);
        
        Button profileFrenzy = new Button("", vistaProfiles.getVista(poolSingleton.obtenerFrenzy(), 50));
        setearBoton(profileFrenzy, frenzy);
        
        GridPane grillaAlgoformers = new GridPane();
        grillaAlgoformers.setHgap(10);
        grillaAlgoformers.setVgap(10);
        grillaAlgoformers.addColumn(0, profileOptimus, profileBumblebee, profileRatchet);
        grillaAlgoformers.addColumn(1, profileMegatron, profileBonecrusher, profileFrenzy);

        contenedorImagenesAlgoformers.getChildren().add(grillaAlgoformers);
        this.getChildren().add(contenedorImagenesAlgoformers);
    }


    private void setearBoton(Button boton, Algoformer algoformer) {
        boton.setMinSize(50, 50);
        boton.setMaxSize(50, 50);
        boton.setOnAction(new ProfileOnClickHandler(algoformer, contenedorJuego));
        algoformer.vidaProperty().addListener(new VidaPropertyListener(boton));
    }


    public void actualizarStats(Algoformer algoformerSeleccionado, Bonus bonusSeleccionado, TerrenoAplicable terrenoSeleccionado){
    	Text textTerreno = (Text) this.lookup("#tipoTerrenoText");
    	Text textBonus = (Text) this.lookup("#tipoBonusText");
    	
    	textTerreno.setText(terrenoSeleccionado.devolverTipoTerreno());
    	textBonus.setText(bonusSeleccionado.getNombreBonus());
    	
    	Text nombre = (Text) this.lookup("#statNombre");
    	Text cantVida = (Text) this.lookup("#statVidaText");
    	Text cantAtk = (Text) this.lookup("#statAtkText");
    	Text cantRng = (Text) this.lookup("#statRngText");
    	Text cantSpd = (Text) this.lookup("#statSpdText");
        VBox imagenProfile = (VBox) this.lookup("#imagenStatsVBox");
    	
    	if (algoformerSeleccionado == null){
    		nombre.setText("------");
    		cantVida.setText("-");
    		cantAtk.setText("-");
    		cantRng.setText("-");
    		cantSpd.setText("-");
            imagenProfile.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
    		return;
    	}

        BackgroundImage nuevaImagen = new BackgroundImage(vistaProfiles.getVista(algoformerSeleccionado, 100).getImage(), null, null, null, null);
        imagenProfile.setBackground(new Background(nuevaImagen));

        nombre.setText(algoformerSeleccionado.getNombre().toUpperCase());
    	cantVida.setText(Integer.toString(algoformerSeleccionado.getVida()));
    	cantAtk.setText(Integer.toString(algoformerSeleccionado.getAtk()));
    	cantRng.setText(Integer.toString(algoformerSeleccionado.getRange()));
    	cantSpd.setText(Integer.toString(algoformerSeleccionado.getSpd()));    	
    }


    private class VidaPropertyListener implements ChangeListener<Number> {

        Button profileButton;

        VidaPropertyListener(Button botonADesabilitar) {
            this.profileButton = botonADesabilitar;
        }


        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            if ( newValue.intValue() <= 0)
                this.profileButton.setDisable(true);
        }
    }
}
