package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.DevTeamUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ListPropertiesUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterUserUI;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthenticationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Main menu ui.
 *
 * @author Paulo maio pam@isep.ipp.pt
 */
public class MainMenuUI implements Runnable {

    /**
     * Instantiates a new Main menu ui.
     */
    public MainMenuUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Login", new AuthenticationUI()));
        options.add(new MenuItem("List all Properties", new ListPropertiesUI()));
        options.add(new MenuItem("Sign Up", new RegisterUserUI()));
        options.add(new MenuItem("Show Development Team", new DevTeamUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }


}
