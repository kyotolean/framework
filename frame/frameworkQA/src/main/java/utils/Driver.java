package utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;

    public WebDriver getDriverChrome(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        return driver;
    }

//    public WebDriver getChrome(){
//        ChromeDriverManager.getInstance().setup();
//        driver = new ChromeDriver();
//        return driver;
//    }
//    public WebDriver getEdge(){
//        EdgeDriverManager.getInstance().setup();
//        driver = new EdgeDriver();
//        return driver;
//    }
}
