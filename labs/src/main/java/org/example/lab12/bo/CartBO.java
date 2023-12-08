package org.example.lab12.bo;

import org.example.lab12.po.CartPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartBO {
    private CartPO cartPO;
    public void deleteItem(){
        if(cartPO == null){
            cartPO = new CartPO();
        }

        Assert.assertTrue(cartPO.isCardPage());

        cartPO.deteleItem();
    }
}
