package api.entities.createdRepo;

import lombok.Data;

@Data
public class Permissions {
    private Boolean admin;
    private Boolean maintain;
    private Boolean push;
    private Boolean triage;
    private Boolean pull;
}
