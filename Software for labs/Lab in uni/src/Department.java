import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    static File file=new File("labs.txt");
    private String name;
    private Employee departmentEmp;
    //main constructor
    public Department(String name, Employee departmentEmp) {
        this.name = name;
        this.departmentEmp = departmentEmp;
        // autoMakeSomeLabs();
        populateArray();
    }
    //depatment main
    public void departmentMain(){
        char user_choice='y';
        while(user_choice=='y'){
            System.out.println("You are in "+this.name+" Department");
            System.out.println("Press 1 to create Lab,Press 2 to show Lab,Press 3 to update Lab, Press 4 to delete Lab or Press 5 to go inside Lab");
            int UserInput=sc.nextInt();
            if(UserInput==1){
                System.out.println("Press 1 to create Lab manually or press 2 to auto create Lab");
                int create=sc.nextInt();
                if(create==1){
                    if(labs[labs.length-1]==null){
                        makeLabs();
                    }
                    else{
                        System.out.println("No more space to make Lab");
                    }
      
                }
                else if(create==2){
                    System.out.println("Enter the number of Lab you want to auto create");
                    int nmbrOfLab=sc.nextInt();
                    autoMakeSomeLabs(nmbrOfLab);
                }
                else{
                    System.out.println("Invalid Input");
                }
            }
            else if(UserInput==2){
                showLabs();
            }
            else if(UserInput==3){
                updateLab();
                updateFile();
                System.out.println("Your Lab is updated");
            }
            else if(UserInput==4){
                deleteLab();
                updateFile();
            }
            else if(UserInput==5){
                if(labs[0]!=null){
                    int result=checkIfLabExist();
                    if(result!=100){
                        labs[result].labMain();;
                     }
                    else{
                        System.out.println("No Lab with that name");
                     }
                }
                else{
                    System.out.println("There is no Lab Exist!");
                }
            }
            
            else{
                System.out.println("Invalid Input!");
            }
            
            System.out.println("Do you want to continue in that department y/n ? ");
            user_choice = sc.next().charAt(0);
        }
    }
    public void makeLabs(){
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
        updateFile();
    }
    //Auto make some labs
    public void autoMakeSomeLabs(int k){
        Random rn=new Random();
        int j=0;
        for(int i=0;i<labs.length;i++){
            if(labs[i]==null && j<k){
                labs[i]=new Lab(LabName[i],new Employee(Integer.toString(rn.nextInt(1000,10000)), Names[rn.nextInt(0,9)],Attendent[rn.nextInt(0,2)]));
                j++;
            }                
        }
        System.out.println("Labs created");
        if(labs[labs.length-1]!=null){
            System.out.println("No more space to make Lab");
        }
        updateFile();
    }
    public void showLabs(){
        for(int i=0;i<labs.length;i++){
            if(labs[i]!=null){
                System.out.println(labs[i].toString());
            }    
        }
    }
    //to update deparment 
    public void updateLab(){
        int result=checkIfLabExist();
        if(result!=100){
            System.out.println("The Lab which you want to update is :");
            System.out.println(labs[result].toString());
            System.out.println("Now update....");
            System.out.print("Enter Lab Name : ");
            String labName=sc.next();
            System.out.println("Now Enter That Lab Attendent data");
            System.out.print("Enter Attendent name: ");
            String empName=sc.next();
            System.out.print("Enter Attendent Id: ");
            String empId=sc.next();
            System.out.print("Enter Attendent Designation : ");
            String empDes=sc.next();
            Employee temp = new Employee(empId, empName, empDes);
            labs[result].setLabName(labName);
            labs[result].setLabAttendant(temp);
            System.out.println("Your Lab is updated");
        }
        else{
           System.out.println("No Lab with that name");
        }
    }
    //to delete Lab 
    public void deleteLab(){
        int result=checkIfLabExist();
        if(result!=100){
            labs[result]=null;
            System.out.println("Your Lab is delete");
        }
        else{
           System.out.println("No Lab with that name");
         }
    }
    //to save Labs data in file
    public void updateFile(){
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
        for(int i=0;i<labs.length;i++){
            if(labs[i]!=null){
                try {
                    FileWriter fw=new FileWriter(file,true);
                    BufferedWriter bw=new BufferedWriter(fw);
                    String labData=labs[i].getLabName()+" " + labs[i].getLabAttendant().getEmployeeID()+"$"+ labs[i].getLabAttendant().getEmployeeName()+"$"+ labs[i].getLabAttendant().getEmployeeDesignation()+"\n";
                    bw.write(labData);
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
    public void populateArray(){
        //to empty the array
        for(int j=0;j<labs.length;j++){
            labs[j]=null;
        }
        try {
            FileReader fr=new FileReader(file);    
            BufferedReader br=new BufferedReader(fr);   
            String str=br.readLine();
            int i=0;
            while(str!=null){
                try{
                    String[] labData=str.split("\\s");
                    String labName=labData[0];
                    String[] empData=labData[1].split("\\$");
                    labs[i]=new Lab(labName,new Employee(empData[0], empData[1], empData[2]));
                }
                catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Data in file is not true");
                }
                str=br.readLine();
                if(i<labs.length)
                    i++;
            }
            br.close();    
            fr.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //check if Lab exist
    public int checkIfLabExist(){
        int d=100;
        System.out.print("Enter Lab name : ");
        String labName=sc.next();
        for(int i=0;i<labs.length;i++){
            if(labs[i]!=null){
                if(new String(labName).equals(labs[i].getLabName())){
                    d=i;
                }
            }    
         }
         return d;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employee getdepartmentEmp() {
        return departmentEmp;
    }
    public void setdepartmentEmp(Employee departmentEmp) {
        this.departmentEmp = departmentEmp;
    }

    @Override
    public String toString() {
        // return name + "Department" + "departmentEmp=" + departmentEmp  ;
        return name + " Department [departmentEmp=" + departmentEmp + "]";
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
        Object temp=new Department(this.name,this.departmentEmp);
        return temp;
    }
}