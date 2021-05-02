package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class scenePlayer1 implements upScaleImageView {

    private Card decktest = new Card();
    private int[] arrayCard1 = new int[52];

    @FXML
    private Game game = new Game();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //private boolen canAccept;
    @FXML
    private ImageView exitButton;
    @FXML
    private ImageView goBackButton;

    @FXML
    private ImageView AcceptButton;
    @FXML
    private Text cardp0, cardp1, cardp2, cardp3, player0Name, player1Name, player2Name, player3Name;//card counting on the left side of players pics. Not start to do sth. with it yet ka

    //@FXML
    //public void AcceptButton(ActionEvent actionEvent) {
    //System.out.println(indexOfselectedCard);
    //System.out.println(indexOfselectedCard.indexOf(9));
    //System.out.println(indexOfselectedCard.size());
    //game.canDownCardByCheckValue(indexOfselectedCard);
    // }

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
    private ImageView card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
    @FXML
    private ImageView pot0, pot1, pot2, pot3, pot4, pot5, pot6;//parn add pot1.. pot6 for add multiple cards, but not start yet ka
    @FXML
    private ImageView player0, player1, player2, player3;//parn added, worked, but not fully successful. Need to random the first player

    @FXML
    private ImageView optionButton;

    @FXML
    private ImageView tradeButton;

    private double sizeViewPortX = 157;
    private double sizeViewPortY = 228;
    private int indexOFcardOn = 0;
    private ArrayList<ImageView> card52 = new ArrayList<ImageView>();
    private ArrayList<ImageView> playerList = new ArrayList<ImageView>();
    private ArrayList<ImageView> potList = new ArrayList<ImageView>();
    private ArrayList<Image> mulanList = new ArrayList<Image>();
    private ArrayList<Image> pocaList = new ArrayList<Image>();
    private ArrayList<Image> snowList = new ArrayList<Image>();
    private ArrayList<Image> tianaList = new ArrayList<Image>();
    private ArrayList<Integer> tradeList = new ArrayList<Integer>();
    private boolean isTrading = false;

    private void saveArrayImage() {

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

    private void saveArrayPlayer() {
        playerList.add(player0);
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

    }

    private void saveArrayPot() {
        potList.add(pot0);
        potList.add(pot1);
        potList.add(pot2);
        potList.add(pot3);
        potList.add(pot4);
        potList.add(pot5);
        potList.add(pot6);
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

    private int[] x = new int[13];
    private int[] y = new int[13];

    @FXML
    private void setValueCard(int[][] player, ArrayList<ImageView> card) {
        for (int i = 0; i < 13; i++) {
            String cardstr = card.get(i).getId();
            //System.out.println(cardstr);
            int index = getIndexCard(cardstr);
            x[i] = player[i][0];//number
            y[i] = player[i][1];//star

        }

    }

    private int getValueCardX(ImageView card) {
        String cardstr = card.getId();
        int index = getIndexCard(cardstr);
        return x[index];
    }

    private int getValueCardY(ImageView card) {
        String cardstr = card.getId();
        int index = getIndexCard(cardstr);

        return y[index];
    }

    private Image backsideimg = new Image("/pics.parn/backsidecard.png");
    private Image frontside = new Image("/Pic/parn2048px-Atlasnye_playing_cards_deck.png");

    private void showImageCard(int y, int x, ImageView card) {
        if (x != 0 || y != 0) {
            card.setImage(frontside);
            card.setScaleX(10);
            card.setScaleY(10);

            if (y == 1) {
                if (x == 1) {//dai 3
                    card.setViewport(new Rectangle2D(214, 310, 100, 150));
                } else if (x >= 2 && x <= 11) {
                    card.setViewport(new Rectangle2D(214 + ((x - 1) * 104) + (-0.1 * x), 310, 100, 150));
                } else if (x == 12) {
                    card.setViewport(new Rectangle2D(6, 310, 100, 150));
                } else if (x == 13) {
                    card.setViewport(new Rectangle2D(110, 310, 100, 150));
                }
            } else if (y == 2) {
                if (x == 1) {//dai 3
                    card.setViewport(new Rectangle2D(214, 158, 100, 150));
                } else if (x >= 2 && x <= 11) {
                    card.setViewport(new Rectangle2D(214 + ((x - 1) * 104) + (-0.1 * x), 158, 100, 150));
                } else if (x == 12) {
                    card.setViewport(new Rectangle2D(6, 158, 100, 150));
                } else if (x == 13) {
                    card.setViewport(new Rectangle2D(110, 158, 100, 150));
                }
            } else if (y == 3) {
                if (x == 1) {//dai 3
                    card.setViewport(new Rectangle2D(214, 6, 100, 150));
                } else if (x >= 2 && x <= 11) {
                    card.setViewport(new Rectangle2D(214 + ((x - 1) * 104) + (-0.1 * x), 6, 100, 150));
                } else if (x == 12) {
                    card.setViewport(new Rectangle2D(6, 6, 100, 150));
                } else if (x == 13) {
                    card.setViewport(new Rectangle2D(110, 6, 100, 150));
                }
            } else if (y == 4) {
                if (x == 1) {//dai 3
                    card.setViewport(new Rectangle2D(214, 462, 100, 150));
                } else if (x >= 2 && x <= 11) {
                    card.setViewport(new Rectangle2D(214 + ((x - 1) * 104) + (-0.1 * x), 462, 100, 150));
                } else if (x == 12) {
                    card.setViewport(new Rectangle2D(6, 462, 100, 150));
                } else if (x == 13) {
                    card.setViewport(new Rectangle2D(110, 462, 100, 150));
                }
            }

        } else {
            card.setImage(backsideimg);
            card.setViewport(new Rectangle2D(0, 0, 118, 175));
        }

    }

    private int getIndexCard(String cardstr) {
        for (int i = 0; i < 13; i++) {
            if (cardstr.equals("card" + i)) {
                //System.out.println("getIndexCard = "+i);
                return i;
            }
        }
        return 0;
    }

    private int countSelect = 0;
    private boolean[] canUpScaleCard = {false, false, false, false, false, false, false, false, false, false, false, false, false};

    private boolean[] selectedCard = {false, false, false, false, false, false, false, false, false, false, false, false, false};

    private ArrayList<Integer> indexOfselectedCard = new ArrayList<>();

    //    public static Media mediaselectedCard;
//    public static MediaPlayer mediaPlayerselectedCard;
    private int countTrade = 0;

    @FXML
    public void selectCard(MouseEvent mouseEvent) {
        //  mediaPlayerUpScaleCard.stop();
//        mediaselectedCard = new Media(getClass().getResource("C:\\Users\\parn\\Documents\\NetBeansProjects\\sample\\src\\audio.parn\\toy.mp3").toExternalForm());
//        mediaPlayerselectedCard = new MediaPlayer(mediaselectedCard);

//        mediaPlayerselectedCard.setVolume(SoundController.sfxvolume);
//        mediaPlayerselectedCard.play();

        SoundController.mediaPlayermouseEnter.stop();
        SoundController.setMediaclicked("/audio.parn/mouseEnter1.mp3");
        SoundController.mediaPlayerClick.setVolume(SoundController.sfxvolume);
        SoundController.mediaPlayerClick.play();



        String Imageview = ((ImageView) mouseEvent.getSource()).getId();
        int index = getIndexCard(Imageview);
//        if (game.isFirstRoundEnd()) {
//            if (selectedCard[index] == false) {
//                if (countSelect < 2 && game.p[game.getKing()].getKQPS() == 1) {
//                    card52.get(index).setScaleY(12);
//                    card52.get(index).setScaleX(12);
//                    selectedCard[index] = true;
//                    canUpScaleCard[index] = true;
//
//                    indexOfselectedCard.add(index);//9 10 11
//                    countSelect += 1;
//
//                } else {
//                    card52.get(index).setScaleY(12);
//                    card52.get(index).setScaleX(12);
//                    selectedCard[index] = true;
//                    canUpScaleCard[index] = true;
//
//                    indexOfselectedCard.add(index);//9 10 11
//                    countSelect += 1;
//                }
//
//            } else if (selectedCard[index] == true) {
//                card52.get(index).setScaleY(10);
//                card52.get(index).setScaleX(10);
//                canUpScaleCard[index] = false;
//                selectedCard[index] = false;
//
//                //System.out.println("FOUND");
//                indexOfselectedCard.remove(indexOfselectedCard.indexOf(index));
//                countSelect -= 1;
//                //System.out.println(countSelect);
//
//            }
//
////            if (tradeCardSelected.get(countTrade) == null) {
////                tradeList.add(index);
////                tradeCardSelected.add(1);
////                countTrade += 1;
////            } else if (tradeCardSelected.get(countTrade) == 1) {
////                tradeCardSelected.remove(index);
////            }
//        }

        System.out.print("VALUE = " + x[index] + " | ");
        System.out.println("STAR = " + y[index] + " ");
        byte maxUpScale;
        if (countTrade == 0 && isTrading == true) {
            maxUpScale = 2;
        } else if (countTrade == 1) {

            maxUpScale = 1;
        } else {
            maxUpScale = 4;
        }

        if (selectedCard[index] == false) {
            if (countSelect < maxUpScale) {
                card52.get(index).setScaleY(12);
                card52.get(index).setScaleX(12);
                selectedCard[index] = true;
                canUpScaleCard[index] = true;

                indexOfselectedCard.add(index);//9 10 11
                countSelect += 1;
                System.out.println(countSelect);
            }

        } else if (selectedCard[index] == true) {
            card52.get(index).setScaleY(10);
            card52.get(index).setScaleX(10);
            canUpScaleCard[index] = false;
            selectedCard[index] = false;

            //System.out.println("FOUND");
            indexOfselectedCard.remove(indexOfselectedCard.indexOf(index));
            countSelect -= 1;
            //System.out.println(countSelect);

        }
        System.out.println("selevcetg card" + selectedCard.toString());

    }

    @FXML
    public void setPot() {

        if (game.getAmount() == 1) {
            showImageCard(game.getLast()[0][1], game.getLast()[0][0], pot0);
        } else if (game.getAmount() == 2) {
            showImageCard(game.getLast()[0][1], game.getLast()[0][0], pot2);
            showImageCard(game.getLast()[1][1], game.getLast()[1][0], pot1);
        } else if (game.getAmount() == 3) {
            showImageCard(game.getLast()[0][1], game.getLast()[0][0], pot4);
            showImageCard(game.getLast()[1][1], game.getLast()[1][0], pot0);
            showImageCard(game.getLast()[2][1], game.getLast()[2][0], pot3);
        } else if (game.getAmount() == 4) {
            showImageCard(game.getLast()[0][1], game.getLast()[0][0], pot6);
            showImageCard(game.getLast()[1][1], game.getLast()[1][0], pot2);
            showImageCard(game.getLast()[2][1], game.getLast()[2][0], pot1);
            showImageCard(game.getLast()[3][1], game.getLast()[3][0], pot5);
        }
        setPotVisibility();
        pot0.setScaleX(1);
        pot0.setScaleY(1);

    }

    @FXML
    public void setPotVisibility() {
        System.out.println("Amout " + game.getAmount());
        if (game.getAmount() == 1) {
            System.out.println("Amout = 1");
            if (game.getLast()[0][1] == 0) {
                pot0.setVisible(false);
            } else {
                pot0.setVisible(true);
            }
            for (int i = 1; i < 7; i++) {
                potList.get(i).setVisible(false);
            }
        } else if (game.getAmount() == 2) {//pot1,2 ON
            if (game.getLast()[0][1] == 0) {
                pot1.setVisible(false);
                pot2.setVisible(false);
            }
            for (int i = 0; i < 7; i++) {

                if (i == 1 || i == 2) {
                    potList.get(i).setVisible(true);
                    potList.get(i).setScaleX(1);
                    potList.get(i).setScaleY(1);

                } else {

                    potList.get(i).setVisible(false);
                }
            }
        } else if (game.getAmount() == 3) {//pot3,0,4 ON
            if (game.getLast()[0][1] == 0) {
                pot3.setVisible(false);
                pot0.setVisible(false);
                pot4.setVisible(false);

            }
            for (int i = 0; i < 7; i++) {

                if (i == 3 || i == 0 || i == 4) {
                    potList.get(i).setVisible(true);
                    potList.get(i).setScaleX(1);
                    potList.get(i).setScaleY(1);

                } else {

                    potList.get(i).setVisible(false);
                }
            }
        } else if (game.getAmount() == 4) {//pot5,1,2,6 ON
            if (game.getLast()[0][1] == 0) {
                pot5.setVisible(false);
                pot6.setVisible(false);
                pot1.setVisible(false);
                pot2.setVisible(false);
            } else {
                pot5.setVisible(true);
                pot6.setVisible(true);
                pot1.setVisible(true);
                pot2.setVisible(true);
            }
            pot3.setVisible(false);
            pot0.setVisible(false);
            pot4.setVisible(false);
        } else if (game.getLastFace() == 0 && game.getLastSuit() == 0) {
            for (int i = 0; i < 7; i++) {

                potList.get(i).setVisible(false);

            }
        } else if (game.isFirstRoundEnd() && isTrading == true) {
            for (int i = 0; i < 7; i++) {

                potList.get(i).setVisible(false);

            }
        }

    }
//    public static Media mediaUpscaleCard;
//    public static MediaPlayer mediaPlayerUpScaleCard;


    @FXML
    public void upScale(MouseEvent mouseEvent) {
//        mediaUpscaleCard=new Media(setMediaFile("mouseEnterCard.mp3"));
//        mediaPlayerUpScaleCard=new MediaPlayer(mediaUpscaleCard);

        SoundController.setMediaEnter("/audio.parn/mouseEnterCard.mp3");
        SoundController.mediaPlayermouseEnter.setVolume(SoundController.sfxvolume);
        SoundController.mediaPlayermouseEnter.play();
//
//        mediaPlayerUpScaleCard.setVolume(SoundController.sfxvolume);
//        mediaPlayerUpScaleCard.play();
//        System.out.println(mediaPlayerUpScaleCard.getVolume()+" = VO");
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        int i = getIndexCard(Imageviewevent);
        if (canUpScaleCard[i] == false) {
            card52.get(i).setScaleX(12);
            card52.get(i).setScaleY(12);
        }

    }


    @FXML
    public void defaultScale(MouseEvent mouseEvent) {
        //mediaPlayerUpScaleCard.stop();
        //SoundController.mediaPlayermouseEnter.stop();
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        int i = getIndexCard(Imageviewevent);
        if (canUpScaleCard[i] == false) {
            card52.get(i).setScaleX(10);
            card52.get(i).setScaleY(10);
        }
    }

    public void setAndShow() {
        if (isTrading == true) {
            if (countTrade == 0) {
                setValueCard(game.p[game.getKing()].getPlayerCard(), card52);
                for (int i = 0; i < 13; i++) {
                    showImageCard(y[i], x[i], card52.get(i));
                    System.out.print("VALUE = " + getValueCardX(card52.get(i)) + " | ");
                    System.out.println("STAR = " + getValueCardY(card52.get(i)) + " " + card52.get(i).getId());
                }
            } else if (countTrade == 1) {
                setValueCard(game.p[game.getQueen()].getPlayerCard(), card52);
                for (int i = 0; i < 13; i++) {
                    showImageCard(y[i], x[i], card52.get(i));
                    System.out.print("VALUE = " + getValueCardX(card52.get(i)) + " | ");
                    System.out.println("STAR = " + getValueCardY(card52.get(i)) + " " + card52.get(i).getId());
                }
            }

        } else {
            setValueCard(game.p[game.getTurn()].getPlayerCard(), card52);
            for (int i = 0; i < 13; i++) {
                showImageCard(y[i], x[i], card52.get(i));
                System.out.print("VALUE = " + getValueCardX(card52.get(i)) + " | ");
                System.out.println("STAR = " + getValueCardY(card52.get(i)) + " " + card52.get(i).getId());
            }
        }

    }

    // public static Media soundbgmedia;
    //public static MediaPlayer soundmediaPlayer;
    @FXML
    void initialize() {
        // soundbgmedia=new Media("file:C:\\Users\\parn\\Documents\\NetBeansProjects\\sample\\src\\audio.parn\\toy.mp3");
        // soundmediaPlayer=new MediaPlayer(soundbgmedia);
        SoundController.setMediaBG("/audio.parn/soundbg.mp3");
        SoundController.mediaPlayerBGr.setVolume(SoundController.bgvolume);
        SoundController.mediaPlayerBGr.play();
        SoundController.mediaPlayerBGr.setCycleCount(99);
//
//        soundmediaPlayer.setVolume(SoundController.bgvolume);
//        soundmediaPlayer.play();
//        soundmediaPlayer.setCycleCount(99);
        game.cheat();
        game.findStartPlayer();
        saveArrayImage();
        saveArrayPlayer();
        saveArrayPot();
        saveMulanList();
        savePocaList();
        saveSnowList();
        saveTianaList();
        tradeButton.setVisible(false);

        setValueCard(game.p[game.getTurn()].getPlayerCard(), card52);
        for (int i = 0; i < 13; i++) {
            showImageCard(y[i], x[i], card52.get(i));
            System.out.print("VALUE = " + getValueCardX(card52.get(i)) + " | ");
            System.out.println("STAR = " + getValueCardY(card52.get(i)) + " " + card52.get(i).getId());
        }
        upScalePlayerImg();
        player0Name.setText(Name.name[0]);
        player1Name.setText(Name.name[1]);
        player2Name.setText(Name.name[2]);
        player3Name.setText(Name.name[3]);

    }
    @FXML
    int turnPlayer = 0;

    public void accept(MouseEvent mouseEvent) {
        //String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();

        if (indexOfselectedCard.isEmpty() != true) {//if that index is valid, you can accept
            if (game.checkDownCard(indexOfselectedCard) == true) {//
                System.out.println("cncdncdncndcndncdcndncdncndcndncndcndncdncndcndcncdncndcndcdncndndcncndcndncncnncdncndcncndncdncndcnnccncdncndcndn");
                setPot();
                setKQPSImg();
                game.checkTurn();
                if (game.isFirstRoundEnd() && countTrade == 0) {//show King's Cards on hand
                    isTrading = true;
                    setPotVisibility();
                    tradeKingSlaveCard();
                    for (int i = 0; i < 4; i++) {
                        System.out.println("Player : " + (i) + "  ");
                        game.p[i].showPlayerCardOnHand();
                    }

                }
                setAndShow();
                showCardLeft();

                if (isTrading == false) {
                    upScalePlayerImg();
                }

            } else {
                System.out.println("NO U CANT (FROM scenePlayer1)");
                //add sound
            }
        } else {
            System.out.println("NULL array");
        }
        for (int index = 0; index < 13; index++) {
            card52.get(index).setScaleX(10);
            card52.get(index).setScaleY(10);
            selectedCard[index] = false;
            canUpScaleCard[index] = false;
        }
        indexOfselectedCard.clear();
        countSelect = 0;

    }

    public void tradeKingSlaveCard() {
        tradeButton.setVisible(true);
        AcceptButton.setVisible(false);
        skipButton.setVisible(false);

        for (int i = 0; i < 4; i++) {
            if (i != game.getKing()) {
                playerList.get(i).setScaleX(1);
                playerList.get(i).setScaleY(1);
            }
        }
        playerList.get(game.getKing()).setScaleX(1.3);
        playerList.get(game.getKing()).setScaleY(1.3);

        for (int i = 0; i < 7; i++) {
            potList.get(i).setVisible(false);
        }
        game.tradeCard();
        showCardLeft();
        game.startGame();
//setSlaveImage
        if (game.getSlave() == 0) {
            player0.setImage(mulanList.get(4));
        } else if (game.getSlave() == 1) {
            player1.setImage(pocaList.get(4));
        } else if (game.getSlave() == 2) {
            player2.setImage(snowList.get(4));
        } else if (game.getSlave() == 3) {
            player3.setImage(tianaList.get(4));
        }


    }

    @FXML
    private void exitButtonAction(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        Parent sceneCardParent = FXMLLoader.load(getClass().getResource("sceneMenuParn.fxml"));
        Scene sceneCardScene = new Scene(sceneCardParent);
        Stage sceneCardStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sceneCardStage.setScene(sceneCardScene);
//
//        soundmediaPlayer.stop();
//        mediaPlayerselectedCard.stop();
//        mediaPlayerUpScaleCard.stop();
        SoundController.mediaPlayerBGr.stop();
        SoundController.mediaPlayerClick.stop();
        SoundController.mediaPlayermouseEnter.stop();
        sceneCardStage.show();
    }

    @FXML
    private void option(MouseEvent event) throws IOException {
        SoundController.display();
    }

    @Override
    public void upScaleButtton(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("AcceptButton")) {
            AcceptButton.setScaleX(1.2);
            AcceptButton.setScaleY(1.2);
        } else if (Imageviewevent.equals("exitButton")) {
            exitButton.setScaleX(1.2);
            exitButton.setScaleY(1.2);
        } else if (Imageviewevent.equals("goBackButton")) {
            goBackButton.setScaleX(1.2);
            goBackButton.setScaleY(1.2);
        } else if (Imageviewevent.equals("skipButton")) {
            skipButton.setScaleX(1.2);
            skipButton.setScaleY(1.2);
        } else if (Imageviewevent.equals("tradeButton")) {
            tradeButton.setScaleX(1.2);
            tradeButton.setScaleY(1.2);
        }
        else if (Imageviewevent.equals("optionButton")) {
            optionButton.setScaleX(1.2);
            optionButton.setScaleY(1.2);
        }
    }

    @Override
    public void defaultScaleButton(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        if (Imageviewevent.equals("AcceptButton")) {
            AcceptButton.setScaleX(1);
            AcceptButton.setScaleY(1);
        } else if (Imageviewevent.equals("exitButton")) {
            exitButton.setScaleX(1);
            exitButton.setScaleY(1);
        } else if (Imageviewevent.equals("goBackButton")) {
            goBackButton.setScaleX(1);
            goBackButton.setScaleY(1);
        } else if (Imageviewevent.equals("skipButton")) {
            skipButton.setScaleX(1);
            skipButton.setScaleY(1);
        } else if (Imageviewevent.equals("tradeButton")) {
            tradeButton.setScaleX(1);
            tradeButton.setScaleY(1);
        }
        else if (Imageviewevent.equals("optionButton")) {
            optionButton.setScaleX(1);
            optionButton.setScaleY(1);
        }
    }

    @FXML
    private ImageView skipButton;

    @FXML
    public void skip(MouseEvent mouseEvent) {
        String Imageviewevent = ((ImageView) mouseEvent.getSource()).getId();
        game.skip();
        setPot();
        showCardLeft();
        upScalePlayerImg();

        System.out.println("skipped");
        setValueCard(game.p[game.getTurn()].getPlayerCard(), card52);
        for (int i = 0; i < 13; i++) {
            showImageCard(y[i], x[i], card52.get(i));
            System.out.print("VALUE = " + getValueCardX(card52.get(i)) + " | ");
            System.out.println("STAR = " + getValueCardY(card52.get(i)) + " " + card52.get(i).getId());
        }
        for (int index = 0; index < 13; index++) {
            card52.get(index).setScaleX(10);
            card52.get(index).setScaleY(10);
            selectedCard[index] = false;
            canUpScaleCard[index] = false;
        }
        indexOfselectedCard.clear();
        countSelect = 0;

    }

    public void showCardLeft() {
        cardp0.setText(game.p[0].countCardOnPlayerHandStr());
        cardp1.setText(game.p[1].countCardOnPlayerHandStr());
        cardp2.setText(game.p[2].countCardOnPlayerHandStr());
        cardp3.setText(game.p[3].countCardOnPlayerHandStr());
        System.out.println(game.getTurn());
    }

    public void upScalePlayerImg() {
        player0.setScaleX(1.3);
        player0.setScaleY(1.3);
        if (game.getTurn() % 4 == 0) {
            player0.setScaleX(1.2);
            player0.setScaleY(1.2);
            for (int i = 1; i < 4; i++) {
                playerList.get(i).setScaleX(1);
                playerList.get(i).setScaleY(1);
            }
        } else if (game.getTurn() % 4 == 1) {
            player1.setScaleX(1.2);
            player1.setScaleY(1.2);
            for (int i = 0; i < 4; i++) {
                if (i != 1) {
                    playerList.get(i).setScaleX(1);
                    playerList.get(i).setScaleY(1);
                }
            }

        } else if (game.getTurn() % 4 == 2) {
            player2.setScaleX(1.2);
            player2.setScaleY(1.2);
            for (int i = 0; i < 4; i++) {
                if (i != 2) {
                    playerList.get(i).setScaleX(1);
                    playerList.get(i).setScaleY(1);
                }
            }
        } else if (game.getTurn() % 4 == 3) {

            player3.setScaleX(1.2);
            player3.setScaleY(1.2);
            for (int i = 0; i < 4; i++) {
                if (i != 3) {
                    playerList.get(i).setScaleX(1);
                    playerList.get(i).setScaleY(1);
                }
            }
        }
    }

    void setKQPSImg() {
        if (game.p[game.getTurn()].getKQPS() != 0) {
            if (game.p[game.getTurn()].getKQPS() == 1) {
                //King
                if (game.getTurn() == 0) {
                    player0.setImage(mulanList.get(1));
                } else if (game.getTurn() == 1) {
                    player1.setImage(pocaList.get(1));
                } else if (game.getTurn() == 2) {
                    player2.setImage(snowList.get(1));
                } else if (game.getTurn() == 3) {
                    player3.setImage(tianaList.get(1));
                }

            }
            if (game.p[game.getTurn()].getKQPS() == 2) {
                //queen
                if (game.getTurn() == 0) {
                    player0.setImage(mulanList.get(2));
                } else if (game.getTurn() == 1) {
                    player1.setImage(pocaList.get(2));
                } else if (game.getTurn() == 2) {
                    player2.setImage(snowList.get(2));
                } else if (game.getTurn() == 3) {
                    player3.setImage(tianaList.get(2));
                }

            }
            if (game.p[game.getTurn()].getKQPS() == 3) {
                //people

                if (game.getTurn() == 0) {
                    player0.setImage(mulanList.get(3));
                } else if (game.getTurn() == 1) {
                    player1.setImage(pocaList.get(3));
                } else if (game.getTurn() == 2) {
                    player2.setImage(snowList.get(3));
                } else if (game.getTurn() == 3) {
                    player3.setImage(tianaList.get(3));
                }

            }

        }
    }

    void tradeQueenPeopleCard() {
        game.tradeQueen(indexOfselectedCard, game.getQueen(), game.getPeople());
        showCardLeft();

        game.restart();
        //game.tradeKing(indexOfselectedCard, game.getKing(), game.getSlave());
        //indexOfselectedCard.get(indexOFcardOn);
        for (int index = 0; index < 13; index++) {
            card52.get(index).setScaleX(10);
            card52.get(index).setScaleY(10);
            selectedCard[index] = false;
            canUpScaleCard[index] = false;
        }
        indexOfselectedCard.clear();
        countSelect = 0;

        //indexOfselectedCard.get(indexOFcardOn);
    }

    @FXML
    void tradeButtonAction() {
        if (countTrade == 0) {
            game.tradeKing(indexOfselectedCard, game.getKing(), game.getSlave());

            for (int index = 0; index < 13; index++) {
                card52.get(index).setScaleX(10);
                card52.get(index).setScaleY(10);
                selectedCard[index] = false;
                canUpScaleCard[index] = false;
            }
            for (int i = 0; i < 4; i++) {
                if (i != game.getQueen()) {
                    playerList.get(i).setScaleX(1);
                    playerList.get(i).setScaleY(1);
                }
            }
            indexOfselectedCard.clear();
            countSelect = 0;
            playerList.get(game.getQueen()).setScaleX(1.3);
            playerList.get(game.getQueen()).setScaleY(1.3);

        } else if (countTrade == 1) {
            System.out.println("index of selected card " + indexOfselectedCard);
            tradeQueenPeopleCard();

            AcceptButton.setVisible(true);
            skipButton.setVisible(true);
            tradeButton.setVisible(false);

            isTrading = false;
            playerList.get(game.getSlave()).setScaleX(1.3);
            playerList.get(game.getSlave()).setScaleY(1.3);
            for (int i = 0; i < 4; i++) {
                if (i != game.getSlave()) {
                    playerList.get(i).setScaleX(1);
                    playerList.get(i).setScaleY(1);
                }

            }
            indexOfselectedCard.clear();
            game.setTurn(game.getSlave());
            for (int i = 0; i < 4; i++) {
                System.out.println("Player : " + (i) + "  ");
                game.p[i].showPlayerCardOnHand();
            }

        }
        countTrade++;
        setAndShow();


    }

//    public String setMediaFile(String filename){
//        return "file:" + System.getProperty("user.dir") + "/src/audio.parn/"+filename;
//    }
}