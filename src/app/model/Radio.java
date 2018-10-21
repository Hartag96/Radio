package app.model;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.Media;
import java.io.File;

public class Radio {
    public Media media;

    public Radio(String file){
        this.media = new Media(new File("src/app/"+file).toURI().toString());

//        System.out.println(media);
//        String path = Radio.class.getResource("2.mp3").toString();
//        Media media = new Media(path);
//        MediaPlayer mp = new MediaPlayer(media);
//        mp.play();

        System.out.println("Playing...");
    }
}
