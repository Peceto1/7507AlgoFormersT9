package fiuba.algo3.view;


import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.juego.Juego;
import fiuba.algo3.view.eventos.ApplicationOnKeyHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ContenedorJuego extends BorderPane {

    Stage stage;
    BarraDeMenu barraMenu;
    VistaArena vistaArena;
    Canvas canvasArena;
    VBox contenedorArena;


    ContenedorJuego(Stage stage, Juego juego, BarraDeMenu menuBar) {
        this.stage = stage;
        this.barraMenu = menuBar;
        this.setTop(barraMenu);
        this.setCentro(Arena.getInstance());
        // this.setControles(); Setear algo en el sector de abajo
    }


    public BarraDeMenu getBarraMenu() {
        return barraMenu;
    }

    void setCentro(Arena arena) {

        canvasArena = new Canvas(50, 50);
        vistaArena = new VistaArena(canvasArena);
        vistaArena.dibujar();
        contenedorArena = new VBox(canvasArena);
        contenedorArena.setAlignment(Pos.CENTER);
        this.setCenter(contenedorArena);
    }
}
