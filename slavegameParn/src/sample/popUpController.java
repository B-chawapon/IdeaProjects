package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class popUpController {

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
    void initialize() {

    }
}
