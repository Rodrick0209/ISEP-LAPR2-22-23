package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.PublishAnnouncementUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ShowTextUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AgentUI implements Runnable {

    public AgentUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Publish Announcement", new PublishAnnouncementUI()));
        options.add(new MenuItem("Option 1 ", new ShowTextUI("You have chosen Option 1.")));
        options.add(new MenuItem("Option 2 ", new ShowTextUI("You have chosen Option 2.")));
        options.add(new MenuItem("Option 3 ", new ShowTextUI("You have chosen Option 3.")));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAgent Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}

