import java.net.Authenticator.RequestorType;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.Random;
public class Department {
    static private String LabName[]={"C1","A3","b3","f5","c5","c7"};
    static private String Attendent[]={"Head","Supervisor","Attendant"};
    static private String Names[]={"Ali","Ahmad","Shafin","Ammar","Arham","Saadan","Zeeshan","Jawad","Aneeq","Zayam"};
    static Scanner sc=new Scanner(System.in);
    static private Lab labs[]=new Lab[20];
    private String name;
    private Employee labsIncharge;
    public Department(String name, Employee labsIncharge) {
        this.name = name;
        this.labsIncharge = labsIncharge;
        autoMakeSomeLabs();
    }
    public void autoMakeSomeLabs(){
        Random rn=new Random();
        for(int i=0;i<5;i++){
            labs[i]=new Lab(LabName[i],new Employee(Integer.toString(rn.nextInt(1000,10000)), Names[rn.nextInt(0,9)],Attendent[rn.nextInt(0,2)]));

            // computers[i]=new PC(Integer.toString(rn.nextInt(1000,5000)),PCName[rn.nextInt(0,4)],Integer.toString(rn.nextInt(100000,23000000)),rn.nextInt(1000,24000),rn.nextInt(128,1024),rn.nextInt(0,1)==1?true:false);
        }
    }
    public void departmentMain(){
        char user_choice='y';
        while(user_choice=='y'){
            System.out.println("You are in "+this.name+" Department");
            System.out.println("Press 1 to create Lab,Press 2 to show Lab");
            int UserInput=sc.nextInt();
            if(UserInput==1){
                makeLabs();
            }
            if(UserInput==2){
                showLabs();
            }
            System.out.println("If you want to go in Lab then press 1,otherwise press any key");
            int user_choice2=sc.nextInt();
            if(user_choice2==1){
                System.out.print("Enter lab name : ");
                String depName=sc.next();
                for(int i=0;i<labs.length;i++){
                    if(labs[i]!=null){
                       if(new String(depName).equals(labs[i].getLabName())){
                            labs[i].labMain();
                       }
                    }    
                }
            }
            
            System.out.println("Do you want to continue in that department y/n ? ");
            user_choice = sc.next().charAt(0);
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employee getLabsIncharge() {
        return labsIncharge;
    }
    public void setLabsIncharge(Employee labsIncharge) {
        this.labsIncharge = labsIncharge;
    }
    public void makeLabs(){
        // for(int i=0;i<labs.length;i++){
        //     labs[i]=new Lab("ICt lab", new Employee("4", "shafin", "attendant"));
        // }
        for(int i=0;i<labs.length;i++){
            if(labs[i]==null){
                System.out.print("Enter Lab Name : ");
                String labName=sc.next();
                System.out.println("Now Enter That Lab Attendent data");
                System.out.print("Enter Attendent name: ");
                String empName=sc.next();
                System.out.print("Enter Attendent Id: ");
                String empId=sc.next();
                System.out.print("Enter Attendent Designation : ");
                String empDes=sc.next();
                labs[i]=new Lab(labName,new Employee(empId, empName, empDes));
                break;
            }
            
        }
    }
    public void showLabs(){
        for(int i=0;i<labs.length;i++){
            if(labs[i]!=null){
                System.out.println(labs[i].toString());
            }    
        }
    }
    @Override
    public String toString() {
        // return name + "Department" + "labsIncharge=" + labsIncharge  ;
        return name + " Department [labsIncharge=" + labsIncharge + "]";
    }
    public boolean equals(Object obj) {
        Department p1=(Department)obj;
        boolean equal=false;
        if(this.name==p1.name){
            equal=true;
        }
        return equal;
    }
    public Object clone(){
        Object temp=new Department(this.name,this.labsIncharge);
        return temp;
    }
}