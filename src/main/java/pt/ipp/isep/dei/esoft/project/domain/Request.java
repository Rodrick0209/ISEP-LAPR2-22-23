package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Request {
    private final Property property;
    private final TypeBusiness typeBusiness;
    private final int price;

    private Owner owner;

    public Request(Property property, TypeBusiness typeBusiness, int price, Owner owner) {
        this.property = property;
        this.typeBusiness = typeBusiness;
        this.price = price;
        this.owner  = owner;
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

    public int getPrice() {
        return price;
    }
}