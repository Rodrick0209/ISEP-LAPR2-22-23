package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * The type Visit repository.
 */
public class VisitRepository implements Serializable {


    private final List<VisitRequest> visitRequests = new ArrayList<>();

    /**
     * Get list visit repository list.
     *
     * @return the list
     */
    public List<VisitRequest> getListVisitRepository(){
        return List.copyOf(visitRequests);
    }

    public VisitRequest getVisitRequestByAnnouncement(Announcement announcement){
        VisitRequest visitRequest = null;
        for(VisitRequest vr : visitRequests){
            if(vr.getAnnouncement().equals(announcement)){
                visitRequest = vr;
            }
        }
        return visitRequest;
    }

    /**
     * Add requests.
     *
     * @param visit the visit
     */
    public boolean addRequest(VisitRequest visit) {
        boolean operationSuccess = false;
        if(validateRequest(visit)){
            operationSuccess = visitRequests.add(visit);
        }
        return operationSuccess;
    }

    private boolean validateRequest(VisitRequest visitRequest){
        return !visitRequests.contains(visitRequest);
    }

    public void addRequests(VisitRequest visit) {
    }


    public List<Request> getRequestsSorted(List<Request> requestList) throws IOException {
        Properties properties = System.getProperties();
        properties.load(new FileReader("src/main/resources/sortingMethods.properties"));
        String algorithm = properties.getProperty("sorting.algorithm");

        /*if ( algorithm.toUpperCase().equalsIgnoreCase("BUBBLE")) {

        }*/

        Sort sort = new Sort();
        switch (algorithm.toUpperCase()) {
            case "BUBBLE":
                //sort.bubbleSort();
                BublleSort bubbleSort = new BublleSort();
                break;
            case "SELECTION":
                //sort.selectionSort();
                SelectionSort selectionSort = new SelectionSort();
                break;
            default:
                System.out.println("Warning: invalid");
        }
        return getRequestsSorted(requestList);
    }
    public List<VisitRequest> getSortedVisitRequestList(List<VisitRequest> list, LocalDate begin, LocalDate end) {
        List<VisitRequest> newList = new ArrayList<>();
        ZoneId zId = ZoneId.systemDefault();

        for (int i = 0; i < list.size(); i++){
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

            if(dateRequest.after(beginDate) && dateRequest.before(endDate)){
                newList.add(list.get(i));
            }

        }
        return newList;
    }
}
