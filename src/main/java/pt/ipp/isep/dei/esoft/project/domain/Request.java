package pt.ipp.isep.dei.esoft.project.domain;

public class Request{
    private Land land;
    private Apartment apartment;
    private House house;
    private TypeBusiness typeBusiness;
    private int price;

    public Request(Land land, TypeBusiness typeBusiness, int price) {
        this.land = land;
        this.typeBusiness = typeBusiness;
        this.price = price;
    }

    public Request(Apartment apartment, TypeBusiness typeBusiness, int price) {
        this.apartment = apartment;
        this.typeBusiness = typeBusiness;
        this.price = price;
    }

    public Request(House house, TypeBusiness typeBusiness, int price) {
        this.house = house;
        this.typeBusiness = typeBusiness;
        this.price = price;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public TypeBusiness getTypeBusiness() {
        return typeBusiness;
    }

    public void setTypeBusiness(TypeBusiness typeBusiness) {
        this.typeBusiness = typeBusiness;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
