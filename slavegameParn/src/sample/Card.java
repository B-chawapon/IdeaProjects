package sample;
import java.util.Random;
/**
 *
 * @author User
 */
public class Card {
    static final String[] SUITS = {"Clubs", "Diamonds", "Hearts" ,"Spades"};
    static final String[] KQPS = {"King", "Queen", "People" ,"Slave"};
    static final String[] FACES = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" , "A", "2",};
    private int[] randomCard = new int[52];
    public Card() {
    }

    public void fillRandomCard(){
        Random rand = new Random();
        System.out.println("fill working");
        int r;
        randomCard[0] = ((1+(int)(Math.random()*5))*100) + (1+(int)(Math.random()*14));
        int row = 1;
        do{
            r = ((1+(int)(Math.random()*4))*100) + (1+(int)(Math.random()*13));

            if(randomCard[row] == 0){
                for(int i = 0 ; i < row; i++){
                    if(randomCard[i] == r){
                        break;
                    }
                    if(i == row - 1){
                        randomCard[row] = r;
                        row++;
                    }


                }
            }
        }while(row < 52);
        System.out.println("out");
    }

    public void show(int[] random){
        for(int i =0 ; i < random.length ; i++){
            System.out.print(random[i] + " ");
        }
    }

    public int[] getRandomCard() {
        return randomCard;
    }



}