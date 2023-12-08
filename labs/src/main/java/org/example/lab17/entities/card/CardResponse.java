package org.example.lab17.entities.card;

import lombok.Data;

@Data
public class CardResponse {
    private Integer statusCode;
    private Card body;
}
