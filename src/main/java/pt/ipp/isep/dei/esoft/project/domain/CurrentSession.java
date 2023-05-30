package pt.ipp.isep.dei.esoft.project.domain;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

public class CurrentSession {
    private static String email;
    OwnerRepository ownerRepository = Repositories.getInstance().getOwnerRepository();

    public static void setCurrentSession(String id){ email = id;}

    public static String getEmail(){
        return email;
    }


}