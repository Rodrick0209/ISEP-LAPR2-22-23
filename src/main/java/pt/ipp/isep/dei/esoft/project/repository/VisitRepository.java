package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Visit repository.
 */
public class VisitRepository {


    private  List<VisitRequest> visitRequests = new ArrayList<>();

    /**
     * Get list visit repository list.
     *
     * @return the list
     */
    public List<VisitRequest> getListVisitRepository(){
        return List.copyOf(visitRequests);
    }


    /**
     * Add requests.
     *
     * @param visit the visit
     */
    public void addRequests(VisitRequest visit) {
        visitRequests.add(visit);
        System.out.println(visit.toString());
    }

}
