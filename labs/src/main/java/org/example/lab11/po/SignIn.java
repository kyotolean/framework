package org.example.lab11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignIn {
    public SignIn(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WebDriver driver;
    private WebDriverWait wait;

    public PhonePO signIn(String username, String password){

        WebElement usernameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        WebElement passwordInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        WebElement logInSubmit = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        logInSubmit.sendKeys(Keys.ENTER);

        return new PhonePO(driver);
    }
}
