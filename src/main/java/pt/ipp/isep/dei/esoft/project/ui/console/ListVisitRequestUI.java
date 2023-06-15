package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListVisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Sort;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class ListVisitRequestUI implements Runnable {

    ListVisitRequestController controller = new ListVisitRequestController();
    private Sort sortingAlgorithm;


    @Override
    public void run() {
        requestDate();
        configurationFile();
        requestAgentList();
    }

    private void requestAgentList() {
        controller.VisitRequest();
    }

    private void configurationFile() {
        controller.getConfigurationFile();
    }

    private void requestDate() {
        System.out.println(controller.getBeginDate());
        System.out.println(controller.getEndDate());
    }
}


