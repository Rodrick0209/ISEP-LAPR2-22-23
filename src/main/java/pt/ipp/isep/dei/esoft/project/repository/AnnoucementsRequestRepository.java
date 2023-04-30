package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.AnnouncementRequest;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;

import java.util.List;

public class AnnoucementsRequestRepository {

    private List<Announcement> announcementsRequest;

    public AnnouncementRequest addAnnouncementRequest (String requestType,String propertyType,int area,int distance,int n_bedrooms,int n_bathrooms,int n_parkingSpaces,String avaiableEquipment,boolean existBasement,boolean inhabitableLoft,String sunExposur,String street,String city,String district,String state,int zipCode,int contractDuraction,float price,float rentprice,List<String> photos ){

    return addAnnouncementRequest(requestType, propertyType, area, distance, n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquipment, existBasement, inhabitableLoft, sunExposur, street,city,district, state,zipCode,contractDuraction,price, rentprice,photos);
    }


}
