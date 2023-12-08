package api;

import api.bo.GithubBO;
import api.entities.createdRepo.CreatedRepoResponse;
import api.entities.createdRepo.UpdateCreatedRepoRequest;
import api.entities.profile.ProfileRequest;
import api.entities.profile.ProfileResponse;
import api.entities.repo.CreateRepoRequest;
import api.entities.repo.RepoResponse;
import db.entities.ResultApi;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.UUID;

import static db.HibernateHelper.*;

public class ApiTest {
    private GithubBO githubBO = new GithubBO();
    private String token;
    private String username;
    private Properties properties = new Properties();
    private String nameRepo;
    @BeforeTest
    void setup() throws IOException {
        InputStream input = ApiTest.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(input);
        token = properties.getProperty("TOKEN");
        username = properties.getProperty("USERNAME");

        startTransaction();
    }

    @DataProvider
    Object[][] createListRepos(){
        int m = 3;
        int n = 1;

        Object[][] res = new Object[m][n];
        String randomName = UUID.randomUUID().toString().substring(2, 10);
        res[0] = new Object[]{randomName + "-my"};
        res[1] = new Object[]{randomName + "-000312"};
        res[2] = new Object[]{randomName + "......"};

        return res;
    }


    @Test(dataProvider = "createListRepos")
    void createRepoTest(String name) throws IOException, URISyntaxException, InterruptedException {
        CreateRepoRequest createRepoRequest = new CreateRepoRequest();

        nameRepo = name;

        createRepoRequest.setNameRepo(nameRepo);
        createRepoRequest.setToken(token);

        RepoResponse repoResponse = githubBO.createRepo(createRepoRequest);
        ResultApi resultApi = new ResultApi();
        try {
            resultApi.setStatusCode(repoResponse.getStatusCode());
            resultApi.setInputData(name);
            resultApi.setOutputData(repoResponse.getBody().getName());

            Assert.assertEquals(repoResponse.getStatusCode(), 201);
            Assert.assertEquals(repoResponse.getBody().getName(), name);

            resultApi.setStatusTest("good");
        }catch (AssertionError e){
            String errorMassage = e.getMessage();
            resultApi.setStatusTest("fail");
            resultApi.setExceptionMessage(errorMassage);
        }catch (SkipException e){
            String errorMassage = e.getMessage();
            resultApi.setStatusTest("skip");
            resultApi.setExceptionMessage(errorMassage);
        }
        session.save(resultApi);
    }


    @Test(dependsOnMethods = "createRepoTest")
    void updateGithubStatusTest() throws IOException, URISyntaxException, InterruptedException {
        UpdateCreatedRepoRequest updateCreatedRepoRequest = new UpdateCreatedRepoRequest();
        updateCreatedRepoRequest.setToken(token);
        updateCreatedRepoRequest.setDescription("working");
        updateCreatedRepoRequest.setSmile(":rocket:");
        updateCreatedRepoRequest.setUsername(username);
        updateCreatedRepoRequest.setRepoName(nameRepo);

        CreatedRepoResponse createdRepoResponse = githubBO.updateGithubStatus(updateCreatedRepoRequest);


        ResultApi resultApi = new ResultApi();
        try {
            resultApi.setStatusCode(createdRepoResponse.getStatusCode());
            resultApi.setInputData(updateCreatedRepoRequest.getDescription());
            resultApi.setOutputData(createdRepoResponse.getBody().getDescription());

            Assert.assertEquals(createdRepoResponse.getStatusCode(), 200);
            Assert.assertEquals(createdRepoResponse.getBody().getDescription(), updateCreatedRepoRequest.getDescription());

            resultApi.setStatusTest("good");
        }catch (AssertionError e){
            String errorMassage = e.getMessage();
            resultApi.setStatusTest("fail");
            resultApi.setExceptionMessage(errorMassage);
        }catch (SkipException e){
            String errorMassage = e.getMessage();
            resultApi.setStatusTest("skip");
            resultApi.setExceptionMessage(errorMassage);
        }
        session.save(resultApi);
    }

    @Test
    void editProfileTest() throws IOException, URISyntaxException, InterruptedException {
        ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.setBio("bio test here");
        profileRequest.setToken(token);
        profileRequest.setName("David Voloshyn");

        ProfileResponse profileResponse= githubBO.editProfile(profileRequest);

        ResultApi resultApi = new ResultApi();
        try {
            resultApi.setStatusCode(profileResponse.getStatusCode());
            resultApi.setInputData(profileRequest.getBio());
            resultApi.setOutputData(profileResponse.getBody().getBio());

            Assert.assertEquals(profileResponse.getStatusCode(), 200);
            Assert.assertEquals(profileResponse.getBody().getName(), profileRequest.getName());
            Assert.assertEquals(profileResponse.getBody().getBio(), profileRequest.getBio());
        }catch (AssertionError e){
            String errorMassage = e.getMessage();
            resultApi.setStatusTest("fail");
            resultApi.setExceptionMessage(errorMassage);
        }catch (SkipException e){
            String errorMassage = e.getMessage();
            resultApi.setStatusTest("skip");
            resultApi.setExceptionMessage(errorMassage);
        }
        session.save(resultApi);
    }

    @AfterTest
    void close(){
        closeTransaction();
    }
}
