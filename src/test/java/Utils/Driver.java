package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static Driver driver = new Driver();
    private static WebDriver instanceDriver;

    public static WebDriver getInstance() {
        System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
        if (instanceDriver == null) {
            instanceDriver = new ChromeDriver();
            instanceDriver.manage().window().maximize();
        }
        instanceDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return instanceDriver;
    }

    public static void waitElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void close (){
        if (instanceDriver!=null) {
            instanceDriver.quit();
            instanceDriver = null;
        }
    }

    private Driver() {
    }
}