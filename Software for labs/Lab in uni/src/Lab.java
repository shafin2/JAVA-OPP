import java.util.Random;
import java.util.Scanner;
public class Lab {
    static Scanner sc=new Scanner(System.in);
    static private String PCName[]={"Dell","Lenovo","HP","Toshiba","Acer"};
    static private PC computers[]=new PC[40];
    private String labName;
    private Employee labAttendant;
    public Lab(String labName, Employee labAttendant) {
        this.labName = labName;
        this.labAttendant = labAttendant;
        autoMakeSomePc();
    }
    public void autoMakeSomePc(){
        Random rn=new Random();
        for(int i=0;i<10;i++){
            computers[i]=new PC(Integer.toString(rn.nextInt(1000,5000)),PCName[rn.nextInt(0,4)],Integer.toString(rn.nextInt(100000,23000000)),rn.nextInt(1000,24000),rn.nextInt(128,1024),rn.nextInt(0,2)==1?true:false);
        }
    }
    public void labMain(){
        char user_choice='y';
        while(user_choice=='y'){
            System.out.println("You are in "+this.labName+" Lab");
            System.out.println("Press 1 to create PC,Press 2 to show PC");
            int UserInput=sc.nextInt();
            if(UserInput==1){
                makePcs();
            }
            if(UserInput==2){
                showPcs();
            }
            
            System.out.println("Do you want to continue in that Lab y/n ? ");
            user_choice = sc.next().charAt(0);
        }
    }
    public String getLabName() {
        return labName;
    }
    public void setLabName(String labName) {
        this.labName = labName;
    }
    public Employee getLabAttendant() {
        return labAttendant;
    }
    public void setLabAttendant(Employee labAttendant) {
        this.labAttendant = labAttendant;
    }
    public void makePcs(){
        for(int i=0;i<computers.length;i++){
            // computers[i]=new PC("1", "Hp", "64t7", 8000, 512, true);
            if(computers[i]==null){
                System.out.print("Enter PC Name : ");
                String pcName=sc.next();
                System.out.print("Enter assetID : ");
                String assetID=sc.next();
                System.out.print("Enter CPUSerialNo : ");
                String CPUSerialNo=sc.next();
                System.out.print("Enter RAMSizeMB : ");
                int RAMSizeMB=sc.nextInt();
                System.out.print("Enter hardDiskSizeGB : ");
                int hardDiskSizeGB=sc.nextInt();
                System.out.print("If there is gpu press 1 : ");
                int GPU=sc.nextInt();
                computers[i]=new PC(assetID,pcName,CPUSerialNo,RAMSizeMB,hardDiskSizeGB,GPU==1?true:false);
                break;
            }
        }
    }
    public void showPcs(){
        for(int i =0 ;i<computers.length;i++){
            if(computers[i]!=null){
                System.out.println(computers[i].toString());
            }
        }
    }
    @Override
    public String toString() {
        return labName+" Lab [labAttendant=" + labAttendant + "]";
    }
    public boolean equals(Object obj) {
        Lab p1=(Lab)obj;
        boolean equal=false;
        if(this.labName==p1.labName){
            equal=true;
        }
        return equal;
    }
    public Object clone(){
        Object temp=new Lab(this.labName,this.labAttendant);
        return temp;
    }
}
