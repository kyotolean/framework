package lab8;

import org.example.lab8.Builder;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BuilderTest {

    @Test
    public void testSetText(){
        Builder builder = new Builder();
        String text = "some text";

        builder.setText(text);

        assertEquals(text, builder.getText());
    }

    @Test
    public void testConnectText(){
        Builder builder = new Builder();
        String text = "my text";
        builder.setText(text);
        String connectedtest = builder.connectText();

        assertEquals(connectedtest, text);
    }

    @Test
    public void textRemoveAllText(){
        Builder builder = new Builder();
        builder.setText("text");
        builder.connectText();
        int length = builder.removeAll();

        assertEquals(length, 0);

    }
}
