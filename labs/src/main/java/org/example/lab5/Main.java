package org.example.lab5;

import java.io.IOException;

public class Main {
    private static JSONParser jsonParser = new JSONParser();
    private static XMLParser xmlParser = new XMLParser();
    public static void main(String[] args) throws IOException {
        //JSON
        jsonParser.run();

        //XML
        xmlParser.run();
    }
}
