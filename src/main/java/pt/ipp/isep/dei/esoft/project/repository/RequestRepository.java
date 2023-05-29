package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestRepository {

    private final List<Request> requests = new ArrayList<>();

    public Request getRequestById(int requestId) {
        Request request = null;
        for (Request r : requests) {
            if (r.getRequestId() == requestId) {
                request = r;
            }
        }
        return request;
    }

    public  Request getRequestByProperty(Property property){
        Request request = null;
        for (Request r : requests) {
            if (r.getProperty().equals(property)) {
                request = r;
            }
        }
        return request;
    }

    public Optional<Request> createSaleRequest(Property property, TypeBusiness typeOfBusiness, int price, Owner owner) {
        Optional<Request> optionalValue = Optional.empty();

        Sale sale = new Sale(property, typeOfBusiness, price, owner);

        if (addRequest(sale)){
            optionalValue = Optional.of(sale);
        }
        return optionalValue;
    }

    public Optional<Request> createRentRequest(Property property, TypeBusiness typeBusiness, int price, int contractDuration, Owner owner){
        Optional<Request> optionalValue = Optional.empty();

        Rent rent = new Rent(property, typeBusiness, price, owner, contractDuration);

        if(addRequest(rent)){
            optionalValue = Optional.of(rent);
        }
        return optionalValue;
    }

    public boolean addRequest(Request request) {
        boolean success = false;
        if (validateRequest(request)) {
            success = requests.add(request);
        }
        return success;
    }

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
    public List<Request> getRequests(){ return List.copyOf(requests); }
    private boolean validateRequest(Request request){ return !requests.contains(request);

    }
}
