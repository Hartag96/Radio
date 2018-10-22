package app.view;
import app.MainApp;
import app.model.Radio;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class RadioController {
    private MainApp mainApp;
    MediaPlayer mediaPlayerU;
    MediaPlayer mediaPlayerS;
    Radio radioU;
    Radio radioS;
    private Radio currentRadio;
    private MediaPlayer currentMediaPlayer;
    private Paint on;
    private Paint off;

    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton buttonS;
    @FXML
    private RadioButton buttonU;

    @FXML
    private ToggleButton buttonPlay;
    @FXML
    private ScrollBar volumeSlider;
    @FXML
    private ScrollBar balanceSlider;
    @FXML
    private Rectangle pointer;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.group = new ToggleGroup();

        this.buttonU.setToggleGroup(this.group);
        this.buttonS.setToggleGroup(this.group);

        this.group.selectToggle(this.buttonS);

        this.radioS= this.mainApp.radioU;
        this.radioU = this.mainApp.radioS;
        initMediaS(this.radioS);
        initMediaU(this.radioU);
        selectedChannel();
        mediaPlayerS.setVolume(0);
        mediaPlayerU.setVolume(0);
    }
    private void initMediaU(Radio radio){
        mediaPlayerU = new MediaPlayer(radio.getMedia());
        mediaPlayerU.play();
        if(this.currentRadio != radio) {
            mediaPlayerU.setVolume(0);
        }
        else if(this.currentRadio == radio && this.buttonPlay.isSelected()){
            mediaPlayerU.setVolume(getVolume());
        }
        mediaPlayerU.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayerU.stop();
                initMediaU(radio);
                return;
            }
        });
    }

    private void initMediaS(Radio radio){
        mediaPlayerS = new MediaPlayer(radio.getMedia());
        mediaPlayerS.play();
        if(this.currentRadio != radio){
            mediaPlayerS.setVolume(0);
        }
        else if(this.currentRadio == radio && this.buttonPlay.isSelected()){
            mediaPlayerS.setVolume(getVolume());
        }

        mediaPlayerS.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayerS.stop();
                initMediaS(radio);
                return;
            }
        });
    }

    private void pointerAnimation(int value){
        final Timeline timeline = new Timeline();
        final KeyValue kv = new KeyValue(this.pointer.xProperty(), value);
        final KeyFrame kf = new KeyFrame(Duration.millis(100), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    private void playAnimation(Paint value){
        this.buttonPlay.setBackground(new Background(new BackgroundFill(value, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private Double getVolume(){
        Double volumeValue = this.volumeSlider.getValue()/100;
        System.out.println(volumeValue);
        return volumeValue;
    }

    @FXML
    private void selectedChannel() {
        System.out.println(group.getSelectedToggle());
        if(this.buttonPlay.isSelected()){
            this.currentMediaPlayer.setVolume(0);
        }

        if(group.getSelectedToggle() == this.buttonU){
            this.currentMediaPlayer = mediaPlayerU;
            this.currentRadio = radioU;
            pointerAnimation(200);
        }else if(group.getSelectedToggle() == this.buttonS){
            this.currentMediaPlayer = mediaPlayerS;
            this.currentRadio = radioS;
            pointerAnimation(-200);
        }
        handlePlay();
    }

    @FXML
    private void handlePlay() {
        System.out.println("handle "+this.buttonPlay.isSelected());
        if (this.buttonPlay.isSelected()){
            playAnimation(Color.GREEN);
            this.currentMediaPlayer.setVolume(getVolume());
        }else{
            playAnimation(Color.RED);
            this.currentMediaPlayer.setVolume(0);
        }
    }

    @FXML
    private void handleVolume() {
        handlePlay();
    }
}
