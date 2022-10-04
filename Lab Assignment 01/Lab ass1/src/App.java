import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int noOfPerson=10;
        Person persons[]=new Person[noOfPerson];
        String personsfirstNames[]={"Ali","Ahmad","Shafin","Ammar","Arham","Saadan","Zeeshan","Jawad","Aneeq","Zayam"};
        String personsSecondNames[]={"Jutt","Rajput","Zaman","Butt","Raza","Waleed","Mohsin","Faiq","Baig","Chaudary"};
        Random rn=new Random();     
        for(int i=0;i<noOfPerson;i++){
            Date randomDate=new Date(rn.nextInt(1,32), rn.nextInt(1,13), rn.nextInt(1950,2022));
            persons[i]=new Person(personsfirstNames[rn.nextInt(0,10)],personsSecondNames[rn.nextInt(0,10)],randomDate);
        }
        
        displayList(persons);
        countPerson(persons);
    
    }
    public static void displayList(Person p[]){
        for(int i=0;i<p.length;i++){
            System.out.println(p[i].toString());
        }
    }
    public static void countPerson(Person p[]){
        int personCount=0;
        for(int i=0;i<p.length;i++){
            personCount++;
        }
        System.out.println("Total number of person are "+personCount);
    }
    
}
