package ui;

import allure.AllureListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.bo.GithubBO;

import static utils.DriverHelper.close;
import static utils.DriverHelper.setup;

@Listeners({AllureListener.class})
public class UITest {

    private GithubBO githubBO;
    @BeforeTest
    void start(){
        setup();
        githubBO = new GithubBO();
    }

    @Test
    void signInTest() throws InterruptedException {
        githubBO.goToSignIn();
    }

    @Test(dependsOnMethods = "signInTest")
    void createRepoTest() throws InterruptedException {
        githubBO.createNewRepo();
    }
    @Test(dependsOnMethods = "createRepoTest")
    void addReadmeToRepoTest() throws InterruptedException {
        githubBO.addReadmeToRepo();
    }
    @Test(dependsOnMethods = "addReadmeToRepoTest")
    void deleteRepoTest(){
        githubBO.deleteRepo();
    }

    @AfterTest
    void exit(){
        close();
    }
}
