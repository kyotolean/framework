package org.example.lab11.po;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PhonePO {
    private static final String URL = "https://www.demoblaze.com/prod.html?idp_=1";
    public PhonePO(WebDriver driver){
        this.driver = driver;
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WebDriver driver;
    private WebDriverWait wait;

    public SignUp signUp(){
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin2")));
        signIn.click();
        return new SignUp(driver);
    }
    public SignIn signIn(){
        WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
        signInButton.click();

        return new SignIn(driver);
    }
    public WebDriver addPhoneToCart(){
        WebElement addToCardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        addToCardButton.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertAddToCard = driver.switchTo().alert();
        alertAddToCard.accept();

        driver.switchTo().defaultContent();
        return driver;
    }
    public boolean isPhonePage(){
        WebElement isPhonePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/h2")));
        return isPhonePage.isDisplayed();
    }
    public boolean isUserLogin(){
        WebElement isLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        return isLogin.isDisplayed();
    }

    public void goCart() {
        WebElement cart = driver.findElement(By.id("cartur"));
        cart.click();
    }
}
