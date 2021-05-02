package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SoundController implements upScaleImageView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    public static void display() throws IOException {
        Parent alertParent = FXMLLoader.load(SoundController.class.getResource("popUp.fxml"));
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
                mediaPlayerBGr.setVolume(SoundController.bgvolume);
            }
        });
    }

    public static Media menusound;
    public static MediaPlayer mediamenusound;

    //Menu
    public static void setMediamenusound(String pathstr){
        menusound=new Media(SoundController.class.getResource(pathstr).toExternalForm());//mouseEnterCard
        mediamenusound=new MediaPlayer(menusound);
    }

    public static Media mediaclick;
    public static MediaPlayer mediaPlayerClick;
    public static void setMediaclicked(String pathstr){
        mediaclick=new Media(SoundController.class.getResource(pathstr).toExternalForm());//mouseEnterCard
        mediaPlayerClick=new MediaPlayer(mediaclick);
    }

    public static Media mediamouseEnter;
    public static MediaPlayer mediaPlayermouseEnter;
    public static void setMediaEnter(String pathstr){
        mediamouseEnter=new Media(SoundController.class.getResource(pathstr).toExternalForm());//mouseEnterCard
        mediaPlayermouseEnter=new MediaPlayer(mediamouseEnter);
    }

    public static Media mediaBG;
    public static MediaPlayer mediaPlayerBGr;
    public static void setMediaBG(String pathstr){
        mediaBG=new Media(SoundController.class.getResource(pathstr).toExternalForm());//mouseEnterCard
        mediaPlayerBGr=new MediaPlayer(mediaBG);
    }


    public void goBack(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((ImageView)mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private ImageView goBackButton;
    @Override
    public void upScaleButtton(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("goBackButton")) {
            goBackButton.setScaleX(1.2);
            goBackButton.setScaleY(1.2);
        }
    }

    @Override
    public void defaultScaleButton(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("goBackButton")) {
            goBackButton.setScaleX(1);
            goBackButton.setScaleY(1);
        }
    }



}
