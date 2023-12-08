package api.entities.profile;

import lombok.Data;

@Data
public class ProfileRequest {
    private String token;
    private String name;
    private String bio;
}
