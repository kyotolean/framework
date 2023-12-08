package org.example.lab17.entities.list;

import lombok.Data;

@Data
public class ListResponse {
    private Integer statusCode;
    private TrelloList body;
}
