package org.example.lab17.entities.lable;

import lombok.Data;

@Data
public class AddLabelToCardRequest {
    private String token;
    private String key;
    private String idCard;
    private String idLabel;
}
