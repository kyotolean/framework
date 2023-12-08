package ui.po;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrappers.Decorator;
import ui.wrappers.MyElement;


import static utils.DriverHelper.driver;

public class RepoPO {
    @FindBy(xpath = "//*[@id=\":r2:\"]")
    private MyElement repoNameField;
    @FindBy(xpath = "//div[@class=\"Box-sc-g0xbh4-0 aBKvw\"]/button")
    private MyElement createRepoSubmit;
    @FindBy(xpath = "/html/body/div[1]/div[6]/div/main/div/div[1]/div[1]/div[1]/strong")
    private MyElement isRepo;
    @FindBy(xpath = "/html/body/div[1]/div[6]/div/main/turbo-frame/div/div/git-clone-help/div[1]/p/a[3]")
    private MyElement createReadmeLink;
    @FindBy(xpath = "/html/body/div[1]/div[6]/div/main/turbo-frame/div/react-app/div/div/div[1]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/button")
    private MyElement commitButton;
    @FindBy(xpath = "//button[@class=\"types__StyledButton-sc-ws60qy-0 gHIvvy\"]")
    private MyElement submitCommeitButton;
    @FindBy(xpath = "/html/body/div[1]/div[6]/div/main/turbo-frame/div/react-app/div/div/div[1]/div/div/div[2]/div[2]/div/div[3]/div[3]/div[2]/div/div[2]/article")
    private MyElement isReadmeArticle;
    @FindBy(id = "settings-tab")
    private MyElement settingBtn;
    @FindBy(id = "dialog-show-repo-delete-menu-dialog")
    private MyElement deleteRepoBtn;
    @FindBy(id = "repo-delete-proceed-button")
    private MyElement confirmDeleteRepoBtn;
    @FindBy(id = "repo-delete-proceed-button")
    private MyElement warningConfirmBtn;
    @FindBy(id = "verification_field")
    private MyElement confirmTextInput;
    @FindBy(id = "repo-delete-proceed-button")
    private MyElement fullDeleteRepoBtn;

    public RepoPO(){
        PageFactory.initElements(new Decorator(driver), this);
    }

    public void createRepo(String nameRepo) throws InterruptedException {
        repoNameField.getElementWithWait().sendKeys(nameRepo);
        Thread.sleep(2000);
        createRepoSubmit.getElementToBeClickable().sendKeys(Keys.ENTER);
    }
    public void createReadme() throws InterruptedException {
        createReadmeLink.getElementWithWait().click();
        commitButton.getElementToBeClickable().click();
        Thread.sleep(2000);
        submitCommeitButton.getElementToBeClickable().click();
    }
    public void deleteRepo(){
        settingBtn.getElementToBeClickable().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        deleteRepoBtn.getElementWithWait().click();

        confirmDeleteRepoBtn.getElementToBeClickable().click();

        warningConfirmBtn.getElementToBeClickable().click();

        confirmTextInput.getElementWithWait().sendKeys("AqaFrameworkUser/first-repo");

        fullDeleteRepoBtn.getElementToBeClickable().click();


    }
    public boolean isReadme(){
        return isReadmeArticle.getElementWithWait().isDisplayed();
    }
    public boolean isRepo(){
        return isRepo.getElementWithWait().isDisplayed();
    }
}
