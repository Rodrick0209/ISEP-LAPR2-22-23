package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.ui.console.DivideStoreSubSetsUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ListPropertiesUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Network manager ui.
 */
public class NetworkManagerUI implements Runnable {


    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List all Properties", new ListPropertiesUI()));
        options.add(new MenuItem("Divide Agencies in Subsets", new DivideStoreSubSetsUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nNetwork Manager Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }

}
