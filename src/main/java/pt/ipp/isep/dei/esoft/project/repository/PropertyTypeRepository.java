package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.PropertyType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Property type repository.
 */
public class PropertyTypeRepository implements Serializable {
        private static final List<PropertyType> propertyTypeArrayList = new ArrayList<>();

    /**
     * Add optional.
     *
     * @param propertyType the property type
     * @return the optional
     */
    public Optional<PropertyType> add(PropertyType propertyType){

        Optional<PropertyType> newPropertyType = Optional.empty();
        boolean operationSuccess = false;

        if(validatePropertyType(propertyType)){
            newPropertyType = Optional.of(propertyType.clone());
            operationSuccess = propertyTypeArrayList.add(newPropertyType.get());
        }

        if (!operationSuccess) {
            newPropertyType = Optional.empty();
        }
        return newPropertyType;
    }

    /**
     * Get property type by name property type.
     *
     * @param propertyTypeName the property type name
     * @return the property type
     */
    public PropertyType getPropertyTypeByName(String propertyTypeName){
        PropertyType propertyType = null;
        for(PropertyType p: propertyTypeArrayList){
            if(p.getName().equalsIgnoreCase(propertyTypeName)){
                propertyType = p;
            }
        }
        return propertyType;
    }

    private boolean validatePropertyType(PropertyType propertyType){
        return !propertyTypeArrayList.contains(propertyType);
    }

    /**
     * Gets property type list.
     *
     * @return the property type list
     */
    public List<PropertyType> getPropertyTypes() {
            //This is a defensive copy, so that the repository cannot be modified from the outside.
            return List.copyOf(propertyTypeArrayList);
        }

}
