package api.entities.profile;

import lombok.Data;

@Data
public class Plan {
    private String name;
    private Integer space;
    private Integer collaborators;
    private Integer private_repos;
}
