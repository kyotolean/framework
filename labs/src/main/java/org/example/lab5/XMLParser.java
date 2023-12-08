package org.example.lab5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class XMLParser {
   public void run() throws IOException {
       XmlMapper xmlMapper = new XmlMapper();

       PersonEntity xmlPerson = xmlMapper.readValue(new File("input_xml.txt"), PersonEntity.class);
       //check data
       System.out.println(xmlPerson);

       //set new data
       xmlPerson.setName("Alice");
       xmlPerson.setAge(20);
       xmlPerson.setFriends(Arrays.asList("Emily", "Bob", "David"));

       String xmlToString = xmlMapper.writeValueAsString(xmlPerson);
       FileWriter file = new FileWriter("output.xml");
       file.write(xmlToString);
       file.close();
   }
}
