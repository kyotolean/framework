package org.example.lab12.wrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImagesWrapper {
    public ImagesWrapper(WebElement image){
        this.image = image;
    }
    private WebElement image;
    //    verifyImageDisplayed - verifies if an image is displayed on the page
    public boolean verifyImageDisplayed(){
        return image.isDisplayed();
    }

//    getImageSource - retrieves the source URL of an image
    public String getImageSource(){
        return image.getAttribute("src");
    }
//    waitForImageToLoad - waits for an image to finish loading
    public void waitForImageToLoad(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(image));
    }
}
