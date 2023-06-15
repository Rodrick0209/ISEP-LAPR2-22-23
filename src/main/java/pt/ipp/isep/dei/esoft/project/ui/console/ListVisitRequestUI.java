package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListVisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Sort;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.List;

public class ListVisitRequestUI implements Runnable {

    ListVisitRequestController controller = new ListVisitRequestController();
    private Sort sortingAlgorithm;


    @Override
    public void run() {
        requestAgentList();
        requestDate();
        configurationFile();
        visitList();

    }

    private void visitList() {
        System.out.println(controller.getSortedVisitRequestList(requestAgentList(), controller.getBeginDate(), controller.getEndDate()));
    }



    private List<VisitRequest> requestAgentList() {
        return controller.AgentVisitRequest();
    }

    private void configurationFile() {
        controller.getConfigurationFile();
    }

    private void requestDate() {
        System.out.println(controller.getBeginDate());
        System.out.println(controller.getEndDate());
    }
}


