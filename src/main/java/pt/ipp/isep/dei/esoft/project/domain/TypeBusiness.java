package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class TypeBusiness {
    private final String type;

    public TypeBusiness(String type) {
        this.type= type;

    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeBusiness that = (TypeBusiness) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public String getName() {
        return type;
    }

    public TypeBusiness clone(){
        return new TypeBusiness(type);

    }

    @Override
    public String toString() {
        return type;
    }
}


