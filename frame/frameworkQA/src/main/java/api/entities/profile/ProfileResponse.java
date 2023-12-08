package api.entities.profile;

import lombok.Data;

@Data
public class ProfileResponse {
    private Integer statusCode;
    private Profile body;
}
