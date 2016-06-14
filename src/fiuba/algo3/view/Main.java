package fiuba.algo3.view;

import fiuba.algo3.model.juego.Juego;
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

		Juego juego = new Juego();

		ContenedorJuego contenedorJuego = new ContenedorJuego(stage, juego);
		Scene escenaArena = new Scene(contenedorJuego, 800, 600);

		stage.setScene(escenaArena);
		stage.show();


	}
}
