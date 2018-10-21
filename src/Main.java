

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Radio;
import javafx.scene.media.Media;

import java.io.IOException;
import java.net.URL;
import java.io.File;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private Radio radio1;
    private Radio radio2;

    public Main() {
        // Add some sample data
//        Radio radio1 = new Radio();
//        Radio radio2 = new Radio();
    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        this.primaryStage = primaryStage;
//        this.primaryStage.setTitle("AddressApp");
//
//        initRootLayout();
//        Radio radio1 = new Radio();
//        final MediaPlayer mediaPlayer = new MediaPlayer(this.radio1.media);
//        mediaPlayer.play();
//    }
//    public void initRootLayout(){
//        try {
//            // Load root layout from fxml file.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("view/RadioLayout.fxml"));
//            rootLayout = (BorderPane) loader.load();
//
//            // Show the scene containing the root layout.
//            Scene scene = new Scene(rootLayout);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        final URL resource = getClass().getResource("1.mp3");
        final Media media = new Media(new File("src/1.mp3").toURI().toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        primaryStage.setTitle("Audio Player 1");
        primaryStage.setWidth(200);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}

