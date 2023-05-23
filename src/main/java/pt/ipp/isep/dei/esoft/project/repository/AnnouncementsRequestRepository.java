package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.AnnouncementRequest;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Annoucements request repository.
 */
public class AnnouncementsRequestRepository {

    private List<Announcement> announcementsRequest = new ArrayList<>();

    /**
     * Add announcement request announcement request.
     *
     * @param requestType       the request type
     * @param propertyType      the property type
     * @param area              the area
     * @param distance          the distance
     * @param n_bedrooms        the n bedrooms
     * @param n_bathrooms       the n bathrooms
     * @param n_parkingSpaces   the n parking spaces
     * @param avaiableEquipment the avaiable equipment
     * @param existBasement     the exist basement
     * @param inhabitableLoft   the inhabitable loft
     * @param sunExposur        the sun exposur
     * @param street            the street
     * @param city              the city
     * @param district          the district
     * @param state             the state
     * @param zipCode           the zip code
     * @param contractDuraction the contract duraction
     * @param price             the price
     * @param rentprice         the rentprice
     * @param photos            the photos
     * @return the announcement request
     */
    public AnnouncementRequest addAnnouncementRequest (String requestType,String propertyType,int area,int distance,int n_bedrooms,int n_bathrooms,int n_parkingSpaces,String avaiableEquipment,boolean existBasement,boolean inhabitableLoft,String sunExposur,String street,String city,String district,String state,int zipCode,int contractDuraction,float price,float rentprice,List<String> photos ){

    return addAnnouncementRequest(requestType, propertyType, area, distance, n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquipment, existBasement, inhabitableLoft, sunExposur, street,city,district, state,zipCode,contractDuraction,price, rentprice,photos);
    }


}
