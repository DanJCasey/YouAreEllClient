package controllers;

//import com.fasterxml.jackson.databind.JsonNode;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.JsonNode;


//import java.net.HttpURLConnection;
//import java.net.

//spiffyUrlManipulator //import library

public class ServerController() {
    private final String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();


    private ServerController() {
    }

    public static ServerController getServerInstance() {
        return svr;
    }

    public String getURL(String urlExtension) {
        HttpResponse<JsonNode> jsonResponse = Unirest.get(rootURL + "/" + urlExtension).asJson();
        if (jsonResponse.isSuccess()) return jsonResponse.getBody().toString();
        return null;
    }

    public String postURL(String urlExtension, String jsonBody) {
        return Unirest.post(rootURL + "/" + urlExtension).body(jsonBody).asJson().getBody().toString();
    }

    public String putURL(String urlExtension, String jsonBody) {
        return Unirest.put(rootURL + "/" + urlExtension).body(jsonBody).asJson().getBody().toString();
    }


//    public ServerController shared() {
//        return svr;
//    } //Caro: took out static and added ServerController to return
//
//    public JsonString idGet() {
//        // url -> /ids/
//        // send the server a get with url
//        // return json from server
//    }
//    public JsonString idPost(Id) {
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
//    }
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }


}

// ServerController.shared.doGet()