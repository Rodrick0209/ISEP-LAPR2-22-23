package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgencyRepository {
    private final List<Agency> agencies = new ArrayList<>();

    /**
     *
     * @param agencyID the agencyID inputted
     * @return agency by the agencyID
     */
    public Agency getAgencyByID(int agencyID){
        Agency newAgency = new Agency(agencyID, "Agency Name", "Power Street, F");
        Agency agency = null;
        if(agencies.contains(newAgency)){
            agency = agencies.get(agencies.indexOf(newAgency));
        }
        if(agency == null){
            throw new IllegalArgumentException("Agency not found");
        }
        return agency;
    }

    /**
     *
     * @param agency the agency registered/added
     * @return list of agency added
     */
    public Optional<Agency> add(Agency agency){

        Optional<Agency> newAgency = Optional.empty();
        boolean operationSuccess = false;

        if(validateAgency(agency)){
            newAgency = Optional.of(agency.clone());
            operationSuccess = agencies.add(newAgency.get());
        }

        if(!operationSuccess){
            newAgency = Optional.empty();
        }
        return newAgency;
    }

    /**
     *
     * @param agency the agency registered/added
     * @return if the agency is already contained on the agency list
     */
    private boolean validateAgency(Agency agency){
        return (!agencies.contains(agency));
    }


    /**
     *
     * @return a copy of the list of agencies
     */
    public List<Agency> getAgencies(){ return List.copyOf(agencies); }
}
