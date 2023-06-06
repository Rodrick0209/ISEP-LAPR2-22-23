package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The type Commission.
 */
public class Commission {

    private String type;
    private double value;

    /**
     * Instantiates a new Commission.
     *
     * @param type  the type
     * @param value the value
     */
    public Commission(String type, double value) {
        this.type = type;
        this.value = value;
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

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\nType:" + type +
                "\nValue: " + value ;
    }
}
