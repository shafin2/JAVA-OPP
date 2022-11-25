import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App {

    public static void main(String[] args){
        ArrayList<Employee> employee = new ArrayList<Employee>();
        
        File file = new File("E:\\Uni folder\\Sem 2\\Projects\\OOP course\\Mids Practice\\LAB Mids\\Poly\\src\\App.java");
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str="";
            while((str=br.readLine())!=null){
                System.out.println(str);
                // String[] data= str.split(" ");
                // if(data[0]=="C"){
                //     System.out.println("Run hogya");
                //     CommisionWorkers cw = new CommisionWorkers(data[0].charAt(0), Integer.parseInt(data[1]),data[2],Double.parseDouble(data[3]),Double.parseDouble(data[4]));
                //     employee.add(cw);
                // }
                // if(data[0]=="H"){
                //     HourlyWorkers hw = new HourlyWorkers(data[0].charAt(0), Integer.parseInt(data[1]),data[2],Double.parseDouble(data[3]),Double.parseDouble(data[4]));
                //     employee.add(hw);
                // }
            }
            br.close();
            fr.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        // printData(employee);
    // }
    // public static void printData(ArrayList<Employee> arr){
    //     for(int i=0;i<arr.size();i++){
    //         System.out.println(arr.get(i).toString());
    //     }
    // }
}
}




