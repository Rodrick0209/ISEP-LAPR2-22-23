package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The type House.
 */
public class House extends Property {

    private  Owner owner ;
    private double area;
    private Location location;

    private double distance;
    private PropertyType typeName;
    private int n_bedrooms;
    private int n_bathrooms;
    private int n_parkingSpaces;
    private String avaiableEquip;

    private boolean centralHeating ;
    private boolean airConditioning ;
    private boolean existBasement;
    private boolean existinhabitableLoft;
    private String sunExposure;


    /**
     * Instantiates a new House.
     *
     * @param typeName             the type name
     * @param area                 the area
     * @param location             the location
     * @param distance             the distance
     * @param n_bedrooms           the n bedrooms
     * @param n_bathrooms          the n bathrooms
     * @param n_parkingSpaces      the n parking spaces
     * @param centralHeating       the central heating
     * @param airConditioning      the air conditioning
     * @param existBasement        the exist basement
     * @param existinhabitableLoft the existinhabitable loft
     * @param sunExposure          the sun exposure
     * @param owner                the owner
     */
    public House(PropertyType typeName, double area, Location location, double distance, int n_bedrooms, int n_bathrooms, int n_parkingSpaces, boolean centralHeating, boolean airConditioning, boolean existBasement,boolean existinhabitableLoft, String sunExposure , Owner owner) {
        super(typeName, area, location, distance, owner);
        this.typeName = typeName;
        this.area = area;
        this.location = location;
        this.distance = distance;
        this.n_bedrooms = n_bedrooms;
        this.n_bathrooms = n_bathrooms;
        this.n_parkingSpaces = n_parkingSpaces;
        this.centralHeating = centralHeating;
        this.airConditioning = airConditioning;
        this.existBasement = existBasement;
        this.existinhabitableLoft = existinhabitableLoft;
        this.sunExposure = sunExposure;
    }


    /**
     * Gets n bedrooms.
     *
     * @return the n bedrooms
     */
    public int getN_bedrooms() {
        return n_bedrooms;
    }


    /**
     * Sets n bedrooms.
     *
     * @param n_bedrooms the n bedrooms
     */
    public void setN_bedrooms(int n_bedrooms) {
        this.n_bedrooms = n_bedrooms;
    }

    /**
     * Gets n bathrooms.
     *
     * @return the n bathrooms
     */
    public int getN_bathrooms() {
        return n_bathrooms;
    }

    /**
     * Sets n bathrooms.
     *
     * @param n_bathrooms the n bathrooms
     */
    public void setN_bathrooms(int n_bathrooms) {
        this.n_bathrooms = n_bathrooms;
    }

    /**
     * Gets n parking spaces.
     *
     * @return the n parking spaces
     */
    public int getN_parkingSpaces() {
        return n_parkingSpaces;
    }

    /**
     * Sets n parking spaces.
     *
     * @param n_parkingSpaces the n parking spaces
     */
    public void setN_parkingSpaces(int n_parkingSpaces) {
        this.n_parkingSpaces = n_parkingSpaces;
    }

    /**
     * Gets avaiable equip.
     *
     * @return the avaiable equip
     */
    public String getAvaiableEquip() {
        return avaiableEquip;
    }

    /**
     * Sets avaiable equip.
     *
     * @param avaiableEquip the avaiable equip
     */
    public void setAvaiableEquip(String avaiableEquip) {
        this.avaiableEquip = avaiableEquip;
    }

    /**
     * Is central heating boolean.
     *
     * @return the boolean
     */
    public boolean isCentralHeating() {
        return centralHeating;
    }

    /**
     * Sets central heating.
     *
     * @param centralHeating the central heating
     */
    public void setCentralHeating(boolean centralHeating) {
        this.centralHeating = centralHeating;
    }

    /**
     * Is air conditioning boolean.
     *
     * @return the boolean
     */
    public boolean isAirConditioning() {
        return airConditioning;
    }

    /**
     * Sets air conditioning.
     *
     * @param airConditioning the air conditioning
     */
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

    @Override
    public String toString() {
        return   "\nType: " + typeName +
                 "Area: " + area + "m2"+
                 "\nLocation: " + location +
                 "\nDistance of city centre: " + distance + "m" +
                 "\nNumber of bedrooms: " + n_bedrooms +
                 "\nNumber of bathrooms: " + n_bathrooms +
                 "\nNumber of parkingSpaces: " + n_parkingSpaces +
                 "\nExistence of central Heating: " + centralHeating +
                 "\nExistence of air Conditioning: " + airConditioning +
                 "\nExistence of basement: " + existBasement +
                 "\nExistince of inhabitableLoft: " + existinhabitableLoft +
                 "\nSun exposure: " + sunExposure ;
    }
}
