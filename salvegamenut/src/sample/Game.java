package sample;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Game {

    private int turn;
    private int lastSuit;
    private int lastFace;
    private boolean secondRound;
    private int kQPS;
    Card card = new Card();
    Player p[] = new Player[4];

    //This function use at start botton. To random 52 cards and give to each player
    //Player 1,2,3,4 have their own card(13 cards).
    private void startGame(){
        card.fillRandomCard();
        p[0] = new Player(10, 1);
        p[1] = new Player(20, 2);
        p[2] = new Player(30, 3);
        p[3] = new Player(40, 4);

        p[0].startDrawCard(card.getRandomCard(), 1);
        p[1].startDrawCard(card.getRandomCard(), 2);
        p[2].startDrawCard(card.getRandomCard(), 3);
        p[3].startDrawCard(card.getRandomCard(), 4);

        findStartPlayer();

        //Testing setRole
        /*for(int i = 0 ; i < 12 ; i++){
            p[0].getPlayerCard()[i][0] = 0;
            p[0].getPlayerCard()[i][1] = 0;
        }*/
    }

    public Game() {
        startGame();
    }

    public Game(int suit, int face) {
        this.lastSuit = suit;
        this.lastFace = face;

    }

    public boolean canDownCardByCheckSkip(){
        if(p[0].isSkipTurn() && p[1].isSkipTurn() && p[2].isSkipTurn() && p[3].isSkipTurn()){
            lastFace = 0;
            lastSuit = 0;
            for(int i = 0 ; i < 4 ; i++){
                p[i].setSkipTurn(false);
            }
            return false;
        }
        else{
            return true;
        }

    }

    public void canDownCardByCheckValue(int choose){
        //choose is the order of card that player what to dep
       //choose -= 1;    //if index begin from 0. You can cut this line
        if (p[turn].getKQPS() == 0) {
            if (p[turn].getPlayerCard()[choose][0] > lastFace && !p[turn].isSkipTurn()) {
                lastFace = p[turn].getPlayerCard()[choose][0];
                lastSuit = p[turn].getPlayerCard()[choose][1];
                p[turn].getPlayerCard()[choose][0] = 0;
                p[turn].getPlayerCard()[choose][1] = 0;
                checkGiveKQPS(turn);
                turn++;
            } else if (p[turn].getPlayerCard()[choose][0] == lastFace) {
                if (p[turn].getPlayerCard()[choose][1] > lastSuit) {
                    lastFace = p[turn].getPlayerCard()[choose][0];
                    lastSuit = p[turn].getPlayerCard()[choose][1];
                    p[turn].getPlayerCard()[choose][0] = 0;
                    p[turn].getPlayerCard()[choose][1] = 0;
                    checkGiveKQPS(turn);
                    turn++;
                } else {
                    System.out.println("You can't choose is card");
                }
            } else {
                System.out.println("You can't choose is card");
            }
        }
        if (turn > 3) {
            turn = 0;
        }
    }

    public void doGame() {
        Scanner input = new Scanner(System.in);
        //Show card on player hand

        System.out.println("Top face and suit is : " + lastFace + " " + lastSuit);
        System.out.println("Turn : " + (turn + 1) + " Player : " + p[turn].getID());
        p[turn].showPlayerCardOnHand();
        System.out.println("0 for skip");
        System.out.print("Choose card : ");
        int choose = input.nextInt();
        if(choose == 0){
            p[turn].setSkipTurn(true);
            turn++;
        }else if(canDownCardByCheckSkip()){
            canDownCardByCheckValue(choose);

        }

        /*if (!(p[0].isSkipTurn() || p[1].isSkipTurn() || p[2].isSkipTurn() || p[3].isSkipTurn())) {
            if (p[turn].getPlayerCard()[choose][0] > lastFace && !p[turn].isSkipTurn()) {
                lastFace = p[turn].getPlayerCard()[choose][0];
                lastSuit = p[turn].getPlayerCard()[choose][1];
                p[turn].getPlayerCard()[choose][0] = 0;
                p[turn].getPlayerCard()[choose][1] = 0;
                checkGiveKQPS(turn);
                turn++;
            } else if (p[turn].getPlayerCard()[choose][0] == lastFace) {
                if (p[turn].getPlayerCard()[choose][1] > lastSuit) {
                    lastFace = p[turn].getPlayerCard()[choose][0];
                    lastSuit = p[turn].getPlayerCard()[choose][1];
                    p[turn].getPlayerCard()[choose][0] = 0;
                    p[turn].getPlayerCard()[choose][1] = 0;
                    checkGiveKQPS(turn);
                    turn++;
                } else {
                    System.out.println("You can't choose is card");
                }
            } else {
                System.out.println("You can't choose is card");
            }
        }*/


        /*if (p[0].isSkipTurn() && p[1].isSkipTurn() && p[2].isSkipTurn() && p[3].isSkipTurn()){
            lastFace = 0;
            lastSuit = 0;
            for(int i = 0 ; i < 4 ; i++){
                p[i].setSkipTurn(false);
            }
        }*/


    }
    /**
     * Find who has 101 card
     */
    public void findStartPlayer(){
        for(int i = 0 ; i < p.length ; i++){
            for(int j = 0 ; j < p[i].getPlayerCard().length ; j++){
                if(p[i].getPlayerCard()[j][0] == 1 && p[i].getPlayerCard()[j][1] == 1){
                    turn = i;
                    break;
                }

            }

        }

    }

    /**
     * To get card on player's hand. By passing player index(0 -> 3)
     * And return [13][2] array
     * But why it doesn't work!!!!
     * @return
     */
    public int[][] getCardOnPlyerHand(int i){
        return p[i].getPlayerCard();
    }

    private void checkGiveKQPS(int turn){
        boolean isWin = true;
        for(int i = 0 ; i < p[turn].getPlayerCard().length && p[turn].getKQPS() == 0 ; i++){
            System.out.println("C");
            if(p[turn].getPlayerCard()[i][0] != 0 && p[turn].getPlayerCard()[i][1] != 0){
                System.out.println("F");
                isWin = false;
                break;
            }
        }
        if(isWin == true){
            p[turn].setKQPS(kQPS);
            showKQPS(p[turn].getKQPS());
            if(kQPS == 2){

            }
            kQPS += 1;

        }

        /*for(int i = 0 ; i < p.length ; i++){
            for(int j = 0 ; j < p[i].getPlayerCard().length ; j++){
                if(p[i].getPlayerCard()[j][0] != 0 && p[i].getPlayerCard()[j][1] != 0 && p[i].getKQPS() == 0){

                }
            }
        }*/
    }
    //For test only
    public void justForTesting(){
        kQPS = 1;
        p[0] = new Player(10, 1);
        p[1] = new Player(20, 2);
        p[0].getPlayerCard()[12][0] = 1;
        p[0].getPlayerCard()[12][1] = 3;
        for(int i = 0 ; i < 13 ; i++){
            p[0].getPlayerCard()[i][0] = 0;
            p[0].getPlayerCard()[i][1] = 0;
        }
        checkGiveKQPS(0);
        System.out.println(p[0].getKQPS());
    }

    public void showKQPS(int order){//To show what role he got from victory first round
        System.out.println("Player : " + Card.KQPS[p[order].getKQPS()]);
    }
}