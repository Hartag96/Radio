package app.view;
import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class RadioController {
    private MainApp mainApp;
    private MediaPlayer mediaPlayer;
    private MediaPlayer.Status currentStatus;
    private boolean  x =true;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton S;
    @FXML
    private RadioButton U;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.group = new ToggleGroup();

        this.U.setToggleGroup(this.group);
        this.S.setToggleGroup(this.group);

        this.group.selectToggle(this.S);
    }

    private Media selectedChannel() {
        System.out.println(group.getSelectedToggle());
        if(group.getSelectedToggle() == this.U){
            return this.mainApp.radioU.media;
        }else{
            return this.mainApp.radioS.media;
        }
    }

    @FXML
    private void handlePlay() {
        MediaPlayer.Status status = this.mediaPlayer != null ? this.mediaPlayer.getStatus() : MediaPlayer.Status.UNKNOWN;
        if (status == MediaPlayer.Status.PLAYING) {
            this.mediaPlayer.pause();
        } else if (status == MediaPlayer.Status.PAUSED) {
            this.mediaPlayer.play();
        } else if (status == MediaPlayer.Status.UNKNOWN){
            this.mediaPlayer = new MediaPlayer(selectedChannel());
            this.mediaPlayer.play();
//            this.currentStatus = this.mediaPlayer.getStatus();
//            this.x = false;
        }
    }

    @FXML
    private void channelSwitch() {
        this.mediaPlayer.stop();
        handlePlay();

    }



//        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
//        if (selectedPerson != null) {
//            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
//            if (okClicked) {
//                showPersonDetails(selectedPerson);
//            }
//
//        } else {
//            // Nothing selected.
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("No Selection");
//            alert.setHeaderText("No Person Selected");
//            alert.setContentText("Please select a person in the table.");
//
//            alert.showAndWait();
//        }

}
