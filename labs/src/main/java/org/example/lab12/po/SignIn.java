package org.example.lab12.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.lab12.WebDriverSupplier.driver;

public class SignIn {
    @FindBy(id = "loginusername")
    private WebElement usernameInputField;
    @FindBy(id = "loginpassword")
    private WebElement passwordInputField;
    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    private WebElement logInSubmit;

    public SignIn(){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebDriverWait wait;

    public void signIn(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        logInSubmit.sendKeys(Keys.ENTER);
    }
}
