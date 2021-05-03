package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AftermatchController implements Initializable {

    @FXML
    private ImageView exitButton, menuButton, player0, player1, player2, player3;
    @FXML
    private Text player0name, player1name, player2name, player3name;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player0name.setText(Name.name[0]);
        player1name.setText(Name.name[1]);
        player2name.setText(Name.name[2]);
        player3name.setText(Name.name[3]);
        saveArrayPlayer();
        saveMulanList();
        savePocaList();
        saveSnowList();
        saveTianaList();

        if (scenePlayer1.Data.get(0) == 1) {
            player0.setImage(mulanList.get(1));
        } else if (scenePlayer1.Data.get(0) == 2) {
            player0.setImage(mulanList.get(2));
        } else if (scenePlayer1.Data.get(0) == 3) {
            player0.setImage(mulanList.get(3));
        } else if (scenePlayer1.Data.get(0) == 4) {
            player0.setImage(mulanList.get(4));
        }

        if (scenePlayer1.Data.get(1) == 1) {
            player1.setImage(pocaList.get(1));
        } else if (scenePlayer1.Data.get(1) == 2) {
            player1.setImage(pocaList.get(2));
        } else if (scenePlayer1.Data.get(1)== 3) {
            player1.setImage(pocaList.get(3));
        } else if (scenePlayer1.Data.get(1) == 4) {
            player1.setImage(pocaList.get(4));
        }

        if (scenePlayer1.Data.get(2) == 1) {
            player2.setImage(snowList.get(1));
        } else if (scenePlayer1.Data.get(2) == 2) {
            player2.setImage(snowList.get(2));
        } else if (scenePlayer1.Data.get(2) == 3) {
            player2.setImage(snowList.get(3));
        } else if (scenePlayer1.Data.get(2) == 4) {
            player2.setImage(snowList.get(4));
        }

        if (scenePlayer1.Data.get(3) == 1) {
            player3.setImage(tianaList.get(1));
        } else if (scenePlayer1.Data.get(3) == 2) {
            player3.setImage(tianaList.get(2));
        } else if (scenePlayer1.Data.get(3) == 3) {
            player3.setImage(tianaList.get(3));
        } else if (scenePlayer1.Data.get(3) == 4) {
            player3.setImage(tianaList.get(4));
        }

    }
    private ArrayList<ImageView> playerList = new ArrayList<ImageView>();
    private ArrayList<Image> mulanList = new ArrayList<Image>();
    private ArrayList<Image> pocaList = new ArrayList<Image>();
    private ArrayList<Image> snowList = new ArrayList<Image>();
    private ArrayList<Image> tianaList = new ArrayList<Image>();

    private void saveArrayPlayer() {
        playerList.add(player0);
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

    }

    private void saveMulanList() {
        Image mulanImg = new Image("/pics.parn/Mulan.png");
        Image mulanKing = new Image("/pics.parn/KQPS/MulanKing.png");
        Image mulanQueen = new Image("/pics.parn/KQPS/MulanQueen.png");
        Image mulanPeople = new Image("/pics.parn/KQPS/MulanPeople.png");
        Image mulanSlave = new Image("/pics.parn/KQPS/MulanSlave.png");
        mulanList.add(mulanImg);
        mulanList.add(mulanKing);
        mulanList.add(mulanQueen);
        mulanList.add(mulanPeople);
        mulanList.add(mulanSlave);

    }

    private void savePocaList() {
        Image pocaImg = new Image("/pics.parn/PocaHontas.png");
        Image pocaKing = new Image("/pics.parn/KQPS/PocaHontasKing.png");
        Image pocaQueen = new Image("/pics.parn/KQPS/PocaHontasQueen.png");
        Image pocaPeople = new Image("/pics.parn/KQPS/PocaHontasPeople.png");
        Image pocaSlave = new Image("/pics.parn/KQPS/PocaHontasSlave.png");
        pocaList.add(pocaImg);
        pocaList.add(pocaKing);
        pocaList.add(pocaQueen);
        pocaList.add(pocaPeople);
        pocaList.add(pocaSlave);
    }

    private void saveSnowList() {
        Image snowImg = new Image("/pics.parn/SnowWhite.png");
        Image snowKing = new Image("/pics.parn/KQPS/SnowWhiteKing.png");
        Image snowQueen = new Image("/pics.parn/KQPS/SnowWhiteQueen.png");
        Image snowPeople = new Image("/pics.parn/KQPS/SnowWhitePeople.png");
        Image snowSlave = new Image("/pics.parn/KQPS/SnowWhiteSlave.png");
        snowList.add(snowImg);
        snowList.add(snowKing);
        snowList.add(snowQueen);
        snowList.add(snowPeople);
        snowList.add(snowSlave);
    }

    private void saveTianaList() {
        Image tianaImg = new Image("/pics.parn/Tiana.png");
        Image tianaKing = new Image("/pics.parn/KQPS/TianaKing.png");
        Image tianaQueen = new Image("/pics.parn/KQPS/TianaQueen.png");
        Image tianaPeople = new Image("/pics.parn/KQPS/TianaPeople.png");
        Image tianaSlave = new Image("/pics.parn/KQPS/TianaSlave.png");
        tianaList.add(tianaImg);
        tianaList.add(tianaKing);
        tianaList.add(tianaQueen);
        tianaList.add(tianaPeople);
        tianaList.add(tianaSlave);

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
    private void upscale(MouseEvent event) {
        String Imageviewevent = ((ImageView) event.getSource()).getId();
        if (Imageviewevent.equals("menuButton")) {
            menuButton.setScaleX(1.3);
            menuButton.setScaleY(1.3);
        }
        if (Imageviewevent.equals("exitButton")) {
            exitButton.setScaleX(1.3);
            exitButton.setScaleY(1.3);
        }
    }

    @FXML
    private void defaultscale(MouseEvent event) {
        String Imageviewevent = ((ImageView) event.getSource()).getId();
        if (Imageviewevent.equals("menuButton")) {
            menuButton.setScaleX(1);
            menuButton.setScaleY(1);
        }
        if (Imageviewevent.equals("exitButton")) {
            exitButton.setScaleX(1);
            exitButton.setScaleY(1);
        }
    }

    @FXML
    private void menuButtonAction(MouseEvent event) throws IOException {
        Parent sceneCardParent = FXMLLoader.load(getClass().getResource("sceneMenuParn.fxml"));
        Scene sceneCardScene = new Scene(sceneCardParent);
        Stage stage = (Stage) menuButton.getScene().getWindow();

        stage.setScene(sceneCardScene);
        stage.show();
    }

    @FXML
    private void Gobackbutton(MouseEvent event) {
        Stage stage = (Stage) ((ImageView)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void upScale(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("menuButton")) {
            menuButton.setScaleX(1.3);
            menuButton.setScaleY(1.3);
        } else if (Imageviewevent.equals("exitButton")) {
            menuButton.setScaleX(1.3);
            menuButton.setScaleY(1.3);
        }

    }

    public void defaultScale(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("menuButton")) {
            menuButton.setScaleX(1);
            menuButton.setScaleY(1);
        } else if (Imageviewevent.equals("exitButton")) {
            menuButton.setScaleX(1);
            menuButton.setScaleY(1);
        }
    }

}
