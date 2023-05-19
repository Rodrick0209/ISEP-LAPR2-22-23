package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerRepository {
    private final List<Owner> owners = new ArrayList<>();

    public Owner getOwnerByEmail(String ownerEmailAddress){
        Owner newOwner = new Owner(ownerEmailAddress);
        Owner owner = null;
        for(Owner o : owners) {
            if(o.getEmailAddress().equalsIgnoreCase(ownerEmailAddress)){
                owner = o;
            }
        }
        if(owner == null){
            throw new IllegalArgumentException("Owner not found");
        }
        return owner;
    }

    public Optional<Owner> add(Owner owner){

        Optional<Owner> newOwner = Optional.empty();
        boolean operationSuccess = false;

        if(validateOwner(owner)){
            newOwner = Optional.of(owner.clone());
            operationSuccess = owners.add(newOwner.get());
        }

        if(!operationSuccess){
            newOwner = Optional.empty();
        }
        return newOwner;
    }

    private boolean validateOwner(Owner owner){return !owners.contains(owner); }
}
