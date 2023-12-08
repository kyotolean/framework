package org.example.lab11.bo;

import org.example.lab11.po.CartPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartBO {
    private WebDriver driver;
    private CartPO cartPO;
    public CartBO(WebDriver driver){
        this.driver = driver;
    }
    public boolean isCartPage(){
        if(cartPO == null){
            cartPO = new CartPO(driver);
        }
        return cartPO.isCardPage();
    }
    public WebDriver deleteItem(){
        if(cartPO == null){
            cartPO = new CartPO(driver);
        }

        Assert.assertTrue(cartPO.isCardPage());

        cartPO.deteleItem();
        return driver;
    }
}
