package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class ResetSystemController {
    private Repositories repositories;

    public ResetSystemController() {
        getRepositories();
    }

    public Repositories getRepositories() {
        if(repositories == null){
            repositories = Repositories.getInstance();
        }
        return repositories;
    }

    public void clearRepositories(){ getRepositories().clearRepositories(); }
}
