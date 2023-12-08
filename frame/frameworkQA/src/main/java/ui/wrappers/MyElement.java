package ui.wrappers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverHelper.driver;

public class MyElement {
    private WebElement element;

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public MyElement(WebElement element){
        this.element = element;
    }

    public WebElement getElementWithWait(){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }
    public WebElement getElementToBeClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
