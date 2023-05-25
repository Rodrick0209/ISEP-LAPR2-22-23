package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 * The type Announcement request.
 */
public class AnnouncementRequest {
    private Land land;
    private double price;
    private String type;

    public void setLand(Land land) {
        this.land = land;
    }

    public Land getLand() {
        return land;
    }

    /**
     * Instantiates a new Announcement request.
     *
     * @param land the property
     * @param price    the price
     * @param type     the type
     */
    public AnnouncementRequest(Land land, double price, String type) {
        this.land = land;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "AnnoucementRequest{" +
                "property=" + land +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     * Gets property.
     *
     * @return the property
     */
    public Land getProperty() {
        return land;
    }

    /**
     * Sets property.
     *
     * @param land the property
     */
    public void setProperty(Land land) {
        this.land = land;
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
        return Double.compare(that.price, price) == 0 && land.equals(that.land) && type.equals(that.type);
    }


    @Override
    public int hashCode() {
        return Objects.hash(land, price, type);
    }
}
