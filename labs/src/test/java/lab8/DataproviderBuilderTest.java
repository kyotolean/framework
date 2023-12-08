package lab8;

import org.example.lab8.Builder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataproviderBuilderTest {

    @DataProvider
    private Object[][] SetDataProvider(){
        int n = 2;
        int m = 4;

        Object[][] res = new Object[m][n];
        res[0] = new Object[]{"sometext", "sometext"};
        res[1] = new Object[]{"second test", "sometextsecond test"};
        res[2] = new Object[]{"123232", "sometextsecond test123232"};
        res[3] = new Object[]{"my test", "sometextsecond test123232my test"};

        return res;
    }

    @Test
    public void testSetText(){
        Builder builder = new Builder();
        String text = "some text";

        builder.setText(text);

        assertEquals(text, builder.getText());
    }

    @Test(dataProvider = "SetDataProvider")
    public void testConnectText(String text, String expected){
        Builder builder = new Builder();
        builder.setText(text);
        String connectedtest = builder.connectText();

        assertEquals(connectedtest, expected);
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
