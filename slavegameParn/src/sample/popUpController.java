package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class popUpController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void goBack(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    public static void display() throws IOException {
        Parent alertParent = FXMLLoader.load(popUpController.class.getResource("popUp.fxml"));
        Scene alertScene = new Scene(alertParent);
        //alertScene.getStylesheets().add("styles/style.css");

        Stage window1 = new Stage();
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setTitle("Setting");
        // window1.getIcons().add(new Image("images/icon.png"));

        window1.setScene(alertScene);
        window1.showAndWait();
    }
    @FXML
    public Slider slider0;
    @FXML
    public Slider slider1;
    public static MediaPlayer mp;
    public static Media me;

    public static double sfxvolume=1;
    public static double bgvolume=1;
    @FXML
    void initialize() {
        slider1.setValue(sfxvolume*100);
        slider1.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sfxvolume=slider1.getValue()/100;
            }
        });

        slider0.setValue(bgvolume*100);
        slider0.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue2, Number number2, Number t2) {
                bgvolume=slider0.getValue()/100;
                scenePlayer1.soundmediaPlayer.setVolume(popUpController.bgvolume);
            }
        });
    }
}
