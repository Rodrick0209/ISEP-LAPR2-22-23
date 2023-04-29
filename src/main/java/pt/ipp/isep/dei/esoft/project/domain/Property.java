package pt.ipp.isep.dei.esoft.project.domain;

public class Property {

    private int area;
    private Location location;

    private int distance;
    public Property(int area, int distance) {
        this.area = area;
        this.distance = distance;
    }
      public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Property(int area, Location location, int  distance) {
        this.area = area;
        this.location = location;
        this.distance = distance;



    }
}
