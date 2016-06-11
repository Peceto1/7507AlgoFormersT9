package fiuba.algo3.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	 Stage window;
	 Button button;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
        window.setTitle("Algoformers: Age of Exception");
        //dark side of code?
        //revenge of the patter?
        // the last night (code) //esta es la nueva que va a salir //que? comentarios en los comentarios? que clase de locura es esa? //#jinception
        
        
        button = new Button("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();
		
	}

}
