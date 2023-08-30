import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    //public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args){
        //driver.get("http://www.google.nl");
        Driver.initialize(Driver.CHROME);
        Driver.get("google.nl");
    }
}
