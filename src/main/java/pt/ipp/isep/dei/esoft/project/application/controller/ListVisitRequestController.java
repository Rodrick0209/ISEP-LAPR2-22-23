package pt.ipp.isep.dei.esoft.project.application.controller;



import pt.ipp.isep.dei.esoft.project.domain.BublleSort;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.SelectionSort;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Properties;

import java.util.*;


/**
 * The type List visit request controller.
 */
public class ListVisitRequestController {

    private VisitRepository visitRepository;
    private EmployeeRepository employeeRepository;
    private AuthenticationRepository authenticationRepository;

    private static LocalDate begin;
    private LocalDate end;

    private List<VisitRequest> visitList;

    private Date visitDate;

    private List<VisitRequest> newList;


    /**
     * Instantiates a new List visit request controller.
     *
     * @param visitRepository    the visit repository
     * @param employeeRepository the employee repository
     */
    public ListVisitRequestController(VisitRepository visitRepository, EmployeeRepository employeeRepository ) {
        this.visitRepository = visitRepository;
        this.employeeRepository = employeeRepository;
    }


    /**
     * Instantiates a new List visit request controller.
     */
    public ListVisitRequestController()  {
        getVisitRepository();
        getEmployeeRepository();

    }
    /*public List<VisitRequest>  getUnsortedVisitRequestList(List<VisitRequest> visitList, Date visitDate, LocalDate begin, LocalDate end) {
        return Repositories.getInstance().getVisitRepository().getUnsortedVisitRequestList( visitList, visitDate, begin, end);
    }
*/

    /*private List<VisitRequest> getSortedVisitRequestList(List<VisitRequest> newList,  LocalDate begin, LocalDate end) {
        ZoneId zId = ZoneId.systemDefault();

        for (int i = 0; i < newlist.size(); i++) {
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
*/

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

    /*public LocalDate getBeginDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate beginDate = null;

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Begin Date (year, month, day):");
                int year = Utils.readIntegerFromConsole("year");
                int month = Utils.readIntegerFromConsole("month");
                int day = Utils.readIntegerFromConsole("day");

                // Validate the input and create LocalDate object
                beginDate = LocalDate.of(year, month, day);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date.");
            }
        }

        return beginDate;
    }
*/

    /*public Date getEndDate() {
        System.out.println("End Date (year, month, day):");
        int year1 = Utils.readIntegerFromConsole("year");
        int year = year1 - 1900;
        int month1 = Utils.readIntegerFromConsole("month");
        int month = month1 - 1;
        int day = Utils.readIntegerFromConsole("day");
        Date endDate= new Date(year, month, day);
        //LocalDate endDate = endDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return endDate ;
    }

    public Date getBeginDate() {
        System.out.println("Begin Date (year, month, day):");
        int year1 = Utils.readIntegerFromConsole("year");
        int year = year1 - 1900;
        int month1 = Utils.readIntegerFromConsole("month");
        int month = month1 - 1;
        int day = Utils.readIntegerFromConsole("day");
        Date beginDate= new Date(year, month, day);
        //LocalDate endDate = endDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return beginDate ;
    }

*/



    /*public List<VisitRequest> AgentVisitRequest() {
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
            FileInputStream file = new FileInputStream("src/main/resources/application.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty("sorting.algorithms");

    }*/

    /*public List<VisitRequest> getUnsortedVisitRequestList() {
        ZoneId zId = ZoneId.systemDefault();


        for (int i = 0; i < visitList.size(); i++) {
            //Date beginDate = Date.from(begin.atStartOfDay(zId).toInstant());
            //Date endDate = Date.from(end.atStartOfDay(zId).toInstant());

            if (visitDate.after(beginDate) && visitDate.before(endDate)) {
                newList.add(newList.get(i));
            }

        }
        return newList;
    }*/


    /**
     * Gets sorted visit request list.
     *
     * @return the sorted visit request list
     */
    public List<VisitRequest> getSortedVisitRequestList()  {
        List<VisitRequest> visitList = Repositories.getInstance().getVisitRepository().getVisitList();
        List<VisitRequest> finalList = new ArrayList<>();
        List<VisitRequest> newList = new ArrayList<>();


        System.out.println("Begin Date (year, month, day):");
        int year1 = Utils.readIntegerFromConsole("year");
        int year = year1 - 1900;
        int month1 = Utils.readIntegerFromConsole("month");
        int month = month1 - 1;
        int day = Utils.readIntegerFromConsole("day");
        Date beginDate= new Date(year, month, day);

        System.out.println("End Date (year, month, day):");
        int year2 = Utils.readIntegerFromConsole("year");
        int year3 = year2 - 1900;
        int month2 = Utils.readIntegerFromConsole("month");
        int month3 = month2 - 1;
        int day2 = Utils.readIntegerFromConsole("day");
        Date endDate= new Date(year3, month3, day2);

        for (int i = 0; i < visitList.size(); i++) {
            Date visitDate = visitList.get(i).getDate();
            if (visitDate.after(beginDate) && visitDate.before(endDate)) {
                newList.add(visitList.get(i));
            }
        }

        BublleSort bublleSort = new BublleSort();
        SelectionSort selectionSort = new SelectionSort();

        Properties properties = System.getProperties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/application.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String algorithm = properties.getProperty("sorting.algorithm");
        if (algorithm == null) {
            algorithm = "BUBBLE";
        }

        switch (algorithm.toUpperCase()) {
            case "BUBBLE":
                finalList = bublleSort.bubbleSort(newList);
                break;
            case "SELECTION":
                finalList = selectionSort.selectionSort(newList);
                break;
            default:
                System.out.println("Warning: invalid");
                finalList = bublleSort.bubbleSort(newList);
        }
        return finalList;
    }


    /*public List<VisitRequest> getSortedVisitRequestList(List<VisitRequest> newList, LocalDate beginDate, LocalDate endDate) throws IOException {
        return Repositories.getInstance().getVisitRepository().getSortedVisitRequestList(newList, beginDate, endDate);
    }*/


}




