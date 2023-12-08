package org.example.lab10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.demoblaze.com/prod.html?idp_=1");

        //1 button sign up
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin2")));
        signIn.click();

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password")));
        WebElement signSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")));

        String username = "DAVID VOLOSHYN";
        String password = "zxc";

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signSubmit.sendKeys(Keys.ENTER);


        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.switchTo().defaultContent();
        //2 button sign in
        WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
        signInButton.click();

        WebElement usernameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        WebElement passwordInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        WebElement logInSubmit = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        logInSubmit.sendKeys(Keys.ENTER);
        //3 button add to cart

        Thread.sleep(3000);//got error because the page do refresh and hove to wait a few second

        WebElement addToCardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        addToCardButton.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertAddToCard = driver.switchTo().alert();
        alertAddToCard.accept();

        driver.switchTo().defaultContent();
        // 4 button go to cart page

        WebElement cart = driver.findElement(By.id("cartur"));
        cart.click();
        // 5 botton delete from cart
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")));
        deleteButton.click();


        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
