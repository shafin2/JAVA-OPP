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
public class Lab {
    static Scanner sc=new Scanner(System.in);
    static File file=new File("PC.txt");
    static private String PCName[]={"Dell","Lenovo","HP","Toshiba","Acer"};
    static private PC computers[]=new PC[40];
    private String labName;
    private Employee labAttendant;
    public Lab(String labName, Employee labAttendant) {
        this.labName = labName;
        this.labAttendant = labAttendant;
    }
    public void labMain(){
        char user_choice='y';
        while(user_choice=='y'){
            System.out.println("You are in "+this.labName+" Lab");
            System.out.println("Press 1 to create PC,Press 2 to show PC,Press 3 to update PC or Press 4 to delete PC");
            int UserInput=sc.nextInt();
            if(UserInput==1){
                System.out.println("Press 1 to create PC manually or press 2 to auto create PCs");
                int createPc=sc.nextInt();
                if(createPc==1){
                    if(computers[computers.length-1]==null){
                        makePCs();
                    }
                    else{
                        System.out.println("No more space to make PC");
                    }
      
                }
                else if(createPc==2){
                    System.out.println("Enter the number of PCs you want to auto create");
                    int nmbrOfPc=sc.nextInt();
                    autoMakeSomePc(nmbrOfPc);
                }
                else{
                    System.out.println("Invalid Input");
                }
            }
            else if(UserInput==2){
                showPcs();
            }
            else if(UserInput==3){
                updatePc();
                updateFile();
            }
            else if(UserInput==4){
                deletePc();
                updateFile();
            }
            
            else{
                System.out.println("Invalid Input!");
            }
            
            System.out.println("Do you want to continue in that Lab y/n ? ");
            user_choice = sc.next().charAt(0);
        }
    }
    public void makePCs(){
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
        updateFile();
    }
    public void showPcs(){
        for(int i =0 ;i<computers.length;i++){
            if(computers[i]!=null){
                System.out.println(computers[i].toString());
            }
        }
    }
    public void autoMakeSomePc(int k){
        Random rn=new Random();
        int j=0;
        for(int i=0;i<10;i++){
            if(computers[i]==null && j<k){
                computers[i]=new PC(Integer.toString(rn.nextInt(1000,5000)),PCName[rn.nextInt(0,4)],Integer.toString(rn.nextInt(100000,23000000)),rn.nextInt(1000,24000),rn.nextInt(128,1024),rn.nextInt(0,2)==1?true:false);
                j++;
            }
            
        }
        System.out.println("PCs created");
        if(computers[computers.length-1]!=null){
            System.out.println("No more space to make Pc");
        }
        updateFile();
    }
    //to update deparment 
    public void updatePc(){
        int result=checkIfPcExist();
        if(result!=100){
            System.out.println("The PC which you want to update is :");
            System.out.println(computers[result].toString());
            System.out.println("Now update....");
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
            computers[result].setAssetID(assetID);
            computers[result].setItemName(pcName);
            computers[result].setCPUSerialNo(CPUSerialNo);
            computers[result].setRAMSizeMB(RAMSizeMB);
            computers[result].setHardDiskSizeGB(hardDiskSizeGB);
            computers[result].setGPU(GPU==1?true:false);
            System.out.println("Your PC is updated");
        }
        else{
           System.out.println("No PC with that name");
        }
    }
    //to delete Lab 
    public void deletePc(){
        int result=checkIfPcExist();
        if(result!=100){
            computers[result]=null;
            System.out.println("Your PC is delete");
        }
        else{
           System.out.println("No PC with that name");
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
        for(int i=0;i<computers.length;i++){
            if(computers[i]!=null){
                try {
                    FileWriter fw=new FileWriter(file,true);
                    BufferedWriter bw=new BufferedWriter(fw);
                    String PcData=computers[i].getAssetID()+" " +computers[i].getItemName()+" " +computers[i].getCPUSerialNo()+" "+computers[i].getRAMSizeMB()+" " +computers[i].getHardDiskSizeGB()+" " +computers[i].getGPU()+"\n";
                    bw.write(PcData);
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
        for(int j=0;j<computers.length;j++){
            computers[j]=null;
        }
        try {
            FileReader fr=new FileReader(file);    
            BufferedReader br=new BufferedReader(fr);   
            String str=br.readLine();
            int i=0;
            while(str!=null){
                try{
                    String[] PcData=str.split("\\s");
                    computers[i]=new PC(PcData[0],PcData[1],PcData[2],Integer.parseInt(PcData[3]),Integer.parseInt(PcData[3]),PcData[5]=="true"?true:false);
                }
                catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Data in file is not true");
                }
                str=br.readLine();
                if(i<computers.length)
                    i++;
            }
            br.close();    
            fr.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //check if PC exist
    public int checkIfPcExist(){
        int d=100;
        System.out.print("Enter PC Asset Id : ");
        String PcName=sc.next();
        for(int i=0;i<computers.length;i++){
            if(computers[i]!=null){
                if(new String(PcName).equals(computers[i].getAssetID())){
                    d=i;
                }
            }    
         }
         return d;
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
