package lab10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeDriverManager.getInstance().setup();
        driver = driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    void testElements() throws InterruptedException {
        driver.get("https://www.demoblaze.com/prod.html?idp_=1");

        //1element
        WebElement nameProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/h2")));
        Assert.assertTrue(nameProduct.isDisplayed());

        WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
        signInButton.click();

        WebElement usernameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        WebElement passwordInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        WebElement logInSubmit = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));

        usernameInputField.sendKeys("text_qwe14");
        passwordInputField.sendKeys("qwe");
        logInSubmit.sendKeys(Keys.ENTER);

        //2 element
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        Assert.assertTrue(username.isDisplayed());

        //3 element
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a")));
        Assert.assertTrue(cart.isDisplayed());
        cart.click();

        //4 element
        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr")));
        Assert.assertTrue(phone.isDisplayed());

        //5 element
        WebElement footer = driver.findElement(By.xpath("/html/body/footer"));
        Assert.assertTrue(footer.isDisplayed());
    }

    @AfterTest
    public void close(){
        driver.close();
        driver.quit();
    }
}
