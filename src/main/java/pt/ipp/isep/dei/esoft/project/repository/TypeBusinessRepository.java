package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.domain.TypeBusiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Type business repository.
 */
public class TypeBusinessRepository {

    private static final List<TypeBusiness> businessTypeArrayList = new ArrayList<>();


    /**
     * Add business type.
     *
     * @param example1 the example 1
     */
    public void addBusinessType(TypeBusiness example1) {
        businessTypeArrayList.add(example1);
    }

    /**
     * Get type businessby name type business.
     *
     * @param typeBusinessName the type business name
     * @return the type business
     */
    public TypeBusiness getTypeBusinessbyName(String typeBusinessName){
        TypeBusiness typebusiness = null;
        for(TypeBusiness p: businessTypeArrayList){
            if(p.getName().equalsIgnoreCase(typeBusinessName)){
                typebusiness = p;
            }
        }
    return typebusiness;
    }

    /**
     * Gets type business.
     *
     * @return the type business
     */
    public List<TypeBusiness> getTypeBusiness() {
        return List.copyOf(businessTypeArrayList);
    }

    /**
     * Add optional.
     *
     * @param typebusiness the typebusiness
     * @return the optional
     */
    public Optional<TypeBusiness> add(TypeBusiness typebusiness){
        Optional<TypeBusiness> newTypeBusiness = Optional.empty();
        boolean operationSucess = false;

        if(validateTypeBusiness(typebusiness)){
            newTypeBusiness = Optional.of(typebusiness.clone());
            operationSucess = businessTypeArrayList.add(newTypeBusiness.get() );
        }

        if (!operationSucess){
            newTypeBusiness = Optional.empty();
        }
        return newTypeBusiness;
    }

    private boolean validateTypeBusiness(TypeBusiness typebusiness) {
        return (!businessTypeArrayList.contains(typebusiness));
    }

}


