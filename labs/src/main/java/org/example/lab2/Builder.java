package org.example.lab2;

public class Builder {
//    StringBuilder
//    Objective: To understand and use the StringBuilder class in Java.
//    Instructions:
//    Use the StringBuilder class to build a string by appending characters.
//    Print the result to the console.
    private static StringBuilder builder = new StringBuilder();
    private static String textFirst = "Hello ";
    private static String textSecond = "World!";

    public static void main(String[] args) {
        builder.append(textFirst);
        builder.append(textSecond);
        System.out.println(builder.toString());
    }
}
