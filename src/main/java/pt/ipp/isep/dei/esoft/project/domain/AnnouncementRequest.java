package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class AnnouncementRequest {

    private Property property;
    private double price;
    private String type;

    public AnnouncementRequest(Property property, double price, String type) {
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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnouncementRequest that = (AnnouncementRequest) o;
        return Double.compare(that.price, price) == 0 && property.equals(that.property) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, price, type);
    }
}
