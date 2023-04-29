package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Location {
    private String street;
    private String city;
    private String district;
    private String state;
    private int zipCode;

    public Location(String street, String city, String district, String state, int zipCode){
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
        this.zipCode = zipCode;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location adress = (Location) o;
        return zipCode == adress.zipCode && street.equals(adress.street) && city.equals(adress.city) && district.equals(adress.district) && state.equals(adress.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, district, state, zipCode);
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

}
