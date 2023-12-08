package lab16;

import io.restassured.path.json.JsonPath;
import org.example.lab14.AllureListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import static io.restassured.RestAssured.given;


@Listeners({AllureListener.class})
public class Trello {
    private Properties properties = new Properties();
    private JsonPath jsonPath;
    private String trelloKey;
    private String trelloToken;
    private String idBoard;
    private String boardName;
    private String idList;
    private String idCard;
    private String idLabel;

    @BeforeTest
    void init() throws IOException {
        properties.load(new FileReader(new File("src/main/resources/application.properties")));

        trelloKey = properties.getProperty("trello.key");
        trelloToken = properties.getProperty("trello.token");
    }

    @Test(priority = 1)
    public void createBoardTest(){
        boardName = UUID.randomUUID().toString().substring(2,10);

        String res = given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://api.trello.com/1/boards/?" +
                        "name="+ boardName +"&"+
                        "key=" + trelloKey +"&" +
                        "token=" + trelloToken)
                .then().assertThat().statusCode(200).extract().response().asString();

        jsonPath = new JsonPath(res);
        idBoard = jsonPath.getString("id");

        Assert.assertEquals(jsonPath.getString("name"), boardName);
    }

    @Test(priority = 2)
    public void getAllListTest(){
        String lists = given().contentType("application/json").accept("application/json")
                .log().all().when().get("https://api.trello.com/1/boards/" +
                        idBoard +
                        "/lists?" +
                        "key="+ trelloKey + "&" +
                        "token=" +trelloToken)
                .then().assertThat().statusCode(200).extract().jsonPath().getString("id");
        idList = lists.substring(1, lists.length() - 1).split(", ")[0];

    }


    @Test(priority = 3)
    public void createCardTest(){

        String cardName = UUID.randomUUID().toString().substring(3,10);

        String res = given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://trello.com/1/cards?" +
                        "key="+ trelloKey + "&" +
                        "token="+ trelloToken + "&" +
                        "idList="+idList+ "&" +
                        "name=" + cardName)
                .then().assertThat().statusCode(200).extract().response().asString();

        jsonPath = new JsonPath(res);
        idCard = jsonPath.getString("id");

        Assert.assertEquals(jsonPath.getString("idList"), idList);
        Assert.assertEquals(jsonPath.getString("name"), cardName);
    }


    @Test(priority = 4)
    public void createLableTest(){
        String labelName = UUID.randomUUID().toString().substring(3,10);

        String res = given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://api.trello.com/1/labels?" +
                        "key="+trelloKey+"&" +
                        "token="+trelloToken+"&" +
                        "idBoard="+ idBoard +"&" +
                        "name="+ labelName +"&" +
                        "color=blue")
                .then().assertThat().statusCode(200).extract().response().asString();

        jsonPath = new JsonPath(res);
        idLabel = jsonPath.getString("id");

        Assert.assertEquals(jsonPath.getString("name"), labelName);
        Assert.assertEquals(jsonPath.getString("idBoard"), idBoard);
    }


    @Test(priority = 5)
    public void addLableToCardTest(){
        given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://api.trello.com/1/cards/" +
                        idCard +"/" +
                        "idLabels?" +
                        "key="+ trelloKey +"&" +
                        "token="+trelloToken+"&" +
                        "value="+ idLabel)
                .then().assertThat().statusCode(200);

    }

    @Test(priority = 6)
    public void updateLable(){
        String res = given().contentType("application/json")
                .accept("application/json")
                .log()
                .all()
                .when()
                .body("{ \"name\": \"my name\" }")
                .put("https://api.trello.com/1/labels/" +
                        idLabel +"?"+
                        "key="+trelloKey+"&" +
                        "token="+trelloToken)
                .then().assertThat().statusCode(200).extract().response().asString();

        jsonPath = new JsonPath(res);

        Assert.assertEquals(jsonPath.getString("name"), "my name");
    }

    @Test(priority = 7)
    public void removeLableFromCardTest(){
        given().contentType("application/json")
                .accept("application/json")
                .log()
                .all()
                .when()
                .delete("https://api.trello.com/1/labels/" +
                        idLabel +
                        "?key="+ trelloKey +
                        "&token="+ trelloToken)
                .then().assertThat().statusCode(200).extract().jsonPath().getString("name");
    }
}
