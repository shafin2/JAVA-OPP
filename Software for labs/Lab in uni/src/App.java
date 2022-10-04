import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.text.MaskFormatter;

public class App {
    static private Department departments[]=new Department[10];
    
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Lab l1=new Lab("hdc",new Employee("4", "hf", "hcf"));
        // l1.toString();

        // Department d1=new Department("hdc",new Employee("4", "hf", "hcf"));
        // d1.showLabs();

        makeDepartments();
        showDepartmernt();

        

    }

    public static void makeDepartments(){
        for(int i=0;i<departments.length;i++){
            departments[i]=new Department("Cs",new Employee("3", "Haris", "Cs"));
        }
    }
    public static void showDepartmernt(){
        for(int i=0;i<departments.length;i++){
            System.out.println(departments[i].toString());
        }
    }


}
