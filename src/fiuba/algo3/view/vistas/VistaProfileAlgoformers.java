package fiuba.algo3.view.vistas;

import fiuba.algo3.model.unidades.Algoformer;
import fiuba.algo3.model.unidades.AlgoformerPool;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;


public class VistaProfileAlgoformers {

    private Map<Algoformer, Image> algoformersProfiles;
    private String optimusProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/optimusProfile.jpg";
    private String bumblebeeProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/bumblebeeProfile.jpg";
    private String ratchetProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/ratchetProfile.jpg";
    private String megatronProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/megatronProfile.jpg";
    private String bonecrusherProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/bonecrusherProfile.jpg";
    private String frenzyProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/frenzyProfile.jpg";


    public VistaProfileAlgoformers() {
        this.algoformersProfiles = new HashMap<>();
        cargarImagenes();
    }


    private void cargarImagenes() {
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerOptimus(), new Image(optimusProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerBumblebee(), new Image(bumblebeeProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerRatchet(), new Image(ratchetProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerMegatron(), new Image(megatronProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerBonecrusher(), new Image(bonecrusherProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerFrenzy(), new Image(frenzyProfileResource));
    }


    public ImageView getVista(Algoformer algoformer, double size) {
        Image imagenAlgoformer = algoformersProfiles.get(algoformer);
        ImageView vista = new ImageView(imagenAlgoformer);
        vista.setPreserveRatio(true);
        vista.setFitWidth(size);
        return vista;
    }

}
