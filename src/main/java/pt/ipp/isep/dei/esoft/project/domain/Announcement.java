package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Announcement {
    private final Property property;
    private final String description;
    private final double commission;
    private final Employee agent;

    public Announcement(Property property, String description, double commission, Employee agent){
        this.property = property;
        this.description = description;
        this.commission = commission;
        this.agent = agent;
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Announcement)){
            return false;
        }
        Announcement that = (Announcement) o;
        return description.equalsIgnoreCase(that.description);
    }

    public int hashCode(){ return Objects.hash(description);}

    public Announcement clone() { return new Announcement(this.property, this.description, this.commission, this.agent);}
}
