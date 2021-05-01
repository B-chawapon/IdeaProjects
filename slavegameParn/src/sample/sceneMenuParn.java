package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author parn
 */
public class sceneMenuParn implements Initializable {

    @FXML
    private ImageView startButton;
    @FXML
    private ImageView exitButton;
    @FXML
    private ImageView aboutButton;
    @FXML
    private ImageView leftButton0, leftButton1, leftButton2, leftButton3;
    @FXML
    private ImageView rightButton0, rightButton1, rightButton2, rightButton3;
    @FXML
    private ImageView player0, player1, player2, player3;
    @FXML
    private TextField player0Name, player1Name, player2Name, player3Name;
    @FXML
    private Button okButton;
    private ArrayList<ImageView> leftButtonList = new ArrayList<ImageView>();
    private ArrayList<ImageView> rightButtonList = new ArrayList<ImageView>();
    private ArrayList<ImageView> playerlist = new ArrayList<ImageView>();
    private ArrayList<TextField> textFieldList = new ArrayList<TextField>();
    @FXML
    private ImageView speakerOn;
    @FXML
    private ImageView mute;

    public String[] name = new String[4];
    Name namename = new Name();

  // private SoundEffect sound=new SoundEffect();

    public Media menusound;
    public MediaPlayer mediamenusound;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setLeftButtonList();
        setRightButtonList();
        playerlist.add(player0);
        playerlist.add(player1);
        playerlist.add(player2);
        playerlist.add(player3);
        textFieldList.add(player0Name);
        textFieldList.add(player1Name);
        textFieldList.add(player2Name);
        textFieldList.add(player3Name);

        addTextLimiter(player0Name, 7);
        addTextLimiter(player1Name, 7);
        addTextLimiter(player2Name, 7);
        addTextLimiter(player3Name, 7);

        //sound.setMedia("/audio.parn/AHNW.mp3");
        //sound.run();
        System.out.println("file:" + System.getProperty("user.dir") + "/src/audio.parn/toy.mp3");

                       //  /Users/b.nut/IdeaProjects/slavegameParn/src/audioparn/AHNW.mp3
        //Media media =new Media("file:/Users/b.nut/IdeaProjects/slavegameParn/src/audioparn/AHNW.mp3");
        // menusound = new Media("file:" + System.getProperty("user.dir") + "/src/audio.parn/toy.mp3");
        menusound=new Media(setMediaFile("toy.mp3"));
         mediamenusound=new MediaPlayer(menusound);
        mediamenusound.play();
        mediamenusound.setVolume(0.3);
        mediamenusound.setCycleCount(99);



    }

    @FXML
    private void startButtonAction(MouseEvent event) throws IOException {

        for (int i = 0; i < 4; i++) { namename.setName(name);
            name[i] = textFieldList.get(i).getText();
        }
        namename.setName(name);
        Parent sceneCardParent = FXMLLoader.load(getClass().getResource("scenePlayer1copy.fxml"));
        Scene sceneCardScene = new Scene(sceneCardParent);
        Stage stage = (Stage) startButton.getScene().getWindow();
        mediamenusound.stop();
        stage.setScene(sceneCardScene);
        stage.show();

    }

    @FXML
    private void exitButtonAction(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
//    String path = "C:\\Users\\parn\\Documents\\NetBeansProjects\\sample\\src\\audio.parn\\AHNW.mp3";
//    Media op = new Media(new File(path).toURI().toString());
//    MediaPlayer opPlayer = new MediaPlayer(op);

    @FXML

    private void speakerOnAction(MouseEvent event) {
        //opPlayer.play();
    }

    @FXML
    private void muteAction(MouseEvent event) {
        //opPlayer.stop();
    }

    private Media mediaClick;
    private MediaPlayer mediaClickPlayer;
    @FXML
    public void upScale(MouseEvent mouseEvent) {
        mediaClick = new Media(setMediaFile("mouseEnter1.mp3"));
        mediaClickPlayer = new MediaPlayer(mediaClick);
        mediaClickPlayer.play();
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("startButton")) {
            startButton.setScaleX(1.3);
            startButton.setScaleY(1.3);
        } else if (Imageviewevent.equals("exitButton")) {
            exitButton.setScaleX(1.3);
            exitButton.setScaleY(1.3);
        } else if (Imageviewevent.equals("aboutButton")) {
            aboutButton.setScaleX(1.3);
            aboutButton.setScaleY(1.3);
        }


    }

    @FXML
    public void defaultScale(MouseEvent mouseEvent) {
        mediaClickPlayer.stop();
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("startButton")) {
            startButton.setScaleX(1);
            startButton.setScaleY(1);
        } else if (Imageviewevent.equals("exitButton")) {
            exitButton.setScaleX(1);
            exitButton.setScaleY(1);
        } else if (Imageviewevent.equals("aboutButton")) {
            aboutButton.setScaleX(1);
            aboutButton.setScaleY(1);
        }

    }

    public void setLeftButtonList() {
        leftButtonList.add(leftButton0);
        leftButtonList.add(leftButton1);
        leftButtonList.add(leftButton2);
        leftButtonList.add(leftButton3);
    }

    public void setRightButtonList() {
        rightButtonList.add(rightButton0);
        rightButtonList.add(rightButton1);
        rightButtonList.add(rightButton2);
        rightButtonList.add(rightButton3);
    }

    @FXML
    public void upScaleRightButton(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        int index = getButtton(Imageviewevent);
        rightButtonList.get(index).setScaleX(1.2);
        rightButtonList.get(index).setScaleY(1.2);
    }

    @FXML
    public void defaultScaleRightButton(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        int index = getButtton(Imageviewevent);
        rightButtonList.get(index).setScaleX(1);
        rightButtonList.get(index).setScaleY(1);
    }

    @FXML
    public void upScaleLeftButton(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        int index = getButtton(Imageviewevent);
        leftButtonList.get(index).setScaleX(1.2);
        leftButtonList.get(index).setScaleY(1.2);
    }

    @FXML
    public void defaultScaleLeftButton(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        int index = getButtton(Imageviewevent);
        leftButtonList.get(index).setScaleX(1);
        leftButtonList.get(index).setScaleY(1);
    }

    private int getButtton(String buttonstr) {
        for (int i = 0; i < 4; i++) {
            if (buttonstr.equals("leftButton" + i) || buttonstr.equals("rightButton" + i)) {
                //System.out.println("getIndexCard = "+i);
                return i;
            }
        }
        return 0;
    }
    @FXML
    private ImageView bg;
    private int change = 0;
    private String old = null;

    @FXML
    public void changeImage(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        int index = getButtton(Imageviewevent);

        if (old != playerlist.get(index).getId()) {
            change = 0;
            old = playerlist.get(index).getId();
        }

        if (Imageviewevent.equals("leftButton" + index)) {
            //System.out.println("getIndexCard = "+i);
            change--;
        } else if (Imageviewevent.equals("rightButton" + index)) {
            change++;
        }
        if (change < 0) {
            change = 0;
        } else if (change > 3) {
            change = 3;
        }
        if ((index + change) % 4 == 0) {
            Image image = new Image("/pics.parn/Mulan.png");
            playerlist.get(index).setImage(image);
        } else if ((index + change) % 4 == 1) {
            Image image = new Image("/pics.parn/PocaHontas.png");
            playerlist.get(index).setImage(image);
        } else if ((index + change) % 4 == 2) {
            Image image = new Image("/pics.parn/SnowWhite.png");
            playerlist.get(index).setImage(image);
        } else if ((index + change) % 4 == 3) {
            Image image = new Image("/pics.parn/Tiana.png");
            playerlist.get(index).setImage(image);
        }
        System.out.println(change);
    }


    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

    public String setMediaFile(String filename){
       return "file:" + System.getProperty("user.dir") + "/src/audio.parn/"+filename;
    }
}