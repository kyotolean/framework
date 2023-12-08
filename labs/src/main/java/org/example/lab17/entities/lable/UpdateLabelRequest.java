package org.example.lab17.entities.lable;

import lombok.Data;

@Data
public class UpdateLabelRequest {
    private String idLabel;
    private String token;
    private String key;
}
