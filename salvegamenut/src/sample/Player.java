package sample;

/**
 *
 * @author User
 */
public class Player {
    private int ID;
    private int turnOrder;
    private int[][] playerCard = new int[13][2];
    private boolean skipTurn;
    private int KQPS;   //contain King(0) , Queen(1) , People(2) or slave(3)
    //1. For suits 2. For face 3. For checking

    public Player() {
    }

    public Player(int ID, int turnOrder) {
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

    public void startDrawCard(int[] randomCard,int playerOrder){

        int temp1,temp2;
        for(int i = ((playerOrder - 1) * 13) ; i < playerOrder * 13 ; i++){
            playerCard[i%13][0] = randomCard[i]%100;
            playerCard[i%13][1] = randomCard[i]/100;
        }

        //Bubble sort min -> max
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

    public int getID() {
        return ID;
    }


}