package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;
import java.util.Objects;

public class Request {
    private static int requestIdCounter = 1;
    private int requestId;
    private final Property property;
    private final TypeBusiness typeBusiness;
    private final double price;
    private final Owner owner;
    private final Date requestDate;


    public Date getRequestDate() {
        return requestDate;
    }

    public Owner getOwner() {
        return owner;
    }


    public int getRequestId() {
        return requestId;
    }

    public Request(Property property, TypeBusiness typeBusiness, double price, Owner owner) {
        this.property = property;
        this.typeBusiness = typeBusiness;
        this.price = price;
        this.owner = owner;
        //this.requestId = requestIdCounter++;
        this.requestDate = new Date();
    }

    public Property getProperty() {
        return property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return property.equals(request.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property);
    }

    public Request clone(){
        return new Request(property, typeBusiness, price, owner);
    }


    public double getPrice() {
        return price;
    }

    public TypeBusiness getTypeBusiness() {
        return typeBusiness;
    }

    @Override
    public String toString() {  // method to convert into displayable
        return "Request{" +
                "\nrequestId=" + requestId +
                "\n, property=" + property.toString() +
                ", typeBusiness=" + typeBusiness.toString() +
                ", price=" + price +
                ", owner=" + owner.toString() +
                ", requestDate=" + requestDate +
                '}';
    }


}