package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
import java.util.List;

public class Property {

    private double area;
    private Location location;

    private double distance;

    private List<String> photos;

    public Property(double area,Location  location , double distance,List<String> photos){
       if(area<=0){
           throw new IllegalArgumentException("Area must be greater than 0.");
       }
       if(location==null){
           throw new IllegalArgumentException("Adress must not be null.");
       }
        if(distance<=0){
            throw new IllegalArgumentException("Distance from the city center must be greater than 0.");
        }
        if (photos == null){
            throw new IllegalArgumentException("Is necesssary more than 0 photos");
        }

    }
    public Property(int area, int distance) {
        this.area = area;
        this.distance = distance;
    }

    public Property(String propertyLocation) {
    }

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return area == property.area && distance == property.distance && Objects.equals(location, property.location) && Objects.equals(photos, property.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, location, distance, photos);
    }

    public Property(int area, Location location, int  distance) {
        this.area = area;
        this.location = location;
        this.distance = distance;
    }

    public Property clone() {return new Property(this.location);}

    public Location getLocation() {return location;}
}
