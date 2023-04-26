package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgencyRepository {
    private final List<Agency> agencies = new ArrayList<>();

    public Agency getAgencyByID(int agencyID){
        Agency newAgency = new Agency(agencyID);
        Agency agency = null;
        if(agencies.contains(newAgency)){
            agency = agencies.get(agencies.indexOf(newAgency));
        }
        if(agency == null){
            throw new IllegalArgumentException("Agency not found");
        }
        return agency;
    }

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
    private boolean validateAgency(Agency agency){
        return (!agencies.contains(agency));
    }

    public List<Agency> getAgencies(){ return List.copyOf(agencies); }
}
