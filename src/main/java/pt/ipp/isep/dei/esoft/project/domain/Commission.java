package pt.ipp.isep.dei.esoft.project.domain;

public class Commission {

    private String type; // type of commision
    private double value;

    public Commission(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


}
