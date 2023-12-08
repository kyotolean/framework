package api.bo;

import api.entities.createdRepo.CreatedRepo;
import api.entities.createdRepo.CreatedRepoResponse;
import api.entities.createdRepo.UpdateCreatedRepoRequest;
import api.entities.profile.Profile;
import api.entities.profile.ProfileRequest;
import api.entities.profile.ProfileResponse;
import api.entities.repo.CreateRepoRequest;
import api.entities.repo.Repo;
import api.entities.repo.RepoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.testng.Assert;


public class GithubBO {
    private final String BASE_USE = "https://api.github.com";
    private ObjectMapper mapper = new ObjectMapper();

    public RepoResponse createRepo(CreateRepoRequest createRepoRequest) throws IOException, URISyntaxException, InterruptedException {
        String json = "{\"name\":\"" + createRepoRequest.getNameRepo() + "\"}";

        String url = BASE_USE+"/user/repos";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + createRepoRequest.getToken())
                .header("User-Agent",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36")
                .uri(new URL(url).toURI())
                .POST(HttpRequest.BodyPublishers.ofString(json)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(httpResponse.statusCode(), 201);

        RepoResponse repoResponse = new RepoResponse();

        repoResponse.setStatusCode(httpResponse.statusCode());

        Repo repo = mapper.readValue(httpResponse.body()+"", Repo.class);

        repoResponse.setBody(repo);
        return repoResponse;
    }

    public CreatedRepoResponse updateGithubStatus(UpdateCreatedRepoRequest updateCreatedRepoRequest) throws IOException, URISyntaxException, InterruptedException {
        String json = String.format("{\"state\":\"success\",\"target_url\":\"\",\"description\":\"%s\",\"context\":\"default\",\"emoji\":\"%s\"}", updateCreatedRepoRequest.getDescription(), updateCreatedRepoRequest.getSmile());
        String url =  BASE_USE+"/repos/" + updateCreatedRepoRequest.getUsername() +"/" + updateCreatedRepoRequest.getRepoName();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + updateCreatedRepoRequest.getToken())
                .header("User-Agent",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36")
                .uri(new URL(url).toURI())
                .method("PATCH", HttpRequest.BodyPublishers.ofString(json)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(httpResponse.statusCode(), 200);

        CreatedRepoResponse createdRepoResponse = new CreatedRepoResponse();
        CreatedRepo createdRepo = mapper.readValue(httpResponse.body()+"", CreatedRepo.class);

        createdRepoResponse.setBody(createdRepo);
        createdRepoResponse.setStatusCode(httpResponse.statusCode());

        return createdRepoResponse;
    }
    public ProfileResponse editProfile(ProfileRequest profileRequest) throws IOException, InterruptedException, URISyntaxException {
        String json = "{\"name\":\""+profileRequest.getName()+"\",\"bio\":\""+profileRequest.getBio()+"\"}\"";
        String url = BASE_USE + "/user";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + profileRequest.getToken())
                .uri(new URL(url).toURI())
                .method("PATCH", HttpRequest.BodyPublishers.ofString(json)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(httpResponse.statusCode(), 200);

        Profile profile = mapper.readValue(httpResponse.body()+"", Profile.class);

        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setBody(profile);
        profileResponse.setStatusCode(httpResponse.statusCode());

        return profileResponse;
    }
}
