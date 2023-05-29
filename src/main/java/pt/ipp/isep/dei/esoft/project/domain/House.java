package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

/**
 * The type House.
 */
public class House extends Property {

    private int n_bedrooms;
    private int n_bathrooms;
    private int n_parkingSpaces;
    private String avaiableEquip;

    private boolean centralHeating ;
    private boolean airConditioning ;
    private boolean existBasement;
    private boolean existinhabitableLoft;
    private String sunExposure;


    public House(PropertyType typeName, double area, Location location, double distance, int n_bedrooms, int n_bathrooms, int n_parkingSpaces, boolean centralHeating, boolean airConditioning, boolean existBasement, boolean existinhabitableLoft, String sunExposure) {
        super(typeName, area, location, distance);
        this.n_bedrooms = n_bedrooms;
        this.n_bathrooms = n_bathrooms;
        this.n_parkingSpaces = n_parkingSpaces;
        this.centralHeating = centralHeating;
        this.airConditioning = airConditioning;
        this.existBasement = existBasement;
        this.existinhabitableLoft = existinhabitableLoft;
        this.sunExposure = sunExposure;
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

    public boolean isCentralHeating() {
        return centralHeating;
    }

    public void setCentralHeating(boolean centralHeating) {
        this.centralHeating = centralHeating;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
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
}
