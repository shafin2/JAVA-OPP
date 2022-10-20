import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileHandling {
    public static void main(String[] args) throws Exception {
        //Create a file
        // File file=new File("abc.txt");
        // try{
        //     file.createNewFile();
        // }
        // catch(IOException e){
        //     System.out.println(e);


        //Read frm file
        // File file=new File("abc.txt");
        // FileReader fr=new FileReader(file);    
        // BufferedReader br=new BufferedReader(fr);   
        // String str=br.readLine();
        // // int i=0;
        // while(str!=null){
        //     System.out.println(str);
        //     str=br.readLine();
        // }
        // br.close();    
        // fr.close(); 

        // write in file
        // File file=new File("abc.txt");
        // FileWriter fw=new FileWriter(file);
        // BufferedWriter bw=new BufferedWriter(fw);
        // bw.write("Hello kasiy ho \n");
        // bw.write("thk ho na");
        // bw.write("thk ho na");
        // bw.close();
        // fw.close();



        // FileReader fr=new FileReader("abc.txt");
        // BufferedReader br=new BufferedReader(fr);
        // String str=br.readLine();
        // while(str!=null){
        //     System.out.println(str);
        //     str=br.readLine();
        // }
        // br.close();
        // fr.close();
            // Cs 23$name$554
        FileWriter fw=new FileWriter("abc.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        String str="CS"+" "+"23"+"$"+"name";
        bw.write(str);
        bw.close();
        fw.close();





        }
        
}

