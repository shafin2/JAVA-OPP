import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.interfaces.RSAKey;
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
    static File file=new File("Departments.txt");
    //main constructor
    public Campus(String name, Employee director) {
        this.name = name;
        this.director = director;
        populateArray();
    }
    //copy constructor
    public Campus(Campus a){
        // a=(Campus)a;
        this.name=a.getName();
        this.director=a.getDirector();
    }
    //main function of Campus class call when user go in department
    public void campusMain(){
        char user_choice='y';
        while(user_choice=='y'){
            System.out.println("Welcome to "+name+" campus");
            System.out.println("Press 1 to create Department,Press 2 to show Department,Press 3 to update Department, Press 4 to delete Department or Press 5 to go inside Department");
            int UserInput=sc.nextInt();
            if(UserInput==1){
                System.out.println("Press 1 to create Department manually or press 2 to auto create deparment");
                int createdpt=sc.nextInt();
                if(createdpt==1){
                    if(departments[departments.length-1]==null){
                        makeDepartments();
                    }
                    else{
                        System.out.println("No more space to make department");
                    }     
                }
                else if(createdpt==2){
                    System.out.println("Enter the number of department you want to auto create");
                    int nmbrOfDpt=sc.nextInt();
                    autoMakeSomeDepartment(nmbrOfDpt);
                }
                else{
                    System.out.println("Invalid Input");
                }
                
            }
            else if(UserInput==2){
                showDepartmernt();
            }
            else if(UserInput==3){
                updateDepartment();
                updateFile();
            }
            else if(UserInput==4){
                deleteDepartment();
                updateFile();
            }
            else if(UserInput==5){
                if(departments[0]!=null){
                    int result=checkIfDeparmentExist();
                    if(result!=100){
                        departments[result].departmentMain();
                     }
                    else{
                        System.out.println("No department with that name");
                     }
                }
                else{
                    System.out.println("There is no Department Exist!");
                }
            }
            else{
                System.out.println("Invalid Input!");
            }
            System.out.println("Do you want to continue y/n ? ");
            user_choice = sc.next().charAt(0);
        }
    }
    //to create new Department
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
        updateFile();   
    }
    //to automatically generate depeartments
    public static void autoMakeSomeDepartment(int k){
        Random rn=new Random();
        int j=0;
        for(int i=0;i<departments.length;i++){
            if(departments[i]==null && j<k){
                departments[i]=new Department(depName[j],new Employee(Integer.toString(rn.nextInt(1000,10000)), Names[rn.nextInt(0,9)],Attendent[rn.nextInt(0,3)]));
                j++;
            } 
                       
        }
        System.out.println("Departments created");
        if(departments[9]!=null){
            System.out.println("No more space to make department");
        }
        updateFile();
    }
    //to show departments
    public void showDepartmernt(){
        for(int i=0;i<departments.length;i++){
            if(departments[i]!=null){
                System.out.println(departments[i].toString());
            }
            
        }
    }
    //to update deparment 
    public static void updateDepartment(){
        int result=checkIfDeparmentExist();
        if(result!=100){
            System.out.println("The department which you want to update is :");
            System.out.println(departments[result].toString());
            System.out.println("Now update....");
            System.out.print("Enter Department Name : ");
            String depName=sc.next();
            System.out.println("Now Update That Department Employee data");
            System.out.print("Enter Employee name: ");
            String empName=sc.next();
            System.out.print("Enter Employee Id: ");
            String empId=sc.next();
            System.out.print("Enter Employee Designation : ");
            String empDes=sc.next();
            Employee temp=new Employee(empId, empName, empDes);
            departments[result].setName(depName);
            departments[result].setdepartmentEmp(temp);
            System.out.println("Your department is updated");
        }
        else{
           System.out.println("No department with that name");
         }
    }
    //to delete deparment 
    public static void deleteDepartment(){
        int result=checkIfDeparmentExist();
        if(result!=100){
            departments[result]=null;
            System.out.println("Your department is deleted");
        }
        else{
           System.out.println("No department with that name");
         }
    }

    //to save departments data in file
    public static void updateFile(){
        //to erase all data written in file
        try {
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("");
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0;i<departments.length;i++){
            if(departments[i]!=null){
                try {
                    FileWriter fw=new FileWriter(file,true);
                    BufferedWriter bw=new BufferedWriter(fw);
                    String depData=departments[i].getName()+" " + departments[i].getdepartmentEmp().getEmployeeID()+"$"+ departments[i].getdepartmentEmp().getEmployeeName()+"$"+ departments[i].getdepartmentEmp().getEmployeeDesignation()+"\n";
                    bw.write(depData);
                    bw.close();
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
        }
        populateArray();
    }
    //to fetch save data from file and save them on array
    public static void populateArray(){
        //to empty the array
        for(int j=0;j<departments.length;j++){
            departments[j]=null;
        }
        try {
            FileReader fr=new FileReader(file);    
            BufferedReader br=new BufferedReader(fr);   
            String str=br.readLine();
            int i=0;
            while(str!=null){
                try{
                    String[] depData=str.split("\\s");
                    String depName=depData[0];
                    String[] empData=depData[1].split("\\$");
                    // System.out.println(empData[1]);
                    departments[i]=new Department(depName,new Employee(empData[0], empData[1], empData[2]));
                }
                catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Data in file is not true");
                }
                str=br.readLine();
                if(i<departments.length)
                    i++;
            }
            br.close();    
            fr.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //check if department exist
    public static int checkIfDeparmentExist(){
        int d=100;
        System.out.print("Enter Department name : ");
        String depName=sc.next();
        for(int i=0;i<departments.length;i++){
            if(departments[i]!=null){
                if(new String(depName).equals(departments[i].getName())){
                    d=i;
                }
            }    
         }
         return d;
    }
    //Getter & Setters
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
    public boolean equals(Object obj) {
        Campus c=(Campus)obj;
        // obj=(Campus)obj;
        boolean b=false;
        if(c.getName()==this.getName()){
            b=true;
        }
        return b;
    }

    // @Override
    public Object clone(){
        Object teamp=new Campus(this.name, this.director);
        return teamp;
    }
}