package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgencyRepository implements Serializable {
    private final List<Agency> agencies = new ArrayList<>();

    /**
     *
     * @param agencyID the agencyID inputted
     * @return agency by the agencyID
     */
    public Agency getAgencyByID(int agencyID){

        Agency agency = null;
        for(Agency a : agencies){
            if(a.getID() == agencyID){
                agency = a;
            }
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

    public Optional<Agency> createAgency(int id, String designation, String location, String emailAddress, String phoneNumber, Employee administrator){
        Optional<Agency> optionalValue = Optional.empty();

        Agency agency = new Agency(id, designation, location, emailAddress, phoneNumber, administrator);

        if(addAgency(agency)){
            optionalValue = Optional.of(agency);
        }
        return optionalValue;
    }

    public boolean addAgency(Agency agency) {
        boolean success = false;
        if(validateAgency(agency)) {
            success = agencies.add(agency);
        }
        return success;
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

    public void clear(){agencies.clear();}
}
