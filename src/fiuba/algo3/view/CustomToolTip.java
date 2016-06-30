package fiuba.algo3.view;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;

public class CustomToolTip extends Tooltip {

    private Node asociado;


    public CustomToolTip(String text) {
        super(text);
    }


    public void asociarA(Node node) {
        this.asociado = node;
        setearOnHoverProperty();
    }


    private void setearOnHoverProperty() {

        asociado.setOnMouseEntered( (mouseEvent) -> {
            Point2D p = asociado.localToScreen(asociado.getLayoutBounds().getMaxX(), asociado.getLayoutBounds().getMaxY());
            this.show(asociado, p.getX(), p.getY());
        } );

        asociado.setOnMouseExited( (mouseEvent) -> {
            this.hide();
        } );
    }


}
