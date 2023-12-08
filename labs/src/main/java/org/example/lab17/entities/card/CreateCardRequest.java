package org.example.lab17.entities.card;

import lombok.Data;

@Data
public class CreateCardRequest {
    private String name;
    private String key;
    private String token;
    private String idList;
}
