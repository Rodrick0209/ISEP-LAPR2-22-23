package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.domain.TypeBusiness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TypeBusinessRepository implements Serializable {

    private static final List<TypeBusiness> businessTypeArrayList = new ArrayList<>();


    public void addBusinessType(TypeBusiness example1) {
        businessTypeArrayList.add(example1);
    }

    public TypeBusiness getTypeBusinessbyName(String typeBusinessName){
        TypeBusiness typebusiness = null;
        for(TypeBusiness p: businessTypeArrayList){
            if(p.getName().equalsIgnoreCase(typeBusinessName)){
                typebusiness = p;
            }
        }
    return typebusiness;
    }
    public List<TypeBusiness> getTypeBusiness() {
        return List.copyOf(businessTypeArrayList);
    }

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


