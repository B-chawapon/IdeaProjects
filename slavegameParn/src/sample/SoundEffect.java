package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundEffect {
    private Media media;
    private MediaPlayer mediaPlayer;

    public SoundEffect() {

    }
    public void setMedia(String pathstr){
        media = new Media(pathstr);
        mediaPlayer = new MediaPlayer(media);
    }
    public void run(){
        mediaPlayer.play();
    }


}
