package fiuba.algo3.view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonProfile extends Button {

    private String estiloNegro = "-fx-base: #474747;";
    private CustomToolTip popUpMsg;


    public BotonProfile(String hoverText, ImageView imagen) {
        super("", imagen);
        this.setMinSize(50, 50);
        this.setMaxSize(50, 50);
        this.setStyle(estiloNegro);
        crearPopUpMsg(hoverText);
        setearTooltip();
    }


    private void crearPopUpMsg(String tooltipText) {
        this.popUpMsg = new CustomToolTip(tooltipText);
    }


    private void setearTooltip() {
        this.setTooltip(popUpMsg);
        popUpMsg.asociarA(this);
    }


}
