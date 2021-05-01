package sample;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.*;

public class ControllerCard  {
    private Card decktest=new Card();
    private  int[] arrayCard1=new int[52];

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private ImageView   card0,card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12;
    @FXML
    private ImageView pot0;
    private double sizeViewPortX=157;
    private double sizeViewPortY=228;
    private int indexOFcardOn=0;
    private ArrayList<ImageView>  card52=new ArrayList<ImageView>();

    private void saveArrayImage(){
        card52.add(card0);
        card52.add(card1);
        card52.add(card2);
        card52.add(card3);
        card52.add(card4);
        card52.add(card5);
        card52.add(card6);
        card52.add(card7);
        card52.add(card8);
        card52.add(card9);
        card52.add(card10);
        card52.add(card11);
        card52.add(card12);

    }

    private int[] x=new int[13];
    private int[] y= new int[13];
    @FXML
    void buttonrandom(ActionEvent event)  throws Exception{
        decktest.fillRandomCard();
        arrayCard1=decktest.getRandomCard();
        saveArrayImage();
        for( indexOFcardOn=0;indexOFcardOn< 13;indexOFcardOn++){
            System.out.println(arrayCard1[indexOFcardOn]);
            setValueCard(card52.get(indexOFcardOn),arrayCard1[indexOFcardOn]);
        }
        for( indexOFcardOn=0;indexOFcardOn< 13;indexOFcardOn++){
            showImageCard(y[indexOFcardOn],x[indexOFcardOn],card52.get(indexOFcardOn));
        }
    }
    private void setValueCard(ImageView card,int value){
        String cardstr=card.getId();
        //System.out.println(cardstr);
        int index=getIndexCard(cardstr);
        //System.out.println(index);
        x[index]=value%100;//number
        y[index]=value/100;//star
        //showImageCard(y[index],x[index],card);
    }
    private int getValueCard(ImageView card){
        String cardstr=card.getId();
        int index=getIndexCard(cardstr);
        return arrayCard1[index];
    }

    private void showImageCard(int y, int x, ImageView card){
        if (y == 1) {
            if (x == 1){//dai 3
                card.setViewport(new Rectangle2D(214, 310, 100, 150));
            }
            else if(x>=2 &&x<=11){
                card.setViewport(new Rectangle2D(214 + ((x - 1) * 104)+(-0.1*x), 310, 100, 150));
            }
            else if(x==12){
                card.setViewport(new Rectangle2D(6, 310, 100, 150));
            }
            else if(x==13){
                card.setViewport(new Rectangle2D(110, 310, 100, 150));
            }
        } else if (y == 2) {
            if (x == 1){//dai 3
                card.setViewport(new Rectangle2D(214, 158, 100, 150));
            }
            else if(x>=2 &&x<=11){
                card.setViewport(new Rectangle2D(214 + ((x - 1) * 104)+(-0.1*x), 158, 100, 150));
            }
            else if(x==12){
                card.setViewport(new Rectangle2D(6, 158, 100, 150));
            }
            else if(x==13){
                card.setViewport(new Rectangle2D(110, 158, 100, 150));
            }
        } else if (y == 3) {
            if (x == 1){//dai 3
                card.setViewport(new Rectangle2D(214, 6, 100, 150));
            }
            else if(x>=2 &&x<=11){
                card.setViewport(new Rectangle2D(214 + ((x - 1) * 104)+(-0.1*x), 6, 100, 150));
            }
            else if(x==12){
                card.setViewport(new Rectangle2D(6, 6, 100, 150));
            }
            else if(x==13){
                card.setViewport(new Rectangle2D(110, 6, 100, 150));
            }
        } else if (y == 4) {
            if (x == 1){//dai 3
                card.setViewport(new Rectangle2D(214, 462, 100, 150));
            }
            else if(x>=2 &&x<=11){
                card.setViewport(new Rectangle2D(214 + ((x - 1) * 104)+(-0.1*x), 462, 100, 150));
            }
            else if(x==12){
                card.setViewport(new Rectangle2D(6, 462, 100, 150));
            }
            else if(x==13){
                card.setViewport(new Rectangle2D(110, 462, 100, 150));
            }
        }
    }
    private int getIndexCard(String cardstr){
        for (int i=0;i<13;i++){
            if(cardstr.equals("card"+i)||cardstr.equals("pot"+i)){
                System.out.println("getIndexCard = "+i);
                return i;
            }
        }
        return 0;
    }


    //BUTTON
    @FXML
    private Button  btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;

    @FXML
    public void selectCardwithButton(ActionEvent actionEvent) {
        String buttonevent=((Button)actionEvent.getSource()).getId();
        int index =getIndexButton(buttonevent);
        System.out.println(index +"   " + getValueButton(index));

        setValueCard(pot0,getValueButton(index));
        showImageCard(y[index],x[index],pot0);

    }
    private int getIndexButton(String button){
        for (int i=0;i<13;i++){
            if(button.equals("btn"+i)){
                return i;
            }
        }
        return 0;
    }




    private void setValueButton(String button,int index,int value){
        if(button.equals("btn"+index))
        {
            arrayCard1[index]=value;
        }
    }
    private int getValueButton(int index){
        return arrayCard1[index];
    }





    @FXML
    public void upScale(MouseEvent mouseEvent) {
        String buttonevent=((Button)mouseEvent.getSource()).getId();
        int i=getIndexButton(buttonevent);
        card52.get(i).setScaleX(13);
        card52.get(i).setScaleY(13);
    }

    @FXML
    public void defaultScale(MouseEvent mouseEvent) {
        String buttonevent=((Button)mouseEvent.getSource()).getId();
        int i=getIndexButton(buttonevent);
        card52.get(i).setScaleX(10);
        card52.get(i).setScaleY(10);

    }

    @FXML
    void goBack(ActionEvent event) throws Exception{
        Parent sceneCardParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene sceneCardScene=new Scene(sceneCardParent);
        Stage sceneCardStage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        sceneCardStage.setScene(sceneCardScene);
        sceneCardStage.show();
    }
    @FXML
    void initialize() {
        //assert card != null : "fx:id=\"card\" was not injected: check your FXML file 'screenCard.fxml'.";

    }



}
