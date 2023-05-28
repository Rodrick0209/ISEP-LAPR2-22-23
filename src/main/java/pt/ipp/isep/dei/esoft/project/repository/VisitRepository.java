package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.ArrayList;
import java.util.List;

public class VisitRepository {


    private  List<VisitRequest> visitRequests = new ArrayList<>();

    public List<VisitRequest> getListVisitRepository(){
        return List.copyOf(visitRequests);
    }


    public void addRequests(VisitRequest visit) {
        visitRequests.add(visit);
        System.out.println(visit.toString());
    }
}
