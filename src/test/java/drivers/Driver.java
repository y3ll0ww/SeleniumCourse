package drivers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Driver {
    public static WebDriver driver = null;
    public static Wait<WebDriver> wait = null;

    public static final String CHROME = "Chrome";
    public static final String FIREFOX = "Firefox";

    public static void initialize(String webDriver){
        setDriver(webDriver);
        setExplicitWait();
    }

    public static void get(String url){
        driver.get("http://www." + url);
    }

    public static void stop() {
        driver.close();
        driver.quit();
    }

    private static void setDriver(String webDriver) {
        switch (webDriver) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    private static void setExplicitWait() {
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }
}
