package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class AgentRequestListUI implements Runnable {

    private final PublishAnnouncementController controller = new PublishAnnouncementController();

    private int requestgettedById;
    public void run() {
        System.out.println("Request List\n");

        requestgettedById = displayAndSelectRequests();
        submitOrNot();
    }

     private void displayRequest(List<Request> requests){
        int index = 1;
        for(Request req : requests){
            System.out.println(index + " "+ req);
            index++;
        }
    }

    private int submitOrNot() {
        boolean answer = Utils.confirm("Confirm request? (type yes or no)");
        if(answer){
            PublishAnnouncementUI publishAnnouncementUI = new PublishAnnouncementUI();
            publishAnnouncementUI.run();
            return requestgettedById;
        } else run();
        return -1;
    }


    private int displayAndSelectRequests() {
        List<Request> requests = controller.getRequests();
        int answer = Utils.showAndSelectIndex(requests, "Requests\n");
        return requests.get(answer).getRequestId();
    }

}
