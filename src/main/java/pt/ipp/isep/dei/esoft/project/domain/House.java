package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.Objects;

/**
 * The type House.
 */
public class House extends Property{

    private boolean existBasement;
    private boolean existinhabitableLoft;
    private String sunExposure;


    public House(double area, double distance, List<String> photos, boolean existBasement, boolean existinhabitableLoft, String sunExposure) {
        super(area, distance, photos);
        this.existBasement = existBasement;
        this.existinhabitableLoft = existinhabitableLoft;
        this.sunExposure = sunExposure;
    }

    public House(int area, int distance, boolean existBasement, boolean existinhabitableLoft, String sunExposure) {
        super(area, distance);
        this.existBasement = existBasement;
        this.existinhabitableLoft = existinhabitableLoft;
        this.sunExposure = sunExposure;
    }

    public House(String location, boolean existBasement, boolean existinhabitableLoft, String sunExposure) {
        super(location);
        this.existBasement = existBasement;
        this.existinhabitableLoft = existinhabitableLoft;
        this.sunExposure = sunExposure;
    }

    public House(String type, double area, String location, double distance, List<String> photos, Owner owner, boolean existBasement, boolean existinhabitableLoft, String sunExposure) {
        super(type, area, location, distance, photos, owner);
        this.existBasement = existBasement;
        this.existinhabitableLoft = existinhabitableLoft;
        this.sunExposure = sunExposure;
    }

    public House(String type, double area, String location, double distance, Owner owner, boolean existBasement, boolean existinhabitableLoft, String sunExposure) {
        super(type, area, location, distance, owner);
        this.existBasement = existBasement;
        this.existinhabitableLoft = existinhabitableLoft;
        this.sunExposure = sunExposure;
    }

    /**
     * Is exist basement boolean.
     *
     * @return the boolean
     */
    public boolean isExistBasement() {
        return existBasement;
    }

    /**
     * Sets exist basement.
     *
     * @param existBasement the exist basement
     */
    public void setExistBasement(boolean existBasement) {
        this.existBasement = existBasement;
    }

    /**
     * Is existinhabitable loft boolean.
     *
     * @return the boolean
     */
    public boolean isExistinhabitableLoft() {
        return existinhabitableLoft;
    }

    /**
     * Sets existinhabitable loft.
     *
     * @param existinhabitableLoft the existinhabitable loft
     */
    public void setExistinhabitableLoft(boolean existinhabitableLoft) {
        this.existinhabitableLoft = existinhabitableLoft;
    }

    /**
     * Gets sun exposure.
     *
     * @return the sun exposure
     */
    public String getSunExposure() {
        return sunExposure;
    }

    /**
     * Sets sun exposure.
     *
     * @param sunExposure the sun exposure
     */
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
