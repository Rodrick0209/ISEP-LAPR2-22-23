package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Collections;
import java.util.List;

public class AgentRequestListUI implements Runnable {

    private final PublishAnnouncementController controller = new PublishAnnouncementController();

    private String announcementPropertyLocation;
    public void run() {
        System.out.println("Request List\n");

        announcementPropertyLocation = displayAndSelectRequests();

    }

     private void displayRequest(List<Request> requests){
        int index = 1;
        for(Request req : requests){
            System.out.println(index + " "+ req);
            index++;
        }
    }

    private void submitOrNot() {
        boolean answer = Utils.confirm("Confirm request? (type yes or no)");
        if(answer){
            PublishAnnouncementUI publishAnnouncementUI = new PublishAnnouncementUI();
            publishAnnouncementUI.run();
        } else run();
    }


    private String displayAndSelectRequests() {
        List<Request> requests = controller.getRequests();
        int answer = Utils.showAndSelectIndex(requests, "Requests\n");
        return requests.get(answer).getProperty().getLocation().getStreet();
    }

}
