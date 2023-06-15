package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
