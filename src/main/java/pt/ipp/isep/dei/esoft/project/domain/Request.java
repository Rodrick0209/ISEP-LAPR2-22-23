package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;
import java.util.Objects;

/**
 * The type Request.
 */
public class Request {
    private static int requestIdCounter = 0;
    private int requestId;
    private final Property property;
    private final TypeBusiness typeBusiness;
    private final double price;
    private final Owner owner;
    private final Date requestDate;

    private int contractDuration=0;


    /**
     * Gets contract duration.
     *
     * @return the contract duration
     */
    public int getContractDuration() {
        return contractDuration;
    }

    /**
     * Set contract duration.
     *
     * @param contractduration the contractduration
     */
    public void setContractDuration(int contractduration){
        this.contractDuration = contractduration;
    }

    /**
     * Gets request date.
     *
     * @return the request date
     */
    public Date getRequestDate() {
        return requestDate;
    }

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
    public String toString() {  // method to convert into displayable
        return "\nRequest Id: " + requestId +
                "\nProperty: " + property +
                "\nTypeBusiness: " + typeBusiness.toString() +
                "\nPrice: " + price +"$" +
                "\nOwner: " + owner +
                "\nRequest Date: " + requestDate;
    }


}