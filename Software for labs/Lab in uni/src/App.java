import java.util.Scanner;
import java.util.Random;
import javax.management.monitor.StringMonitor;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.text.MaskFormatter;

public class App {
    static private String depName[]={"CS","SE","IT","IEE","Pharmacy"};
    static private String Attendent[]={"Head","Supervisor","Attendant"};
    static private String Names[]={"Ali","Ahmad","Shafin","Ammar","Arham","Saadan","Zeeshan","Jawad","Aneeq","Zayam"};
    static private Department departments[]=new Department[10];
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Lab l1=new Lab("hdc",new Employee("4", "hf", "hcf"));
        // l1.toString();

        // Department d1=new Department("hdc",new Employee("4", "hf", "hcf"));
        // d1.showLabs();
        autoMakeSomeDepartment();
        char user_choice='y';
        while(user_choice=='y'){
            System.out.println("Welcome to CUI campus lahore");
            System.out.println("Press 1 to create Department,Press 2 to show Department");
            int UserInput=sc.nextInt();
            if(UserInput==1){
                makeDepartments();
            }
            if(UserInput==2){
                showDepartmernt();
            }
            System.out.println("If you want to go in Departement then press 1,otherwise press 2");
            int user_choice2=sc.nextInt();
            if(user_choice2==1){
                System.out.print("Enter Department name : ");
                String depName=sc.next();
                for(int i=0;i<departments.length;i++){
                    if(departments[i]!=null){
                       if(new String(depName).equals(departments[i].getName())){
                            departments[i].departmentMain();
                       }
                    }    
                }
            }
            
            System.out.println("Do you want to continue y/n ? ");
            user_choice = sc.next().charAt(0);
        }
        
        

        

    }

    public static void makeDepartments(){
        for(int i=0;i<departments.length;i++){
            if(departments[i]==null){
                System.out.print("Enter Department Name : ");
                String depName=sc.next();
                System.out.println("Now Enter That Department Employee data");
                System.out.print("Enter Employee name: ");
                String empName=sc.next();
                System.out.print("Enter Employee Id: ");
                String empId=sc.next();
                System.out.print("Enter Employee Designation : ");
                String empDes=sc.next();
                departments[i]=new Department(depName,new Employee(empId, empName, empDes));
                break;
            }
            
        }
        
        

        
    }
    public static void showDepartmernt(){
        for(int i=0;i<departments.length;i++){
            if(departments[i]!=null){
                System.out.println(departments[i].toString());
            }
            
        }
    }


    public static void autoMakeSomeDepartment(){
        Random rn=new Random();
        for(int i=0;i<5;i++){
            departments[i]=new Department(depName[i],new Employee(Integer.toString(rn.nextInt(1000,10000)), Names[rn.nextInt(0,9)],Attendent[rn.nextInt(0,2)]));
        }
    }

}
