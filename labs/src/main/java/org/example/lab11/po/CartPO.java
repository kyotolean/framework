package org.example.lab11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPO {
    private WebDriver driver;
    private WebDriverWait wait;
    public CartPO(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isCardPage(){
        WebElement cardMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div")));
        return cardMenu.isDisplayed();
    }
    public WebDriver deteleItem(){
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")));
        deleteButton.click();
        return driver;
    }
}
