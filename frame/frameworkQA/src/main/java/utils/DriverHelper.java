package utils;

import org.openqa.selenium.WebDriver;

public class DriverHelper {
    public static WebDriver driver;

    public static void setup(){
        Driver webDriver = new Driver();
        driver = webDriver.getDriverChrome();
    }

    public static void close(){
        driver.close();
        driver.quit();
    }
}
