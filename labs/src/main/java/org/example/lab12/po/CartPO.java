package org.example.lab12.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.lab12.WebDriverSupplier.driver;

public class CartPO {
    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div")
    private WebElement cardMenu;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")
    private WebElement deleteButton;

    private WebDriverWait wait;
    public CartPO(){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isCardPage(){
        wait.until(ExpectedConditions.visibilityOf(cardMenu));
        return cardMenu.isDisplayed();
    }
    public void deteleItem(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
    }
}
