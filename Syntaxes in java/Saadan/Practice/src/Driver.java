import java.util.ArrayList;

import java.util.Collections;

import javax.xml.transform.Source;

public class Driver {
    public static void main(String[] args) {
        A obj = new A();

        obj.shafin();
        // obj.game();

        // ArrayList arr = new ArrayList();

        ArrayList<String> arr2 = new ArrayList<>();
        // ArrayList<String> arr6 = new ArrayList<>(5);
        
        ArrayList<Integer> arr3 = new ArrayList<>();

        ArrayList<Float> arr4 = new ArrayList<>();

        System.out.println(arr2);
        //Adding object in ArrayList
        arr2.add("Shafin");
        arr2.add("Saadaan");
        System.out.println(arr2.get(1));

        arr2.add(1,"Arham");

        System.out.println(arr2);

        //Replacing object in ArrayList
        arr2.set(1, "Phupho");
        System.out.println(arr2);

        // ArrayList<String> ary = new ArrayList<String>();
        // arr2.replaceAll(ary);

        //Removing object in ArrayList
        arr2.remove(2);
        System.out.println(arr2);

        arr2.add("Hafeez");
        arr2.add("Shadab");
        System.out.println(arr2);
        // arr2.removeIf(n -> n.charAt(0) == 'S');
        // System.out.println(arr2);

        Collections.sort(arr2);
        System.out.println(arr2);
        
        // arr2.sort(arr2);
    }
}
