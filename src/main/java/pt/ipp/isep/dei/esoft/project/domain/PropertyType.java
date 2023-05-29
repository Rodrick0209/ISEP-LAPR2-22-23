package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The type Property type.
 */
public class PropertyType {
        private final String propertyType;

    /**
     * Instantiates a new Property type.
     *
     * @param name the name
     */
    public PropertyType(String name){
            this.propertyType=name;
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
        return String.format("%s%n", propertyType);
    }
}


