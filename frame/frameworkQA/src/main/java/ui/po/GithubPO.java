package ui.po;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrappers.Decorator;
import ui.wrappers.MyElement;

import static utils.DriverHelper.driver;

public class GithubPO {
    private final String BASE_URL = "https://github.com";

    @FindBy(xpath = "//a[@href='/login' and contains(@class,'HeaderMenu-link--sign-in') and normalize-space()='Sign in']")
    private MyElement signInButton;
    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div/div[2]/div/div")
    private MyElement loginNav;
    @FindBy(xpath = "/html/body/div[1]/div[6]/div/div/aside/div/div/loading-context/div/div[1]/div/h2/a")
    private MyElement newRepoBtn;
    @FindBy(xpath = "//*[@id=\"dashboard-repositories-box\"]/div/div/div/div/a[1]")
    private MyElement createRepoBtn;
    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div[2]/div[3]")
    private MyElement userMenu;
    @FindBy(xpath = "//a[@href=\"/AqaFrameworkUser?tab=repositories\"]")
    private MyElement yourRepo;


    public GithubPO(){
        PageFactory.initElements(new Decorator(driver), this);
        if(!BASE_URL.equals(driver.getCurrentUrl())){
            driver.get(BASE_URL);
        }
    }

    public void goToSignIn(){
        signInButton.getElementWithWait().click();
    }
    public void createNewRepo(){
        createRepoBtn.getElementWithWait().click();
    }
    public void openUserMenu(){
        userMenu.getElementWithWait().click();
    }
    public void goToMyRepos(){
        yourRepo.getElementWithWait().click();
    }

    public boolean isHomePage(){
        return loginNav.getElement().isDisplayed();
    }
}
