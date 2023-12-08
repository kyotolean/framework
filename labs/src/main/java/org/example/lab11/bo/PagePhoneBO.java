package org.example.lab11.bo;

import org.example.lab11.po.SignIn;
import org.example.lab11.po.SignUp;
import org.testng.Assert;
import org.example.lab11.po.PhonePO;
import org.openqa.selenium.WebDriver;


public class PagePhoneBO {
    public PagePhoneBO(WebDriver driver){
        this.driver = driver;
    }
    private WebDriver driver;
    private PhonePO phonePO;
    private SignUp signUpPO;
    private SignIn signInPO;
    public PagePhoneBO signIn(){
        phonePO = new PhonePO(driver);

        Assert.assertTrue(phonePO.isPhonePage());

        signInPO = phonePO.signIn();
        signInPO.signIn("test_qwe", "qwe");


        Assert.assertTrue(phonePO.isUserLogin());
        return this;
    }
    public PagePhoneBO signUp(){
        phonePO = new PhonePO(driver);
        signUpPO =  phonePO.signUp();
        phonePO = signUpPO.signUp("test_qwe16", "qwe");
        return this;
    }
    public PagePhoneBO addToCart(){
        Assert.assertTrue(phonePO.isPhonePage());
        phonePO.addPhoneToCart();
        return this;
    }

    public WebDriver goToCard() {
        phonePO.goCart();
        return driver;
    }
}
