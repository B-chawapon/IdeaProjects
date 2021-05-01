package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AftermatchController implements Initializable {

    @FXML
    private ImageView goback;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    public static void display() throws IOException {
        Parent alertParent = FXMLLoader.load(SoundController.class.getResource("aftermatch.fxml"));
        Scene alertScene = new Scene(alertParent);
        //alertScene.getStylesheets().add("styles/style.css");

        Stage window1 = new Stage();
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setTitle("End");
        // window1.getIcons().add(new Image("images/icon.png"));

        window1.setScene(alertScene);
        window1.showAndWait();
    }

    @FXML
    private ImageView PlayagainButton;
    @FXML
    private void upscale(MouseEvent event) {
        String Imageviewevent = ((ImageView) event.getSource()).getId();
        if (Imageviewevent.equals("playagainButtton")) {
            PlayagainButton.setScaleX(1.3);
            PlayagainButton.setScaleY(1.3);
        }
    }

    @FXML
    private void defaultscale(MouseEvent event) {
        String Imageviewevent = ((ImageView) event.getSource()).getId();
        if (Imageviewevent.equals("playagainButtton")) {
            PlayagainButton.setScaleX(1);
            PlayagainButton.setScaleY(1);
        }
    }


    @FXML
    private void playagainButtonAction(MouseEvent event) {
    }

    @FXML
    private void Gobackbutton(MouseEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }


    public void upScale(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("playagainButtton")) {
            PlayagainButton.setScaleX(1.3);
            PlayagainButton.setScaleY(1.3);
        }

    }

    public void defaultScale(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("playagainButtton")) {
            PlayagainButton.setScaleX(1);
            PlayagainButton.setScaleY(1);
        }
    }
}