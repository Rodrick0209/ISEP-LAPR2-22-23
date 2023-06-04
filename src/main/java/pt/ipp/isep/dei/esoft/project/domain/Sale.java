package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The type Sale.
 */
public class Sale extends Request{

    /**
     * Instantiates a new Sale.
     *
     * @param property     the property
     * @param typeBusiness the type business
     * @param price        the price
     * @param owner        the owner
     */
    public Sale(Property property, TypeBusiness typeBusiness, int price, Owner owner) {
        super(property, typeBusiness, price, owner);
    }


}
