package org.example.lab17.entities.lable;

import lombok.Data;

@Data
public class RemoveLabelRequest {
    private String token;
    private String key;
    private String idLabel;
}
