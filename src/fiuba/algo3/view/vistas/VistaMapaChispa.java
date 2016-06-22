package fiuba.algo3.view.vistas;



import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.Chispa;
import fiuba.algo3.model.espacio.Punto;
import fiuba.algo3.view.utilities.ConvertidorPuntoAPixels;
import fiuba.algo3.view.utilities.PuntoPixels;

public class VistaMapaChispa{
	Punto ubicacionChispa;
	Chispa chispa;
	Arena arenaDeJuegoSingleton;
	private final String chispaResource = "file:src/fiuba/algo3/view/resources/images/textures/chispa.png";
	private Image imagenChispa;
	private int imageWidthSize = 20;
	private int imageHeightSize = 20;
	
	public VistaMapaChispa(Chispa chispa, Punto ubicacionChispa){
		this.ubicacionChispa = ubicacionChispa;
		this.chispa = chispa;
		this.imagenChispa = new Image(chispaResource);
	}
	
	public void dibujar(Canvas canvasEnElQueSeDibuja){
		
		ConvertidorPuntoAPixels conversor = new ConvertidorPuntoAPixels();
        PuntoPixels puntoPixeleado = conversor.convertir(ubicacionChispa);
        
		int ajusteX = imageWidthSize/2;
        int ajusteY = imageHeightSize/2;

        GraphicsContext gc = canvasEnElQueSeDibuja.getGraphicsContext2D();
        gc.drawImage(imagenChispa, puntoPixeleado.getX()-ajusteX, puntoPixeleado.getY()-ajusteY);
	}

}
