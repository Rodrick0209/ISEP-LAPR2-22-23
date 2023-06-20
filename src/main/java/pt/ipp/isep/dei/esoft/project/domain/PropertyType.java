package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Property type.
 */
public class PropertyType implements Serializable {
    private static final List<PropertyType> VALUES = new ArrayList<>();
    private final String propertyType;

    /**
     * Instantiates a new Property type.
     *
     * @param name the name
     */
    public PropertyType(String name) {
        this.propertyType = name;
    }


    public String getTypeName() {
        return propertyType;
    }

    public static PropertyType valueOf(String name) {
        for (PropertyType type : PropertyType.values()) {
            if (type.getTypeName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No constant with propertyType " + name + " found in PropertyType");
    }

    public static PropertyType[] values() {
        // Convert the VALUES list to an array
        return VALUES.toArray(new PropertyType[0]);
    }





    /**
     * Gets id type.
     *
     * @return the id type
     */

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
            return propertyType;
        }

        public PropertyType clone(){
        return new PropertyType(propertyType);
        }

    @Override
    public String toString() {
        return String.format("%s", propertyType);
    }
}


