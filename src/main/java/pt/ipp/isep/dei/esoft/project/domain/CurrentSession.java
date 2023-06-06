package pt.ipp.isep.dei.esoft.project.domain;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

/**
 * The type Current session.
 */
public class CurrentSession {
    private static String email;
    /**
     * The Owner repository.
     */
    OwnerRepository ownerRepository = Repositories.getInstance().getOwnerRepository();

    /**
     * Set current session.
     *
     * @param id the id
     */
    public static void setCurrentSession(String id){ email = id;}

    /**
     * Get email string.
     *
     * @return the string
     */
    public static String getEmail(){
        return email;
    }


}