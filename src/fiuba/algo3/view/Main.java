package fiuba.algo3.view;

import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.eventos.ApplicationOnKeyHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Algoformers 2016");

		VentanaDefault ventanaDefault = new VentanaDefault(stage);	// Ventana con MenuBar
		Scene escena = new Scene(ventanaDefault, 800, 600);

		Juego juego = new Juego();

		// 3ra Escena
		ContenedorJuego vistaJuego = new ContenedorJuego(juego);

		// 2da Escena --> Seleccion de equipos
		ContenedorEleccionEquipos vistaEquipos = new ContenedorEleccionEquipos(ventanaDefault, juego, vistaJuego);

		// 1ra Escena
		ContenedorInicio contenedorInicio = new ContenedorInicio(ventanaDefault, vistaEquipos);


		ventanaDefault.setCenter(contenedorInicio);
		escena.setOnKeyPressed(new ApplicationOnKeyHandler(stage, ventanaDefault.getMenuBar()));
		stage.setScene(escena);
		stage.setFullScreenExitHint("");
		stage.setFullScreen(true);
		stage.show();
	}

}
