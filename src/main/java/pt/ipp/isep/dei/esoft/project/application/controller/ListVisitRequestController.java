package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRepository;


public class ListVisitRequestController {

    private VisitRepository visitRepository;

    public ListVisitRequestController(VisitRepository visitRepository){


    }



    private VisitRepository getVisitRepository(){
        if(visitRepository == null){
            Repositories repositories = Repositories.getInstance();
            visitRepository = repositories.getVisitRepository();
        }
        return visitRepository;
    }




}
