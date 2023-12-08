package lab11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.example.lab11.bo.CartBO;
import org.example.lab11.bo.PagePhoneBO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {
    private WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Test
    void EndToEndTest(){
        //1
        PagePhoneBO pagePhoneBO = new PagePhoneBO(driver);
        //pagePhoneBO.signUp();//first to run have to change username
        //2
        pagePhoneBO.signIn();
        //3
        pagePhoneBO.addToCart();
        //4
        CartBO cartBO = new CartBO(pagePhoneBO.goToCard());
        //5
        cartBO.deleteItem();

    }

    @AfterTest
    public void close(){
        driver.close();
        driver.quit();
    }
}
