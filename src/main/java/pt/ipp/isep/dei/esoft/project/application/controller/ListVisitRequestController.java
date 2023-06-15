package pt.ipp.isep.dei.esoft.project.application.controller;



import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Sort;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;

import java.util.*;


public class ListVisitRequestController {

    private VisitRepository visitRepository;
    private EmployeeRepository employeeRepository;
    private AuthenticationRepository authenticationRepository;
    private Sort sortingAlgorithm;
    private LocalDate begin;
    private LocalDate end;
    private List<VisitRequest> list;

    public ListVisitRequestController(VisitRepository visitRepository, EmployeeRepository employeeRepository, Sort sortingAlgorithm) {
        this.visitRepository = visitRepository;
        this.employeeRepository = employeeRepository;
        this.sortingAlgorithm = sortingAlgorithm;
    }


    public ListVisitRequestController() {
        getVisitRepository();
        getEmployeeRepository();
        getSortedVisitRequestList(begin, end);
        getConfigurationFile();
    }


    private List<VisitRequest> getSortedVisitRequestList(LocalDate begin, LocalDate end) {
        List<VisitRequest> list = new ArrayList<>();
        List<VisitRequest> newList = new ArrayList<>();
        ZoneId zId = ZoneId.systemDefault();

        for (int i = 0; i < list.size(); i++) {
            Date beginDate = Date.from(begin.atStartOfDay(zId).toInstant());
            Date endDate = Date.from(end.atStartOfDay(zId).toInstant());

            String requestDate = list.get(i).getDate().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dateRequest = null;

            try {
                dateRequest = sdf.parse(requestDate);
            } catch (ParseException e) {
                throw new RuntimeException("The date format in the system is wrong!");
            }

            if (dateRequest.after(beginDate) && dateRequest.before(endDate)) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }


    private VisitRepository getVisitRepository() {
        if (visitRepository == null) {
            Repositories repositories = Repositories.getInstance();
            visitRepository = repositories.getVisitRepository();
        }
        return visitRepository;
    }

    private EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public LocalDate getBeginDate() {
        System.out.println("Begin Date (year, month, day):");
        int year1 = Utils.readIntegerFromConsole("year");
        int year = year1 - 1900;
        int month1 = Utils.readIntegerFromConsole("month");
        int month = month1 - 1;
        int day = Utils.readIntegerFromConsole("day");
        Date beginDate1= new Date (year, month, day);
        LocalDate beginDate = beginDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return beginDate ;
    }
    

    public LocalDate getEndDate() {
        System.out.println("End Date (year, month, day):");
        int year1 = Utils.readIntegerFromConsole("year");
        int year = year1 - 1900;
        int month1 = Utils.readIntegerFromConsole("month");
        int month = month1 - 1;
        int day = Utils.readIntegerFromConsole("day");
        Date endDate1= new Date(year, month, day);
        LocalDate endDate = endDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return endDate ;

    }


    public List<VisitRequest> AgentVisitRequest() {
        List<VisitRequest> visitRequests = getVisitRepository().getListVisitRepository();
        List<VisitRequest> agentVisitRequestsList = new ArrayList<>();
        for (VisitRequest vr : visitRequests) {
            if (vr.getAgent().equals(getAgentFromSession())) {
                agentVisitRequestsList.add(vr);
            }
        }
        return agentVisitRequestsList;
    }

    private Employee getAgentFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }


    public String getConfigurationFile() {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\tomas\\OneDrive\\Ambiente de Trabalho\\submissãoSprintC\\src\\main\\resources\\application.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty("sorting.algorithms");

    }




    public List<VisitRequest> getSortedVisitRequestList(List<VisitRequest> list, LocalDate begin, LocalDate end){
        return Repositories.getVisitRepository().getSortedVisitRequestList(list, begin, end);
    }
    public List<VisitRequest> bubbleSort(List<VisitRequest> unsorted) {
        List<VisitRequest> sorted = new ArrayList<>(unsorted);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                if (sorted.get(j).getDate().after(sorted.get(j + 1).getDate())) {
                    VisitRequest temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }

    public List<VisitRequest> selectionSort(List<VisitRequest> unsorted) {
        List<VisitRequest> sorted = new ArrayList<>(unsorted);
        for (int i = 0; i < sorted.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(j).getDate().after(sorted.get(j + 1).getDate())) {
                    minIndex = j;
                }
            }
            VisitRequest temp = sorted.get(i);
            sorted.set(i, sorted.get(minIndex));
            sorted.set(minIndex, temp);
        }
        return sorted;
    }

}



