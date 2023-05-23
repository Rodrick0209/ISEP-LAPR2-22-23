package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.PropertyType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Property type repository.
 */
public class PropertyTypeRepository {
        private static final List<PropertyType> propertyTypeArrayList = new ArrayList<>();

    /**
     * Add property types.
     *
     * @param example1 the example 1
     */
    public void addPropertyTypes(PropertyType example1) {
        propertyTypeArrayList.add(example1);
    }

    public PropertyType getPropertyTypeByName(String propertyTypeName){
        PropertyType propertyType = null;
        for(PropertyType p: propertyTypeArrayList){
            if(p.getName().equalsIgnoreCase(propertyTypeName)){
                propertyType = p;
            }
        }
        return propertyType;
    }

    /**
     * Gets property type list.
     *
     * @return the property type list
     */
    public static List<PropertyType> getPropertyTypeList() {
            //This is a defensive copy, so that the repository cannot be modified from the outside.
            return List.copyOf(propertyTypeArrayList);
        }
    }
