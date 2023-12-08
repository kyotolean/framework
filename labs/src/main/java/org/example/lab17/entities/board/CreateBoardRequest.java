package org.example.lab17.entities.board;

import lombok.Data;

@Data
public class CreateBoardRequest {
    private String name;
    private String token;
    private String key;
}
