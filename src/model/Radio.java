package model;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

import java.net.URL;

public class Radio {
    public Media media;

    public Radio(){
        final URL resource = Radio.class.getResource("1.mp3");
        Media media = new Media(resource.toString());
//
//        String path = Radio.class.getResource("2.mp3").toString();
//        Media media = new Media(path);
//        MediaPlayer mp = new MediaPlayer(media);
//        mp.play();

        System.out.println("Playing...");
    }
}
