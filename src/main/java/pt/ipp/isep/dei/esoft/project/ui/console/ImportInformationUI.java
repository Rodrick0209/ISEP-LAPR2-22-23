package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ImportInformationController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Optional;

/**
 * The type Import information ui.
 */
public class ImportInformationUI implements Runnable {

    private final ImportInformationController controller = new ImportInformationController();
    private String fileName;

    /**
     * Gets controller.
     *
     * @return the controller
     */
    public ImportInformationController getController() {
        return controller;
    }

    public void run(){
        requestData();
        submitOrNot();
    }

    private void requestData(){
        fileName = requestFileName();
    }

    private void submitData() {
        boolean operationSuccess = getController().readFile(fileName);

        if (operationSuccess) {
            System.out.println("Information successfully inserted in the system");
        } else {
            System.out.println("Information not inserted successfully!");
        }
    }

    private void submitOrNot() {
        boolean answer = Utils.confirm("Confirm data? (type yes or no)");
        if(answer){
            submitData();
        } else run();
    }

    private String requestFileName(){
        String input;
        do{
            input = Utils.readLineFromConsole("Inserts the file: ");
            if (input != null && !input.contains(".csv")) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input != null && !input.contains(".csv"));
        return input;
    }
}
