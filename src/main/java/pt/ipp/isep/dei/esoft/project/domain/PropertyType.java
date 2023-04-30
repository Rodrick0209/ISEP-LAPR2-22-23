package pt.ipp.isep.dei.esoft.project.domain;

public class PropertyType {
        private final int idType;
        private final String propertyType;
        private static int numberOfTypes=1;
        public PropertyType(String name){
            this.idType=numberOfTypes;
            this.propertyType=name;
            numberOfTypes++;
        }

        public int getIdType() {
            return idType;
        }

        public String getName() {
            return propertyType;
        }
    }

