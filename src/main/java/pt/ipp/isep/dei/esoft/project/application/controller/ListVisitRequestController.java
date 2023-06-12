package pt.ipp.isep.dei.esoft.project.application.controller;


//import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;

import pt.ipp.isep.dei.esoft.project.domain.Sort;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class ListVisitRequestController {

    private VisitRepository visitRepository;
    private EmployeeRepository employeeRepository;
    private Sort sortingAlgorithm;

    public ListVisitRequestController(VisitRepository visitRepository, EmployeeRepository employeeRepository, Sort sortingAlgorithm){
        this.visitRepository = visitRepository;
        this.employeeRepository = employeeRepository;
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public ListVisitRequestController() {
        getVisitRepository();
        getEmployeeRepository();
        //sortingAlgorithm=Repositories.getInstance().getSortingMethod();
    }

    private VisitRepository getVisitRepository(){
        if(visitRepository == null){
            Repositories repositories = Repositories.getInstance();
            visitRepository = repositories.getVisitRepository();
        }
        return visitRepository;
    }

    public EmployeeRepository getEmployeeRepository(){
        if(employeeRepository == null){
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    public void getBeginDate() {
        System.out.println("Begin Date (year, month, day");
        int year = Utils.readIntegerFromConsole("year");
        Calendar calendar = Calendar.getInstance();
        int month = Utils.readIntegerFromConsole("month");
        month = calendar.get(Calendar.MONTH) + 1;
        int day = Utils.readIntegerFromConsole("day");
        Date beginDate = new Date ( year, month ,day);
    }

    public void getEndDate() {
        System.out.println("End Date (year, month, day");
        int year = Utils.readIntegerFromConsole("year");
        Calendar calendar = Calendar.getInstance();
        int month = Utils.readIntegerFromConsole("month");
        month = calendar.get(Calendar.MONTH) + 1;
        int day = Utils.readIntegerFromConsole("day");
        Date endDate = new Date(year , month , day);
    }


    /*private Employee agentInfo() {


        return controller.getEmployeeRepository().getAgent();
    }*/


}
