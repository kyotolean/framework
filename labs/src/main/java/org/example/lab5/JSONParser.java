package org.example.lab5;

import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class JSONParser {
    public void run() throws IOException {
        JsonMapper jsonMapper = new JsonMapper();

        PersonEntity jsonPerson = jsonMapper.readValue(new File("input.txt"), PersonEntity.class);
        //check data
        System.out.println(jsonPerson);

        //set some data
        jsonPerson.setName("Alice");
        jsonPerson.setAge(20);
        jsonPerson.setFriends(Arrays.asList("Emily", "Bob", "David"));

        String jsonToString = jsonMapper.writeValueAsString(jsonPerson);
        FileWriter file = new FileWriter("output.json");
        file.write(jsonToString);
        file.close();
    }
}
