package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.util.Collections;
import java.util.List;

public class AgentRequestListUI implements Runnable {
    private  String date;
    private  int numberOfRequests = 0;
    public void run(){
            System.out.println("RequestList:\n");
               System.out.println("Please select a request:\n");//displayRequest(request));

    }

     private void displayRequest(List<Request> requests){
        int index = 1;
        for(Request req : requests){
            System.out.println(index + " "+ req);
            index++;
        }
    }
}