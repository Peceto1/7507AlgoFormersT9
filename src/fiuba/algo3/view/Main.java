package fiuba.algo3.view;

import fiuba.algo3.model.juego.Juego;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
		Scene escenaJuego = new Scene(contenedorJuego, 800, 600);

		ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaJuego);
		Scene escenaInicio = new Scene(contenedorInicio, 800, 600);





		escenaJuego.setOnKeyPressed(new ApplicationOnKeyHandler(stage, contenedorJuego.getBarraMenu()));

		stage.setScene(escenaInicio);
		stage.setFullScreenExitHint("");
		stage.setFullScreen(true);
		stage.show();

	}


	private class ApplicationOnKeyHandler implements EventHandler<KeyEvent> {

		Stage stage;
		BarraDeMenu menuBar;

		ApplicationOnKeyHandler(Stage stage, BarraDeMenu menuBar) {
			this.stage = stage;
			this.menuBar = menuBar;
		}

		@Override
		public void handle(KeyEvent keyEvent) {
			if (keyEvent.getCode() == KeyCode.ESCAPE) {
				stage.setMaximized(true);
				menuBar.aplicacionMaximizada();
			}
		}
	}
}
