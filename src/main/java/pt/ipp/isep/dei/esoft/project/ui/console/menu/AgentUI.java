package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.AgentRequestListUI;
import pt.ipp.isep.dei.esoft.project.ui.console.OrderUI;
import pt.ipp.isep.dei.esoft.project.ui.console.PublishAnnouncementUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ShowTextUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AgentUI implements Runnable {

    public void run() {
        addAnnouncements();
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Publish Announcement", new PublishAnnouncementUI())); // us 002 and 009 combined
        options.add(new MenuItem("Manage purchase orders", new OrderUI()));
        //options.add(new MenuItem("See property requests ",new AgentRequestListUI()));  // us009;


        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAgent Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }

    private void addAnnouncements() {
        OrderController orderController = new OrderController();
        Announcement announcement1 = new Announcement();
        Announcement announcement2 = new Announcement();
        Announcement announcement3 = new Announcement();
        orderController.getAnnouncementsList().add(announcement1);
        orderController.getAnnouncementsList().add(announcement3);

    }
}
