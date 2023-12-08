package api.entities.createdRepo;

import lombok.Data;

@Data
public class UpdateCreatedRepoRequest {
    private String token;
    private String repoName;
    private String username;
    private String smile;
    private String description;
}
