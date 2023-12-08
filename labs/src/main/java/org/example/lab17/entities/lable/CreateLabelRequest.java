package org.example.lab17.entities.lable;

import lombok.Data;

@Data
public class CreateLabelRequest {
    private String token;
    private String key;
    private String idBoard;
    private String lablename;
}
