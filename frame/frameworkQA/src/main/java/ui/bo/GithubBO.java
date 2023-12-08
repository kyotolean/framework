package ui.bo;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.po.RepoPO;
import ui.po.GithubPO;
import ui.po.ProfilePO;
import ui.po.SignInPO;
import ui.wrappers.Decorator;

import static utils.DriverHelper.driver;

public class GithubBO {
    private GithubPO githubPO;
    private SignInPO signInPO;
    private RepoPO repoPO;

    public GithubBO(){
        PageFactory.initElements(new Decorator(driver), this);
    }

    public void goToSignIn() throws InterruptedException {
        githubPO = new GithubPO();

        Assert.assertTrue(githubPO.isHomePage());

        githubPO.goToSignIn();

        signInPO = new SignInPO();
        Thread.sleep(2000);

        Assert.assertTrue(signInPO.isSignInPage());

        signInPO.signIn("wall.street.tradess@gmail.com", "User123Pass");
    }
    public void createNewRepo() throws InterruptedException {
        githubPO.openUserMenu();
        githubPO.goToMyRepos();

        ProfilePO profilePO = new ProfilePO();
        profilePO.createNewRepo();

        repoPO = new RepoPO();
        repoPO.createRepo("first repo");
        Assert.assertTrue(repoPO.isRepo());
    }
    public void addReadmeToRepo() throws InterruptedException {
        repoPO.createReadme();

        Assert.assertTrue(repoPO.isReadme());
    }
    public void deleteRepo(){
        repoPO.deleteRepo();
        //signInPO.confirmDeleteRepo();
    }
}
