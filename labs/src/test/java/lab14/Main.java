package lab14;


import org.apache.log4j.BasicConfigurator;
import org.example.lab12.WebDriverSupplier;
import org.example.lab12.bo.PagePhoneBO;
import org.example.lab12.po.CartPO;
import org.example.lab14.AllureListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({AllureListener.class})
public class Main {
    @BeforeTest
    public void setup(){
        WebDriverSupplier.setup();
        BasicConfigurator.configure();
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
