package app.model;

import javafx.scene.media.Media;

import java.io.File;

public class Radio {
    public Media media;
    private Media [] mediaArray;
    private int iterator;

    public Radio(String [] files){
        this.mediaArray= new Media[files.length];
        this.iterator = 0;
        for (int i = 0; i < files.length; i++) {
            this.mediaArray[i] = new Media(new File("src/app/resources/"+files[i]).toURI().toString());;
        }

        System.out.println("Playing...");
    }

    public Media getMedia(){
        Media media = this.mediaArray[this.iterator];

        this.iterator++;
        if(this.iterator == this.mediaArray.length) {
            this.iterator = 0;
        }

        return media;

    }
}
