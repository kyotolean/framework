package api.entities.repo;

import lombok.Data;

@Data
public class RepoResponse {
    private Integer statusCode;
    private Repo body;
}
