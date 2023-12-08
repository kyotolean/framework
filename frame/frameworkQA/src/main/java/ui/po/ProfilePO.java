package ui.po;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrappers.Decorator;
import ui.wrappers.MyElement;

import static utils.DriverHelper.driver;

public class ProfilePO {
    @FindBy(xpath = "//*[@id=\"user-profile-frame\"]/div/div[1]/div/div/a")
    private MyElement newRepoBtn;
    public ProfilePO(){
        PageFactory.initElements(new Decorator(driver), this);
    }
    public void createNewRepo() {
        newRepoBtn.getElementWithWait().click();
    }
}
