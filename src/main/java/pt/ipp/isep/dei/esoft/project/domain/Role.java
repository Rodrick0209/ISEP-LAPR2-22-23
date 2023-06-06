package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Role.
 */
public class Role implements Serializable {
    private final String name;

    /**
     * Instantiates a new Role.
     *
     * @param name the name
     */
    public Role(String name){ this.name = name; }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Role)){
            return false;
        }
        Role that = (Role) o;
        return name.equalsIgnoreCase(that.name);
    }

    /**
     * Get name string.
     *
     * @return the string
     */
    public String getName(){ return name; }

    public int hashCode(){ return Objects.hashCode(name); }

    public Role clone() { return new Role(this.name); }

    public String toString() {
        return String.format("%s", this.name);
    }
}
