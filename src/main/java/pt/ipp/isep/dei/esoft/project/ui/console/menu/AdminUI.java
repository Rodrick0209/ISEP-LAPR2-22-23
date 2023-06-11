package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Admin ui.
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class AdminUI implements Runnable {
    /**
     * Instantiates a new Admin ui.
     */
    public AdminUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List all Properties", new ListPropertiesUI()));
        options.add(new MenuItem("Register Employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("Register Agency", new RegisterAgencyUI()));
        options.add(new MenuItem("Import Information from a legacy system", new ImportInformationUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
