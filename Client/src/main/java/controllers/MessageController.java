package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController { //we need to create a constructor?
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> messagesFromFriend;
    private List<Message> messagesToId;


    public List<Message> getMessages(){
        String getResultsJSON;
        try {
            getResultsJSON = ServerController.getServerInstance().getURL("messages");
            return Arrays.asList(objectMapper.readValue(getResultsJSON, Message[].class));
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Message> getMessagesForId(String id) {
        if (messagesFromFriend == null) {
            String getResultJSON;
            try {
                getResultJSON = ServerController.getServerInstance().getURL("ids/" + id + "/messages");
                if(getResultJSON == null) return null;
                return Arrays.asList(objectMapper.readValue(getResultJSON, Message[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messagesFromFriend;
    }

    public Message getMessageSequence(String githubId, String sequence){
        Message message;
        String getResultJSON;
        try {
            getResultJSON = ServerController.getServerInstance().getURL("ids/" + githubId + "/messages/" + sequence);
            return objectMapper.readValue(getResultJSON, Message.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Message> getMessagesFromFriend(String myId, String friendId) {
        if(messagesFromFriend == null){
            String getResultJSON;
            try {
                getResultJSON = ServerController.getServerInstance().getURL("ids/" + myId +"/from/" + friendId);
                return Arrays.asList(objectMapper.readValue(getResultJSON, Message[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messagesFromFriend;
    }
    public Message postMessage(Message message) throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(message);
        String jsonString = objectMapper.
    }

//    private Message message; //caro: added instance
//    private HashSet<Message> messagesSeen;
//    // why a HashSet?? Messages come in batches

//    public MessageController(HashSet<Message> messagesSeen, Message message) { //caro: created constructor
//        this.messagesSeen = messagesSeen; //auto generated
//        this.message = message; //added in constructor
//    }
//
//    public MessageController() { //caro: created nullery
//
//    }


//    public ArrayList<Message> getMessages() {
//        return null;
//    } //why return an arraylist
//    public ArrayList<Message> getMessagesForId(Id Id) {
//        return null;
//    }
//    public Message getMessageForSequence(String seq) {
//        return null;
//    }
//    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
//        return null;
//    }
//
//    public Message postMessage(Id myId, Id toId, Message msg) {
//        return null;
//    }
//
}