package pt.ipp.isep.dei.esoft.project.repository;


import com.sun.scenario.effect.Merge;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * The type Visit repository.
 */
public class VisitRepository implements Serializable {


    private  List<VisitRequest> visitList = new ArrayList<>();
    public List<VisitRequest> newList = new ArrayList<>();

    public void addVisit1(VisitRequest visitRequest) {
        this.visitList.add(visitRequest);
    }




    public List<VisitRequest> getSortedVisitRequestList()  {
        ZoneId zId = ZoneId.systemDefault();
        List<VisitRequest> finalList = new ArrayList<>();

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
                newList.add(newList.get(i));
            }
        }

        BublleSort bublleSort = new BublleSort();
        SelectionSort selectionSort = new SelectionSort();

        Properties properties = System.getProperties();
        try {
            properties.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String algorithm = properties.getProperty("sorting.algorithm");

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

    /**
     * Get list visit repository list.
     *
     * @return the list
     */
    public List<VisitRequest> getListVisitRepository() {
        return List.copyOf(visitList);
    }

    public VisitRequest getVisitRequestByAnnouncement(Announcement announcement) {
        VisitRequest visitRequest = null;
        for (VisitRequest vr : visitList) {
            if (vr.getAnnouncement().equals(announcement)) {
                visitRequest = vr;
            }
        }
        return visitRequest;
    }

    public List<VisitRequest> getVisitList() {
        return visitList;
    }


/*

    public boolean addRequest(VisitRequest visit) {
        boolean operationSuccess = false;
        if (validateRequest(visit)) {
            operationSuccess = visitRequests.add(visit);
        }
        return operationSuccess;
    }
    */

    /*private boolean validateRequest(VisitRequest visitRequest) {
        return !visitList.contains(visitRequest);
    }

    public void addRequests(VisitRequest visit) {


    }
*/

    public List<VisitRequest> visitRequestList() {
        return visitList;
    }


    public List<VisitRequest> getUnsortedVisitRequestList(List<VisitRequest> visitList, Date visitDate,  LocalDate begin, LocalDate end) {
        ZoneId zId = ZoneId.systemDefault();

        for (int i = 0; i < visitList.size(); i++) {
            Date beginDate = Date.from(begin.atStartOfDay(zId).toInstant());
            Date endDate = Date.from(end.atStartOfDay(zId).toInstant());

            if (visitDate.after(beginDate) && visitDate.before(endDate)) {
                newList.add(newList.get(i));
            }

        }
        return newList;
    }
    public List<VisitRequest> getSortedVisitRequestList(List<VisitRequest> newList, LocalDate begin, LocalDate end)  {
        ZoneId zId = ZoneId.systemDefault();
        List<VisitRequest> finalList = new ArrayList<>();


        Date beginDate = Date.from(begin.atStartOfDay(zId).toInstant());
        Date endDate = Date.from(end.atStartOfDay(zId).toInstant());

        BublleSort bublleSort = new BublleSort();
        SelectionSort selectionSort = new SelectionSort();

        Properties properties = System.getProperties();
        try {
            properties.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String algorithm = properties.getProperty("sorting.algorithm");

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


    public void addRequests(VisitRequest request1) {
        this.visitList.add(request1);
    }
}

