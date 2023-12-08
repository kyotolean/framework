package org.example.lab17.entities.lable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Label {
    private String id;
    private String idBoard;
    private String name;
    private String color;
    @JsonProperty("uses")
    private Integer myuses;
    private Limits limits;
}
