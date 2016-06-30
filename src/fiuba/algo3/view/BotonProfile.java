package fiuba.algo3.view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonProfile extends Button {

    private String estiloNegro = "-fx-base: #474747;";


    public BotonProfile(String text, ImageView imagen) {
        super(text, imagen);
        this.setMinSize(50, 50);
        this.setMaxSize(50, 50);
        this.setStyle(estiloNegro);
    }


}
