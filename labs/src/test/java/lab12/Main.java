package lab12;

import org.example.lab12.bo.PagePhoneBO;
import org.example.lab12.WebDriverSupplier;
import org.example.lab12.po.CartPO;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {
    @BeforeTest
    public void setup(){
        WebDriverSupplier.setup();
    }

    @Test
    public void TestAllFunctions(){
        PagePhoneBO pagePhoneBO = new PagePhoneBO();
        pagePhoneBO.signIn();
        pagePhoneBO.addToCart();
        pagePhoneBO.goToCard();

        CartPO cartPO = new CartPO();
        cartPO.deteleItem();
    }

    @AfterTest
    public void closeBrowser(){
        WebDriverSupplier.close();
    }
}
