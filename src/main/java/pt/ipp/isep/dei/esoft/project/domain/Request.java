package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The type Request.
 */
public class Request implements Serializable {
    private static int requestIdCounter = 0;
    private final int requestId;
    private final Property property;
    private final TypeBusiness typeBusiness;
    private final double price;
    private final Owner owner;

    private final Date requestDate;


//    public Date getRequestDate() {
//        return requestDate;
//    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }


    /**
     * Gets request id.
     *
     * @return the request id
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * Instantiates a new Request.
     *
     * @param property     the property
     * @param typeBusiness the type business
     * @param price        the price
     * @param owner        the owner
     */
    public Request(Property property, TypeBusiness typeBusiness, double price, Owner owner) {
        this.property = property;
        this.typeBusiness = typeBusiness;
        this.price = price;
        this.owner = owner;
        this.requestId = requestIdCounter++;
        this.requestDate = new Date();
    }



    /**
     * Gets property.
     *
     * @return the property
     */
    public Property getProperty() {
        return property;
    }

    public Request clone(){
        return new Request(property, typeBusiness, price, owner);
    }


    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets type business.
     *
     * @return the type business
     */
    public TypeBusiness getTypeBusiness() {
        return typeBusiness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return requestId == request.requestId && Double.compare(request.price, price) == 0 && Objects.equals(property, request.property) && Objects.equals(typeBusiness, request.typeBusiness) && Objects.equals(owner, request.owner) && Objects.equals(requestDate, request.requestDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, property, typeBusiness, price, owner, requestDate);
    }

    @Override
    public String toString() {  // method to convert into displayable
        return  "Property: "  + property +
                "\nType of Business: " + typeBusiness +
                "\nPrice: " + price +"$" +
                "\nOwner: " + owner +
                "\nRequest Date: " + requestDate;
    }


}