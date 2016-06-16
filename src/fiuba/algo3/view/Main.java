package fiuba.algo3.view;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.eventos.ApplicationOnKeyHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Algoformers 2016");

		// Creo la barra de menu que voy a utilizar en 2 de las 3 escenas
		BarraDeMenu menuBar = new BarraDeMenu(stage);

		Juego juego = new Juego();

		// 3ra Escena
		ContenedorJuego contenedorJuego = new ContenedorJuego(stage, juego, menuBar);
		Scene escenaJuego = new Scene(contenedorJuego, 800, 600);

		// 2da Escena --> Seleccion de equipos
		ContenedorEleccionEquipos contenedorEleccion = new ContenedorEleccionEquipos(stage, juego, menuBar, escenaJuego);
		Scene escenaEquipos = new Scene(contenedorEleccion, 800, 600);

		// 1ra Escena
		ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaEquipos, menuBar);
		Scene escenaInicio = new Scene(contenedorInicio, 800, 600);


		ApplicationOnKeyHandler escHandler = new ApplicationOnKeyHandler(stage, menuBar);
		escenaInicio.setOnKeyPressed(escHandler);
		escenaEquipos.setOnKeyPressed(escHandler);
		escenaJuego.setOnKeyPressed(escHandler);

		stage.setScene(escenaInicio);
		stage.setFullScreenExitHint("");
		stage.setFullScreen(true);
		stage.show();
	}

}
