package org.example.lab12.bo;

import org.example.lab12.po.PhonePO;
import org.example.lab12.po.SignIn;
import org.example.lab12.po.SignUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PagePhoneBO {
    private PhonePO phonePO;
    private SignUp signUpPO;
    private SignIn signInPO;
    public PagePhoneBO signIn(){
        if(phonePO == null){
            phonePO = new PhonePO();
        }

        Assert.assertTrue(phonePO.isPhonePage());
        phonePO.signIn();

        signInPO = new SignIn();
        signInPO.signIn("test_qwe", "qwe");


        Assert.assertTrue(phonePO.isUserLogin());
        return this;
    }
    public PagePhoneBO signUp(){
        if(phonePO == null){
            phonePO = new PhonePO();
        }
        phonePO.signUp();

        signUpPO = new SignUp();
        signUpPO.signUp("test_qwe16", "qwe");

        return this;
    }
    public PagePhoneBO addToCart(){
        Assert.assertTrue(phonePO.isPhonePage());
        phonePO.addPhoneToCart();

        return this;
    }

    public void goToCard() {
        phonePO.goCart();
    }
}
