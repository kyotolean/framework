package org.example.lab17.entities.list;

import lombok.Data;

@Data
public class GetListRequest {
    private String idBoard;
    private String key;
    private String token;
}
