package org.example.lab12.po;

import org.example.lab12.wrapper.Decorator;
import org.example.lab12.wrapper.ImagesWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.lab12.WebDriverSupplier.driver;

public class PhonePO {
    @FindBy(id = "signin2")
    private WebElement signIn;
    @FindBy(id = "login2")
    private WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    private WebElement addToCardButton;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/h2")
    private WebElement isPhonePage;
    @FindBy(id = "nameofuser")
    private WebElement isLogin;
    @FindBy(id = "cartur")
    private WebElement cart;
    @FindBy(xpath = "//*[@id=\"imgp\"]/div/img")
    private ImagesWrapper imagesWrapper;
    private static final String URL = "https://www.demoblaze.com/prod.html?idp_=1";
    public PhonePO(){
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
        PageFactory.initElements(new Decorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WebDriverWait wait;

    public void signUp(){
        wait.until(ExpectedConditions.visibilityOf(signIn));
        signIn.click();
    }
    public void signIn(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }
    public void addPhoneToCart(){
        imagesWrapper.waitForImageToLoad(wait);

        Assert.assertTrue(imagesWrapper.verifyImageDisplayed());
        Assert.assertEquals(imagesWrapper.getImageSource(), "https://www.demoblaze.com/imgs/galaxy_s6.jpg");

        wait.until(ExpectedConditions.visibilityOf(addToCardButton));
        addToCardButton.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertAddToCard = driver.switchTo().alert();
        alertAddToCard.accept();

        driver.switchTo().defaultContent();
    }
    public boolean isPhonePage(){
        wait.until(ExpectedConditions.visibilityOf(isPhonePage));
        return isPhonePage.isDisplayed();
    }
    public boolean isUserLogin(){
        wait.until(ExpectedConditions.visibilityOf(isLogin));
        return isLogin.isDisplayed();
    }

    public void goCart() {
        cart.click();
    }
}
