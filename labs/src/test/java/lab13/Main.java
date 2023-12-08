package lab13;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.apache.log4j.BasicConfigurator;
import org.example.lab12.WebDriverSupplier;
import org.example.lab12.bo.PagePhoneBO;
import org.example.lab12.po.CartPO;
import org.example.lab13.SuiteListener;
import org.example.lab13.TestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({SuiteListener.class, TestListener.class, UniversalVideoListener.class})
public class Main {
    @BeforeTest
    public void setup(){
        WebDriverSupplier.setup();
        BasicConfigurator.configure();
    }

    @Video
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
