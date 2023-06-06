package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Owner repository.
 */
public class OwnerRepository {
    private final List<Owner> owners = new ArrayList<>();

    /**
     * Get owner by email owner.
     *
     * @param ownerEmailAddress the owner email address
     * @return the owner
     */
    public Owner getOwnerByEmail(String ownerEmailAddress){
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

    /**
     * Add optional.
     *
     * @param owner the owner
     * @return the optional
     */
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

    /**
     * Create owner optional.
     *
     * @param name         the name
     * @param ccNumber     the cc number
     * @param taxNumber    the tax number
     * @param emailAddress the email address
     * @param phoneNumber  the phone number
     * @return the optional
     */
    public Optional<Owner> createOwner(String name, int ccNumber, String taxNumber,String emailAddress, String phoneNumber){
            Optional<Owner> optionalValue = Optional.empty();

            Owner owner = new Owner(name, ccNumber, taxNumber, emailAddress, phoneNumber);

            if(addOwner(owner)) {
                optionalValue = Optional.of(owner);
            }
            return optionalValue;
    }

    /**
     * Add owner boolean.
     *
     * @param owner the owner
     * @return the boolean
     */
    public boolean addOwner(Owner owner) {
        boolean success = false;
        if(validateOwner(owner)) {
            success = owners.add(owner);
        }
        return success;
    }

    private boolean validateOwner(Owner owner){return !owners.contains(owner); }


    public List<Owner> getOwners() {return owners;}


    /**
     * Get the object/instance Owner from its own class.
     *
     * @return the owner
     */
    public Owner getOwner (){
        Owner user1 = null;
        List<Owner> people = getOwners();
        for (Owner user: people){
            if (user.getEmailAddress().equals(CurrentSession.getEmail())){
                user1 = user;
            }
        }
        return user1;
    }

}
