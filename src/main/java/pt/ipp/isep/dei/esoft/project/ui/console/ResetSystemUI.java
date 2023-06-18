package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ResetSystemController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class ResetSystemUI implements Runnable{

    private final ResetSystemController controller = new ResetSystemController();

    @Override
    public void run() {
        confirmOrNot();
    }

    private void confirmOrNot(){
        boolean answer = Utils.confirm("Are you sure you want to restart the system? You can lose everything in the system. (type yes or no)");
        if(answer){
            controller.clearRepositories();
            System.out.println("System has been reset successfully!");
        }
    }
}
