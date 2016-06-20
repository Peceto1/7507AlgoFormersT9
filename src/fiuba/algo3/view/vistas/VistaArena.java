package fiuba.algo3.view.vistas;

import fiuba.algo3.model.arena.Arena;
import fiuba.algo3.model.arena.TerrenoAplicable;
import fiuba.algo3.model.espacio.PuntoAire;
import fiuba.algo3.model.espacio.PuntoTierra;
import fiuba.algo3.view.Dibujable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaArena extends GridPane {

    private int filas;
    private int columnas;
    private Arena arena;
    private final String rocosoResource = "file:src/fiuba/algo3/view/resources/images/textures/rocoso.jpg";
    private final String pantanoResource = "file:src/fiuba/algo3/view/resources/images/textures/pantano.jpg";
    private final String espinasResource = "file:src/fiuba/algo3/view/resources/images/textures/espinas.jpg";
    private final String nubeResource = "file:src/fiuba/algo3/view/resources/images/textures/nube.jpg";
    private final String nebulosaResource = "file:src/fiuba/algo3/view/resources/images/textures/nebulosa.jpg";
    private final String tormentaResource = "file:src/fiuba/algo3/view/resources/images/textures/tormenta.jpg";
    private final String errorResource = "file:src/fiuba/algo3/view/resources/images/textures/error.jpg";
    private Image imageRocoso;
    private Image imagePantano;
    private Image imageEspinas;
    private Image imageNube;
    private Image imageNebulosa;
    private Image imageTormenta;
    private Image imageError;


    public VistaArena(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.arena = Arena.getInstance();
        this.imageRocoso = new Image(rocosoResource);
        this.imagePantano = new Image(pantanoResource);
        this.imageEspinas = new Image(espinasResource);
        this.imageNube = new Image(nubeResource);
        this.imageNebulosa = new Image(nebulosaResource);
        this.imageTormenta = new Image(tormentaResource);
        this.imageError = new Image(errorResource);
    }


    public void dibujarArena() {

        int y2;
        TerrenoAplicable terreno;

        for (int y=0 ; y<filas; y++) {

            for (int x=1; x<=columnas; x++) {

                y2 = y/2 + 1;

                terreno = (y % 2 != 0) ? arena.devolverTerrenoEn(new PuntoTierra(x, y2)) : arena.devolverTerrenoEn(new PuntoAire(x, y2));
                ImageView imagen = obtenerImagenDeTerreno(terreno);
                this.add(imagen, x, y+1);
            }
        }

    }


    private ImageView obtenerImagenDeTerreno(TerrenoAplicable terreno) {

        switch (terreno.devolverTipoTerreno()) {

            case "Nube" :
                return new ImageView(imageNube);

            case "Rocoso" :
                return new ImageView(imageRocoso);

            case "Pantano" :
                return new ImageView(imagePantano);

            case "Espinas" :
                return new ImageView(imageEspinas);

            case "Tormenta Psionica" :
                return new ImageView(imageTormenta);

            case "Nebulosa de Andromeda" :
                return new ImageView(imageNebulosa);
        }

        // No debería llegar nunca acá
        return new ImageView(imageError);
    }
}
