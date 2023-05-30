package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The type Rent.
 */
public class Rent extends Request{

    /**
     * Gets contract duration.
     *
     * @return the contract duration
     */
    public int getContractDuration() {
        return contractDuration;
    }

    private final int contractDuration;

    /**
     * Instantiates a new Rent.
     *
     * @param property         the property
     * @param typeBusiness     the type business
     * @param price            the price
     * @param owner            the owner
     * @param contractDuration the contract duration
     */
    public Rent(Property property, TypeBusiness typeBusiness, int price, Owner owner, int contractDuration) {
        super(property, typeBusiness, price, owner);
        this.contractDuration = contractDuration;
    }
}
