package sample;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void startButton(ActionEvent event) throws Exception{
        String input=((Button)event.getSource()).getText();

        Parent  sceneCardParent = FXMLLoader.load(getClass().getResource("screenCard.fxml"));
        Scene   sceneCardScene=new Scene(sceneCardParent);
        Stage   sceneCardStage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        sceneCardStage.setScene(sceneCardScene);
        sceneCardStage.show();


    }


    @FXML
    void initialize() {

    }

    private Card card = new Card();

    private void randomCard(){
        card.fillRandomCard();
    }

    private Player p[] = new Player[4];

    private void drawPlayerCard(){
        p[0].startDrawCard(card.getRandomCard(), 0);
        p[1].startDrawCard(card.getRandomCard(), 1);
        p[2].startDrawCard(card.getRandomCard(), 2);
        p[3].startDrawCard(card.getRandomCard(), 3);
    }

    /*private int[][] getPlayerCard(){
        int[][] c = new int[13][2];



    }*/
}