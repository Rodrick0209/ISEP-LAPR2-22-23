package pt.ipp.isep.dei.esoft.project.domain;


import java.io.Serializable;
import java.util.Objects;

public class AppointmentRequest implements Serializable {
    private final VisitRequest visitRequest;
    private final String message;
    private final Client client;
    private final Employee agent;

    public AppointmentRequest(VisitRequest visitRequest, String message, Client client, Employee agent) {
        this.visitRequest = visitRequest;
        this.message = message;
        this.client = client;
        this.agent = agent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentRequest that = (AppointmentRequest) o;
        return Objects.equals(visitRequest, that.visitRequest) && Objects.equals(message, that.message) && Objects.equals(client, that.client) && Objects.equals(agent, that.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitRequest, message, client, agent);
    }

    public AppointmentRequest clone(){
        return new AppointmentRequest(visitRequest, message, client, agent);
    }

    public String toString() {
        return "Agent Name: " + agent.getName() +
                "\nAgent Email Address: " + agent.getEmail() +
                "\nProperty ID: " + visitRequest.getAnnouncement().getAnnouncementId() +
                "\nProperty Location: " + visitRequest.getAnnouncement().getRequest().getProperty().getLocation() +
                "\nMessage: " + message;
    }

    public VisitRequest getVisitRequest() {
        return visitRequest;
    }
}
