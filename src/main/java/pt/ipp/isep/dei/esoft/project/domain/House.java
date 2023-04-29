package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.Objects;

public class House extends Apartment {

    private boolean existBasement;
    private boolean existinhabitableLoft;
    private String sunExposure;

    public House(double area, Location location, double distance, List<String> photos,int n_bedrooms,int n_bathrooms, int n_parkingSpaces,String avaiableEquip){
        super( area,location,distance,  photos,n_bedrooms,n_bathrooms,  n_parkingSpaces,avaiableEquip);
        this.existBasement = existBasement;
        this.existinhabitableLoft = existinhabitableLoft;
        this.sunExposure = sunExposure;
    }

    public boolean isExistBasement() {
        return existBasement;
    }

    public void setExistBasement(boolean existBasement) {
        this.existBasement = existBasement;
    }

    public boolean isExistinhabitableLoft() {
        return existinhabitableLoft;
    }

    public void setExistinhabitableLoft(boolean existinhabitableLoft) {
        this.existinhabitableLoft = existinhabitableLoft;
    }

    public String getSunExposure() {
        return sunExposure;
    }

    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        House house = (House) o;
        return existBasement == house.existBasement && existinhabitableLoft == house.existinhabitableLoft && sunExposure.equals(house.sunExposure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), existBasement, existinhabitableLoft, sunExposure);
    }
}
