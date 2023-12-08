package org.example.lab12;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSupplier {
    public static WebDriver driver;

    public static void setup(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
    public static void close(){
        driver.close();
        driver.quit();
    }
}