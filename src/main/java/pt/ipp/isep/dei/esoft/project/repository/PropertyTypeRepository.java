package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.PropertyType;

import java.util.ArrayList;
import java.util.List;

public class PropertyTypeRepository {
        private static final List<PropertyType> propertyTypeArrayList = new ArrayList<>();

        public void addPropertyTypes(PropertyType example1) {
            propertyTypeArrayList.add(example1);
        }

        public static List<PropertyType> getPropertyTypeList() {
            //This is a defensive copy, so that the repository cannot be modified from the outside.
            return List.copyOf(propertyTypeArrayList);
        }
    }
