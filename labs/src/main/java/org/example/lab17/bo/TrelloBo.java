package org.example.lab17.bo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.lab17.entities.board.Board;
import org.example.lab17.entities.board.BoardResponse;
import org.example.lab17.entities.board.CreateBoardRequest;
import org.example.lab17.entities.card.Card;
import org.example.lab17.entities.card.CardResponse;
import org.example.lab17.entities.card.CreateCardRequest;
import org.example.lab17.entities.lable.*;
import org.example.lab17.entities.list.GetListRequest;
import org.example.lab17.entities.list.ListResponse;
import org.example.lab17.entities.list.TrelloList;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TrelloBo {
    private final String URL_BASE = "https://api.trello.com/";
    private ObjectMapper mapper = new ObjectMapper();


    public BoardResponse createBoard(CreateBoardRequest createBoardRequest) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(URL_BASE+"/1/boards/?" +
                        "name="+ createBoardRequest.getName() +
                        "&key=" + createBoardRequest.getKey() +
                        "&token="+ createBoardRequest.getToken()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());


        BoardResponse boardResponse = new BoardResponse();
        boardResponse.setStatusCode(httpResponse.statusCode());

        Board board = mapper.readValue(httpResponse.body()+"", Board.class);

        boardResponse.setBody(board);

        return boardResponse;
    }

    public ListResponse getAllList(GetListRequest getAllListRequest) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(URL_BASE+"/1/boards/" +
                        getAllListRequest.getIdBoard() +
                        "/lists?" +
                        "key=" +getAllListRequest.getKey()+
                        "&token="+getAllListRequest.getToken()).toURI())
                .GET().build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        ListResponse listResponse = new ListResponse();

        TrelloList[] trelloList = mapper.readValue(httpResponse.body()+"", TrelloList[].class);

        listResponse.setStatusCode(httpResponse.statusCode());
        listResponse.setBody(trelloList[0]);

        return listResponse;
    }

    public CardResponse createCard(CreateCardRequest createCardRequest) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(URL_BASE+"/1/cards?" +
                        "key="+ createCardRequest.getKey() + "&" +
                        "token="+ createCardRequest.getToken() + "&" +
                        "idList="+createCardRequest.getIdList()+ "&" +
                        "name=" + createCardRequest.getName()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8))
                .build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        CardResponse cardResponse = new CardResponse();

        Card card = mapper.readValue(httpResponse.body()+"", Card.class);

        cardResponse.setBody(card);
        cardResponse.setStatusCode(httpResponse.statusCode());

        return cardResponse;
    }

    public LabelResponse createLable(CreateLabelRequest createLableRequest) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(URL_BASE+"/1/labels?" +
                        "key="+createLableRequest.getKey()+"&" +
                        "token="+createLableRequest.getToken()+"&" +
                        "idBoard="+ createLableRequest.getIdBoard() +"&" +
                        "name="+ createLableRequest.getLablename() +"&" +
                        "color=blue").toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8))
                .build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        LabelResponse lableResponse = new LabelResponse();

        Label lable = mapper.readValue(httpResponse.body()+"", Label.class);

        lableResponse.setBody(lable);
        lableResponse.setStatusCode(httpResponse.statusCode());

        return lableResponse;
    }

    public int addLableToCard(AddLabelToCardRequest addLableToCardRequest) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(URL_BASE+"/1/cards/" +
                        addLableToCardRequest.getIdCard() +"/" +
                        "idLabels?" +
                        "key="+ addLableToCardRequest.getKey() +"&" +
                        "token="+addLableToCardRequest.getToken()+"&" +
                        "value="+ addLableToCardRequest.getIdLabel()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8))
                .build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return httpResponse.statusCode();
    }

    public LabelResponse updateLabel(UpdateLabelRequest updateLabelRequest) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(URL_BASE+"/1/labels/" +
                        updateLabelRequest.getIdLabel() +"?"+
                        "key="+updateLabelRequest.getKey()+"&" +
                        "token="+updateLabelRequest.getToken()).toURI())
                .PUT(HttpRequest.BodyPublishers.ofString("{ \"name\": \"new my name\" }", StandardCharsets.UTF_8))
                .build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        LabelResponse labelResponse = new LabelResponse();

        Label label = mapper.readValue(httpResponse.body()+"", Label.class);

        labelResponse.setBody(label);
        labelResponse.setStatusCode(httpResponse.statusCode());

        return labelResponse;
    }
    public LabelResponse removeLabel(RemoveLabelRequest removeLabelRequest) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(URL_BASE+"/1/labels/" +
                        removeLabelRequest.getIdLabel() +
                        "?key="+ removeLabelRequest.getKey() +
                        "&token="+ removeLabelRequest.getToken()).toURI())
                .DELETE().build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        LabelResponse labelResponse = new LabelResponse();

        labelResponse.setStatusCode(httpResponse.statusCode());

        return labelResponse;
    }
}
