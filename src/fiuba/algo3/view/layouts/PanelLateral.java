package fiuba.algo3.view.layouts;

import fiuba.algo3.model.arena.Bonus;
import fiuba.algo3.model.arena.TerrenoAplicable;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.view.ContenedorJuego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PanelLateral extends VBox {

    private ContenedorJuego contenedorJuego;
    private Juego juego;
    private Text msjError;

    public PanelLateral(ContenedorJuego contenedorJuego, Background fondoPanel) {
        this.contenedorJuego = contenedorJuego;
        this.juego = contenedorJuego.getJuego();
        this.msjError = contenedorJuego.getMsjError();
        this.setBackground(fondoPanel);
        this.setMinWidth(180);
        this.setMaxWidth(180);
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
        this.contenedorJuego.setMsjError(msjError);

        VBox espacio = new VBox();
        espacio.setMinHeight(90);
        espacio.setMaxHeight(90);

        contenedorErrores.getChildren().addAll(titulo, msjError);
        this.getChildren().addAll(contenedorErrores, espacio);
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

        contenedorStats.getChildren().addAll(imagen, grillaStats);
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
        this.getChildren().add(contenedorImagenesAlgoformers);
    }
    
    public void actualizarStats(Algoformer algoformerSeleccionado, Bonus bonusSeleccionado, TerrenoAplicable terrenoSeleccionado){
    	Text textTerreno = (Text) this.lookup("#tipoTerrenoText");
    	Text textBonus = (Text) this.lookup("#tipoBonusText");
    	
    	textTerreno.setText(terrenoSeleccionado.devolverTipoTerreno());
    	textBonus.setText(bonusSeleccionado.getNombreBonus());
    	
    	Text cantVida = (Text) this.lookup("#statVidaText");
    	Text cantAtk = (Text) this.lookup("#statAtkText");
    	Text cantRng = (Text) this.lookup("#statRngText");
    	Text cantSpd = (Text) this.lookup("#statSpdText");
    	
    	if (algoformerSeleccionado == null){
    		cantVida.setText("");
    		cantAtk.setText("");
    		cantRng.setText("");
    		cantSpd.setText("");
    		return;
    	}
    	cantVida.setText(Integer.toString(algoformerSeleccionado.getVida()));
    	cantAtk.setText(Integer.toString(algoformerSeleccionado.getAtk()));
    	cantRng.setText(Integer.toString(algoformerSeleccionado.getRange()));
    	cantSpd.setText(Integer.toString(algoformerSeleccionado.getSpd()));    	
    }


}
