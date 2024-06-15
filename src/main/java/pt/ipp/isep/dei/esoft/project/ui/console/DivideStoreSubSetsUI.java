package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.DivideStoresSubSetsController;
import pt.ipp.isep.dei.esoft.project.application.controller.ImportInformationController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyInfo;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DivideStoreSubSetsUI implements Runnable{

    private final DivideStoresSubSetsController controller = new DivideStoresSubSetsController();

    private final ImportInformationController importInformationController = new ImportInformationController();

    private String fileName;


    public DivideStoresSubSetsController getController() {
        return controller;
    }

    public void run(){
        submitData();
        submitAgencyNum();
    }

    private void submitData(){
        requestData();
        importInformationController.receiveFile(fileName);
    }

    private void requestData(){
        fileName = requestFileName();
    }


    private void submitAgencyNum(){
        List<Agency> agencies = controller.getAgencies();
        List<AgencyInfo> subset1 = new ArrayList();
        List<AgencyInfo> subset2 = new ArrayList();
        long startTime = System.nanoTime();
        int minDifferenceSubSets = controller.findMinSubsetDifference(agencies, subset1, subset2);
        long endTime = System.nanoTime();
        double runtime = (double)(endTime - startTime) / 1.0E9; //nano times so
        System.out.println("Subset 1: " + subset1);
        System.out.println("Subset 2: " + subset2);
        System.out.println("Start time: " + startTime);
        System.out.println("End time: " + endTime);
        System.out.println("Runtime: " + runtime);
        System.out.println("Minimum Difference: " + minDifferenceSubSets);
    }

    private String requestFileName(){
        return Utils.readLineFromConsole("Inserts your file: ");
    }

    private int requestsNumAgencies(){
        return Utils.readIntegerFromConsole("Number of agencies (maximum 30): ");
    }

    private void showSubSetsAndRuntime(){

    }
}
