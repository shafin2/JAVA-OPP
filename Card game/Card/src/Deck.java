import java.util.Random;

import javax.security.auth.login.CredentialException;

// import java.util.Formatter;

public class Deck {
    private String ranks[]={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private String suits[]={"Clubs","Diamonds","Spades","Hearts"};
    private Card cards[]=new Card[52];
    Deck(){
        for(int i=0;i<52;i++){
            cards[i]=new Card(ranks[0],suits[2]);
        }
    }
    public void  displayDeck(){
        for(int i=0;i<52;i++){
            System.out.println(cards[i].getCardInfo());
        }
    }

















    // private final String suits[]={"Clubs","Diamonds","Spades","Hearts"};
    // private final String ranks[]={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    // private final int Deck_Length=52;
    // private Card cards[]=new Card[Deck_Length];
    
    // Deck(){
    // //    cards=new Card[Deck_Length];
    //    int suitIndex=0;
    //     for(int i=0;i<Deck_Length;i++){
    //         if(i>0){
    //             if(i%13==0){
    //                 suitIndex++;
    //             }
    //         }
    //         cards[i]=new Card(ranks[i%13],suits[suitIndex]);
    //     }
    // }
    // public void showDeck(){
    //     for(int i=0;i<Deck_Length;i++){
    //         // String cardDetail=String.format("%15s", formatter.format(cards[i].getCardInfo()));
    //         // System.out.printf("%-5s of %-10s\n",cards[i].getRank(),cards[i].getSuit());
    //         System.out.println(cards[i].getCardInfo());
    //     }
    // }

    // public void shuffle(){
    //     Random rn =new Random();
    //     for(int i=0;i<100;i++){
    //         Card temp= cards[0];
    //         int randomIndex=rn.nextInt(Deck_Length);
    //         cards[0]=cards[randomIndex];
    //         cards[randomIndex]=temp;
    //     }
    // }
}
