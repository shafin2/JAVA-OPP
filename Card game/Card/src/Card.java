public class Card{
    private String rank;
    private String suit;
    Card(String r,String s){
        rank=r;
        suit=s;
    }
    public String getRank(){
        return rank;
    }
    public String getSuit(){
        return suit;
    }
    public String getCardInfo(){
        String s=String.format("%-5s of %-10s",getRank(),getSuit());
        return s;
    }
}