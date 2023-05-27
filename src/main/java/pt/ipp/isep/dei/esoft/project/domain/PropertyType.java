package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The type Property type.
 */
public class PropertyType {
        private final int idType;
        private final String propertyType;
        private static int numberOfTypes=1;

    /**
     * Instantiates a new Property type.
     *
     * @param name the name
     */
    public PropertyType(String name){
            this.idType=numberOfTypes;
            this.propertyType=name;
            numberOfTypes++;
        }

    /**
     * Gets id type.
     *
     * @return the id type
     */
    public int getIdType() {
            return idType;
        }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
            return propertyType;
        }

    @Override
    public String toString() {
        return propertyType ;
    }
}

