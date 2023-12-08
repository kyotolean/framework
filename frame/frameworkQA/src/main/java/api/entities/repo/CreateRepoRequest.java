package api.entities.repo;

import lombok.Data;

@Data
public class CreateRepoRequest {
    private String NameRepo;
    private String Token;
}
