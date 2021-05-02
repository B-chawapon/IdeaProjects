package sample;


import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Player {

    private String ID;
    private int turnOrder;
    private int[][] playerCard = new int[13][2];
    private boolean skipTurn;
    private int KQPS;   //contain King(0) , Queen(1) , People(2) or slave(3)
    private int countCardOnPlayerHand;
    //1. For suits 2. For face 3. For checking

    public Player() {
    }

    public Player(String  ID, int turnOrder) {
        this.ID = ID;
        this.turnOrder = turnOrder;
        skipTurn = false;
    }



    public int getTurnOrder() {
        return turnOrder;
    }


    public boolean isSkipTurn() {
        return skipTurn;
    }

    public void setKQPS(int KQPS) {
        this.KQPS = KQPS;
    }

    public int getKQPS() {
        return KQPS;
    }

    public int[][] getPlayerCard() {
        return playerCard;
    }

    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    public void addNumberOfCard(int a){
        countCardOnPlayerHand += a;
    }

    public int getCountCardOnPlayerHand() {

        return countCardOnPlayerHand;
    }

    public String getCountCardOnPlayerHandStr() {
        int temp = 13-countCardOnPlayerHand;

        return String.valueOf(temp);
    }
    public void startDrawCard(int[] randomCard,int playerOrder){

        for(int i = ((playerOrder - 1) * 13) ; i < playerOrder * 13 ; i++){
            playerCard[i%13][0] = randomCard[i]%100;
            playerCard[i%13][1] = randomCard[i]/100;
        }

        //Bubble sort min -> max
        minToMax();


    }
    public boolean isFirstPlayerStartWith101(ArrayList<Integer> card){
        if(playerCard[0][0] == 1 && playerCard[0][1] == 1){
            for(int i = 0 ; i < card.size() ; i++){
                if(playerCard[card.get(i)][0] == 1 && playerCard[card.get(i)][1] == 1){
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void minToMax(){
        int temp1,temp2;
        for (int i = 0; i < playerCard.length - 1; i++)
        {
            for (int j = 0; j < playerCard.length - i - 1; j++)
            {
                if (playerCard[j][0] > playerCard[j + 1][0])
                {
                    // swap arr[j] and arr[j+1]
                    temp1 = playerCard[j][0];
                    temp2 = playerCard[j][1];
                    playerCard[j][0] = playerCard[j + 1][0];
                    playerCard[j][1] = playerCard[j + 1][1];
                    playerCard[j + 1][0] = temp1;
                    playerCard[j + 1][1] = temp2;

                }else if(playerCard[j][0] == playerCard[j + 1][0]){
                    if(playerCard[j][1] > playerCard[j + 1][1]){
                        temp1 = playerCard[j][1];
                        playerCard[j][1] = playerCard[j + 1][1];
                        playerCard[j + 1][1] = temp1;
                    }
                }
            }
        }
    }

    public void showPlayerCardOnHand(){
        for(int i = 0 ; i < playerCard.length ; i++){
            if(playerCard[i][1] != 0 && playerCard[i][0] != 0 ){
                System.out.println((i+1)+"::"+playerCard[i][0] + " " + playerCard[i][1]);
            }
        }
    }

    public String getID() {
        return ID;
    }

    public int countCardOnPlayerHand(){
        int num = 0;
        for(int i = 0 ; i < 13 ; i++){
            if(playerCard[i][0] != 0){
                num++;
            }
        }
        return num;
    }
    public String countCardOnPlayerHandStr(){
        String temp = String.valueOf(countCardOnPlayerHand());
        return temp;
    }

}