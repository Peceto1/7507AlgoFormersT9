package fiuba.algo3.view.utilities;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class ReproductorMusica {

    private static MediaPlayer musicPlayer;


    public static void playBackGroundTheme(String musicFile, Boolean loopeable) {
        Media sound = new Media(new File(musicFile).toURI().toString());
        musicPlayer = new MediaPlayer(sound);

        if (loopeable)
            musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        musicPlayer.play();
    }


    public static Boolean isMute() {
        return musicPlayer.isMute();
    }


    public static void setMute(Boolean mute) {
        musicPlayer.setMute(mute);
    }

    public static void stop() {
        musicPlayer.stop();
    }


}
