package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.CreateRequestUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ListPropertiesUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User ui.
 */
public class UserUI implements Runnable{

    /**
     * Instantiates a new User ui.
     */
    public UserUI(){

    }

    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List all Properties", new ListPropertiesUI()));


        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nUser Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
    }
