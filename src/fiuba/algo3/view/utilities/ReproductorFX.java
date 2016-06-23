package fiuba.algo3.view.utilities;

import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ReproductorFX {


    private static Map<String, AudioClip> efectos;
    public static String ROBOTIC = "robotArmFX";
    public static String HITFX = "hitFX";
    public static String ERROR1 = "error1";
    public static String ENDTURN = "endTurn";
    public static String MOVEFX = "moveFx";
    public static String ATTACKFX = "atkFx";
    private static String roboticResource = "src/fiuba/algo3/view/resources/sounds/robotArmSound.mp3";
    private static String hitFXResource = "src/fiuba/algo3/view/resources/sounds/hitSoundFX.mp3";
    private static String errorTeamResource = "src/fiuba/algo3/view/resources/sounds/errorTeam.mp3";
    private static String endTurnResource = "src/fiuba/algo3/view/resources/sounds/endTurn.mp3";
    private static String moveFXResource = "src/fiuba/algo3/view/resources/sounds/moveSound.mp3";
    private static String atkFXResource = "src/fiuba/algo3/view/resources/sounds/attackFX.mp3";
    private static Boolean isMute = false;


    public static void inicializarReproductorFX() {
        efectos = new HashMap<>();
        efectos.put(ROBOTIC, crearAudioClip(roboticResource));
        efectos.put(HITFX, crearAudioClip(hitFXResource));
        efectos.put(ERROR1, crearAudioClip(errorTeamResource));
        efectos.put(ENDTURN, crearAudioClip(endTurnResource));
        efectos.put(MOVEFX, crearAudioClip(moveFXResource));
        efectos.put(ATTACKFX, crearAudioClip(atkFXResource));
    }


    private static AudioClip crearAudioClip(String fxFileSource) {
        return new AudioClip(new File(fxFileSource).toURI().toString());
    }


    public static void reproducirFX(String fx) {
        if (isMute)
            return;

        efectos.get(fx).play();
    }


    public static void setMute(Boolean bool) {
        isMute = bool;
    }


    public static boolean isMute() {
        return isMute;
    }
}
