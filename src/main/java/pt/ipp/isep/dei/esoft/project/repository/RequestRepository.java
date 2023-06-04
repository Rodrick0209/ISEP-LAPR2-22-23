package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Request repository.
 */
public class RequestRepository {

    private final List<Request> requests = new ArrayList<>();

    /**
     * Gets request by id.
     *
     * @param requestId the request id
     * @return the request by id
     */
    public Request getRequestById(int requestId) {
        Request request = null;
        for (Request r : requests) {
            if (r.getRequestId() == requestId) {
                request = r;
            }
        }
        return request;
    }

    /**
     * Get request by property request.
     *
     * @param property the property
     * @return the request
     */
    public  Request getRequestByProperty(Property property){
        Request request = null;
        for (Request r : requests) {
            if (r.getProperty().equals(property)) {
                request = r;
            }
        }
        return request;
    }

    /**
     * Create sale request optional.
     *
     * @param property       the property
     * @param typeOfBusiness the type of business
     * @param price          the price
     * @param owner          the owner
     * @return the optional
     */
    public Optional<Request> createSaleRequest(Property property, TypeBusiness typeOfBusiness, int price, Owner owner) {
        Optional<Request> optionalValue = Optional.empty();

        Sale sale = new Sale(property, typeOfBusiness, price, owner);

        if (addRequest(sale)){
            optionalValue = Optional.of(sale);
        }
        return optionalValue;
    }

    /**
     * Create rent request optional.
     *
     * @param property         the property
     * @param typeBusiness     the type business
     * @param price            the price
     * @param contractDuration the contract duration
     * @param owner            the owner
     * @return the optional
     */
    public Optional<Request> createRentRequest(Property property, TypeBusiness typeBusiness, int price, int contractDuration, Owner owner){
        Optional<Request> optionalValue = Optional.empty();

        Rent rent = new Rent(property, typeBusiness, price, owner, contractDuration);

        if(addRequest(rent)){
            optionalValue = Optional.of(rent);
        }
        return optionalValue;
    }


    /**
     * Add request boolean.
     *
     * @param request the request
     * @return the boolean
     */
    public boolean addRequest(Request request) {
        boolean success = false;
        if (validateRequest(request)) {
            success = requests.add(request);
        }
        return success;
    }

    /**
     * Add optional.
     *
     * @param request the request
     * @return the optional
     */
    public Optional<Request> add(Request request){
        Optional<Request> newRequest = Optional.empty();
        boolean operationSuccess = false;

        if(validateRequest(request)){
            newRequest = Optional.of(request.clone());
            operationSuccess = requests.add(newRequest.get());
        }

        if(!operationSuccess){
            newRequest = Optional.empty();
        }
        return newRequest;
    }

    /**
     * Get requests list.
     *
     * @return the list
     */
    public List<Request> getRequests(){ return List.copyOf(requests); }
    private boolean validateRequest(Request request){ return !requests.contains(request);


    }
}
