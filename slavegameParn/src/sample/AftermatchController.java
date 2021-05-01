package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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