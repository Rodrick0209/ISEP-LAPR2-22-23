package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.domain.Owner;
import pt.ipp.isep.dei.esoft.project.ui.console.CreateRequestUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ListPropertiesUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Owner ui.
 */
public class OwnerUI implements Runnable{
    /**
     * The Owner.
     */
    Owner owner;

    /**
     * Instantiates a new Owner ui.
     *
     * @param owner the owner
     */
    public OwnerUI(Owner owner) {
        this.owner = owner;
    }

    /**
     * Instantiates a new Owner ui.
     */
    public OwnerUI() {

    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List all properties", new ListPropertiesUI()));
        options.add(new MenuItem("Submit a request", new CreateRequestUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nOwner Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }

    }
