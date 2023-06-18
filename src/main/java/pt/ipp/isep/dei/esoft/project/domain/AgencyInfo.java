package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class AgencyInfo {
    private int agencyID;
    private int numberOfProperties;

    public AgencyInfo(int agencyID, int numberOfProperties) {
        this.agencyID = agencyID;
        this.numberOfProperties = numberOfProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgencyInfo that = (AgencyInfo) o;
        return agencyID == that.agencyID && numberOfProperties == that.numberOfProperties;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencyID, numberOfProperties);
    }

    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    public String toString(){
        return "/nAgency ID: " + agencyID +
               "/nNumber of Properties: " + numberOfProperties + "\n";
    }
}
