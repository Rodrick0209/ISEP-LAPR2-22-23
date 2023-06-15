package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.io.Serializable;
import java.util.ArrayList;
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

}
