package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 * The type Announcement request.
 */
public class AnnouncementRequest {
    private Property property;
    private double price;
    private String type;

    public void setProperty(Property property) {
        this.property= property;
    }

    public Property getProperty() {
        return property;
    }

    /**
     * Instantiates a new Announcement request.
     *
     * @param property the property
     * @param price    the price
     * @param type     the type
     */
    public AnnouncementRequest( Property property, double price, String type) {
        this.property = property;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "AnnoucementRequest{" +
                "property=" + property +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }



    /**
     * Sets property.
     *
     * @param land the property
     */
    public void setProperty(Land land) {
        this.property = land;
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
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnouncementRequest that = (AnnouncementRequest) o;
        return Double.compare(that.price, price) == 0 && property.equals(that.price) && type.equals(that.type);
    }


    @Override
    public int hashCode() {
        return Objects.hash(property, price, type);
    }
}
