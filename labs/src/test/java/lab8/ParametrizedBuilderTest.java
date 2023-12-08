package lab8;

import org.example.lab8.Builder;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParametrizedBuilderTest {
    @Test
    public void testSetText(){
        Builder builder = new Builder();
        String text = "some text";

        builder.setText(text);

        assertEquals(text, builder.getText());
    }

    @Parameters({"text", "expectedOutput"})
    @Test
    public void testConnectText(String text, String expectedOutput){
        Builder builder = new Builder();
        String someText = text;
        builder.setText(someText);
        String connectedtest = builder.connectText();

        assertEquals(connectedtest, expectedOutput);
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
