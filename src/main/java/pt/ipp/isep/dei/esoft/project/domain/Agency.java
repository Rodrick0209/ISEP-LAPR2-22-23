package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Agency {
    private final String name;

    public Agency(String name){
        this.name = name;
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(!(o instanceof Agency)){
            return false;
        }
        Agency that = (Agency) o;
        return name.equalsIgnoreCase(that.name);
    }

    public String getName(){return name;}

    public int hashCode() { return Objects.hash(name); }

    public Agency clone(){ return new Agency(this.name);}
}
