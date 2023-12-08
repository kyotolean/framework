package org.example.lab17.entities.list;

import lombok.Data;

@Data
public class TrelloList {
    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
    private Integer pos;
    private Boolean subscribed;
    private Object softLimit;
    private Object status;
}
