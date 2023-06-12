package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateVisitController;
import pt.ipp.isep.dei.esoft.project.application.controller.ListVisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Sort;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Date;

public class ListVisitRequestUI implements Runnable {

    ListVisitRequestController controller = new ListVisitRequestController();
    private Sort sortingAlgorithm;


    @Override
    public void run() {
        requestDate();
        configurationFile();
    }

    private void configurationFile() {
        //sortingAlgorithm=Repositories.getInstance().getSortingMethod();

    }

    private void requestDate() {
        controller.getBeginDate();
        controller.getEndDate();
    }

    private void showDate() {


    }
}


