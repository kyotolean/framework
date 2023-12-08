package org.example.lab17.entities.board;

import lombok.Data;

@Data
public class BoardResponse {
    private Integer statusCode;
    private Board body;
}
