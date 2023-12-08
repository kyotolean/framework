package api.entities.createdRepo;

import lombok.Data;

@Data
public class CreatedRepoResponse {
    private Integer statusCode;
    private CreatedRepo body;
}
