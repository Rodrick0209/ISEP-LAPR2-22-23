package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.PropertyType;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.domain.TypeBusiness;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyTypeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TypeBusinessRepository;

import java.util.List;

public class CreateRequestController {

    private TypeBusinessRepository typeBusinessRepository;

    private PropertyRepository propertyRepository;

    private PropertyTypeRepository propertyTypeRepository;
    public CreateRequestController(){
        getTypeBusinessRepository();
    }




    public boolean createRequest(int requestType, String propertyType, String area, String location, double distance, int photos, int n_bedrooms, int n_bathrooms, int n_parkingSpaces, String avaiableEquip, boolean price, boolean rentprice, String contractduration){
        return createRequest(requestType, propertyType,area, location,distance,photos,n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquip, price, rentprice,contractduration);
    }

    public void addRequest() {

    }

    public List<TypeBusiness> getTypeBusiness() {
        return getTypeBusinessRepository().getTypeBusiness();
    }

    public TypeBusinessRepository getTypeBusinessRepository() {
        if(typeBusinessRepository == null){
            Repositories repositories = Repositories.getInstance();
            typeBusinessRepository = repositories.getTypeBusinessRepository();
        }
        return typeBusinessRepository;
    }

    public List<PropertyType> getPropertyTypes() {
        return  getPropertyTypeRepository().getPropertyTypes();
    }

    private PropertyTypeRepository getPropertyTypeRepository() {
        if(propertyTypeRepository == null){
            Repositories repositories = Repositories.getInstance();
            propertyTypeRepository = repositories.getPropertyTypeRepository();
        }
        return  propertyTypeRepository;
    }
}
