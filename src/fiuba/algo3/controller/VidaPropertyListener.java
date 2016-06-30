package fiuba.algo3.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;

public class VidaPropertyListener implements ChangeListener<Number> {

    private Button profileButton;

    public VidaPropertyListener(Button botonADesabilitar) {
        this.profileButton = botonADesabilitar;
    }


    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

        if ( newValue.intValue() <= 0)
            this.profileButton.setDisable(true);
    }
}
