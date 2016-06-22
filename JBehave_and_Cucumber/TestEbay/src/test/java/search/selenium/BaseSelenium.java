package search.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by BIL on 16.06.2016.
 *
 */
public class BaseSelenium {
    public static WebDriver driver;

    public static void init(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public static void close(){
        try {
            driver.quit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            driver = null;
        }
    }
}
