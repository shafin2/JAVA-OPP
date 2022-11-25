import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.opencsv.CSVWriter;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {  
      
    // System Property for Chrome Driver   
     System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
     // Instantiate a ChromeDriver class.     
     WebDriver driver=new ChromeDriver();  
    // Launch Website  
     driver.navigate().to("https://www.betfair.com/exchange/plus/horse-racing/market/1.206334465?nodeId=31900281.0820");  
       

    //sleep to load website properly
    try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //to go on require place
    driver.findElement(By.className("TODAYS_CARD")).click(); 
    //sleep to load website properly
    try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    
    //finding elements
    List<WebElement> myList=driver.findElements(By.className("runner-line"));
    
    //declare list to store text of elements
    List<String> all_elements_text=new ArrayList<>();

    //storing text in list
    for(int i=0; i<myList.size(); i++){
        all_elements_text.add(myList.get(i).getText());
    }
    

    //Storing data in file
    File file = new File("Data.csv");
    try {
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);
        String[] header = { "1st column","1st column","2nd column","2nd column","3rd column","3rd column","4th column","4th column","5th column","5th column","6th column","6th column","7th column","7th column","8th column","8th column"};
        writer.writeNext(header);
  
        for(String items:all_elements_text){
                String[] item=items.split("\n");
                writer.writeNext(item); 
        }
        writer.close();
    }
    catch (IOException e) {
        e.printStackTrace();
    }


    driver.close();


 }  









 //end
}
