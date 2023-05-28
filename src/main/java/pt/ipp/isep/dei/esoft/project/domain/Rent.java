package pt.ipp.isep.dei.esoft.project.domain;

public class Rent extends Request{
    private int contractDuration;

    public Rent(Property property, TypeBusiness typeBusiness, int price, Owner owner, int contractDuration) {
        super(property, typeBusiness, price, owner);
        this.contractDuration = contractDuration;
    }
}
