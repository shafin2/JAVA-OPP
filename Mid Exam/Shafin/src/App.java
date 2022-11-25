import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<Employee> emplst=new ArrayList<Employee>();
        Salesman s1=new Salesman("Ahmed", new Date(2, 4,1997), 80, 40);
        Salesman s2=new Salesman("Ali", new Date(2, 6,2007), 70, 35);
        Salesman s3=new Salesman("Jawad", new Date(8, 6,2015), 50, 25);
        Manager m1=new Manager("Shafin", new Date(5, 6,2008), 50000);
        Manager m2=new Manager("Ammar", new Date(12, 2,1998), 100000);
        Manager m3=new Manager("Saadan", new Date(25, 7,1992), 250000);
        emplst.add(s1);
        emplst.add(s2);
        emplst.add(s3);
        emplst.add(m1);
        emplst.add(m2);
        emplst.add(m3);
        printPayroll(emplst);
        printSortedListOfEmployees(emplst);
    }
    public static void printPayroll(ArrayList<Employee> lst){
        double totalPayable=0;
        int i=001;
        System.out.println(String.format("%s\t%s\t","Sr.","Name","Salary"));
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        for(Employee e:lst){
            System.out.println(String.format("%d\t%s\t%s",i,e.getName(),e.earning()));
            i++;
            totalPayable=totalPayable+e.earning();
        }
        System.out.println("-------------------------------");
        System.out.printf("Summary: Emp: %d  Manager: %d  Salesman: %d",Employee.noOfEmployee,Manager.noOfManager,Salesman.noOfSalesman);
        System.out.printf("\nTotal Payable: "+totalPayable);
        System.out.println(" ");

    }
    public static void printSortedListOfEmployees(ArrayList<Employee> lst){
        Collections.sort(lst);
        System.out.println("Sorted list by names ");
        for(Employee e:lst){
            System.out.println(e);
        }
    }
}
