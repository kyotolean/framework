package lab17;

import org.example.lab14.AllureListener;
import org.example.lab17.bo.TrelloBo;
import org.example.lab17.entities.board.BoardResponse;
import org.example.lab17.entities.board.CreateBoardRequest;
import org.example.lab17.entities.card.CardResponse;
import org.example.lab17.entities.card.CreateCardRequest;
import org.example.lab17.entities.lable.*;
import org.example.lab17.entities.list.GetListRequest;
import org.example.lab17.entities.list.ListResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.UUID;

@Listeners({AllureListener.class})
public class HttpTrelloTest {
    private Properties properties = new Properties();
    private String trelloKey;
    private String trelloToken;
    private TrelloBo trello = new TrelloBo();

    private String idBoard;
    private String idList;
    private String idCard;
    private String idLable;

    @BeforeTest
    void init() throws IOException {
        properties.load(new FileReader(new File("src/main/resources/application.properties")));
        trelloKey = properties.getProperty("trello.key");
        trelloToken = properties.getProperty("trello.token");
    }

    @Test(priority = 1)
    void createBoardTest() throws IOException, InterruptedException, URISyntaxException {
        CreateBoardRequest createBoardRequest = new CreateBoardRequest();
        String nameBoard = UUID.randomUUID().toString().substring(2,10);

        createBoardRequest.setName(nameBoard);
        createBoardRequest.setToken(trelloToken);
        createBoardRequest.setKey(trelloKey);


        BoardResponse res = trello.createBoard(createBoardRequest);
        idBoard = res.getBody().getId();


        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 2)
    void getAllListTest() throws IOException, URISyntaxException, InterruptedException {
        GetListRequest getListRequest = new GetListRequest();
        getListRequest.setIdBoard(idBoard);
        getListRequest.setKey(trelloKey);
        getListRequest.setToken(trelloToken);

        ListResponse listResponse = trello.getAllList(getListRequest);
        idList = listResponse.getBody().getId();

        Assert.assertEquals(listResponse.getStatusCode(), 200);
    }

    @Test(priority = 3)
    void createCardTest() throws IOException, URISyntaxException, InterruptedException {
        CreateCardRequest createCardRequest = new CreateCardRequest();
        createCardRequest.setName("hi");
        createCardRequest.setIdList(idList);
        createCardRequest.setToken(trelloToken);
        createCardRequest.setKey(trelloKey);

        CardResponse cardResponse = trello.createCard(createCardRequest);
        idCard = cardResponse.getBody().getId();

        Assert.assertEquals(cardResponse.getStatusCode(), 200);
        Assert.assertEquals(cardResponse.getBody().getName(), "hi");
    }

    @Test(priority = 4)
    void createLableTest() throws IOException, URISyntaxException, InterruptedException {
        CreateLabelRequest createLableRequest = new CreateLabelRequest();
        createLableRequest.setLablename("mylabel");
        createLableRequest.setKey(trelloKey);
        createLableRequest.setToken(trelloToken);
        createLableRequest.setIdBoard(idBoard);

        LabelResponse lableResponse = trello.createLable(createLableRequest);
        idLable = lableResponse.getBody().getId();

        Assert.assertEquals(lableResponse.getStatusCode(), 200);
        Assert.assertEquals(lableResponse.getBody().getName(), "mylabel");
    }

    @Test(priority = 5)
    void addLableToCardTest() throws IOException, URISyntaxException, InterruptedException {
        AddLabelToCardRequest addLableToCardRequest = new AddLabelToCardRequest();

        addLableToCardRequest.setIdCard(idCard);
        addLableToCardRequest.setIdLabel(idLable);
        addLableToCardRequest.setKey(trelloKey);
        addLableToCardRequest.setToken(trelloToken);

        int statusCode = trello.addLableToCard(addLableToCardRequest);

        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 6)
    void updateLabelTest() throws IOException, URISyntaxException, InterruptedException {
        UpdateLabelRequest updateLabelRequest = new UpdateLabelRequest();
        updateLabelRequest.setIdLabel(idLable);
        updateLabelRequest.setKey(trelloKey);
        updateLabelRequest.setToken(trelloToken);

        LabelResponse labelResponse = trello.updateLabel(updateLabelRequest);

        Assert.assertEquals(labelResponse.getStatusCode(), 200);
    }

    @Test(priority = 7)
    void removeLabelTest() throws IOException, URISyntaxException, InterruptedException {
        RemoveLabelRequest removeLabelRequest = new RemoveLabelRequest();
        removeLabelRequest.setIdLabel(idLable);
        removeLabelRequest.setKey(trelloKey);
        removeLabelRequest.setToken(trelloToken);

        LabelResponse response = trello.removeLabel(removeLabelRequest);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
