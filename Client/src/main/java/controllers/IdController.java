package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public List<Id> getIdsAsList() {
        String getResultJSON;
        try {
            getResultJSON = ServerController.getServerInstance().getURL("ids");
            return new ArrayList<>(Arrays.asList(objectMapper.readValue(getResultJSON, Id[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Id postId(Id id) throws MalformedURLException, JsonProcessingException {
        try {
            String jsonString = objectMapper.writeValueAsString(id);
            String responseJsonString = ServerController.getServerInstance().postURL("ids", jsonString);
            return objectMapper.readValue(responseJsonString, Id.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Id putId(Id id) throws MalformedURLException, JsonProcessingException {
        try {
            String jsonString = objectMapper.writeValueAsString(id);
            String responseJsonString = ServerController.getServerInstance().putURL("ids", jsonString);
            return objectMapper.readValue(responseJsonString, Id.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean idExists(Id id) {
        List<Id> idList = getIdsAsList();
        for (Id individual : idList) {
            if (individual.getGithub().equals(id.getGithub())) return true;
        }
        return false;
    }
    public String getUserId(Id id) {
        List<Id> idList = getIdsAsList();
        for(Id individual : idList) {
            if(individual.getGithub().equals(id.getGithub())) return individual.getUserId();
        }
    }
    public Id getIdByUserId(String userId) {
        List<Id> idList = getIdsAsList();
        for(Id individual : idList) {
            if(individual.getUserid().equals(userId)) return individual;
        }
        return null;
    }


    //private HashMap<String, Id> allIds; //why is the key a string:

    //Id myId;

//    public ArrayList<Id> getIds() {
//        return null;
//    }
//
//    public Id postId(Id id) {
//        // create json from id
//        // call server, get json result Or error
//        // result json to Id obj
//
//        return null;
//    }
//
//    public Id putId(Id id) {
//        return null;
//    }
//
}