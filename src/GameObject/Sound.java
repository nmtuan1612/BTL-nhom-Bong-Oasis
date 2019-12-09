package GameObject;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class Sound {
    private boolean isPause ;
    MediaPlayer mediaPlayer ;
    public Sound(String link) {
        isPause = false ;
        File file = new File(link) ;
        Media sound = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(sound) ;
    }
    public void play() {
       mediaPlayer.seek(Duration.ZERO);
       mediaPlayer.play();
    }
    public void loop() {
        if (isPause) return;
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void pause() {
        isPause = true;
        mediaPlayer.pause();
    }

    public void continuePlay() {
        isPause = false;
        mediaPlayer.play();
    }

}
