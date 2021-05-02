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
    private int[][] last = new int[4][2];
    private boolean secondRound;
    private int kQPS = 1;
    private int amount;
    private int king, queen, people, slave;

    public int getAmount() {
        return amount;
    }
    private boolean isGameStarted;
    private boolean isPlayDouble;
    private boolean firstRoundEnd;
    Card card = new Card();
    Player p[] = new Player[4];

    //This function use at start botton. To random 52 cards and give to each player
    //Player 1,2,3,4 have their own card(13 cards).
    public void startGame() {
        card.fillRandomCard();
        p[0] = new Player("10", 0);
        p[1] = new Player("20", 1);
        p[2] = new Player("30", 2);
        p[3] = new Player("40", 3);

        p[0].startDrawCard(card.getRandomCard(), 1);
        p[1].startDrawCard(card.getRandomCard(), 2);
        p[2].startDrawCard(card.getRandomCard(), 3);
        p[3].startDrawCard(card.getRandomCard(), 4);

        //findStartPlayer();
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

    public int getKing() {
        return king;
    }

    public int getQueen() {
        return queen;
    }

    public int getPeople() {
        return people;
    }

    public int getSlave() {
        return slave;
    }

    public int getTurn() {
        return turn;
    }

    public int getLastSuit() {
        return lastSuit;
    }

    public int getLastFace() {
        return lastFace;
    }

    public boolean isFirstRoundEnd() {
        return firstRoundEnd;
    }

    public void setFirstRoundEnd(boolean firstRoundEnd) {
        this.firstRoundEnd = firstRoundEnd;
    }

    public boolean canDownCardByCheckSkip() {
        if (p[0].isSkipTurn() && p[1].isSkipTurn() && p[2].isSkipTurn() && p[3].isSkipTurn()) {

            for (int i = 0; i < 4; i++) {
                last[i][0] = 0;
                last[i][1] = 0;
            }
            for (int i = 0; i < 4 && p[i].getKQPS() == 0; i++) {
                p[i].setSkipTurn(false);
            }
            return false;
        } else {
            return true;
        }

    }

    public boolean isGameStarted(int size) {
        if (size <= 4 && size > 0) {
            if (isGameStarted == false) {
                if (size == 1 || size == 2) {
                    isGameStarted = true;
                    amount = size;
                    return true;
                }
            } else {
                if (amount == size) {
                    return true;
                }
                if (size > amount && (amount % 2 == size % 2)) {
                    amount = size;
                    return true;
                }
            }
        }

        return false;

    }

    //Start with most value card
    public void setLastCard(ArrayList<Integer> card) {
        for (int i = 0; i < card.size(); i++) {
            last[i][0] = p[turn].getPlayerCard()[card.get(i)][0];
            last[i][1] = p[turn].getPlayerCard()[card.get(i)][1];
        }
        for (int i = 0; i < 4 - 1; i++) {
            for (int j = 0; j < 4 - i - 1; j++) {
                int temp;
                if (last[j][1] < last[j + 1][1]) {
                    temp = last[j][1];
                    last[j][1] = last[j + 1][1];
                    last[j + 1][1] = temp;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(":::" + last[i][0] + " " + last[i][1]);
        }
    }

    public boolean isSameNumber(ArrayList<Integer> card) {
        int temp = p[turn].getPlayerCard()[card.get(0)][0];
        for (int i = 1; i < card.size(); i++) {
            if (temp != p[turn].getPlayerCard()[card.get(i)][0]) {
                return false;
            }
        }
        return true;
    }

    public int findMaxSuit(ArrayList<Integer> card) {
        int max = p[turn].getPlayerCard()[card.get(0)][1];
        for (int i = 1; i < card.size(); i++) {
            if (p[turn].getPlayerCard()[card.get(i)][1] > max) {
                max = p[turn].getPlayerCard()[card.get(i)][1];
            }
        }
        return max;
    }

    public boolean canDownCardByValue(ArrayList<Integer> card) {
        if (isSameNumber(card) && isGameStarted(card.size())) {
            if (amount == 1 || amount == 2) {
                if (p[turn].getPlayerCard()[card.get(0)][0] > last[0][0]) {
                    /*lastFace = p[turn].getPlayerCard()[card.get(0)][0];
                    lastSuit = findMaxSuit(card);*/
                    setLastCard(card);
                    for (int i = 0; i < card.size(); i++) {
                        p[turn].getPlayerCard()[card.get(i)][0] = 0;
                        p[turn].getPlayerCard()[card.get(i)][1] = 0;
                    }
                    return true;
                } else if (p[turn].getPlayerCard()[card.get(0)][0] == last[0][0]) {
                    for (int i = 0; i < card.size(); i++) {
                        if (p[turn].getPlayerCard()[card.get(i)][1] <= last[0][1]) {
                            return false;
                        }
                    }
                    //lastSuit = findMaxSuit(card);
                    setLastCard(card);
                    for (int i = 0; i < card.size(); i++) {
                        p[turn].getPlayerCard()[card.get(i)][0] = 0;
                        p[turn].getPlayerCard()[card.get(i)][1] = 0;
                    }
                    return true;
                }

            } else if (amount == 3 || amount == 4) {
                if (isPlayDouble == false) {
                    /*lastFace = p[turn].getPlayerCard()[card.get(0)][0];
                    lastSuit = findMaxSuit(card);*/
                    setLastCard(card);
                    isPlayDouble = true;
                    for (int i = 0; i < card.size(); i++) {
                        p[turn].getPlayerCard()[card.get(i)][0] = 0;
                        p[turn].getPlayerCard()[card.get(i)][1] = 0;
                    }
                    return true;
                } else {
                    if (p[turn].getPlayerCard()[card.get(0)][0] > last[0][0]) {
                        /*lastFace = p[turn].getPlayerCard()[card.get(0)][0];
                        lastSuit = findMaxSuit(card);*/
                        setLastCard(card);
                        for (int i = 0; i < card.size(); i++) {
                            p[turn].getPlayerCard()[card.get(i)][0] = 0;
                            p[turn].getPlayerCard()[card.get(i)][1] = 0;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void checkTurn() {
        turn++;
        if (turn > 3) {
            turn = 0;
        }
    }

    public boolean checkDownCard(ArrayList<Integer> card) {
        if (p[turn].isFirstPlayerStartWith101(card) && canDownCardByValue(card)) {
            p[turn].addNumberOfCard(card.size());
            checkGiveKQPS();
            //  checkTurn();
            return true;

        } else {
            System.out.println("***You can't***");
            return false;
        }

    }

    public void showCard() {
        System.out.println(" ");
        System.out.println("Top face and suit is : " + last[0][0] + " " + last[0][1]);
        System.out.println("Turn : " + (turn + 1) + " Player : " + p[turn].getID());
        p[turn].showPlayerCardOnHand();
        System.out.println("-1 for skip");
        System.out.print("Choose card : ");
    }

    public void doGame() {
        Scanner input = new Scanner(System.in);
        //Show card on player hand
        if (p[turn].isSkipTurn() != true && p[turn].getKQPS() == 0) {
            System.out.println(" ");
            System.out.println("Top face and suit is : " + last[0][0] + " " + last[0][1]);
            System.out.println("Turn : " + (turn + 1) + " Player : " + p[turn].getID());
            p[turn].showPlayerCardOnHand();
            System.out.println("-1 for skip");
            System.out.print("Choose card : ");
            ArrayList<Integer> card = new ArrayList<Integer>();
            int choose;
            while ((choose = input.nextInt()) > 0) {
                card.add(choose - 1);
            }
            if (choose == -1) {
                skip();
            } else {
                checkDownCard(card);
            }
        } else {
            checkTurn();
        }
    }

    public void checkFirstRoundEnd() {
        if (kQPS == 4) {
            System.out.println("Round End");
            firstRoundEnd = true;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                    p[i].getPlayerCard()[j][0] = 0;
                    p[i].getPlayerCard()[j][1] = 0;
                }
            }
            for (int i = 0; i < 52; i++) {
                card.getRandomCard()[i] = 0;
            }

        }
    }

    public void tradeCard() {

        for (int i = 0; i < 4; i++) {
            if (p[i].getKQPS() == 1) {
                king = i;
            }
            if (p[i].getKQPS() == 2) {
                queen = i;
            }
            if (p[i].getKQPS() == 3) {
                people = i;
            }
            if (p[i].getKQPS() == 4) {
                slave = i;
            }
        }
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    /*
        public void tradeKing(ArrayList<Integer> card, int king, int slave) {
            if (card.get(0) > card.get(1)) {
                int temp = card.get(0);
                card.set(0, card.get(1));
                card.set(1, temp);
            }
            int[][] arrayTemp = new int[2][2];
            arrayTemp[0][0] = p[king].getPlayerCard()[card.get(0)][0];
            arrayTemp[0][1] = p[king].getPlayerCard()[card.get(0)][1];
            arrayTemp[1][0] = p[king].getPlayerCard()[card.get(1)][0];
            arrayTemp[1][1] = p[king].getPlayerCard()[card.get(1)][1];
            p[king].getPlayerCard()[card.get(0)][0] = p[slave].getPlayerCard()[0][0];
            p[king].getPlayerCard()[card.get(0)][1] = p[slave].getPlayerCard()[0][1];
            p[king].getPlayerCard()[card.get(1)][0] = p[slave].getPlayerCard()[1][0];
            p[king].getPlayerCard()[card.get(1)][1] = p[slave].getPlayerCard()[1][1];
            p[slave].getPlayerCard()[0][0] = arrayTemp[0][0];
            p[slave].getPlayerCard()[0][1] = arrayTemp[0][1];
            p[slave].getPlayerCard()[1][0] = arrayTemp[1][0];
            p[slave].getPlayerCard()[1][1] = arrayTemp[1][1];
            p[king].minToMax();
            p[slave].minToMax();
        }
        public void tradeQueen(ArrayList<Integer> card, int queen, int people) {
            int[] arrayTemp = new int[2];
            arrayTemp[0] = p[queen].getPlayerCard()[card.get(0)][0];
            arrayTemp[1] = p[queen].getPlayerCard()[card.get(0)][1];
            p[queen].getPlayerCard()[card.get(0)][0] = p[people].getPlayerCard()[0][0];
            p[queen].getPlayerCard()[card.get(0)][1] = p[people].getPlayerCard()[0][1];
            p[people].getPlayerCard()[0][0] = arrayTemp[0];
            p[people].getPlayerCard()[0][0] = arrayTemp[1];
            p[queen].minToMax();
            p[people].minToMax();
        }
        */
    public void tradeKing(ArrayList<Integer> card, int king, int slave) {
        if (card.get(0) > card.get(1)) {
            int temp = card.get(0);
            card.set(0, card.get(1));
            card.set(1, temp);
        }
        int[][] arrayTemp = new int[2][2];
        arrayTemp[0][0] = p[king].getPlayerCard()[card.get(0)][0];
        arrayTemp[0][1] = p[king].getPlayerCard()[card.get(0)][1];
        arrayTemp[1][0] = p[king].getPlayerCard()[card.get(1)][0];
        arrayTemp[1][1] = p[king].getPlayerCard()[card.get(1)][1];

        p[king].getPlayerCard()[card.get(0)][0] = p[slave].getPlayerCard()[11][0];
        p[king].getPlayerCard()[card.get(0)][1] = p[slave].getPlayerCard()[11][1];
        p[king].getPlayerCard()[card.get(1)][0] = p[slave].getPlayerCard()[12][0];
        p[king].getPlayerCard()[card.get(1)][1] = p[slave].getPlayerCard()[12][1];

        p[slave].getPlayerCard()[11][0] = arrayTemp[0][0];
        p[slave].getPlayerCard()[11][1] = arrayTemp[0][1];
        p[slave].getPlayerCard()[12][0] = arrayTemp[1][0];
        p[slave].getPlayerCard()[12][1] = arrayTemp[1][1];

        p[king].minToMax();
        p[slave].minToMax();
    }

    public void tradeQueen(ArrayList<Integer> card, int queen, int people) {
        int[] arrayTemp = new int[2];
        arrayTemp[0] = p[queen].getPlayerCard()[card.get(0)][0];
        arrayTemp[1] = p[queen].getPlayerCard()[card.get(0)][1];

        p[queen].getPlayerCard()[card.get(0)][0] = p[people].getPlayerCard()[12][0];
        p[queen].getPlayerCard()[card.get(0)][1] = p[people].getPlayerCard()[12][1];

        p[people].getPlayerCard()[0][0] = arrayTemp[0];
        p[people].getPlayerCard()[0][0] = arrayTemp[1];

        p[queen].minToMax();
        p[people].minToMax();

    }
    public void skip() {
        if (p[turn].getPlayerCard()[0][0] != 1 || p[turn].getPlayerCard()[0][1] != 1) {
            p[turn].setSkipTurn(true);
            int temp = 0;
            for (int i = 0; i < 4; i++) {
                if (p[i].isSkipTurn() == true) {
                    temp++;
                }
            }
            if (temp >= 3) {
                /*lastFace = 0;
            lastSuit = 0;*/
                for (int i = 0; i < 4; i++) {
                    last[i][0] = 0;
                    last[i][1] = 0;
                }
                amount = 0;
                isGameStarted = false;
                isPlayDouble = false;
                for (int i = 0; i < 4; i++) {
                    if (p[i].getKQPS() == 0) {
                        p[i].setSkipTurn(false);
                    }

                }
            }
            checkTurn();
        } else {
            System.out.println("Please down 101");
        }

    }

    /**
     * Find who has 101 card
     */
    public void findStartPlayer() {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].getPlayerCard().length; j++) {
                if (p[i].getPlayerCard()[j][0] == 1 && p[i].getPlayerCard()[j][1] == 1) {
                    turn = i;
                    break;
                }

            }
        }
    }

    /**
     * To get card on player's hand. By passing player index(0 -> 3) And return
     * [13][2] array But why it doesn't work!!!!
     *
     * @return
     */
    public int[][] getCardOnPlyerHand(int i) {
        return p[i].getPlayerCard();
    }

    private void checkGiveKQPS() {

        if (p[turn].countCardOnPlayerHand() == 0 && p[turn].getKQPS() == 0) {
            p[turn].setKQPS(kQPS);

            if (kQPS == 3) {
                for (int i = 0; i < 4; i++) {
                    if (p[i].getKQPS() == 0) {
                        p[i].setKQPS(4);
                        p[i].setSkipTurn(true);

                    }
                }
            }
            kQPS += 1;
            p[turn].setSkipTurn(true);
        }
        for (int i = 0; i < 4; i++) {
            showKQPS(i);
        }

        checkFirstRoundEnd();

    }

    public void showKQPS(int order) {//To show what role he got from victory first round
        System.out.println("Player : " + order + " " + Card.KQPS[p[order].getKQPS()]);
    }

    public int[][] getLast() {
        return last;
    }

    public void cheat() {

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 12; i++) {
                p[j].getPlayerCard()[i][0] = 0;
                p[j].getPlayerCard()[i][1] = 0;

            }
            p[j].addNumberOfCard(j);
        }
    }

    public void restart() {
        for (int i = 0; i < 4; i++) {
            p[i].setKQPS(0);
            p[i].setSkipTurn(false);

        }
        for (int i = 0; i < 4; i++) {
            last[i][0] = 0;
            last[i][1] = 0;
        }
        kQPS = 1;
        amount = 0;
    }

}