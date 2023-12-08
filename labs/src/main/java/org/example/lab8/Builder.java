package org.example.lab8;

public class Builder {
    private String text = "";
    public static StringBuilder builder = new StringBuilder();

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public String connectText(){
        builder.append(text);
        return builder.toString();
    }

    public int removeAll(){
        builder.setLength(0);
        text = "";
        return builder.length();
    }
}
