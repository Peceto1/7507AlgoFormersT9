package fiuba.algo3.view.vistas;

import fiuba.algo3.model.unidades.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VistaProfileAlgoformers {

    private Map<Algoformer, Image> algoformersProfiles;
    private String optimusProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/optimusProfile.jpg";
    private String bumblebeeProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/bumblebeeProfile.jpg";
    private String ratchetProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/ratchetProfile.jpg";
    private String megatronProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/megatronProfile.jpg";
    private String bonecrusherProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/bonecrusherProfile.jpg";
    private String frenzyProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/frenzyProfile.jpg";
    private String menasorProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/menasorProfile.jpg";
    private String superionProfileResource = "file:src/fiuba/algo3/view/resources/images/textures/superionProfile.jpg";

    public VistaProfileAlgoformers() {
        this.algoformersProfiles = new HashMap<>();
        cargarImagenes();
    }


    private void cargarImagenes() {

        Algoformer menasor = crearMenasor();
        Algoformer superion = crearSuperion();

        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerOptimus(), new Image(optimusProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerBumblebee(), new Image(bumblebeeProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerRatchet(), new Image(ratchetProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerMegatron(), new Image(megatronProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerBonecrusher(), new Image(bonecrusherProfileResource));
        algoformersProfiles.put(AlgoformerPool.getInstance().obtenerFrenzy(), new Image(frenzyProfileResource));
        algoformersProfiles.put(menasor, new Image(megatronProfileResource));
        algoformersProfiles.put(superion, new Image(optimusProfileResource));
    }

    private Algoformer crearSuperion() {

        return new Superion(1000, new ArrayList<>(), new EstadoProto());

    }

    private Algoformer crearMenasor(){

        return new Menasor(1000, new ArrayList<>(), new EstadoProto());

    }

    public ImageView getVista(Algoformer algoformer, double size) {
        Image imagenAlgoformer = algoformersProfiles.get(algoformer);
        ImageView vista = new ImageView(imagenAlgoformer);
        vista.setPreserveRatio(true);
        vista.setFitWidth(size);
        return vista;
    }

}
