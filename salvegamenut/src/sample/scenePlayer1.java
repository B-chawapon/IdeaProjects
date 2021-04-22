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
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.*;

public class scenePlayer1  {
    private Card decktest=new Card();
    private  int[] arrayCard1=new int[52];

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Game game=new Game();
    //private boolen canAccept;

    @FXML
    public void AcceptButton(ActionEvent actionEvent) {

        System.out.println(indexOfselectedCard);
        //System.out.println(indexOfselectedCard.indexOf(9));
        //System.out.println(indexOfselectedCard.size());
        //game.canDownCardByCheckValue(indexOfselectedCard);

    }

   /*private acceptButton( star,number  ,turn ){


        game.getCardOnPlyerHand(turn)[][];




        if (true){
            showtopcard(game.getTop)



        }
        else{
            //show error cant



        }



    }*/

    /*mouseclicked(){




        if()
            acceptbutton


    }*/





    @FXML
    private ImageView   card0,card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12;
    @FXML
    private ImageView pot0;
    private double sizeViewPortX=157;
    private double sizeViewPortY=228;
    private int indexOFcardOn=0;
    private ArrayList<ImageView> card52=new ArrayList<ImageView>();

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



    private void setValueCard(int[][] player,ArrayList<ImageView> card){
        for(int i=0;i<13;i++)
        {
            String cardstr = card.get(i).getId();
            //System.out.println(cardstr);
            int index = getIndexCard(cardstr);
            x[i]=player[i][0];//number
            y[i]=player[i][1];//star

        }
        //System.out.println(index);

        //showImageCard(y[index],x[index],card);
    }

    /*private void setValueCard(ImageView card,int value){
        String cardstr=card.getId();
        //System.out.println(cardstr);
        int index=getIndexCard(cardstr);
        //System.out.println(index);
        x[index]=value%100;//number
        y[index]=value/100;//star
        //showImageCard(y[index],x[index],card);
    }*/

    private int getValueCardX(ImageView card){
        String cardstr=card.getId();
        int index=getIndexCard(cardstr);
        //System.out.print("VALUE = "+x[index]+" | ");
        return x[index];
    }
    private int getValueCardY(ImageView card){
        String cardstr=card.getId();
        int index=getIndexCard(cardstr);
        //System.out.println("STAR = "+y[index]+" "+cardstr);

        return y[index];
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
                //System.out.println("getIndexCard = "+i);
                return i;
            }
        }
        return 0;
    }
    private int countSelect=0;
    private boolean[] canUpScaleCard ={false,false,false,false,false,false,false,false,false,false,false,false,false};

    private boolean[] selectedCard={false,false,false,false,false,false,false,false,false,false,false,false,false};


    private ArrayList<Integer> indexOfselectedCard=new ArrayList<>();
    @FXML
    public void selectCard(MouseEvent mouseEvent) {

        String Imageview=((ImageView)mouseEvent.getSource()).getId();
        int index =getIndexCard(Imageview);

        System.out.println(Imageview);

        if(selectedCard[index]==false) {
            if(countSelect<4) {
                card52.get(index).setScaleY(12);
                card52.get(index).setScaleX(12);
                selectedCard[index] = true;
                canUpScaleCard[index] = true;

                indexOfselectedCard.add(index);//9 10 11
                countSelect += 1;
                //System.out.println(countSelect);
            }

        }
        else if(selectedCard[index]==true){
            card52.get(index).setScaleY(10);
            card52.get(index).setScaleX(10);
            canUpScaleCard[index]=false;
            selectedCard[index]=false;

            System.out.println("FOUND");
            indexOfselectedCard.remove(indexOfselectedCard.indexOf(index));
            countSelect-=1;
            //System.out.println(countSelect);

        }


        //countSelect+=1;
    }


    //BUTTON
    /*
    @FXML

    private Button  btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
    private ArrayList<Button> btnArray=new ArrayList<>();

    private void saveArrayButton(){
        btnArray.add(btn0);
        btnArray.add(btn1);
        btnArray.add(btn2);
        btnArray.add(btn3);
        btnArray.add(btn4);
        btnArray.add(btn5);
        btnArray.add(btn6);
        btnArray.add(btn7);
        btnArray.add(btn8);
        btnArray.add(btn9);
        btnArray.add(btn10);
        btnArray.add(btn11);
        btnArray.add(btn12);

    }
    @FXML
    public void selectCardtoShowpot(ActionEvent actionEvent) {
        String buttonevent=((Button)actionEvent.getSource()).getId();
        int index =getIndexButton(buttonevent);
        //System.out.println(index +"   " + getValueButton(index));
        //setValueCard(pot0,getValueButton(index));
        showImageCard(y[index],x[index],pot0);
        System.out.print("VALUE BUTTON = "+getValueButtonX(btnArray.get(index))+" | ");
        System.out.println("STAR BUTTON = "+getValueButtonY(btnArray.get(index))+" "+btnArray.get(index).getId());

    }
    private int getIndexButton(String button){
        for (int i=0;i<13;i++){
            if(button.equals("btn"+i)){
                return i;
            }
        }
        return 0;
    }


    /*private void setValueButton(String button,int index,int value){
        if(button.equals("btn"+index))
        {
            arrayCard1[index]=value;
        }
    }


    private int getValueButtonX(Button btn){
        String btnstr=btn.getId();
        int index=getIndexButton(btnstr);
        return x[index];
    }
    private int getValueButtonY(Button btn){
        String btnstr=btn.getId();
        int index=getIndexButton(btnstr);
        return y[index];
    }

    */



    @FXML
    public void upScale(MouseEvent mouseEvent) {
        String Imageviewevent=((ImageView)mouseEvent.getSource()).getId();
        int i=getIndexCard(Imageviewevent);
        if(canUpScaleCard[i]==false) {
            card52.get(i).setScaleX(12);
            card52.get(i).setScaleY(12);
        }
    }

    @FXML
    public void defaultScale(MouseEvent mouseEvent) {
        String Imageviewevent=((ImageView)mouseEvent.getSource()).getId();
        int i=getIndexCard(Imageviewevent);
        if(canUpScaleCard[i]==false) {
            card52.get(i).setScaleX(10);
            card52.get(i).setScaleY(10);
        }

    }

    @FXML
    void goBack(ActionEvent event) throws Exception{
        Parent sceneCardParent = FXMLLoader.load(getClass().getResource("sceneMenu.fxml"));
        Scene sceneCardScene=new Scene(sceneCardParent);
        Stage sceneCardStage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        sceneCardStage.setScene(sceneCardScene);
        sceneCardStage.show();
    }


    @FXML
    void initialize() {
        //assert card != null : "fx:id=\"card\" was not injected: check your FXML file 'screenCard.fxml'.";
        saveArrayImage();
        //saveArrayButton();

        setValueCard( game.p[0].getPlayerCard(),card52);
        for(int i=0;i<13;i++) {
            showImageCard(y[i], x[i], card52.get(i));

            System.out.print("VALUE = "+getValueCardX(card52.get(i))+" | ");
            System.out.println("STAR = "+getValueCardY(card52.get(i))+" "+card52.get(i).getId());
        }

    }



}
