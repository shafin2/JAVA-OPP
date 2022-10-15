import java.util.Scanner;
import java.util.Random;
public class Campus {
    private String name;
    private Employee director;
    static private String depName[]={"CS","SE","IT","IEE","Pharmacy"};
    static private String Attendent[]={"Head","Supervisor","Attendant"};
    static private String Names[]={"Ali","Ahmad","Shafin","Ammar","Arham","Saadan","Zeeshan","Jawad","Aneeq","Zayam"};
    static private Department departments[]=new Department[10];
    static Scanner sc=new Scanner(System.in);

    public Campus(String name, Employee director) {
        this.name = name;
        this.director = director;
        autoMakeSomeDepartment();
    }
    public Campus(Campus a){
        // a=(Campus)a;
        this.name=a.getName();
        this.director=a.getDirector();
    }
    public void campusMain(){
        char user_choice='y';
        while(user_choice=='y'){
            System.out.println("Welcome to "+name+" campus");
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
    public void makeDepartments(){
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
    public void showDepartmernt(){
        for(int i=0;i<departments.length;i++){
            if(departments[i]!=null){
                System.out.println(departments[i].toString());
            }
            
        }
    }

    public static void autoMakeSomeDepartment(){
        Random rn=new Random();
        for(int i=0;i<5;i++){
            departments[i]=new Department(depName[i],new Employee(Integer.toString(rn.nextInt(1000,10000)), Names[rn.nextInt(0,9)],Attendent[rn.nextInt(0,3)]));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "name='" + name + '\'' +
                ", director=" + director +
                '}';
    }

    // @Override
    // public boolean equals(Object obj) {
    //     return super.equals(obj);
    // }

    // @Override
    public Object clone(){
        Object teamp=new Campus(this.name, this.director);
        return teamp;
    }
}
