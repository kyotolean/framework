package org.example.lab11.po;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp {
    public SignUp(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WebDriver driver;
    private WebDriverWait wait;

    public PhonePO signUp(String username, String password){
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password")));
        WebElement signSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signSubmit.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.switchTo().defaultContent();

        return new PhonePO(driver);
    }
}
