package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Network manager ui.
 */
public class StoreManagerUI implements Runnable {


    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nStore Manager Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}