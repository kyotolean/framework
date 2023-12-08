package ui.po;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrappers.Decorator;
import ui.wrappers.MyElement;

import static utils.DriverHelper.driver;

public class SignInPO {
    @FindBy(id = "login_field")
    private MyElement usernameField;
    @FindBy(id = "password")
    private MyElement passwordField;
    @FindBy(xpath = "/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[13]")
    private MyElement submitBtn;
    @FindBy(id = "login")
    private MyElement login;

    @FindBy(id = "sudo_password")
    private MyElement passwordInput;
    @FindBy(xpath = "/html/body/div[1]/div[5]/main/div/sudo-credential-options/div[2]/form/div/div/button")
    private MyElement confirmBtn;

    public SignInPO(){
        PageFactory.initElements(new Decorator(driver), this);
    }

    public void signIn(String username, String password){
        usernameField.getElementWithWait().sendKeys(username);
        passwordField.getElement().sendKeys(password);
        submitBtn.getElement().click();
    }
    public boolean isSignInPage(){
        return login.getElement().isDisplayed();
    }

    public void confirmDeleteRepo(){
        passwordInput.getElementWithWait().sendKeys("m8s7d1w10");
        confirmBtn.getElementToBeClickable().click();
    }
}
