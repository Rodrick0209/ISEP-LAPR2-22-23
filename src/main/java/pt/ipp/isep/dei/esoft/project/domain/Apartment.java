package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.Objects;

public class Apartment extends Property {

    private int n_bedrooms;
    private int n_bathrooms;
    private int n_parkingSpaces;
    private String avaiableEquip;

    public Apartment(double area, Location location, double distance, List<String> photos,int n_bedrooms,int n_bathrooms, int n_parkingSpaces,String avaiableEquip) {
        super(area, location, distance, photos);
        this.n_bedrooms = n_bedrooms;
        this.n_bathrooms = n_bathrooms;
        this.n_parkingSpaces = n_parkingSpaces;
        this.avaiableEquip = avaiableEquip;
    }

    public int getN_bedrooms() {
        return n_bedrooms;
    }

    public void setN_bedrooms(int n_bedrooms) {
        this.n_bedrooms = n_bedrooms;
    }

    public int getN_bathrooms() {
        return n_bathrooms;
    }

    public void setN_bathrooms(int n_bathrooms) {
        this.n_bathrooms = n_bathrooms;
    }

    public int getN_parkingSpaces() {
        return n_parkingSpaces;
    }

    public void setN_parkingSpaces(int n_parkingSpaces) {
        this.n_parkingSpaces = n_parkingSpaces;
    }

    public String getAvaiableEquip() {
        return avaiableEquip;
    }

    public void setAvaiableEquip(String avaiableEquip) {
        this.avaiableEquip = avaiableEquip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartment apartment = (Apartment) o;
        return n_bedrooms == apartment.n_bedrooms && n_bathrooms == apartment.n_bathrooms && n_parkingSpaces == apartment.n_parkingSpaces && avaiableEquip.equals(apartment.avaiableEquip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquip);
    }
}
