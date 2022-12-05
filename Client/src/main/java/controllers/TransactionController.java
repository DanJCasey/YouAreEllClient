package controllers;

//import kong.unirest.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

import java.util.List;

public class TransactionController {
    //private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;
    private ObjectMapper mapper = new ObjectMapper();

    public TransactionController(MessageController m, IdController j) {
        this.msgCtrl = m; //caro: added
        this.idCtrl = j; //caro: added
    }
    public MessageController getMsgCtrl() {
        return msgCtrl;
    }
    public IdController getIdCtrl() {

    }

}


//    public List<Id> getIds() {
//       return idCtrl.getIds(); //caro :added
//    }
//    public String postId(String idtoRegister, String githubName) {
//        Id tid = new Id(idtoRegister, githubName);
//        tid = idCtrl.postId(tid);
//        return ("Id registered.");
//    }
//
//    public String makecall(String s, String get, String s1){
//        return s + " " + get + " " + s1;
//    }
//}
