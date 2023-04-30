package pt.ipp.isep.dei.esoft.project.application.controller;


public class CreateRequestController {

    public CreateRequestController(){
    }


    public boolean createRequest(int requestType, String propertyType, String area, String location, double distance, int photos, int n_bedrooms, int n_bathrooms, int n_parkingSpaces, String avaiableEquip, boolean price, boolean rentprice, String contractduration){
        return createRequest(requestType, propertyType,area, location,distance,photos,n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquip, price, rentprice,contractduration);
    }

    public void addRequest() {

    }
}
