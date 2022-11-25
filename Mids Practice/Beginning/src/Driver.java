import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Driver {
    public static void main(String[] args) {
        ArrayList<House> houses =new ArrayList<House>();
        houses.add(new House(30000,"Las vegas",2000.24,5));
        houses.add(new House(40000,"Lahore",201510.24,6));
        houses.add(new House(50000,"London",51515.24,2));
        houses.add(new House(60000,"Las",2055.24,8));
        houses.add(new House(120000,"vegas",205450.24,20));
        houses.add(new House(120000,"Karanchi",257750.24,7));

        System.out.println("Simple list houses");
        displayList(houses);

        System.out.println("");

        System.out.println("Comparable sorting");
        Collections.sort(houses);
        displayList(houses);

        System.out.println("");

        System.out.println("Comparator sorted ");
        houses.sort(houses.get(0));
        displayList(houses);

        System.out.println("");

        System.out.println("Comparator sorted with other class");
        houses.sort(new CompareByName());
        displayList(houses);

        System.out.println("");
        

        System.out.println("Comparator sorted with function");
        houses.sort(new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                return o1.noOfRooms>o2.noOfRooms?1:-1;
            }
        });
        displayList(houses);

        System.out.println("");
//         System.out.println("Comparator sorted with passing object");
//         houses.sort(new House(50000,"London",51515.24,2));
// //        houses.sort(houses.get(0));
//         displayList(houses);

//         System.out.println("");

//         System.out.println("Comparator sorted with comparator function");
//         houses.sort(new Comparator<House>() {
//             @Override
//             public int compare(House o1, House o2) {
//                 return o1.noOfRooms>o2.noOfRooms?1:-1;
//             }
//         });
        // displayList(houses);

    }
    public static void displayList(ArrayList<House> list){
        for (House m : list) {
            System.out.println(m);
        }

    }
}
